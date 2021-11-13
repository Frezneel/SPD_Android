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
import com.spdapps.Model.SessionManager;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView dashboardMenu;
    private SessionManager sessionManager;

    String nim, nama, jurusan, prodi, kelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dashboardMenu = findViewById(R.id.dashboard_menu);
        dashboardMenu.setOnNavigationItemSelectedListener(this);
        dashboardMenu.setSelectedItemId(R.id.menu_beranda);

        sessionManager = new SessionManager(MainActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        nim = sessionManager.getAkunDetail().get("s_nim");
        nama = sessionManager.getAkunDetail().get("s_nama");
        jurusan = sessionManager.getAkunDetail().get("s_jurusan");
        prodi = sessionManager.getAkunDetail().get("s_prodi");
        kelas = sessionManager.getAkunDetail().get("s_nama");

    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginMhs.class);
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

            case R.id.menu_list_data:
                loadFragment(new Frg_data_gedung());
                break;

            case R.id.menu_scan:
                Intent tampilScan = new Intent(MainActivity.this, tampilQrcode.class);
                startActivity(tampilScan);
                break;

            case R.id.menu_riwayat:
                loadFragment(new Frg_riwayat());
                break;

            case R.id.menu_akun:
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