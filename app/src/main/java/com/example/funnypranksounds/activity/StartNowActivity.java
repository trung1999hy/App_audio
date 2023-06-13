package com.example.funnypranksounds.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.example.funnypranksounds.R;
import com.example.funnypranksounds.dialog.LoadingDialog;
import com.example.funnypranksounds.utils.AppUtil;

public class StartNowActivity extends AppCompatActivity {

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // To hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // To hide navigation bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        setContentView(R.layout.activity_start_now);

        loadingDialog = new LoadingDialog(this);

        MaterialButton prankButton = findViewById(R.id.prank_button);
        MaterialCardView rate_btn = findViewById(R.id.rate_btn);
        MaterialCardView share_btn = findViewById(R.id.share_btn);

        prankButton.setOnClickListener(view -> {
                    new Handler().postDelayed(() -> {
                        loadingDialog.show();
                        changeActivity();
                    }, 500);
                     loadingDialog.dismiss();
                }
        );

        rate_btn.setOnClickListener(view -> sbRate());
        share_btn.setOnClickListener(view -> sbShare());

    }

    public void changeActivity() {
        startActivity(new Intent(StartNowActivity.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void sbPrivacy() {
        startActivity(new Intent(StartNowActivity.this, PolicyActivity.class));
    }

    public void sbRate() {
        Intent in = new Intent("android.intent.action.VIEW");
        String stringBuilder = "https://play.google.com/store/apps/details?id=" +
                getPackageName();
        in.setData(Uri.parse(stringBuilder));
        startActivity(in);
    }

    public void sbShare() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        String sb = getString(R.string.share_msg) +
                "https://play.google.com/store/apps/details?id=" +
                getPackageName();
        intent.putExtra("android.intent.extra.TEXT", sb);
        startActivity(Intent.createChooser(intent, getResources().getText(R.string.APD_SEND_TO)));
    }

}