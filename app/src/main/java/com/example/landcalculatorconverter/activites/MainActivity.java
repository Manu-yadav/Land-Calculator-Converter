package com.example.landcalculatorconverter.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.example.landcalculatorconverter.BuildConfig;
import com.example.landcalculatorconverter.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private CardView mAreaCV;
    private CardView mLandAreaCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initVariables();
    }

    @Override
    void initView() {
        mAreaCV = (CardView) findViewById(R.id.cv_area);
        mLandAreaCV = (CardView) findViewById(R.id.cv_land_area);
        mAreaCV.setOnClickListener(this);
        mLandAreaCV.setOnClickListener(this);
        findViewById(R.id.iv_back_button).setVisibility(View.GONE);
        findViewById(R.id.iv_share_button).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_title)).setText("Area Calculator");
    }

    @Override
    void initVariables() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cv_area:
                Intent intent = new Intent(this, AreaActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_land_area:
                Toast.makeText(this, "Under development", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_share_button:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
                    String shareMessage = "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}