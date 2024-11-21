package com.migu3lone.pryclinica.ui.login;

import androidx.annotation.Nullable;

/**
 * Data validation state of the login form.
 */
public class LoginFormState {
    private boolean isDataValid;
    private Integer emailError;
    private Integer passwordError;

    public LoginFormState(boolean isDataValid) {
        this.isDataValid = isDataValid;
        this.emailError = null;
        this.passwordError = null;
    }

    public LoginFormState(Integer emailError, Integer passwordError) {
        this.emailError = emailError;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    public boolean isDataValid() {
        return isDataValid;
    }

    public Integer getEmailError() {
        return emailError;
    }

    public Integer getPasswordError() {
        return passwordError;
    }
}
