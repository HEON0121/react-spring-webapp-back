package org.seheon.movies.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seheon.movies.domain.Movie;
import org.seheon.movies.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mapping.MappingException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieControllerTest {

//    @Autowired
//    private MockMvc mvc;

//    @LocalServerPort
//    private int port;

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void return_movie() throws MappingException {
        //String hello = "Hello!"; test fail
        //String url = "http://localhost:"+port+"/api/v1/movies";

//        String imdbId = "tt3915174";
//        Optional<Movie> test = movieRepository.findMovieByImdbId(imdbId);
//
//        assertThat(test).isNotEmpty();
        List<Movie> all = movieRepository.findAll();

        assertThat(all).isNotEmpty();

    }
}
