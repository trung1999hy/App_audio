package com.example.funnypranksounds.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.example.funnypranksounds.R;
import com.example.funnypranksounds.adapter.TimeFormatAdapter;
import com.example.funnypranksounds.dialog.LoadingDialog;
import com.example.funnypranksounds.spiner.MySpinner;
import com.example.funnypranksounds.utils.AppUtil;
import com.example.funnypranksounds.utils.SoundUtil;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PrankActivity extends AppCompatActivity implements View.OnTouchListener {

    private LoadingDialog loadingDialog;

    private boolean isStopFlag = false;
    private boolean isTimer;
    private boolean isLooping;
    private LottieAnimationView bg_lottie;

    private long milliSeconds;

    private LinearLayout timer_container;
    private RelativeLayout touch_card;
    private TextView toolbar_name;
    private TextView time;
    private ImageView effect_img;
    private MaterialCheckBox check_box;

    private MediaPlayer touchMp;

    private int selectedPosition;
    private String selectedEffect;

    private MySpinner time_spinner;
    private ArrayList<String> timeList;

    private CountDownTimer cTimer = null;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // To hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_prank);

        loadingDialog = new LoadingDialog(this);


        touch_card = findViewById(R.id.touch_card);
        check_box = findViewById(R.id.check_box);
        toolbar_name = findViewById(R.id.toolbar_name);
        ImageView back_arrow = findViewById(R.id.back_arrow);
        effect_img = findViewById(R.id.effect_img);
        time_spinner = findViewById(R.id.time_spinner);
        bg_lottie = findViewById(R.id.bg_lottie);
        time = findViewById(R.id.time);
        SeekBar volume_seekbar = findViewById(R.id.volume_seekbar);
        timer_container = findViewById(R.id.timer_container);

        this.timeList = new ArrayList<>();
        this.timeList.add("Off");
        this.timeList.add("15s");
        this.timeList.add("30s");
        this.timeList.add("45s");
        this.timeList.add("1m");
        this.timeList.add("2m");
        this.timeList.add("5m");

        back_arrow.setOnClickListener(view -> onBackPressed());

        check_box.setOnCheckedChangeListener((compoundButton, b) -> {
            isLooping = b;
            touchMp.setLooping(b);
            if (b) {
                check_box.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.light_red_5));
            } else {
                if (touchMp != null) {
                    if (touchMp.isPlaying()) {
                        bg_lottie.setVisibility(View.GONE);
                        bg_lottie.playAnimation();
                        bg_lottie.setProgress(0);
                        touchMp.pause();
                        touchMp.seekTo(0);
                        touchMp.setLooping(false);
                    }
                }
            }
        });

        getData();
        setUpSpinner();

        touchMp.setOnPreparedListener(mediaPlayer -> {
            touchMp = mediaPlayer;
            touch_card.setOnTouchListener(PrankActivity.this);

        });

        touchMp.setOnCompletionListener(mediaPlayer -> {
            if (isTimer) {
                isTimer = false;
                bg_lottie.setVisibility(View.GONE);
                bg_lottie.pauseAnimation();
                bg_lottie.setProgress(0);
            }
        });

        time_spinner.setOnItemSelectedEvenIfUnchangedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cancelTimer();
                switch (i) {
                    case 0:
                        milliSeconds = 0;
                        break;
                    case 1:
                        milliSeconds = 15000;
                        break;
                    case 2:
                        milliSeconds = 30000;
                        break;
                    case 3:
                        milliSeconds = 45000;
                        break;
                    case 4:
                        milliSeconds = 60000;
                        break;
                    case 5:
                        milliSeconds = 120000;
                        break;
                    case 6:
                        milliSeconds = 300000;
                        break;
                }
                if (i > 0) {
                    startTimer(milliSeconds);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volume_seekbar.setMax(maxVolume);

        int currentVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        volume_seekbar.setProgress(currentVol);

        volume_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onResume() {
        super.onResume();

        if (isStopFlag) {
            isStopFlag = false;
            touchMp = MediaPlayer.create(getApplicationContext(), SoundUtil.getList(selectedEffect)[selectedPosition]);

            touchMp.setOnPreparedListener(mediaPlayer -> {
                touchMp = mediaPlayer;
                Log.wtf("ddd", "player prepared");

                touch_card.setOnTouchListener(PrankActivity.this);

            });

            touchMp.setOnCompletionListener(mediaPlayer -> {
                if (isTimer) {
                    isTimer = false;
                    bg_lottie.setVisibility(View.GONE);
                    bg_lottie.pauseAnimation();
                    bg_lottie.setProgress(0);
                }
            });
        }

    }

    // method for setting effect image
    public void setEffectImg(String effectName) {
        Context context = getApplicationContext();
        switch (effectName) {
            case "Air Horn":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_air_horn));
                break;

            case "Fart":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_fart_sound));
                break;

            case "Hair Clipper":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_hair_clipper));
                break;

            case "Halloween":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_halloween));
                break;

            case "Burp":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_burp));
                break;

            case "Breaking":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_breaking));
                break;

            case "Stun Gun":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_stun_gun));
                break;

            case "Car Horn":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_car_horn));
                break;

            case "Engine Sound":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_engine));
                break;

            case "Police Siren":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_siren));
                break;

            case "Door Bell":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_door_bell));
                break;

            case "Man Sneeze":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_man_sneeze));
                break;

            case "Toilet Flush":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_toilet));
                break;

            case "Scary":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_scary));
                break;

            case "Man Cough":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_man_cough));
                break;

            case "Gun":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_gun));
                break;

            case "Laugh & Clap":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_laugh));
                break;

            case "Scissors":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_scissors));
                break;

            case "Woman Cough":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_woman_cough));
                break;

            case "Woman Sneeze":
                effect_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_woman_sneeze));
                break;
        }
    }

    // start your timer here
    public void startTimer(long milliSeconds) {
        if (touchMp != null) {
            if (touchMp.isPlaying()) {
                if (touchMp.isLooping()) {
                    check_box.setChecked(false);
                }
                touchMp.pause();
                touchMp.seekTo(0);
                bg_lottie.setVisibility(View.GONE);
                bg_lottie.pauseAnimation();
                bg_lottie.setProgress(0);
            }
        }
        timer_container.setVisibility(View.VISIBLE);
        cTimer = new CountDownTimer(milliSeconds, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                NumberFormat f = new DecimalFormat("00");

                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;

                time.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));

                int value = (int) (millisUntilFinished / 1000);
                if (value == 1) {
                    new Handler().postDelayed(() -> time.setText("00:00:00"), 1000);
                }

            }

            @Override
            public void onFinish() {
                PrankActivity.this.isTimer = true;
                timer_container.setVisibility(View.GONE);
                cancelTimer();
                if (touchMp != null) {
                    touchMp.start();
                }
                bg_lottie.setVisibility(View.VISIBLE);
                bg_lottie.playAnimation();
            }
        };
        cTimer.start();
    }

    // cancel your timer any time with this method
    public void cancelTimer() {
        if (cTimer != null) {
            cTimer.cancel();
        }
    }

    // set your spinner here
    public void setUpSpinner() {
        TimeFormatAdapter adapter = new TimeFormatAdapter(this, this.timeList, 0, PrankActivity.this);
        this.time_spinner.setAdapter(adapter);
        this.time_spinner.setSelection(0);
    }

    // get your data that pass from past activity
    public void getData() {
        String position = getIntent().getStringExtra("selectedPosition");
        this.selectedPosition = Integer.parseInt(position);
        this.selectedEffect = getIntent().getStringExtra("selectedEffect");
        String selectedSubEffect = getIntent().getStringExtra("selectedSubEffect");

        toolbar_name.setText(selectedSubEffect);

        touchMp = MediaPlayer.create(getApplicationContext(), SoundUtil.getList(selectedEffect)[selectedPosition]);
        setEffectImg(this.selectedEffect);
    }

    @Override
    public void onBackPressed() {
        exitMethod();
    }

    private void exitMethod(){
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        if (touchMp != null) {
            touchMp.stop();
            touchMp.release();
            touchMp = null;
            isStopFlag = true;
        }
        super.onStop();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                timer_container.setVisibility(View.GONE);
                bg_lottie.setVisibility(View.VISIBLE);
                bg_lottie.playAnimation();
                time_spinner.setSelection(0);
                cancelTimer();
                touchMp.setLooping(true);
                if (touchMp != null) {
                    if (touchMp.isPlaying()) {
                        touchMp.pause();
                        touchMp.seekTo(0);
                    }
                    touchMp.start();
                }
                break;
            case MotionEvent.ACTION_UP:
                if (!isLooping) {
                    bg_lottie.setVisibility(View.GONE);
                    bg_lottie.playAnimation();
                    bg_lottie.setProgress(0);
                    if (touchMp != null) {
                        if (touchMp.isPlaying()) {
                            touchMp.pause();
                            touchMp.seekTo(0);
                            touchMp.setLooping(false);
                        }
                    }
                }
                break;
        }
        return true;
    }

}