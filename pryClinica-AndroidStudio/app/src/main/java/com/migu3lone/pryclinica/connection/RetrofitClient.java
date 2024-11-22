package com.migu3lone.pryclinica.connection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
<<<<<<< Updated upstream:pryClinica-AndroidStudio/app/src/main/java/com/migu3lone/pryclinica/connection/RetrofitClient.java
    //private static final String baseUrl = "http://192.168.20.22/pryClinica/";
=======
    //12345678private static final String baseUrl = "http://192.168.20.22/pryClinica/";
>>>>>>> Stashed changes:app/src/main/java/com/migu3lone/pryclinica/connection/RetrofitClient.java
    private static final String baseUrl = "http://10.0.2.2/pryClinica/";

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static ApiServiceLogin getApiService() {
        return getClient().create(ApiServiceLogin.class);
    }
}