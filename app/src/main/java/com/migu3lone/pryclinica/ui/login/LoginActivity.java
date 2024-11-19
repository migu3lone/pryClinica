package com.migu3lone.pryclinica.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.migu3lone.pryclinica.MainActivity;
import com.migu3lone.pryclinica.R;
import com.migu3lone.pryclinica.beans.usuario;
import com.migu3lone.pryclinica.connection.ApiServiceLogin;
import com.migu3lone.pryclinica.connection.RetrofitClient;
import com.migu3lone.pryclinica.connection.ResponseMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText idUsuarioEditText, passwordEditText;
    private Button loginButton;
    private ProgressBar loadingProgressBar;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE);

        // Si ya está autenticado, redirige al MainActivity
        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        idUsuarioEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        loadingProgressBar = findViewById(R.id.loading);

        // Deshabilitar el botón de inicio de sesión por defecto
        loginButton.setEnabled(false);

        // Añadir el TextWatcher para habilitar el botón solo cuando ambos campos estén llenos
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                validateLoginFields();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };

        // Aplicar el TextWatcher a ambos EditText
        idUsuarioEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);

        // Configuración del botón de inicio de sesión
        loginButton.setOnClickListener(v -> {
            loadingProgressBar.setVisibility(View.VISIBLE);
            String idUsuario = idUsuarioEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            loginUser(idUsuario, password);
        });
    }

    private void validateLoginFields() {
        String idUsuario = idUsuarioEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Habilitar el botón de login solo si ambos campos tienen texto
        loginButton.setEnabled(!idUsuario.isEmpty() && !password.isEmpty());
    }

    private void loginUser(String idUsuario, String password) {
        ApiServiceLogin apiService = RetrofitClient.getApiService();

        JsonObject loginData = new JsonObject();
        loginData.addProperty("idUsuario", idUsuario);
        loginData.addProperty("password", password);

        Call<ResponseMessage<usuario>> call = apiService.login(loginData);
        call.enqueue(new Callback<ResponseMessage<usuario>>() {
            @Override
            public void onResponse(Call<ResponseMessage<usuario>> call, Response<ResponseMessage<usuario>> response) {
                loadingProgressBar.setVisibility(View.GONE);

                // Verifica el código de estado HTTP
                if (response.isSuccessful()) {
                    ResponseMessage<usuario> responseBody = response.body();

                    if (responseBody != null) {
                        // Debug: Verifica el contenido de la respuesta
                        Log.d("Login", "Success: " + responseBody.getSuccess());

                        if (responseBody.getSuccess()) {
                            usuario user = responseBody.getData();
                            // Si usas Retrofit o alguna librería similar
                            Log.d("LoginActivity", "Nombres: " + user.getNombres());
                            Log.d("LoginActivity", "Rol: " + user.getRol());


                            // Guardar estado de autenticación
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("isLoggedIn", true);
                            //editor.putString("userName", user.getNombres());
                            //editor.putString("userRole", user.getRol()); // Guardar el rol
                            //editor.apply();
                            Log.d("LoginActivity", "Nombres: " + user.getNombres());
                            Log.d("LoginActivity", "Rol: " + user.getRol());

                            // Redirigir a MainActivity
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("userName", user.getNombres());
                            intent.putExtra("userRole", user.getRol());
                            Log.d("LoginActivity", "userName: " + user.getNombres());
                            Log.d("LoginActivity", "userRole: " + user.getRol());

                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Inicio de sesión fallido: Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Respuesta inesperada del servidor", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Error de conexión: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage<usuario>> call, Throwable t) {
                loadingProgressBar.setVisibility(View.GONE);
                Log.e("Login", "Error en la conexión: " + t.getMessage());
                Toast.makeText(LoginActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
