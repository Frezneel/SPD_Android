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

import com.example.spdsosialdanphysicaldistance.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.spdapps.FrgMenu.Frg_Beranda;
import com.spdapps.FrgMenu.Frg_akun;
import com.spdapps.FrgMenu.Frg_data_gedung;
import com.spdapps.FrgMenu.Frg_riwayat;
import com.spdapps.FrgMenuDosen.Frg_Beranda_ds;
import com.spdapps.FrgMenuDosen.Frg_akun_ds;
import com.spdapps.FrgMenuDosen.Frg_data_kelas_ds;
import com.spdapps.FrgMenuDosen.Frg_riwayat_ds;
import com.spdapps.Model.SessionManagerDosen;
import com.spdapps.Model.SessionManagerMhs;

public class MainActivityDosen extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView dashboardMenu;
    private SessionManagerDosen sessionManagerDs;

    String nip, nama, jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dosen);

        dashboardMenu = findViewById(R.id.dashboard_menu);
        dashboardMenu.setOnNavigationItemSelectedListener(this);
        dashboardMenu.setSelectedItemId(R.id.menu_beranda);

        sessionManagerDs = new SessionManagerDosen(MainActivityDosen.this);
        if(!sessionManagerDs.isLoggedIn()){
            moveToLogin();
        }
        nip = sessionManagerDs.getAkunDetail().get("sd_nip");
        nama = sessionManagerDs.getAkunDetail().get("sd_nama");
        jurusan = sessionManagerDs.getAkunDetail().get("sd_jurusan");

    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivityDosen.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    private void loadFragment (Fragment fragment){
        Bundle data = new Bundle();
        data.putString("b_nip",nip);
        data.putString("b_nama",nama);
        data.putString("b_jurusan",jurusan);

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
                loadFragment(new Frg_data_kelas_ds());
                break;

            case R.id.menu_riwayat:
                loadFragment(new Frg_riwayat_ds());
                break;

            case R.id.menu_setting:
                loadFragment(new Frg_akun_ds());
                break;

            default:
                Handler waitData = new Handler();
                waitData.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadFragment(new Frg_Beranda_ds());
                    }
                },150);
                break;

        }
        return true;
    }
}