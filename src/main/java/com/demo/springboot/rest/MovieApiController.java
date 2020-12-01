package com.demo.springboot.rest;

import com.demo.springboot.dto.CreateMovieDto;
import com.demo.springboot.dto.MovieDto;
import com.demo.springboot.dto.MovieListDto;
import com.demo.springboot.services.Movies;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieApiController {
    private static final Logger LOG = LoggerFactory.getLogger(MovieApiController.class);

    Movies movies = new Movies();

    /** Tworzenie filmu */
    @PostMapping("/movies")
    public ResponseEntity<Void> createMovie(@RequestBody MovieDto movieDto) throws URISyntaxException {
        LOG.info("--- id: {}", movieDto.getMovieId());
        LOG.info("--- title: {}", movieDto.getTitle());
        LOG.info("--- year: {}", movieDto.getYear());
        LOG.info("--- image: {}", movieDto.getImage());

        movies.addingMovies(movieDto.getTitle(), movieDto.getYear(), movieDto.getImage());

        if (!equals(movieDto.getMovieId())|| !equals(movieDto.getTitle()) || !equals(movieDto.getYear()) || !equals(movieDto.getImage())){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.created(new URI("/movies/" + movieDto.getMovieId())).build();
        }
    }

    /** Pobieranie filmów */
    @GetMapping("/movies")
    public ResponseEntity<MovieListDto> getMovies() {
        LOG.info("--- get all movies: {}", movies.getMovies());
        return ResponseEntity.ok().body(movies.getMovies());    // = new ResponseEntity<>(movies, HttpStatus.OK);
    }

    /** Aktualizowanie danego filmu */
    @PutMapping("/movies/{id}")
    public ResponseEntity<Void> updateMovie(@PathVariable("id") Integer id, @RequestBody CreateMovieDto createMovieDto) {

        if (!id.equals(createMovieDto.getMovieId())) {
            return ResponseEntity.notFound().build();
        }

        LOG.info("--- id: {}", createMovieDto.getMovieId());
        LOG.info("--- title: {}", createMovieDto.getTitle());
        LOG.info("--- year: {}", createMovieDto.getYear());
        LOG.info("--- image: {}", createMovieDto.getImage());

        movies.updatingMovies(id, createMovieDto.getTitle(), createMovieDto.getYear(), createMovieDto.getImage());

        return ResponseEntity.ok().build();
    }

    /** Usuwanie danego filmu */
    @DeleteMapping("movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Integer id){
        MovieDto movieDto = new MovieDto();
        if (id != movieDto.getMovieId()) {
            return ResponseEntity.notFound().build();
        }

        LOG.info("--- id:{}",id);
        movies.deletingMovies(id);

        return ResponseEntity.ok().build();
    }
}
