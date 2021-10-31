package com.spdapps.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.spdapps.FrgMenu.Frg_Beranda;
import com.spdapps.FrgMenu.Frg_data_gedung;
import com.example.spdsosialdanphysicaldistance.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView dashboardMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dashboardMenu = findViewById(R.id.dashboard_menu);
        dashboardMenu.setOnItemSelectedListener(this);
        dashboardMenu.setSelectedItemId(R.id.menu_beranda);
    }

    private void loadFragment (Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.fr_show, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            //action ketika ditekan
            case R.id.menu_beranda:
                loadFragment(new Frg_Beranda());
                break;

            case R.id.menu_list_data:
                loadFragment(new Frg_data_gedung());
                break;

            case R.id.menu_riwayat:
                break;

            case R.id.menu_akun:
                break;
        }
        return false;
    }
}