package com.demo.springboot.dto;

public class CreateMovieDto {
    private Integer movieId;
    private String title;
    private int year;
    private String image;

    public CreateMovieDto() {
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() { return year; }

    public String getImage() {return image;}
}
