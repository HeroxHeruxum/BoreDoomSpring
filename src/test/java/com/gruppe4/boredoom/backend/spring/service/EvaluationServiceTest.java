package com.gruppe4.boredoom.backend.spring.service;

import com.gruppe4.boredoom.backend.spring.model.UserAnswer;
import com.gruppe4.boredoom.backend.spring.repository.BookRepository;
import com.gruppe4.boredoom.backend.spring.repository.MovieRepository;
import com.gruppe4.boredoom.backend.spring.repository.QuestionRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

class EvaluationServiceTest {

    QuestionRepository questionRepository = mock(QuestionRepository.class);
    BookRepository bookRepository = mock(BookRepository.class);
    MovieRepository movieRepository = mock(MovieRepository.class);

    EvaluationService evaluationService = spy(new EvaluationService(questionRepository, bookRepository, movieRepository));

    @Test
    void evaluateByResultMap() {
        //List<MediaResultValue> mediaList = evaluationService.evaluateByEvaluationMap(generateMockResultMap(), generateMockMedia
        // ());
        //System.out.println(mediaList);
    }

    //@Test
    void getResultTest() {
        //List<Media> allMedia = generateMockMedia();
        //doReturn(allMedia).when(evaluationService).getAllMediaFromDatabase();

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
}