package com.example.landcalculatorconverter.appDialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.landcalculatorconverter.R;
import com.example.landcalculatorconverter.utils.Constants;

public class AppDialog {
    public static Dialog showFormulaDialog(final Activity activity, String figure) {
        final Dialog progressDialog = new Dialog(activity);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setContentView(R.layout.formula_dialog_view);
        progressDialog.setCancelable(false);
        ImageView formulaIV = (ImageView) progressDialog.findViewById(R.id.iv_formula);
        switch (figure) {
            case Constants.CIRCLE:
                formulaIV.setImageResource(R.drawable.circle_area_formula_img);
                break;
            case Constants.TRIANGLE:

                break;
            case Constants.RECTANGLE:
                formulaIV.setImageResource(R.drawable.rectangle_area_formula_img);
                break;
            case Constants.TRAPEZIUM:

            case Constants.RHOMBUS:

                break;
            case Constants.ELLIPSE:

                break;
            case Constants.SQUARE:

                break;
            case Constants.POLYGON:

                break;
            case Constants.PARALLELOGRAM:

                break;
            case Constants.QUADRILATERAL:

                break;
        }
        progressDialog.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.dismiss();
            }
        });
        return progressDialog;
    }
}
