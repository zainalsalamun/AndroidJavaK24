package com.androidjava.k24.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.androidjava.k24.R;
import com.androidjava.k24.entity.DataFilter;
import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<DataFilter> dataList;
    private Context context;

    public RecyclerViewAdapter(ArrayList<DataFilter> dataList){
        this.dataList = dataList;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nama, alamat, tgllahir;
        private ImageButton Overflow;

        ViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            nama = itemView.findViewById(R.id.nama);
            alamat = itemView.findViewById(R.id.alamat);
            Overflow = itemView.findViewById(R.id.overflow);
            tgllahir = itemView.findViewById(R.id.tgl_lahir);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final String Nama = dataList.get(position).getNama();
        final String Alamat = dataList.get(position).getAlamat();
        final String Tgllahir = dataList.get(position).getTglLahir();
        holder.nama.setText(Nama);
        holder.alamat.setText(Alamat);
        holder.tgllahir.setText(Tgllahir);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setFilter(ArrayList<DataFilter> filterList){
        dataList = new ArrayList<>();
        dataList.addAll(filterList);
        notifyDataSetChanged();
    }

}