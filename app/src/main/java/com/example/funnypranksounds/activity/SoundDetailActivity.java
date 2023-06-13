package com.example.funnypranksounds.activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.funnypranksounds.R;
import com.example.funnypranksounds.adapter.SoundDetailAdapter;
import com.example.funnypranksounds.dialog.LoadingDialog;
import com.example.funnypranksounds.utils.AppUtil;
import com.example.funnypranksounds.utils.SoundUtil;

import java.util.ArrayList;

public class SoundDetailActivity extends AppCompatActivity {

    private LoadingDialog loadingDialog;
    private RecyclerView sound_detail_recycler;
    private String effectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // To hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sound_detail);

        loadingDialog = new LoadingDialog(this);


        TextView effect_name = findViewById(R.id.effect_name);
        ImageView back_arrow = findViewById(R.id.back_arrow);
        sound_detail_recycler = findViewById(R.id.sound_detail_recycler);

        effectName = getIntent().getExtras().getString("effect_name");

        effect_name.setText(effectName);

        back_arrow.setOnClickListener(view -> onBackPressed());

        setEffectDetailRecycler();

    }

    @Override
    public void onBackPressed() {
        if (AppUtil.isNetworkAvailable(this)) {
            loadingDialog.show();

            new Handler().postDelayed(() -> {
                loadingDialog.dismiss();
                exitMethod();
            }, 500);

        } else {
            exitMethod();
        }
    }

    private void exitMethod(){
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    // method to set up all sounds list
    public void setEffectDetailRecycler() {

        ArrayList<String> effectNameList = new ArrayList<>();
        for (int i = 0; i < SoundUtil.getList(effectName).length; i++) {
            effectNameList.add(effectName + " " + (i + 1));
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        this.sound_detail_recycler.setLayoutManager(gridLayoutManager);
        SoundDetailAdapter soundDetailAdapter = new SoundDetailAdapter(getApplicationContext(), effectName, effectNameList);
        sound_detail_recycler.setAdapter(soundDetailAdapter);
        soundDetailAdapter.setEffectListener((position, effectName, subEffectName) -> {

            if (AppUtil.isNetworkAvailable(this)) {
                loadingDialog.show();

                new Handler().postDelayed(() -> {
                    loadingDialog.dismiss();
                    changeActivity(position, subEffectName);
                }, 500);

            } else {
                changeActivity(position, subEffectName);
            }

//            changeActivity(position, subEffectName);
        });
    }

    public void changeActivity(int position, String subEffectName) {
        Intent intent = new Intent(SoundDetailActivity.this, PrankActivity.class);
        intent.putExtra("selectedPosition", String.valueOf(position));
        intent.putExtra("selectedEffect", SoundDetailActivity.this.effectName);
        intent.putExtra("selectedSubEffect", subEffectName);
        startActivity(intent);
    }

}