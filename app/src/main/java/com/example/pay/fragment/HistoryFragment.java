package com.example.pay.fragment;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pay.R;
import com.example.pay.history.History;
import com.example.pay.history.HistoryAdapter;
import com.example.pay.history.HistoryViewModel;

import java.util.List;

public class HistoryFragment extends Fragment {

    private HistoryViewModel historyViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rvListHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        HistoryAdapter adapter = new HistoryAdapter();
        recyclerView.setAdapter(adapter);

        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        historyViewModel.getAllHistory().observe(getViewLifecycleOwner(), new Observer<List<History>>() {
            @Override
            public void onChanged(List<History> histories) {
                adapter.setHistoryList(histories);
            }
        });
        return view;
    }
}