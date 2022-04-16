package com.example.landcalculatorconverter.activites;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.landcalculatorconverter.R;
import com.example.landcalculatorconverter.appDialog.AppDialog;
import com.example.landcalculatorconverter.utils.Constants;

public class AreaCalculationActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mIncludeLL;
    private TextView mCheckFormulaTV;
    private TextView mCalculateAreaTV;
    private int mColor;
    private ImageView mFigureIV;
    private String mFigure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_calculation);
        initView();
        initVariables();
    }

    @Override
    void initView() {
        mIncludeLL = (LinearLayout) findViewById(R.id.ll_include);
        mCheckFormulaTV = (TextView) findViewById(R.id.tv_check_formula);
        mCalculateAreaTV = (TextView) findViewById(R.id.tv_calculate_area);
        mFigureIV = (ImageView) findViewById(R.id.iv_figure);
        mCheckFormulaTV.setOnClickListener(this);
        mCalculateAreaTV.setOnClickListener(this);
    }

    @Override
    void initVariables() {
        findViewById(R.id.iv_back_button).setOnClickListener(this);
        findViewById(R.id.iv_share_button).setVisibility(View.GONE);
        TextView title = (TextView) findViewById(R.id.tv_title);
        //--------------------
        Intent intent = getIntent();
        mFigure = intent.getStringExtra(Constants.FIGURE);
        mColor = intent.getIntExtra(Constants.FIGURE_COLOR, 0);
        setColorToButton();
        initViewBasedOnFigure(title);
    }

    private void initViewBasedOnFigure(TextView title) {
        switch (mFigure) {
            case Constants.CIRCLE:
                title.setText(Constants.CIRCLE);
                drawCircleView();
                break;
            case Constants.TRIANGLE:
                title.setText(Constants.TRIANGLE);
                drawTriangleView();
                break;
            case Constants.RECTANGLE:
                drawRectangleView();
                title.setText(Constants.RECTANGLE);
                break;
            case Constants.TRAPEZIUM:
                drawTrapeziumView();
                title.setText(Constants.TRAPEZIUM);
                break;
            case Constants.RHOMBUS:
                drawRhombusView();
                title.setText(Constants.RHOMBUS);
                break;
            case Constants.ELLIPSE:
                drawEllipseView();
                title.setText(Constants.ELLIPSE);
                break;
            case Constants.SQUARE:
                title.setText(Constants.SQUARE);
                mFigureIV.setImageResource(R.drawable.square_area);
                drawSquareView();
                break;
            case Constants.POLYGON:
                drawPolygonView();
                title.setText(Constants.POLYGON);
                break;
            case Constants.PARALLELOGRAM:
                drawParallelogramView();
                title.setText(Constants.PARALLELOGRAM);
                break;
            case Constants.QUADRILATERAL:
                drawQuadrilateralView();
                title.setText(Constants.QUADRILATERAL);
                break;
        }
    }

    private void drawQuadrilateralView() {
        mIncludeLL.removeAllViews();
        View quadrilateralView = getLayoutInflater().inflate(R.layout.quadrilateral_area_calculation, null);
        EditText sideAET = (EditText) quadrilateralView.findViewById(R.id.et_side_a);
        sideAET.requestFocus();
        EditText sideBET = (EditText) quadrilateralView.findViewById(R.id.et_side_b);
        EditText sideCET = (EditText) quadrilateralView.findViewById(R.id.et_side_c);
        TextView areaTV = (TextView) quadrilateralView.findViewById(R.id.tv_area);
        TextView perimeterTV = (TextView) quadrilateralView.findViewById(R.id.tv_parimeter);

        // Setting color for result view................
        ((TextView) quadrilateralView.findViewById(R.id.tv_result)).setTextColor(mColor);
        quadrilateralView.findViewById(R.id.divider_1).setBackgroundColor(mColor);
        quadrilateralView.findViewById(R.id.divider_2).setBackgroundColor(mColor);
        //................................................
        mIncludeLL.addView(quadrilateralView);
    }

    private void drawParallelogramView() {
        mIncludeLL.removeAllViews();
        View parallelogramView = getLayoutInflater().inflate(R.layout.parallelogram_area_calculation, null);
        EditText sideAET = (EditText) parallelogramView.findViewById(R.id.et_side_a);
        sideAET.requestFocus();
        EditText sideBET = (EditText) parallelogramView.findViewById(R.id.et_side_b);
        EditText angleET = (EditText) parallelogramView.findViewById(R.id.et_angle);
        TextView areaTV = (TextView) parallelogramView.findViewById(R.id.tv_area);
        TextView perimeterTV = (TextView) parallelogramView.findViewById(R.id.tv_parimeter);

        // Setting color for result view................
        ((TextView) parallelogramView.findViewById(R.id.tv_result)).setTextColor(mColor);
        parallelogramView.findViewById(R.id.divider_1).setBackgroundColor(mColor);
        parallelogramView.findViewById(R.id.divider_2).setBackgroundColor(mColor);
        //................................................
        mIncludeLL.addView(parallelogramView);
    }

    private void drawPolygonView() {
        mIncludeLL.removeAllViews();
        View polygonView = getLayoutInflater().inflate(R.layout.polygon_area_calculation, null);
        EditText numberOfSideET = (EditText) polygonView.findViewById(R.id.et_number_of_side);
        numberOfSideET.requestFocus();
        EditText sideAET = (EditText) polygonView.findViewById(R.id.et_side_a);
        TextView areaTV = (TextView) polygonView.findViewById(R.id.tv_area);
        TextView perimeterTV = (TextView) polygonView.findViewById(R.id.tv_parimeter);

        // Setting color for result view................
        ((TextView) polygonView.findViewById(R.id.tv_result)).setTextColor(mColor);
        polygonView.findViewById(R.id.divider_1).setBackgroundColor(mColor);
        polygonView.findViewById(R.id.divider_2).setBackgroundColor(mColor);
        //................................................
        mIncludeLL.addView(polygonView);
    }

    private void drawEllipseView() {
        mIncludeLL.removeAllViews();
        View ellipseView = getLayoutInflater().inflate(R.layout.ellipse_area_calculation, null);
        EditText axisAET = (EditText) ellipseView.findViewById(R.id.et_axis_a);
        axisAET.requestFocus();
        EditText axisBET = (EditText) ellipseView.findViewById(R.id.et_axis_b);
        TextView areaTV = (TextView) ellipseView.findViewById(R.id.tv_area);
        TextView circumferenceTV = (TextView) ellipseView.findViewById(R.id.tv_circumfrence);

        // Setting color for result view................
        ((TextView) ellipseView.findViewById(R.id.tv_result)).setTextColor(mColor);
        ellipseView.findViewById(R.id.divider_1).setBackgroundColor(mColor);
        ellipseView.findViewById(R.id.divider_2).setBackgroundColor(mColor);
        //................................................
        mIncludeLL.addView(ellipseView);
    }

    private void drawRhombusView() {
        mIncludeLL.removeAllViews();
        View rhombusView = getLayoutInflater().inflate(R.layout.rhombus_area_calculation, null);
        EditText diagonalAET = (EditText) rhombusView.findViewById(R.id.et_diagonal_a);
        diagonalAET.requestFocus();
        EditText diagonalBET = (EditText) rhombusView.findViewById(R.id.et_diagonal_b);
        TextView areaTV = (TextView) rhombusView.findViewById(R.id.tv_area);
        TextView perimeterTV = (TextView) rhombusView.findViewById(R.id.tv_perimeter);

        // Setting color for result view................
        ((TextView) rhombusView.findViewById(R.id.tv_result)).setTextColor(mColor);
        rhombusView.findViewById(R.id.divider_1).setBackgroundColor(mColor);
        rhombusView.findViewById(R.id.divider_2).setBackgroundColor(mColor);
        //................................................
        mIncludeLL.addView(rhombusView);
    }

    private void drawTrapeziumView() {
        mIncludeLL.removeAllViews();
        View trapeziumView = getLayoutInflater().inflate(R.layout.trapezoid_area_calculation, null);
        EditText sideAET = (EditText) trapeziumView.findViewById(R.id.et_side_a);
        sideAET.requestFocus();
        EditText sideBET = (EditText) trapeziumView.findViewById(R.id.et_side_b);
        EditText heightET = (EditText) trapeziumView.findViewById(R.id.et_height);
        TextView areaTV = (TextView) trapeziumView.findViewById(R.id.tv_area);

        // Setting color for result view................
        ((TextView) trapeziumView.findViewById(R.id.tv_result)).setTextColor(mColor);
        trapeziumView.findViewById(R.id.divider_1).setBackgroundColor(mColor);
        trapeziumView.findViewById(R.id.divider_2).setBackgroundColor(mColor);
        //................................................
        mIncludeLL.addView(trapeziumView);
    }

    private void drawRectangleView() {
        mIncludeLL.removeAllViews();
        View rectangleView = getLayoutInflater().inflate(R.layout.rectangle_area_calculation, null);
        EditText sideAET = (EditText) rectangleView.findViewById(R.id.et_side_a);
        sideAET.requestFocus();
        EditText sideBET = (EditText) rectangleView.findViewById(R.id.et_side_b);
        TextView areaTV = (TextView) rectangleView.findViewById(R.id.tv_area);
        TextView perimeterTV = (TextView) rectangleView.findViewById(R.id.tv_parimeter);

        // Setting color for result view................
        ((TextView) rectangleView.findViewById(R.id.tv_result)).setTextColor(mColor);
        rectangleView.findViewById(R.id.divider_1).setBackgroundColor(mColor);
        rectangleView.findViewById(R.id.divider_2).setBackgroundColor(mColor);
        //................................................
        mIncludeLL.addView(rectangleView);
    }

    private void drawTriangleView() {
        mIncludeLL.removeAllViews();
        View triangleView = getLayoutInflater().inflate(R.layout.triangle_area_calculation, null);
        EditText sideAET = (EditText) triangleView.findViewById(R.id.et_side_a);
        sideAET.requestFocus();
        EditText sideBET = (EditText) triangleView.findViewById(R.id.et_side_b);
        EditText sideCET = (EditText) triangleView.findViewById(R.id.et_side_c);
        TextView areaTV = (TextView) triangleView.findViewById(R.id.tv_area);

        // Setting color for result view................
        ((TextView) triangleView.findViewById(R.id.tv_result)).setTextColor(mColor);
        triangleView.findViewById(R.id.divider_1).setBackgroundColor(mColor);
        triangleView.findViewById(R.id.divider_2).setBackgroundColor(mColor);
        //................................................
        mIncludeLL.addView(triangleView);
    }

    private void drawCircleView() {
        mIncludeLL.removeAllViews();
        View circleView = getLayoutInflater().inflate(R.layout.circle_area_calculation, null);
        EditText radiusET = (EditText) circleView.findViewById(R.id.et_radius);
        radiusET.requestFocus();
        TextView areaTV = (TextView) circleView.findViewById(R.id.tv_area);
        TextView circumfrenceTV = (TextView) circleView.findViewById(R.id.tv_circumfrence);

        // Setting color for result view................
        ((TextView) circleView.findViewById(R.id.tv_result)).setTextColor(mColor);
        circleView.findViewById(R.id.divider_1).setBackgroundColor(mColor);
        circleView.findViewById(R.id.divider_2).setBackgroundColor(mColor);
        //................................................
        mIncludeLL.addView(circleView);
    }

    private void drawSquareView() {
        mIncludeLL.removeAllViews();
        View squareView = getLayoutInflater().inflate(R.layout.squar_area_calculationl, null);
        EditText sideAET = (EditText) squareView.findViewById(R.id.et_side_a);
        sideAET.requestFocus();
        ((TextView) squareView.findViewById(R.id.tv_result)).setTextColor(mColor);
        squareView.findViewById(R.id.divider_1).setBackgroundColor(mColor);
        squareView.findViewById(R.id.divider_2).setBackgroundColor(mColor);
        TextView areaTV = (TextView) squareView.findViewById(R.id.tv_area);
        TextView parimeterTV = (TextView) squareView.findViewById(R.id.tv_parimeter);
        mIncludeLL.addView(squareView);
    }

    private void setColorToButton() {
        GradientDrawable gradientDrawableCheckFormula = (GradientDrawable) mCheckFormulaTV.getBackground();
        GradientDrawable gradientDrawableCalculateArea = (GradientDrawable) mCalculateAreaTV.getBackground();
        gradientDrawableCheckFormula.setColor(mColor);
        gradientDrawableCalculateArea.setColor(mColor);
        findViewById(R.id.divider_1).setBackgroundColor(mColor);
        findViewById(R.id.divider_2).setBackgroundColor(mColor);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_check_formula:
                checkFormula();
                break;
            case R.id.tv_calculate_area:
                calculateArea();
                break;
            case R.id.iv_back_button:
                onBackPressed();
                break;
        }
    }

    private void checkFormula() {
        switch (mFigure) {
            case Constants.CIRCLE:
                AppDialog.showFormulaDialog(this, Constants.CIRCLE).show();
                break;
            case Constants.TRIANGLE:
                AppDialog.showFormulaDialog(this, Constants.TRIANGLE).show();
                break;
            case Constants.RECTANGLE:
                AppDialog.showFormulaDialog(this, Constants.RECTANGLE).show();
                break;
            case Constants.TRAPEZIUM:
                AppDialog.showFormulaDialog(this, Constants.TRAPEZIUM).show();
            case Constants.RHOMBUS:
                AppDialog.showFormulaDialog(this, Constants.RHOMBUS).show();
                break;
            case Constants.ELLIPSE:
                AppDialog.showFormulaDialog(this, Constants.ELLIPSE).show();
                break;
            case Constants.SQUARE:
                AppDialog.showFormulaDialog(this, Constants.SQUARE).show();
                break;
            case Constants.POLYGON:
                AppDialog.showFormulaDialog(this, Constants.POLYGON).show();
                break;
            case Constants.PARALLELOGRAM:
                AppDialog.showFormulaDialog(this, Constants.PARALLELOGRAM).show();
                break;
            case Constants.QUADRILATERAL:
                AppDialog.showFormulaDialog(this, Constants.QUADRILATERAL).show();
                break;
        }
    }

    private void calculateArea() {

    }
}