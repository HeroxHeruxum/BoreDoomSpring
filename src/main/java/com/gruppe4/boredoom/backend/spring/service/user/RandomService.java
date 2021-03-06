package com.gruppe4.boredoom.backend.spring.service.user;

import com.gruppe4.boredoom.backend.spring.model.Book;
import com.gruppe4.boredoom.backend.spring.model.Media;
import com.gruppe4.boredoom.backend.spring.model.Movie;
import com.gruppe4.boredoom.backend.spring.repository.BookRepository;
import com.gruppe4.boredoom.backend.spring.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomService {

    private final BookRepository bookRepository;
    private final MovieRepository movieRepository;

    public RandomService(BookRepository bookRepository, MovieRepository movieRepository) {
        this.bookRepository = bookRepository;
        this.movieRepository = movieRepository;
    }

    public Media getRandomMedia(){
        List<Book> bookList = bookRepository.findAll();
        List<Movie> movieList = movieRepository.findAll();

        List<Media> allMedia = new ArrayList<>();
        allMedia.addAll(bookList);
        allMedia.addAll(movieList);

        var randomIndex = new Random().nextInt(allMedia.size());

        return allMedia.get(randomIndex);
    }
}
