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
        History history = historyList.get(position);
        historyHolder.namapembayaran.setText(history.getNamapembayaran());
        historyHolder.tanggal.setText(history.getTanggal());
        historyHolder.metodepembayaran.setText(history.getMetodepembayaran());
        historyHolder.status.setText(history.getStatus());
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
        private TextView namapembayaran;
        private TextView tanggal;
        private TextView metodepembayaran;
        private TextView status;

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            namapembayaran = itemView.findViewById(R.id.tvNamaPembayaran);
            tanggal = itemView.findViewById(R.id.tvTanggal);
            metodepembayaran = itemView.findViewById(R.id.tvMetodePembayaran);
            status = itemView.findViewById(R.id.tvStatus);
        }
    }
}