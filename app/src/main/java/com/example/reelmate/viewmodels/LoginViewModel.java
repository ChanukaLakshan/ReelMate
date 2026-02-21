package com.example.reelmate.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Log;

import com.example.reelmate.repositories.AuthRepository;
import com.example.reelmate.utils.ValidationUtil;

/**
 * LoginViewModel for Login Activity
 * Handles login screen logic and state management
 * This is the first module created by Chanuka Lakshan
 */
public class LoginViewModel extends ViewModel {
    private static final String TAG = "LoginViewModel";
    
    private final AuthRepository authRepository = new AuthRepository();
    
    private final MutableLiveData<String> emailError = new MutableLiveData<>();
    private final MutableLiveData<String> passwordError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    private final MutableLiveData<String> loginMessage = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loginSuccess = new MutableLiveData<>(false);

    /**
     * Observe email validation error
     */
    public LiveData<String> getEmailError() {
        return emailError;
    }

    /**
     * Observe password validation error
     */
    public LiveData<String> getPasswordError() {
        return passwordError;
    }

    /**
     * Observe loading state
     */
    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    /**
     * Observe login message/error
     */
    public LiveData<String> getLoginMessage() {
        return loginMessage;
    }

    /**
     * Observe login success
     */
    public LiveData<Boolean> getLoginSuccess() {
        return loginSuccess;
    }

    /**
     * Validate email and password input
     */
    public boolean validateInputs(String email, String password) {
        boolean isValid = true;

        // Validate email
        String emailError = ValidationUtil.getEmailErrorMessage(email);
        if (!emailError.isEmpty()) {
            this.emailError.setValue(emailError);
            isValid = false;
        } else {
            this.emailError.setValue("");
        }

        // Validate password
        String passwordError = ValidationUtil.getPasswordErrorMessage(password);
        if (!passwordError.isEmpty()) {
            this.passwordError.setValue(passwordError);
            isValid = false;
        } else {
            this.passwordError.setValue("");
        }

        return isValid;
    }

    /**
     * Attempt user login
     * @param email User email
     * @param password User password
     */
    public void login(String email, String password) {
        Log.d(TAG, "Login attempt for: " + email);

        // Validate inputs
        if (!validateInputs(email, password)) {
            return;
        }

        isLoading.setValue(true);

        // Call repository to perform login
        authRepository.loginUser(email, password, new AuthRepository.AuthCallback() {
            @Override
            public void onSuccess(String message) {
                Log.d(TAG, "Login successful: " + message);
                isLoading.setValue(false);
                loginMessage.setValue(message);
                loginSuccess.setValue(true);
            }

            @Override
            public void onError(String error) {
                Log.e(TAG, "Login failed: " + error);
                isLoading.setValue(false);
                loginMessage.setValue(error);
                loginSuccess.setValue(false);
            }
        });
    }

    /**
     * Clear all error messages
     */
    public void clearErrors() {
        emailError.setValue("");
        passwordError.setValue("");
    }
}
