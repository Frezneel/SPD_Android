package com.spdapps.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.spdapps.FrgMenu.Frg_Beranda;
import com.spdapps.FrgMenu.Frg_akun;
import com.spdapps.FrgMenu.Frg_data_gedung;
import com.example.spdsosialdanphysicaldistance.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.spdapps.FrgMenu.Frg_riwayat;
import com.spdapps.Model.SessionManagerDosen;
import com.spdapps.Model.SessionManagerMhs;

public class MainActivityMhs extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView dashboardMenu;
    private SessionManagerMhs sessionManagerMhs;

    String nim, nama, jurusan, prodi, kelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mhs);

        dashboardMenu = findViewById(R.id.dashboard_menu);
        dashboardMenu.setOnNavigationItemSelectedListener(this);
        dashboardMenu.setSelectedItemId(R.id.menu_beranda);

        sessionManagerMhs = new SessionManagerMhs(MainActivityMhs.this);
        if(!sessionManagerMhs.isLoggedIn()){
            moveToLogin();
        }

        nim = sessionManagerMhs.getAkunDetail().get("s_nim");
        nama = sessionManagerMhs.getAkunDetail().get("s_nama");
        jurusan = sessionManagerMhs.getAkunDetail().get("s_jurusan");
        prodi = sessionManagerMhs.getAkunDetail().get("s_prodi");
        kelas = sessionManagerMhs.getAkunDetail().get("s_kelas");

    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivityMhs.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    private void loadFragment (Fragment fragment){
        Bundle data = new Bundle();
        data.putString("b_nim",nim);
        data.putString("b_nama",nama);
        data.putString("b_jurusan",jurusan);
        data.putString("b_prodi", prodi);
        data.putString("b_kelas",kelas);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragment.setArguments(data);
        fragmentTransaction.replace(R.id.fr_show, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            //action ketika ditekan

            case R.id.kelas:
                loadFragment(new Frg_data_gedung());
                break;

            case R.id.menu_riwayat:
                loadFragment(new Frg_riwayat());
                break;

            case R.id.menu_setting:
                loadFragment(new Frg_akun());
                break;

            default:
                Handler waitData = new Handler();
                waitData.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    loadFragment(new Frg_Beranda());
                    }
                },150);
                break;

        }
        return true;
    }

}