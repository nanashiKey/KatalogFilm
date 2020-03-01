package com.ngopidev.project.katalogfilm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ngopidev.project.katalogfilm.R;
import com.ngopidev.project.katalogfilm.appshelper.FilmModel;

import java.util.ArrayList;

/**
 * created by Irfan Assidiq on 2020-03-01
 * email : assidiq.irfan@gmail.com
 **/
public class KatalogFilmAdapter extends RecyclerView.Adapter<KatalogFilmAdapter.KatalogFilmViewHolder> {

    private ArrayList<FilmModel> listFilm;
    private Context ctx;
    public KatalogFilmAdapter(){

    }

    public KatalogFilmAdapter(Context ctx, ArrayList<FilmModel> listFilm){
        this.ctx = ctx;
        this.listFilm = listFilm;
    }

    @NonNull
    @Override
    public KatalogFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_list, parent, false);
        return new KatalogFilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KatalogFilmViewHolder holder, int position) {
        FilmModel filmModel = listFilm.get(position);
        holder.tvPenulis.setText(filmModel.nama_penulis);
        holder.tvJudul.setText(filmModel.judul_buku);
        Glide.with(ctx)
                .load(filmModel.image)
                .error(R.drawable.ic_film)
                .placeholder(R.drawable.ic_film)
                .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    class KatalogFilmViewHolder extends RecyclerView.ViewHolder{
        CardView cdView;
        ImageView imgView;
        TextView tvJudul, tvPenulis;
        KatalogFilmViewHolder(View itemView){
            super(itemView);
            cdView = itemView.findViewById(R.id.cdView);
            imgView = itemView.findViewById(R.id.imgPreview);
            tvJudul = itemView.findViewById(R.id.tvJudulFilm);
            tvPenulis = itemView.findViewById(R.id.tvPenulis);
        }
    }
}
