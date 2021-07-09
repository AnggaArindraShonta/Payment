package com.example.pay.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.pay.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class PaymentFragment extends Fragment {

    private Activity mActivity;
    private Context mContext;

    private ViewGroup contentFrame;
    private ZXingScannerView zXingScannerView;
    private int camId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVar();
        zXingScannerView = new ZXingScannerView(mActivity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_payment, container, false);
        initView(rootView);
        return rootView;
    }

    private void initVar() {
        mActivity = getActivity();
        mContext = mActivity.getApplicationContext();
    }


    private void initView(View rootView) {
        contentFrame = (ViewGroup) rootView.findViewById(R.id.scanner);

    }

    private void activateScanner() {
        if(zXingScannerView != null) {

            if(zXingScannerView.getParent()!=null) {
                ((ViewGroup) zXingScannerView.getParent()).removeView(zXingScannerView); // to prevent crush on re adding view
            }
            contentFrame.addView(zXingScannerView);

            if(zXingScannerView.isActivated()) {
                zXingScannerView.stopCamera();
            }

            zXingScannerView.startCamera(camId);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        activateScanner();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(zXingScannerView != null) {
            zXingScannerView.stopCamera();
        }
    }

}