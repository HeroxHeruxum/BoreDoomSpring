package com.gruppe4.boredoom.backend.spring.service;

import com.gruppe4.boredoom.backend.spring.model.*;
import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.Genre;
import com.gruppe4.boredoom.backend.spring.model.enums.Setting;
import com.gruppe4.boredoom.backend.spring.repository.BookRepository;
import com.gruppe4.boredoom.backend.spring.repository.MovieRepository;
import com.gruppe4.boredoom.backend.spring.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EvaluationService {

    private final QuestionRepository questionRepository;
    private final BookRepository bookRepository;
    private final MovieRepository movieRepository;

    public EvaluationService(QuestionRepository questionRepository,
            BookRepository bookRepository, MovieRepository movieRepository) {
        this.questionRepository = questionRepository;
        this.bookRepository = bookRepository;
        this.movieRepository = movieRepository;
    }

    public List<Media> getResults(List<UserAnswer> userAnswers) {
        List<MediaResultValue> mediaResultValues = getMediaResultData(userAnswers);
        List<Media> media = new ArrayList<>();

        for (MediaResultValue mediaResultValue : mediaResultValues) {
            media.add(mediaResultValue.getMedia());
        }

        return media;
    }

    public List<MediaResultValue> getMediaResultData(List<UserAnswer> userAnswers) {

        List<Choice> choices = new ArrayList<>();
        List<Media> media = getAllMediaFromDatabase();

        for (UserAnswer userAnswer : userAnswers) {
            List<Question> questions = questionRepository.getAll();

            for (Question question : questions) {
                if (question.getId() == userAnswer.getQuestionId()) {
                    for (long id : userAnswer.getChoices()) {
                        for (Choice choice : question.getChoices()) {
                            if (choice.getId() == id) {
                                choices.add(choice); // Put user choice to list
                            }
                        }
                    }
                }
            }

        }

        Map<String, Map<String, Double>> evaluationMap = generateEvaluationMap(choices);

        return evaluateByEvaluationMap(evaluationMap, media);
    }

    protected List<Media> getAllMediaFromDatabase() {
        List<Media> mediaList = new ArrayList<>();

        mediaList.addAll(movieRepository.findAll());
        mediaList.addAll(bookRepository.findAll());

        return mediaList;
    }

    protected Map<String, Map<String, Double>> generateEvaluationMap(List<Choice> userChoices) {
        Map<String, Map<String, Double>> evaluationTypes = new HashMap<>();

        for (Choice choice : userChoices) {
            String evaluationType = choice.getEvaluationValue().getEvaluationType().getType();
            String evaluationValueName = choice.getEvaluationValue().getValue();
            double weight = choice.getWeight();

            if (evaluationTypes.containsKey(evaluationType)) {
                Map<String, Double> evaluationValues = evaluationTypes.get(evaluationType);
                if (evaluationValues.containsKey(evaluationValueName)) {
                    Double existingWeight = evaluationValues.get(evaluationValueName);
                    Double newWeight = existingWeight + weight;
                    evaluationValues.remove(evaluationValueName);
                    evaluationValues.put(evaluationValueName, newWeight);
                } else {
                    evaluationValues.put(evaluationValueName, weight);
                }
            } else {
                Map<String, Double> evaluationValues = new HashMap<>();
                evaluationValues.put(evaluationValueName, weight);
                evaluationTypes.put(evaluationType, evaluationValues);
            }
        }

        return evaluationTypes;
    }

    protected List<MediaResultValue> evaluateByEvaluationMap(Map<String, Map<String, Double>> evaluationMap, List<Media> allMedia) {

        List<ResultValue> allResults = new ArrayList<>();

        for (Map.Entry<String, Map<String, Double>> evaluationEntry : evaluationMap.entrySet()) {
            List<ResultValue> resultValues = getResultsForEvaluationType(evaluationEntry.getKey(), allMedia,
                    evaluationEntry.getValue());
            allResults.addAll(resultValues);
        }

        return getWeightedListForMatchingMedia(allResults, 5);
    }

    protected List<MediaResultValue> getWeightedListForMatchingMedia(List<ResultValue> resultValues, int maxResults) {
        List<MediaResultValue> allMediaResultValues = getAllMatchingMedia(resultValues);
        return new EvaluationAlgorithm().evaluateResultValueList(allMediaResultValues, maxResults);
    }

    protected List<MediaResultValue> getAllMatchingMedia(List<ResultValue> resultValues) {
        List<MediaResultValue> allMediaResultValues = new ArrayList<>();

        for (ResultValue resultValue : resultValues) {

            for (Media media : resultValue.getResults()) {
                Map<String, Double> criteria = new HashMap<>();
                criteria.put(resultValue.getName(), resultValue.getWeight());
                MediaResultValue newMrv = new MediaResultValue(media, resultValue.getWeight(), criteria);
                List<String> userPreferences = getUserPreferences(resultValues);
                newMrv.setUserPreferences(userPreferences);

                addMediaResultValue(allMediaResultValues, newMrv);
            }
        }

        return allMediaResultValues;
    }

    protected List<String> getUserPreferences(List<ResultValue> resultValues) {
        List<ResultValue> resultValuesShadow = new ArrayList<>();
        resultValuesShadow.addAll(resultValues);

        resultValuesShadow.sort(new Comparator<ResultValue>() {
            @Override
            public int compare(ResultValue t1, ResultValue t2) {
                if (t1.getWeight() == t2.getWeight()) {
                    return 0;
                }
                return t1.getWeight() < t2.getWeight() ? 1 : -1;
            }
        });

        int maxUserPrefs = 3;
        if (maxUserPrefs > resultValues.size()) {
            maxUserPrefs = resultValues.size();
        }

        List<String> userPreferences = new ArrayList<>();
        resultValuesShadow.subList(0, maxUserPrefs).forEach(r -> userPreferences.add(r.getName()));

        return userPreferences;
    }

    protected void addMediaResultValue(List<MediaResultValue> list, MediaResultValue mrv) {
        boolean exists = false;

        for (MediaResultValue existingMrv : list) {
            if (existingMrv.equals(mrv)) {
                existingMrv.setWeight(existingMrv.getWeight() + mrv.getWeight());
                existingMrv.getSingleCriteria().putAll(mrv.getSingleCriteria());
                exists = true;
            }
        }

        if (!exists) {
            list.add(mrv);
        }
    }

    protected List<ResultValue> getResultsForEvaluationType(String evaluationType, List<Media> allMedia,
            Map<String, Double> evaluationValues) {
        List<ResultValue> resultValues = new ArrayList<>();

        for (Map.Entry<String, Double> evaluationValue : evaluationValues.entrySet()) {
            ResultValue resultValue = new ResultValue();
            resultValue.setName(evaluationValue.getKey());
            resultValue.setWeight(evaluationValue.getValue());
            resultValue.setResults(getResultsForEvaluationValue(allMedia, evaluationType, evaluationValue.getKey()));
            resultValues.add(resultValue);
        }

        return resultValues;
    }

    protected List<Media> getResultsForEvaluationValue(List<Media> allMedia, String evaluationType, String evaluationValue) {

        if (evaluationType.equals("ActivityType")) {
            return getResultsForActivityType(allMedia, evaluationValue);
        } else if (evaluationType.equals("Setting")) {
            return getResultsForSetting(allMedia, evaluationValue);
        } else if (evaluationType.equals("Genre")) {
            return getResultsForGenre(allMedia, evaluationValue);
        } else if (evaluationType.equals("Dauer")) {
            return getResultsForDuration(allMedia, evaluationValue);
        }

        return Collections.emptyList();
    }

    protected List<Media> getResultsForActivityType(List<Media> allMedia, String evaluationValue) {
        List<Media> results = new ArrayList<>();
        for (Media media : allMedia) {
            for (ActivityType activityType : media.getActivityTypes()) {
                if (activityType.equals(ActivityType.fromString(evaluationValue))) {
                    results.add(media);
                }
            }
        }
        return results;
    }

    protected List<Media> getResultsForGenre(List<Media> allMedia, String evaluationValue) {
        List<Media> results = new ArrayList<>();

        for (Media media : allMedia) {
            for (Genre genre : media.getGenres()) {
                if (genre.equals(Genre.fromString(evaluationValue))) {
                    results.add(media);
                }
            }
        }

        return results;
    }

    protected List<Media> getResultsForSetting(List<Media> allMedia, String evaluationValue) {
        List<Media> results = new ArrayList<>();

        for (Media media : allMedia) {
            if (media.getSetting().equals(Setting.fromString(evaluationValue))) {
                results.add(media);
            }
        }

        return results;
    }

    protected List<Media> getResultsForDuration(List<Media> allMedia, String evaluationValue) {
        List<Media> results = new ArrayList<>();

        for (Media media : allMedia) {
            // TODO: handle Duration
        }

        return results;
    }

    public static List<Media> generateMockMedia() {
        List<Media> mediaList = new ArrayList<>();

        Book book = new Book();
        book.setActivityTypes(List.of(ActivityType.ACTION, ActivityType.EXCITING));
        book.setSetting(Setting.FANTASY);
        book.setGenres(List.of(Genre.ADVENTURE));
        mediaList.add(book);

        Book book2 = new Book();
        book2.setActivityTypes(List.of(ActivityType.EDUCATIONAL, ActivityType.SCARY));
        book2.setSetting(Setting.FUTURE);
        book2.setGenres(List.of(Genre.ADVENTURE));
        mediaList.add(book2);

        Book book3 = new Book();
        book3.setActivityTypes(List.of(ActivityType.EDUCATIONAL, ActivityType.CALM));
        book3.setSetting(Setting.PRESENT);
        book3.setGenres(List.of(Genre.HORROR, Genre.COMEDY));
        mediaList.add(book3);

        Movie movie = new Movie();
        movie.setActivityTypes(List.of(ActivityType.DRAMATIC));
        movie.setSetting(Setting.PRESENT);
        movie.setGenres(List.of(Genre.HORROR));
        mediaList.add(movie);

        Movie movie2 = new Movie();
        movie2.setActivityTypes(List.of(ActivityType.CALM));
        movie2.setSetting(Setting.PRESENT);
        movie2.setGenres(Collections.emptyList());
        mediaList.add(movie2);

        Movie movie3 = new Movie();
        movie3.setActivityTypes(List.of(ActivityType.CALM, ActivityType.EXCITING));
        movie3.setSetting(Setting.PRESENT);
        movie3.setGenres(List.of(Genre.ADVENTURE, Genre.ACTION, Genre.COMEDY));
        mediaList.add(movie3);

        return mediaList;
    }

}
