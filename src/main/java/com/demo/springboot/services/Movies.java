package com.demo.springboot.services;

import com.demo.springboot.dto.MovieDto;
import com.demo.springboot.dto.MovieListDto;

import java.util.ArrayList;
import java.util.List;

public class Movies implements MoviesInterface {
    List <MovieDto> moviesList = new ArrayList<>();
    private MovieListDto movies;
    private int idCounter = 1;

    public Movies(){
        MovieApiController();
    }

    public void MovieApiController() {
        moviesList.add(new MovieDto(idCounter,
                "Piraci z Krzemowej Doliny",
                1999,
                "https://fwcdn.pl/fpo/30/02/33002/6988507.6.jpg"));
        movies = new MovieListDto(moviesList);
        idCounter++;
    }

    public void addingMovies(String title, int year, String image){
        moviesList.add(new MovieDto(idCounter, title, year, image));
        idCounter++;
    }

    public MovieListDto getMovies(){
        moviesList.sort((a,b) -> b.getMovieId().compareTo(a.getMovieId()));
        movies = new MovieListDto(moviesList);
        return movies;
    }

    public void updatingMovies(int id, String title, int year, String image){
        moviesList.set(id-1, new MovieDto(id, title, year, image));
    }

    public void deletingMovies(int id){
        moviesList.remove(id-1);
        idCounter--;
    }
}
