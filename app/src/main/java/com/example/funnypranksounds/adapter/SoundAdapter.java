package com.example.funnypranksounds.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.funnypranksounds.R;

import java.util.ArrayList;

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.ViewHolder> {

    ArrayList<String> soundEffectNameList = new ArrayList<>();
    ArrayList<Drawable> soundEffectImgList = new ArrayList<>();
    ArrayList<Drawable> bgImgList = new ArrayList<>();
    Context context;
    int selectedItem = 0;
    SoundEffectListener soundEffectListener;

    public interface SoundEffectListener {
        void OnEffectClick(int position, String effectName);
    }

    public void setEffectListener(SoundEffectListener soundEffectListener) {
        this.soundEffectListener = soundEffectListener;
    }

    public SoundAdapter(Context context) {
        this.context = context;
        init();
        Log.wtf("size", String.valueOf(soundEffectNameList.size()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.icon_img.setImageDrawable(soundEffectImgList.get(position));
        holder.bg_img.setImageDrawable(bgImgList.get(position));
        holder.effect_name.setText(soundEffectNameList.get(position));

    }

    @Override
    public int getItemCount() {
        return soundEffectNameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bg_img;
        ImageView icon_img;
        TextView effect_name;

        @SuppressLint("NotifyDataSetChanged")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon_img = itemView.findViewById(R.id.effect_img);
            bg_img = itemView.findViewById(R.id.bg_img);
            effect_name = itemView.findViewById(R.id.effect_name);

            bg_img.setOnClickListener(view -> {
                SoundAdapter.this.selectedItem = ViewHolder.this.getLayoutPosition();
                SoundAdapter.this.soundEffectListener.OnEffectClick(SoundAdapter.this.selectedItem, SoundAdapter.this.soundEffectNameList.get(selectedItem));
                notifyDataSetChanged();
            });

        }
    }

    public void init() {
        soundEffectNameList.add(context.getString(R.string.fart));
        soundEffectNameList.add(context.getString(R.string.burp));
        soundEffectNameList.add(context.getString(R.string.hair_clipper));
        soundEffectNameList.add(context.getString(R.string.air_horn));
        soundEffectNameList.add(context.getString(R.string.halloween));
        soundEffectNameList.add(context.getString(R.string.breaking));
        soundEffectNameList.add(context.getString(R.string.car_horn));
        soundEffectNameList.add(context.getString(R.string.engine_sound));
        soundEffectNameList.add(context.getString(R.string.stun_gun));
        soundEffectNameList.add(context.getString(R.string.scary));
        soundEffectNameList.add(context.getString(R.string.police_siren));
        soundEffectNameList.add(context.getString(R.string.man_sneeze));
        soundEffectNameList.add(context.getString(R.string.toilet_flushing));
        soundEffectNameList.add(context.getString(R.string.gun));
        soundEffectNameList.add(context.getString(R.string.door_bell));
        soundEffectNameList.add(context.getString(R.string.scissors));
        soundEffectNameList.add(context.getString(R.string.man_cough));
        soundEffectNameList.add(context.getString(R.string.woman_cough));
        soundEffectNameList.add(context.getString(R.string.woman_sneeze));
        soundEffectNameList.add(context.getString(R.string.laugh_clap));

        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_fart_sound));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_burp));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_hair_clipper));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_air_horn));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_halloween));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_breaking));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_car_horn));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_engine));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_stun_gun));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_scary));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_siren));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_man_sneeze));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_toilet));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_gun));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_door_bell));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_scissors));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_man_cough));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_woman_cough));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_woman_sneeze));
        soundEffectImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_laugh));

        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_purple_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_pink_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_blue_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_orange_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_green_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_yellow_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_purple_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_pink_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_blue_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_orange_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_green_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_yellow_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_purple_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_pink_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_blue_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_orange_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_green_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_yellow_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_purple_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_pink_bg));
    }

}

