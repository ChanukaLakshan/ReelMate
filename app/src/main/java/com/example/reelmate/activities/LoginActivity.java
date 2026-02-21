package com.example.reelmate.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reelmate.MainActivity;
import com.example.reelmate.R;
import com.example.reelmate.viewmodels.LoginViewModel;

/**
 * Login Activity
 * This is the first module created by Chanuka Lakshan
 * Handles user login functionality with validation and error handling
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        initializeViews();

        // Initialize ViewModel
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        // Setup observers and UI
        setupObservers();
        setupUI();
    }

    /**
     * Initialize all UI views
     */
    private void initializeViews() {
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
    }

    /**
     * Setup LiveData observers
     */
    private void setupObservers() {
        // Observe login success
        loginViewModel.getLoginSuccess().observe(this, isSuccess -> {
            if (isSuccess) {
                Log.d(TAG, "Login successful");
                // Navigate to main activity
                navigateToMainActivity();
            }
        });

        // Observe login message
        loginViewModel.getLoginMessage().observe(this, message -> {
            if (message != null && !message.isEmpty()) {
                showMessage(message);
            }
        });

        // Observe loading state
        loginViewModel.getIsLoading().observe(this, isLoading -> {
            loginButton.setEnabled(!isLoading);
            if (isLoading) {
                loginButton.setText(R.string.loading);
            } else {
                loginButton.setText(R.string.login_button);
            }
        });

        // Observe email error
        loginViewModel.getEmailError().observe(this, error -> {
            if (error != null && !error.isEmpty()) {
                emailEditText.setError(error);
            }
        });

        // Observe password error
        loginViewModel.getPasswordError().observe(this, error -> {
            if (error != null && !error.isEmpty()) {
                passwordEditText.setError(error);
            }
        });
    }

    /**
     * Setup UI event listeners
     */
    private void setupUI() {
        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            loginViewModel.login(email, password);
        });

        registerButton.setOnClickListener(v -> {
            // TODO: Navigate to RegisterActivity when it's created
            Log.d(TAG, "Register button clicked");
            showMessage("Register feature coming soon!");
        });
    }

    /**
     * Navigate to MainActivity after successful login
     */
    private void navigateToMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    /**
     * Show error or success message to user
     */
    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
