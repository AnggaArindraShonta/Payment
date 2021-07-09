package com.example.pay.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pay.R;
import com.example.pay.adapter.IphoneAdapter;
import com.example.pay.data.IphoneData;
import com.example.pay.model.Iphone;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView rv;
    private ArrayList<Iphone> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv = view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        list.addAll(IphoneData.getListData());
        showRecyclerList();
        return view;

    }

    private void showRecyclerList() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        rv.setLayoutManager(mLayoutManager);
        IphoneAdapter shoesAdapter = new IphoneAdapter(list);
        rv.setAdapter(shoesAdapter);

    }
}