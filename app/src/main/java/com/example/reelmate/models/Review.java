package com.example.reelmate.models;

/**
 * Review model class representing a movie review in the ReelMate application.
 * Contains review details like rating, text content, author information, etc.
 */
public class Review {
    private String reviewId;
    private String movieId;
    private String userId;
    private int rating; // 1-5 stars
    private String reviewText;
    private String authorUsername;
    private long createdAt;
    private long updatedAt;
    private int likeCount;

    /**
     * Constructor for creating a new Review instance
     */
    public Review(String reviewId, String movieId, String userId, int rating, String reviewText) {
        this.reviewId = reviewId;
        this.movieId = movieId;
        this.userId = userId;
        this.rating = rating;
        this.reviewText = reviewText;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.likeCount = 0;
    }

    // Getters and Setters
    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        }
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
        this.updatedAt = System.currentTimeMillis();
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
