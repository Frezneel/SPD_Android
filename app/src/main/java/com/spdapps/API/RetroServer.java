package com.spdapps.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
//    alamat url database
    private static final String baseURL = "https://spd-2021.herokuapp.com/";
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
