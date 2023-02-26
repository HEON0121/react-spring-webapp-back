package org.seheon.movies.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.seheon.movies.domain.Customer;
import org.seheon.movies.domain.Movie;
import org.seheon.movies.service.MovieService;
import org.seheon.movies.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/movies")
@Slf4j
public class MovieController {
    private final MovieService movieService;
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByID(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(imdbId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public Movie uploadMovie(@RequestBody Movie movieParam) {
        //JSONPObject jsonpObject = new JSONPObject();
        //jsonpObject.put()
            log.info("==============================movieParam=============================="+movieParam.toString());
            //log.info("==============================movieParamList=============================="+movieParamList.toString());
    //        return movieService.uploadMovie(movieParam.get("imdbId"),
    //                movieParam.get("title"),
    //                movieParam.get("releaseData"),
    //                movieParam.get("trailerLink"),
    //                movieParam.get("poster"),
    //                movieParamList.get("genres"),
    //                movieParamList.get("backdrops"),
    //                movieParamList.get("reviewId"));
        return movieService.uploadMovie(movieParam.getImdbId(),
                movieParam.getTitle(),
                movieParam.getReleaseDate(),
                movieParam.getTrailerLink(),
                movieParam.getPoster(),
                movieParam.getGenres(),
                movieParam.getBackdrops(),
                movieParam.getReviewIds()
                );
    }
    @GetMapping("/users")
    public ResponseEntity<List<Customer>>getUsers() {
        return new ResponseEntity<List<Customer>>(userService.getUserList(), HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<String> getCustomer(String firstName) throws JsonProcessingException {
        return new ResponseEntity<String>(userService.selectCustomer(firstName), HttpStatus.OK);
    }

    @PostMapping("/user/save")
    public String saveUser(String firstName, String lastName) throws JsonProcessingException {
        userService.saveCustomer(firstName, lastName);
        return userService.selectCustomer(firstName);
    }
}
