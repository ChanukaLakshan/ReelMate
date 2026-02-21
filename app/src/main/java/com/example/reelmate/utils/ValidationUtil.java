package com.example.reelmate.utils;

import android.util.Patterns;

/**
 * Utility class for input validation
 */
public class ValidationUtil {

    /**
     * Validate email format
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Validate password strength
     * Password must be at least 6 characters long
     */
    public static boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return password.length() >= 6;
    }

    /**
     * Validate username
     * Username must be 3-20 characters and alphanumeric
     */
    public static boolean isValidUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (username.length() < 3 || username.length() > 20) {
            return false;
        }
        return username.matches("^[a-zA-Z0-9_]+$");
    }

    /**
     * Get error message for email validation
     */
    public static String getEmailErrorMessage(String email) {
        if (email == null || email.isEmpty()) {
            return "Email cannot be empty";
        }
        if (!isValidEmail(email)) {
            return "Please enter a valid email address";
        }
        return "";
    }

    /**
     * Get error message for password validation
     */
    public static String getPasswordErrorMessage(String password) {
        if (password == null || password.isEmpty()) {
            return "Password cannot be empty";
        }
        if (password.length() < 6) {
            return "Password must be at least 6 characters";
        }
        return "";
    }

    /**
     * Get error message for username validation
     */
    public static String getUsernameErrorMessage(String username) {
        if (username == null || username.isEmpty()) {
            return "Username cannot be empty";
        }
        if (username.length() < 3) {
            return "Username must be at least 3 characters";
        }
        if (username.length() > 20) {
            return "Username cannot exceed 20 characters";
        }
        if (!username.matches("^[a-zA-Z0-9_]+$")) {
            return "Username can only contain letters, numbers, and underscores";
        }
        return "";
    }
}
