package com.example.pay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pay.R;
import com.example.pay.model.Iphone;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class IphoneAdapter extends RecyclerView.Adapter<IphoneAdapter.ListViewHolder> {

    private final ArrayList<Iphone> listIphone;
    private OnItemClickCallback onItemClickCallback;


    public IphoneAdapter(ArrayList<Iphone> listIphone) {
        this.listIphone = listIphone;

    }

    @NonNull
    @NotNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_iphone, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListViewHolder holder, int position) {
        Iphone iphone = listIphone.get(position);
        Glide.with(holder.itemView.getContext())
                .load(iphone.getImage())
                .apply(new RequestOptions())
                .into(holder.img_iphone);
        holder.name.setText(iphone.getIphone_name());
        holder.type.setText(iphone.getType());
        holder.price.setText(iphone.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listIphone.get(holder.getAdapterPosition()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return listIphone.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView img_iphone;
        TextView name, type, price;

        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img_iphone = itemView.findViewById(R.id.img_iphone);
            name = itemView.findViewById(R.id.iphone_name);
            type = itemView.findViewById(R.id.type_iphone);
            price = itemView.findViewById(R.id.price);


        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Iphone data);
    }
}