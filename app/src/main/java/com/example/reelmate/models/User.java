package com.example.reelmate.models;

/**
 * User model class representing a user in the ReelMate application.
 * Contains user information like userId, email, username, and profile picture.
 */
public class User {
    private String userId;
    private String email;
    private String username;
    private String profilePicture;
    private long createdAt;

    /**
     * Constructor for creating a new User instance
     */
    public User(String userId, String email, String username) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.createdAt = System.currentTimeMillis();
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
