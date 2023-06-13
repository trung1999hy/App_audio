package com.example.funnypranksounds.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funnypranksounds.MyApplication;
import com.example.funnypranksounds.R;
import com.example.funnypranksounds.adapter.SoundAdapter;
import com.example.funnypranksounds.dialog.LoadingDialog;
import com.example.funnypranksounds.purchase.InAppPurchaseActivity;
import com.example.funnypranksounds.utils.AppUtil;

public class MainActivity extends AppCompatActivity {


    private LoadingDialog loadingDialog;

    private boolean doubleBackToExitPressedOnce = false;
    private RecyclerView sound_recycler;
    private TextView btnBuy, valueCoin;

    private String effectName;
    private int coin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // to hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        loadingDialog = new LoadingDialog(this);

        this.sound_recycler = findViewById(R.id.sound_recycler);
        this.btnBuy = findViewById(R.id.txtBuy);
        this.valueCoin = findViewById(R.id.tvValueCoin);
        ImageView back_arrow = findViewById(R.id.back_arrow);

        back_arrow.setOnClickListener(view -> onBackPressed());

        setSound();

        btnBuy.setOnClickListener( v -> {
            startActivity(new Intent(this, InAppPurchaseActivity.class));
        });


    }

    // set all sounds category list
    private void setSound() {
        coin = MyApplication.newInstance().getPreference().getValueCoin();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        this.sound_recycler.setLayoutManager(gridLayoutManager);
        SoundAdapter soundAdapter = new SoundAdapter(getApplicationContext());
        this.sound_recycler.setAdapter(soundAdapter);
        soundAdapter.setEffectListener((position, effect) -> {
            effectName = effect;
            loadingDialog.show();
            new Handler().postDelayed(() -> {
                if (position == 10 || position == 13) {
                    if (coin > 100) {
                        changeActivity(effectName);
                    } else {
                        Toast.makeText(this, "you don't have enough coins, please top up to use!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    changeActivity(effectName);
                }
                loadingDialog.dismiss();
            }, 500);

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        // show toast for double click to exit
        View layout = getLayoutInflater().inflate(R.layout.custom_toast_layout,
                findViewById(R.id.toast_layout_root));
        TextView textView = layout.findViewById(R.id.text_view);
        textView.setText(R.string.exit_again_txt);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT); // set the duration for the Toast
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(layout);// set the inflated layout
        toast.show();

        this.doubleBackToExitPressedOnce = true;
        new Handler(Looper.getMainLooper()).postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
    }

    // code for changing activity
    public void changeActivity(String effectName) {
        try {
            Intent intent = new Intent(MainActivity.this, SoundDetailActivity.class);
            intent.putExtra("effect_name", effectName);
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}