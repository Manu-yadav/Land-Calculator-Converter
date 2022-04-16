package com.example.landcalculatorconverter.activites;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.landcalculatorconverter.R;
import com.example.landcalculatorconverter.utils.Constants;

public class AreaActivity extends BaseActivity implements View.OnClickListener {
    private CardView mCircleCV;
    private CardView mTriangleCV;
    private CardView mRectangleCV;
    private CardView mTrapeziumCV;
    private CardView mRhombusCV;
    private CardView mEllipseCV;
    private CardView mSquareCV;
    private CardView mPolygonCV;
    private CardView mParallelogramCV;
    private CardView mQuadriletralCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        initView();
        initVariables();
    }

    @Override
    void initView() {
        findViewById(R.id.iv_back_button).setOnClickListener(this);
        findViewById(R.id.iv_share_button).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.tv_title)).setText("Geometry Area");
        //--------------------
        mCircleCV = (CardView) findViewById(R.id.circle);
        mTriangleCV = (CardView) findViewById(R.id.triangle);
        mRectangleCV = (CardView) findViewById(R.id.rectangle);
        mTrapeziumCV = (CardView) findViewById(R.id.trapezium);
        mRhombusCV = (CardView) findViewById(R.id.rhombus);
        mEllipseCV = (CardView) findViewById(R.id.ellipse);
        mSquareCV = (CardView) findViewById(R.id.square);
        mPolygonCV = (CardView) findViewById(R.id.polygon);
        mParallelogramCV = (CardView) findViewById(R.id.parallelogram);
        mQuadriletralCV = (CardView) findViewById(R.id.quadriletral);
        mCircleCV.setOnClickListener(this);
        mTriangleCV.setOnClickListener(this);
        mRectangleCV.setOnClickListener(this);
        mTrapeziumCV.setOnClickListener(this);
        mRhombusCV.setOnClickListener(this);
        mEllipseCV.setOnClickListener(this);
        mSquareCV.setOnClickListener(this);
        mPolygonCV.setOnClickListener(this);
        mParallelogramCV.setOnClickListener(this);
        mQuadriletralCV.setOnClickListener(this);
    }

    @Override
    void initVariables() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.circle:
                Intent circle = new Intent(this, AreaCalculationActivity.class);
                circle.putExtra(Constants.FIGURE, Constants.CIRCLE);
                circle.putExtra(Constants.FIGURE_COLOR, getViewBackGroundColor(mCircleCV));
                startActivity(circle);
                break;
            case R.id.triangle:
                Intent triangle = new Intent(this, AreaCalculationActivity.class);
                triangle.putExtra(Constants.FIGURE, Constants.TRIANGLE);
                triangle.putExtra(Constants.FIGURE_COLOR, getViewBackGroundColor(mTriangleCV));
                startActivity(triangle);
                break;
            case R.id.rectangle:
                Intent rectangle = new Intent(this, AreaCalculationActivity.class);
                rectangle.putExtra(Constants.FIGURE, Constants.RECTANGLE);
                rectangle.putExtra(Constants.FIGURE_COLOR, getViewBackGroundColor(mRectangleCV));
                startActivity(rectangle);
                break;
            case R.id.trapezium:
                Intent trapezium = new Intent(this, AreaCalculationActivity.class);
                trapezium.putExtra(Constants.FIGURE, Constants.TRAPEZIUM);
                trapezium.putExtra(Constants.FIGURE_COLOR, getViewBackGroundColor(mTrapeziumCV));
                startActivity(trapezium);
                break;
            case R.id.rhombus:
                Intent rhombus = new Intent(this, AreaCalculationActivity.class);
                rhombus.putExtra(Constants.FIGURE, Constants.RHOMBUS);
                rhombus.putExtra(Constants.FIGURE_COLOR, getViewBackGroundColor(mRhombusCV));
                startActivity(rhombus);
                break;
            case R.id.ellipse:
                Intent ellipse = new Intent(this, AreaCalculationActivity.class);
                ellipse.putExtra(Constants.FIGURE, Constants.ELLIPSE);
                ellipse.putExtra(Constants.FIGURE_COLOR, getViewBackGroundColor(mEllipseCV));
                startActivity(ellipse);
                break;
            case R.id.square:
                Intent square = new Intent(this, AreaCalculationActivity.class);
                square.putExtra(Constants.FIGURE, Constants.SQUARE);
                square.putExtra(Constants.FIGURE_COLOR, getViewBackGroundColor(mSquareCV));
                startActivity(square);
                break;
            case R.id.polygon:
                Intent polygon = new Intent(this, AreaCalculationActivity.class);
                polygon.putExtra(Constants.FIGURE, Constants.POLYGON);
                polygon.putExtra(Constants.FIGURE_COLOR, getViewBackGroundColor(mPolygonCV));
                startActivity(polygon);
                break;
            case R.id.parallelogram:
                Intent parallelogram = new Intent(this, AreaCalculationActivity.class);
                parallelogram.putExtra(Constants.FIGURE, Constants.PARALLELOGRAM);
                parallelogram.putExtra(Constants.FIGURE_COLOR, getViewBackGroundColor(mParallelogramCV));
                startActivity(parallelogram);
                break;
            case R.id.quadriletral:
                Intent quadriletral = new Intent(this, AreaCalculationActivity.class);
                quadriletral.putExtra(Constants.FIGURE, Constants.QUADRILATERAL);
                quadriletral.putExtra(Constants.FIGURE_COLOR, getViewBackGroundColor(mQuadriletralCV));
                startActivity(quadriletral);
                break;
            case R.id.iv_back_button:
                onBackPressed();
                break;
        }
    }

    private int getViewBackGroundColor(View view) {
        ColorStateList color = ((CardView) view).getCardBackgroundColor();
        return color.getDefaultColor();
    }
}