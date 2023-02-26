package org.seheon.movies.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.seheon.movies.domain.Movie;
import org.seheon.movies.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Transactional(readOnly = true)
    public List<Movie> getAllMovies(){
        //log.info(movieRepository.findAll().toString());
        List<Movie>all = movieRepository.findAll();
        //all.forEach(movie -> {log.info(movie.getTitle());});
        return all;
    }

    @Transactional(readOnly = true)
    public Optional<Movie> getMovieById(String imdbId) {
        log.info("==========id============="+imdbId);
        log.info("==========body============="+movieRepository.findMovieByImdbId(imdbId));
        return movieRepository.findMovieByImdbId(imdbId);
    }

    @Transactional
    public void uploadMovie(String imdbId,
                            String title,
                            String releaseDate,
                            String trailerLink,
                            List<String> genres,
                            String poster,
                            List<String> backdrops,
                            List<String> reviewIds) {
        Movie movie = new Movie();
        movie.setImdbId(imdbId);
        movie.setTitle(title);
        movie.setReleaseDate(releaseDate);
        movie.setTrailerLink(trailerLink);
        movie.setGenres(genres);
        movie.setPoster(poster);
        movie.setBackdrops(backdrops);
        movie.setReviewIds(reviewIds);

//        if(movieRepository.findMovieByImdbId(imdbId)!=null){
//            log.info("================================this movie is already exist!================================");
//            movie.setId(movieRepository.findMovieByImdbId(imdbId).orElseThrow().getId());
//        }else {
//            log.info("================================a new movie is created!================================");
//        }
        movieRepository.save(movie);
    }

    public Movie uploadMovie(String imdbId,
                            String title,
                            String releaseData,
                            String trailerLink,
                            String poster,
                            List genres,
                            List backdrops,
                            List reviewId) {

        Movie movie = new Movie();
        movie.setImdbId(imdbId);
        movie.setTitle(title);
        movie.setReleaseDate(releaseData);
        movie.setTrailerLink(trailerLink);
        movie.setPoster(poster);
        movie.setGenres(genres);
        movie.setBackdrops(backdrops);
        movie.setReviewIds(reviewId);
        movieRepository.save(movie);
        return movie;

    }
}
