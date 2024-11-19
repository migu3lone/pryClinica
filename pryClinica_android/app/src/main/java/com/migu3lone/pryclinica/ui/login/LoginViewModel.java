package com.migu3lone.pryclinica.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.migu3lone.pryclinica.data.LoginRepository;
import com.migu3lone.pryclinica.data.Result;
import com.migu3lone.pryclinica.data.model.LoggedInUser;
import com.migu3lone.pryclinica.R;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String userId, String password) {
        // can be launched in a separate asynchronous job
        Result<LoggedInUser> result = loginRepository.login(userId, password);

        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    public void loginDataChanged(String userId, String password) {
        if (!isUserIdValid(userId)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_user_id, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // Validación del ID de usuario
    private boolean isUserIdValid(String userId) {
        return userId != null && !userId.trim().isEmpty();
    }

    // Validación de la contraseña
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
