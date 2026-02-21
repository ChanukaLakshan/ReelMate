package com.example.reelmate.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reelmate.MainActivity;
import com.example.reelmate.R;
import com.example.reelmate.viewmodels.SignupViewModel;

/**
 * Signup Activity
 * Handles user registration functionality with validation and error handling
 */
public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button signupButton;
    private TextView backToLoginText;
    private SignupViewModel signupViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize views
        initializeViews();

        // Initialize ViewModel
        signupViewModel = new ViewModelProvider(this).get(SignupViewModel.class);

        // Setup observers and UI
        setupObservers();
        setupUI();
    }

    /**
     * Initialize all UI views
     */
    private void initializeViews() {
        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        confirmPasswordEditText = findViewById(R.id.confirm_password_edit_text);
        signupButton = findViewById(R.id.signup_button);
        backToLoginText = findViewById(R.id.back_to_login_text);
    }

    /**
     * Setup LiveData observers
     */
    private void setupObservers() {
        // Observe signup success
        signupViewModel.getSignupSuccess().observe(this, isSuccess -> {
            if (isSuccess) {
                Log.d(TAG, "Signup successful");
                // Navigate to main activity
                navigateToMainActivity();
            }
        });

        // Observe signup message
        signupViewModel.getSignupMessage().observe(this, message -> {
            if (message != null && !message.isEmpty()) {
                showMessage(message);
            }
        });

        // Observe loading state
        signupViewModel.getIsLoading().observe(this, isLoading -> {
            signupButton.setEnabled(!isLoading);
            if (isLoading) {
                signupButton.setText(R.string.loading);
            } else {
                signupButton.setText(R.string.signup_button);
            }
        });

        // Observe name error
        signupViewModel.getNameError().observe(this, error -> {
            if (error != null && !error.isEmpty()) {
                nameEditText.setError(error);
            }
        });

        // Observe email error
        signupViewModel.getEmailError().observe(this, error -> {
            if (error != null && !error.isEmpty()) {
                emailEditText.setError(error);
            }
        });

        // Observe password error
        signupViewModel.getPasswordError().observe(this, error -> {
            if (error != null && !error.isEmpty()) {
                passwordEditText.setError(error);
            }
        });

        // Observe confirm password error
        signupViewModel.getConfirmPasswordError().observe(this, error -> {
            if (error != null && !error.isEmpty()) {
                confirmPasswordEditText.setError(error);
            }
        });
    }

    /**
     * Setup UI event listeners
     */
    private void setupUI() {
        signupButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String confirmPassword = confirmPasswordEditText.getText().toString();
            signupViewModel.signup(name, email, password, confirmPassword);
        });

        backToLoginText.setOnClickListener(v -> {
            Log.d(TAG, "Back to login clicked");
            navigateToLoginActivity();
        });
    }

    /**
     * Navigate to MainActivity after successful signup
     */
    private void navigateToMainActivity() {
        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    /**
     * Navigate back to LoginActivity
     */
    private void navigateToLoginActivity() {
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
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

