package com.example.landcalculatorconverter.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.landcalculatorconverter.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    abstract void initView();

    abstract void initVariables();
}