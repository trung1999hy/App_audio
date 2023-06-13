package com.example.funnypranksounds.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import com.example.funnypranksounds.R;

public class LoadingDialog extends Dialog {
    Context context;

    public LoadingDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        setContentView(R.layout.loading_dialog);

        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
}
