package com.spdapps.FrgMenuDosen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.spdsosialdanphysicaldistance.R;

public class Frg_Beranda_ds extends Fragment {
    View view;
    TextView tvNama, tvNIP, tvJurusan, tvProdi, tvKelas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_beranda, container, false);

        tvNama = view.findViewById(R.id.tv_nama);
        tvNIP = view.findViewById(R.id.tv_nim);
        tvJurusan = view.findViewById(R.id.tv_jurusan);
        tvProdi = view.findViewById(R.id.tv_prodi);
        tvKelas = view.findViewById(R.id.tv_kelas);

        tvNama.setText(getArguments().getString("b_nama"));
        tvNIP.setText(getArguments().getString("b_nip"));
        tvJurusan.setText(getArguments().getString("b_jurusan"));
        tvProdi.setVisibility(View.GONE);
        tvKelas.setText(getArguments().getString("b_kelas"));

        return view;
    }
}
