package com.gruppe4.boredoom.backend.spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gruppe4.boredoom.backend.spring.model.*;
import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.Genre;
import com.gruppe4.boredoom.backend.spring.model.enums.Setting;
import com.gruppe4.boredoom.backend.spring.repository.BookRepository;
import com.gruppe4.boredoom.backend.spring.repository.MovieRepository;
import com.gruppe4.boredoom.backend.spring.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EvaluationServiceTest {

    QuestionRepository questionRepository = mock(QuestionRepository.class);
    BookRepository bookRepository = mock(BookRepository.class);
    MovieRepository movieRepository = mock(MovieRepository.class);
    ObjectMapper objectMapper = new ObjectMapper();

    static List<Media> allMedia = new ArrayList<>();
    static List<Media> expectedResult = new ArrayList<>();

    EvaluationService evaluationService = spy(new EvaluationService(questionRepository, bookRepository, movieRepository));

    @Test
    void getResultTest() throws IOException {

        generateMockMedia();
        List<Question> allQuestions = generateMockQuestions();
        doReturn(allMedia).when(evaluationService).getAllMediaFromDatabase();
        doReturn(allQuestions).when(questionRepository).getAll();

        List<Media> results = evaluationService.getResults(generateUserChoices());
        assertEquals(expectedResult, results);
    }

    private List<Question> generateMockQuestions() throws IOException {
        File questionFile = new ClassPathResource("mock-questions.json").getFile();
        Question[] questions = objectMapper.readValue(questionFile, Question[].class);
        return Arrays.asList(questions);
    }

    private List<UserAnswer> generateUserChoices() {

        List<UserAnswer> userAnswers = new ArrayList<>();

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setQuestionId(1);
        userAnswer.setChoices(List.of(1L, 3L)); // Horror, Abenteuer mit Weight: 1.0
        userAnswers.add(userAnswer);

        UserAnswer userAnswer2 = new UserAnswer();
        userAnswer2.setQuestionId(2);
        userAnswer2.setChoices(List.of(7L, 8L)); // ruhig, actionreich mit Weight: 1.0
        userAnswers.add(userAnswer2);

        UserAnswer userAnswer3 = new UserAnswer();
        userAnswer3.setQuestionId(3);
        userAnswer3.setChoices(List.of(15L)); // kurz
        userAnswers.add(userAnswer3);

        UserAnswer userAnswer4 = new UserAnswer();
        userAnswer4.setQuestionId(4);
        userAnswer4.setChoices(List.of(20L, 21L)); //Zukunft und Gegenwart mit Weight: 1.0
        userAnswers.add(userAnswer4);

        UserAnswer userAnswer5 = new UserAnswer();
        userAnswer5.setQuestionId(5);
        userAnswer5.setChoices(List.of(23L, 24L)); //humorvoll und gruselig mit Weight: 0.5
        userAnswers.add(userAnswer5);

        return userAnswers;
    }

    private void generateMockMedia() {

        Book book = new Book(); // Expected value: 1.0
        book.setName("1");
        book.setActivityTypes(List.of(ActivityType.ACTION, ActivityType.EXCITING));
        book.setSetting(Setting.FANTASY);
        book.setGenres(List.of(Genre.CRIME));
        allMedia.add(book);

        Book book2 = new Book(); // Expected Value: 2.0
        book2.setName("2");
        book2.setActivityTypes(List.of(ActivityType.EDUCATIONAL, ActivityType.SCARY));
        book2.setSetting(Setting.FUTURE);
        book2.setGenres(List.of(Genre.ADVENTURE));
        allMedia.add(book2);

        Book book3 = new Book(); // Expected Value: 3.0
        book3.setName("3");
        book3.setActivityTypes(List.of(ActivityType.EDUCATIONAL, ActivityType.CALM));
        book3.setSetting(Setting.PRESENT);
        book3.setGenres(List.of(Genre.HORROR, Genre.COMEDY));
        allMedia.add(book3);

        Movie movie = new Movie(); // Expected Value 1.0
        movie.setName("4");
        movie.setActivityTypes(List.of(ActivityType.DRAMATIC));
        movie.setSetting(Setting.PRESENT);
        movie.setGenres(List.of(Genre.HORROR));
        allMedia.add(movie);

        Movie movie2 = new Movie(); // Expected Value 3.0
        movie2.setName("5");
        movie2.setActivityTypes(List.of(ActivityType.CALM));
        movie2.setSetting(Setting.PRESENT);
        movie2.setGenres(List.of(Genre.ADVENTURE));
        allMedia.add(movie2);

        Movie movie3 = new Movie(); // Expected Value 4.0
        movie3.setName("6");
        movie3.setActivityTypes(List.of(ActivityType.CALM, ActivityType.ACTION));
        movie3.setSetting(Setting.PRESENT);
        movie3.setGenres(List.of(Genre.ADVENTURE, Genre.COMEDY, Genre.COMEDY));
        allMedia.add(movie3);

        expectedResult.add(movie3); // 4.0
        expectedResult.add(book3); // 3.0
        expectedResult.add(movie2); // 3.0
        expectedResult.add(book2); // 2.0
        expectedResult.add(movie); // 1.0
    }
}