package com.gruppe4.boredoom.backend.spring.service;

import com.gruppe4.boredoom.backend.spring.model.*;
import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.Genre;
import com.gruppe4.boredoom.backend.spring.model.enums.Setting;
import com.gruppe4.boredoom.backend.spring.repository.BookRepository;
import com.gruppe4.boredoom.backend.spring.repository.MovieRepository;
import com.gruppe4.boredoom.backend.spring.repository.QuestionRepository;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.mockito.Mockito.*;

class EvaluationServiceTest {

    QuestionRepository questionRepository = mock(QuestionRepository.class);
    BookRepository bookRepository = mock(BookRepository.class);
    MovieRepository movieRepository = mock(MovieRepository.class);

    EvaluationService evaluationService = spy(new EvaluationService(questionRepository, bookRepository, movieRepository));

    @Test
    void evaluateByResultMap() {
        List<MediaResultValue> mediaList = evaluationService.evaluateByEvaluationMap(generateMockResultMap(), generateMockMedia());
        System.out.println(mediaList);
    }

    //@Test
    void getResultTest() {
        List<Media> allMedia = generateMockMedia();
        doReturn(allMedia).when(evaluationService).getAllMediaFromDatabase();

        //List<MediaResultValue> mediaResultValues = evaluationService.getResult(generateMockEvaluationData());
        //System.out.println(mediaResultValues);
    }

    protected List<UserAnswer> generateMockEvaluationData() {
        return Collections.emptyList();
    }

    protected Map<String, Map<String, Double>> generateMockResultMap() {

        Map<String, Map<String, Double>> mockResults = new HashMap<>();

        Map<String, Double> activityTypeResults = Map.of("ruhig", 1.0, "spannend", 1.5);
        mockResults.put("ActivityType", activityTypeResults);

        Map<String, Double> settingResults = Map.of("Gegenwart", 1.0);
        mockResults.put("Setting", settingResults);

        return mockResults;

    }

    public static List<Media> generateMockMedia() {
        List<Media> mediaList = new ArrayList<>();

        Book book = new Book();
        book.setActivityTypes(List.of(ActivityType.ACTION, ActivityType.EXCITING));
        book.setSetting(Setting.FANTASY);
        book.setGenres(List.of(Genre.ROMANCE));
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
        movie.setGenres(List.of(Genre.ROMANCE));
        mediaList.add(movie);

        Movie movie2 = new Movie();
        movie2.setActivityTypes(List.of(ActivityType.CALM));
        movie2.setSetting(Setting.PRESENT);
        movie.setGenres(Collections.emptyList());
        mediaList.add(movie2);

        Movie movie3 = new Movie();
        movie3.setActivityTypes(List.of(ActivityType.CALM, ActivityType.EXCITING));
        movie3.setSetting(Setting.PRESENT);
        movie3.setGenres(List.of(Genre.ADVENTURE, Genre.SCIENCE_FICTION, Genre.COMEDY));
        mediaList.add(movie3);

        return mediaList;
    }
}