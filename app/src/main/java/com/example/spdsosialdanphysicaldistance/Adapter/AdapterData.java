package com.example.spdsosialdanphysicaldistance.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spdsosialdanphysicaldistance.Model.DataModel;
import com.example.spdsosialdanphysicaldistance.R;
import com.google.android.material.transition.Hold;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<DataModel> listDataMasuk;

    public AdapterData(Context ctx, List<DataModel> listDataMasuk) {
        this.ctx = ctx;
        this.listDataMasuk = listDataMasuk;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listDataMasuk.get(position);
        holder.tvid.setText(String.valueOf(dm.getId()));
        holder.tvnama.setText(dm.getNama());
        holder.tvketerangan.setText(dm.getKeterangan());
    }

    @Override
    public int getItemCount() {
        return listDataMasuk.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvid, tvnama, tvketerangan;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvid = itemView.findViewById(R.id.tv_id);
            tvnama = itemView.findViewById(R.id.tv_nama);
            tvketerangan = itemView.findViewById(R.id.tv_keterangan);
        }
    }
}
