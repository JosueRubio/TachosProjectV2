package com.example.tachosprojectv2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import static com.example.tachosprojectv2.R.color.colorAccent;


public class AdapterDisponibilidad extends RecyclerView.Adapter<AdapterDisponibilidad.ImageViewHolder>{

    private Context mContext;
    private ArrayList<ModeloControl> mUploads;
    private OnItemClickListener mListener;
    View v;

    public AdapterDisponibilidad(Context context, ArrayList<ModeloControl> uploads){
        mContext = context;
        mUploads = uploads;

    }



    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(mContext).inflate(R.layout.cardview_disponibilidad, parent, false);

        return new ImageViewHolder(v);
    }


    @Override
    public void onBindViewHolder( ImageViewHolder holder, int position) {

        //DE MANERA ITERATIVA

        ModeloControl uploadCurrent = mUploads.get(position);
        holder.tvEspacio.setText(String.valueOf(uploadCurrent.getEspacio()));

        if(uploadCurrent.getOcupado().equals("SI")){
//            holder.tvEspacio.setTextColor(Color.parseColor("#0000FF"));
            holder.imageView2.setImageResource(R.drawable.ic_menu_send);
        }


    }

    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvEspacio;
        ImageView imageView2;

        public ImageViewHolder(View itemView) {
            super(itemView);
            tvEspacio = itemView.findViewById(R.id.tvEspacio);
            imageView2 = itemView.findViewById(R.id.imageView2);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mListener!=null){
                int position = getAdapterPosition();
                if ( position!= RecyclerView.NO_POSITION){
                    mListener.onItemClick(position);
                }
            }


        }

    }//IMAGEVIEWHOLDER


    public interface  OnItemClickListener{
        void onItemClick(int position);


    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

}
