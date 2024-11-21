package com.migu3lone.pryclinica.connection;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import com.migu3lone.pryclinica.beans.usuario;

public interface ApiServiceLogin {
    // Endpoint para iniciar sesión
    @POST("apiLogin.php")
    Call<ResponseMessage<usuario>> login(@Body JsonObject loginData);
}
