package com.example.reelmate.repositories;

import android.util.Log;

import com.example.reelmate.models.Movie;

import java.util.List;

/**
 * Watchlist Repository
 * Handles all watchlist related operations
 * This is the second module created by Member 2
 */
public class WatchlistRepository {
    private static final String TAG = "WatchlistRepository";

    /**
     * Get all movies in watchlist
     * @param callback Callback for getting movies
     */
    public void getWatchlistMovies(WatchlistCallback callback) {
        Log.d(TAG, "Getting watchlist movies");
        
        // TODO: Implement get movies logic
        // Steps to implement:
        // 1. Query database for all movies in watchlist
        // 2. Return list to callback
    }

    /**
     * Add movie to watchlist
     * @param movie Movie to add
     * @param callback Callback for add operation
     */
    public void addMovieToWatchlist(Movie movie, OperationCallback callback) {
        Log.d(TAG, "Adding movie to watchlist: " + movie.getTitle());
        
        // TODO: Implement add logic
    }

    /**
     * Remove movie from watchlist
     * @param movieId Movie ID to remove
     * @param callback Callback for remove operation
     */
    public void removeMovieFromWatchlist(String movieId, OperationCallback callback) {
        Log.d(TAG, "Removing movie from watchlist: " + movieId);
        
        // TODO: Implement remove logic
    }

    /**
     * Search movies in watchlist
     * @param query Search query
     * @param callback Callback with search results
     */
    public void searchMovies(String query, WatchlistCallback callback) {
        Log.d(TAG, "Searching movies: " + query);
        
        // TODO: Implement search logic
    }

    /**
     * Callback interface for getting movies
     */
    public interface WatchlistCallback {
        void onSuccess(List<Movie> movies);
        void onError(String error);
    }

    /**
     * Callback interface for operations
     */
    public interface OperationCallback {
        void onSuccess(String message);
        void onError(String error);
    }
}
