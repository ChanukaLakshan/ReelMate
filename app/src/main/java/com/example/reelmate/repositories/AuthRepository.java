package com.example.reelmate.repositories;

import android.util.Log;

/**
 * Authentication Repository
 * Handles all authentication related operations
 * This is the first module created by Chanuka Lakshan
 */
public class AuthRepository {
    private static final String TAG = "AuthRepository";

    /**
     * Register a new user
     * @param email User email
     * @param password User password
     * @param username User username
     * @param callback Callback for registration result
     */
    public void registerUser(String email, String password, String username, AuthCallback callback) {
        Log.d(TAG, "Registering user: " + email);
        
        // TODO: Implement registration logic
        // Steps to implement:
        // 1. Validate inputs
        // 2. Check if user already exists in database
        // 3. Hash password
        // 4. Save user to local database (Room)
        // 5. Call backend API if needed
        // 6. Call callback with result
        
        if (callback != null) {
            callback.onError("Registration not yet implemented");
        }
    }

    /**
     * Login user with email and password
     * @param email User email
     * @param password User password
     * @param callback Callback for login result
     */
    public void loginUser(String email, String password, AuthCallback callback) {
        Log.d(TAG, "Logging in user: " + email);
        
        // TODO: Implement login logic
        // Steps to implement:
        // 1. Validate inputs
        // 2. Query database for user with email
        // 3. Compare password hash
        // 4. Create session/token
        // 5. Save session to SharedPreferences
        // 6. Call backend API if needed
        // 7. Call callback with result
        
        if (callback != null) {
            callback.onError("Login not yet implemented");
        }
    }

    /**
     * Logout current user
     * @param callback Callback for logout result
     */
    public void logoutUser(AuthCallback callback) {
        Log.d(TAG, "Logging out user");
        
        // TODO: Implement logout logic
        // Steps to implement:
        // 1. Clear session from SharedPreferences
        // 2. Clear local user data
        // 3. Call backend API if needed
        // 4. Call callback with result
        
        if (callback != null) {
            callback.onSuccess("Logged out successfully");
        }
    }

    /**
     * Check if user is already logged in
     * @return true if user is logged in, false otherwise
     */
    public boolean isUserLoggedIn() {
        // TODO: Implement check
        // Check SharedPreferences for session token
        return false;
    }

    /**
     * Get current logged in user ID
     * @return Current user ID or null if not logged in
     */
    public String getCurrentUserId() {
        // TODO: Implement get current user ID
        // Return user ID from SharedPreferences
        return null;
    }

    /**
     * Callback interface for authentication operations
     */
    public interface AuthCallback {
        void onSuccess(String message);
        void onError(String error);
    }
}
