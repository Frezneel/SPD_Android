package com.spdapps.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
//    alamat url database
    private static final String baseURL = "http://192.168.1.10/spd/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit(){
        if(retro == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create(gson)) //menconvert data ke json
                    .build();
        }
        return  retro;
    }
}
