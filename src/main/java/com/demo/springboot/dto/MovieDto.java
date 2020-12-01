package com.demo.springboot.dto;

public class MovieDto {
    private Integer movieId;
    private String title;
    private Integer year;
    private String image;

    public MovieDto() {
    }

    public MovieDto(Integer movieId, String title, Integer year, String image) {
        this.movieId = movieId;
        this.title = title;
        this.year = year;
        this.image = image;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }
}
