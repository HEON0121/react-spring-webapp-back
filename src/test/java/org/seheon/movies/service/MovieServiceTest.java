package org.seheon.movies.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seheon.movies.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {
    @Autowired
    private MovieService service;

    @Test
    public void return_movies(){
        List<Movie> all = service.getAllMovies();


    }
}
