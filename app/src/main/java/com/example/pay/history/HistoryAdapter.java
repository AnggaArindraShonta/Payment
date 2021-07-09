package com.example.pay.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pay.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> implements Filterable {

    private List<History> historyList = new ArrayList<>();

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_history,viewGroup, false);
        return new HistoryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryHolder historyHolder, int position) {
        History pengenDoa = historyList.get(position);
        historyHolder.title.setText(pengenDoa.getNamapembayaran());
        historyHolder.arabic.setText(pengenDoa.getTanggal());
        historyHolder.latin.setText(pengenDoa.getMetodepembayaran());
        historyHolder.translation.setText(pengenDoa.getStatus());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public void setHistoryList(List<History>historyList){
        this.historyList = historyList;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    class HistoryHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView arabic;
        private TextView latin;
        private TextView translation;

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvNamaPembayaran);
            arabic = itemView.findViewById(R.id.tvTanggal);
            latin = itemView.findViewById(R.id.tvMetodePembayaran);
            translation = itemView.findViewById(R.id.tvStatus);
        }
    }
}