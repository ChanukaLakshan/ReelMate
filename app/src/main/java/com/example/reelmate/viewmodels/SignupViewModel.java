package com.example.reelmate.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Log;

import com.example.reelmate.repositories.AuthRepository;
import com.example.reelmate.utils.ValidationUtil;

/**
 * SignupViewModel for Signup Activity
 * Handles signup screen logic and state management
 */
public class SignupViewModel extends ViewModel {
    private static final String TAG = "SignupViewModel";

    private final AuthRepository authRepository = new AuthRepository();

    private final MutableLiveData<String> nameError = new MutableLiveData<>();
    private final MutableLiveData<String> emailError = new MutableLiveData<>();
    private final MutableLiveData<String> passwordError = new MutableLiveData<>();
    private final MutableLiveData<String> confirmPasswordError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    private final MutableLiveData<String> signupMessage = new MutableLiveData<>();
    private final MutableLiveData<Boolean> signupSuccess = new MutableLiveData<>(false);

    /**
     * Observe name validation error
     */
    public LiveData<String> getNameError() {
        return nameError;
    }

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
     * Observe confirm password validation error
     */
    public LiveData<String> getConfirmPasswordError() {
        return confirmPasswordError;
    }

    /**
     * Observe loading state
     */
    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    /**
     * Observe signup message/error
     */
    public LiveData<String> getSignupMessage() {
        return signupMessage;
    }

    /**
     * Observe signup success
     */
    public LiveData<Boolean> getSignupSuccess() {
        return signupSuccess;
    }

    /**
     * Validate name, email, password and confirm password input
     */
    public boolean validateInputs(String name, String email, String password, String confirmPassword) {
        boolean isValid = true;

        // Validate name
        String nameError = ValidationUtil.getNameErrorMessage(name);
        if (!nameError.isEmpty()) {
            this.nameError.setValue(nameError);
            isValid = false;
        } else {
            this.nameError.setValue("");
        }

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

        // Validate confirm password
        if (!password.equals(confirmPassword)) {
            this.confirmPasswordError.setValue("Passwords do not match");
            isValid = false;
        } else if (confirmPassword.isEmpty()) {
            this.confirmPasswordError.setValue("Please confirm your password");
            isValid = false;
        } else {
            this.confirmPasswordError.setValue("");
        }

        return isValid;
    }

    /**
     * Attempt user signup
     * @param name User full name
     * @param email User email
     * @param password User password
     * @param confirmPassword User password confirmation
     */
    public void signup(String name, String email, String password, String confirmPassword) {
        Log.d(TAG, "Signup attempt for: " + email);

        // Validate inputs
        if (!validateInputs(name, email, password, confirmPassword)) {
            return;
        }

        isLoading.setValue(true);

        // Call repository to perform signup
        authRepository.registerUser(name, email, password, new AuthRepository.AuthCallback() {
            @Override
            public void onSuccess(String message) {
                Log.d(TAG, "Signup successful: " + message);
                isLoading.setValue(false);
                signupMessage.setValue(message);
                signupSuccess.setValue(true);
            }

            @Override
            public void onError(String error) {
                Log.e(TAG, "Signup failed: " + error);
                isLoading.setValue(false);
                signupMessage.setValue(error);
                signupSuccess.setValue(false);
            }
        });
    }

    /**
     * Clear all error messages
     */
    public void clearErrors() {
        nameError.setValue("");
        emailError.setValue("");
        passwordError.setValue("");
        confirmPasswordError.setValue("");
    }
}

