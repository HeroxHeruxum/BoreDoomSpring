package com.gruppe4.boredoom.backend.spring.service;

import com.gruppe4.boredoom.backend.spring.model.*;
import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
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

    public List<MediaResultValue> getResult(List<UserAnswer> userAnswers) {

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
                    existingWeight = existingWeight + weight;
                } else {
                    evaluationValues.put(evaluationValueName, weight);
                }
            } else {
                Map<String, Double> evaluationValues = Map.of(evaluationValueName, weight);
                evaluationTypes.put(evaluationType, evaluationValues);
            }
        }

        return evaluationTypes;
    }

    protected List<MediaResultValue> evaluateByEvaluationMap(Map<String, Map<String, Double>> evaluationMap, List<Media> allMedia) {
        double totalWeight = getTotalWeight(evaluationMap);

        List<ResultValue> allResults = new ArrayList<>();

        for (Map.Entry<String, Map<String, Double>> evaluationEntry : evaluationMap.entrySet()) {
            List<ResultValue> resultValues = getResultsForEvaluationType(evaluationEntry.getKey(), allMedia,
                    evaluationEntry.getValue());
            allResults.addAll(resultValues);
        }

        return getWeightedListForMatchingMedia(allResults, totalWeight, 5);
    }

    protected List<MediaResultValue> getWeightedListForMatchingMedia(List<ResultValue> resultValues, double totalWeight,
            int maxResults) {
        List<MediaResultValue> allMediaResultValues = getAllMatchingMedia(resultValues);
        return new EvaluationAlgorithm().evaluateResultValueList(allMediaResultValues, maxResults);
    }

    protected List<MediaResultValue> getAllMatchingMedia(List<ResultValue> resultValues) {
        List<MediaResultValue> allMediaResultValues = new ArrayList<>();

        for (ResultValue resultValue : resultValues) {

            for (Media media : resultValue.getResults()) {
                MediaResultValue newMrv = new MediaResultValue(media, resultValue.getWeight());

                addMediaResultValue(allMediaResultValues, newMrv);
            }
        }

        return allMediaResultValues;
    }

    protected void addMediaResultValue(List<MediaResultValue> list, MediaResultValue mrv) {
        boolean exists = false;

        for (MediaResultValue existingMrv : list) {
            if (existingMrv.equals(mrv)) {
                existingMrv.setWeight(existingMrv.getWeight() + mrv.getWeight());
                exists = true;
            }
        }

        if (!exists) {
            list.add(mrv);
        }
    }

    protected double getTotalWeight(Map<String, Map<String, Double>> evaluationMap) {
        double weight = 0;
        for (Map.Entry<String, Map<String, Double>> evaluationEntry : evaluationMap.entrySet()) {
            for (Map.Entry<String, Double> entry : evaluationEntry.getValue().entrySet()) {
                weight = weight + entry.getValue();
            }
        }
        return weight;
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
        }

        return null;
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

    protected List<Media> getResultsForSetting(List<Media> allMedia, String evaluationValue) {
        List<Media> results = new ArrayList<>();

        for (Media media : allMedia) {
            if (media.getSetting().equals(Setting.fromString(evaluationValue))) {
                results.add(media);
            }
        }

        return results;
    }
}
