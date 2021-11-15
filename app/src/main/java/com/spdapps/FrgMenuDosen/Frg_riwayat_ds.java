package com.spdapps.FrgMenuDosen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.spdsosialdanphysicaldistance.R;

public class Frg_riwayat_ds extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_riwayat, container, false);


        return view;
    }
}
