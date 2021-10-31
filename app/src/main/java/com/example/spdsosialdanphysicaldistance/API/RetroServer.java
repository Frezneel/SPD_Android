package com.example.spdsosialdanphysicaldistance.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
//    alamat url database
    private static final String baseURL = "http://192.168.0.102/SPD/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit(){
        if(retro == null){
            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create()) //menconvert data ke json
                    .build();
        }
        return  retro;
    }
}
