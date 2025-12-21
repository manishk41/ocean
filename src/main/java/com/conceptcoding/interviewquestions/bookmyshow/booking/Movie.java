package com.conceptcoding.interviewquestions.bookmyshow.booking;

public class Movie {

    int movieId;
    String movieName;
    int movieDurationInMinutes;
    String genre;
    String language;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieDuration() {
        return movieDurationInMinutes;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDurationInMinutes = movieDuration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDuration=" + movieDurationInMinutes
                + ", genre=" + genre + ", language=" + language + "]";
    }
}
