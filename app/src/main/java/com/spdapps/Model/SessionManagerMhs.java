package com.spdapps.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

public class SessionManagerMhs {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String IS_LOGGED_IN = "s_isLoggedIn";
    private static final String ID = "s_id";
    private static final String NIM = "s_nim";
    private static final String NAMA = "s_nama";
    private static final String JURUSAN = "s_jurusan";
    private static final String PRODI = "s_prodi";
    private static final String KELAS = "s_kelas";

    public SessionManagerMhs(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(DataModelAkunMhs akun){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID, akun.getId());
        editor.putString(NIM, akun.getNim());
        editor.putString(NAMA, akun.getNama());
        editor.putString(JURUSAN, akun.getJurusan());
        editor.putString(PRODI, akun.getProdi());
        editor.putString(KELAS, akun.getKelas());
        editor.commit();
    }

    public HashMap<String,String> getAkunDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(ID, sharedPreferences.getString(ID,null));
        user.put(NIM, sharedPreferences.getString(NIM, null));
        user.put(NAMA, sharedPreferences.getString(NAMA, null));
        user.put(JURUSAN, sharedPreferences.getString(JURUSAN, null));
        user.put(PRODI, sharedPreferences.getString(PRODI, null));
        user.put(KELAS, sharedPreferences.getString(KELAS, null));
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
