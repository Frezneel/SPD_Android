package com.spdapps.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

public class SessionManagerDosen {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String IS_LOGGED_IN = "s_isLoggedIn";
    private static final String ID = "sd_id";
    private static final String NIP = "sd_nip";
    private static final String NAMA = "sd_nama";
    private static final String JURUSAN = "sd_jurusan";

    public SessionManagerDosen (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(DataModelAkunDosen akun){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID, akun.getId());
        editor.putString(NIP, akun.getNip());
        editor.putString(NAMA, akun.getNama());
        editor.putString(JURUSAN, akun.getJurusan());
        editor.commit();
    }

    public HashMap<String,String> getAkunDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(ID, sharedPreferences.getString(ID,null));
        user.put(NIP, sharedPreferences.getString(NIP, null));
        user.put(NAMA, sharedPreferences.getString(NAMA, null));
        user.put(JURUSAN, sharedPreferences.getString(JURUSAN, null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

}
