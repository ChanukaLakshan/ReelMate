package com.example.reelmate.models;

/**
 * Movie model class representing a movie in the ReelMate application.
 * Contains movie details like title, genre, rating, poster, etc.
 */
public class Movie {
    private String movieId;
    private String title;
    private String genre;
    private String description;
    private String releaseDate;
    private String posterUrl;
    private double imdbRating;
    private int runtimeMinutes;
    private String director;
    private long addedToWatchlistAt;

    /**
     * Constructor for creating a new Movie instance
     */
    public Movie(String movieId, String title, String genre, String description) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.addedToWatchlistAt = System.currentTimeMillis();
    }

    // Getters and Setters
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(int runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public long getAddedToWatchlistAt() {
        return addedToWatchlistAt;
    }

    public void setAddedToWatchlistAt(long addedToWatchlistAt) {
        this.addedToWatchlistAt = addedToWatchlistAt;
    }
}
