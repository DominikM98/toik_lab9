package com.demo.springboot.dto;

import java.util.List;
import java.util.stream.Collectors;

public class MovieListDto {
    private List<MovieDto> movies;

    public MovieListDto(List<MovieDto> movies) {
        this.movies = movies;
    }

    public List<MovieDto> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "[" + movies.stream()
                .map(movie -> movie.getMovieId().toString())
                .collect(Collectors.joining(",")) + "]";
    }
}
