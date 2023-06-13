package com.example.funnypranksounds.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funnypranksounds.R;

import java.util.ArrayList;

public class SoundDetailAdapter extends RecyclerView.Adapter<SoundDetailAdapter.ViewHolder> {

    ArrayList<String> soundEffectNameList = new ArrayList<>();
    ArrayList<Integer> bgColorList = new ArrayList<>();
    ArrayList<Drawable> bgImgList = new ArrayList<>();
    Context context;
    String effectName;
    int selectedItem = 0;
    ArrayList<String> soundList;
    SoundDetailListener soundDetailListener;

    public interface SoundDetailListener {
        void OnEffectClick(int position, String effectName, String subEffectName);
    }

    public void setEffectListener(SoundDetailListener soundDetailListener) {
        this.soundDetailListener = soundDetailListener;
    }

    public SoundDetailAdapter(Context context, String effectName, ArrayList<String> soundList) {
        this.context = context;
        this.effectName = effectName;
        this.soundList = soundList;
        init();
        Log.wtf("size", String.valueOf(soundEffectNameList.size()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_detail_layout, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        switch (effectName) {
            case "Air Horn":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_air_horn));
                break;

            case "Fart":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_fart_sound));
                break;

            case "Hair Clipper":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_hair_clipper));
                break;

            case "Halloween":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_halloween));
                break;

            case "Burp":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_burp));
                break;

            case "Breaking":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_breaking));
                break;

            case "Stun Gun":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_stun_gun));
                break;

            case "Car Horn":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_car_horn));
                break;

            case "Engine Sound":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_engine));
                break;

            case "Police Siren":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_siren));
                break;

            case "Door Bell":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_door_bell));
                break;

            case "Man Sneeze":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_man_sneeze));
                break;

            case "Toilet Flush":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_toilet));
                break;

            case "Scary":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_scary));
                break;

            case "Man Cough":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_man_cough));
                break;

            case "Gun":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_gun));
                break;

            case "Laugh & Clap":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_laugh));
                break;

            case "Scissors":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_scissors));
                break;

            case "Woman Cough":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_woman_cough));
                break;

            case "Woman Sneeze":
                holder.icon_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_woman_sneeze));
                break;
        }

        holder.effect_name.setText(soundList.get(position));
//        holder.outer_card.setCardBackgroundColor(txtColorList.get(position));
        holder.outer_card.setBackground(bgImgList.get(position));
//        holder.inner_card.setBackgroundResource(bgColorList.get(position));

    }

    @Override
    public int getItemCount() {
        return soundList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView icon_img;
        TextView effect_name;
        RelativeLayout outer_card;

        @SuppressLint("NotifyDataSetChanged")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon_img = itemView.findViewById(R.id.effect_img);
            effect_name = itemView.findViewById(R.id.effect_name);
            outer_card = itemView.findViewById(R.id.outer_card);

            outer_card.setOnClickListener(view -> {
                SoundDetailAdapter.this.selectedItem = ViewHolder.this.getLayoutPosition();
                SoundDetailAdapter.this.soundDetailListener.OnEffectClick(SoundDetailAdapter.this.selectedItem, SoundDetailAdapter.this.soundEffectNameList.get(selectedItem), SoundDetailAdapter.this.soundList.get(selectedItem));
                notifyDataSetChanged();
            });

        }
    }

    public void init() {
        soundEffectNameList.add(context.getString(R.string.air_horn));
        soundEffectNameList.add(context.getString(R.string.fart));
        soundEffectNameList.add(context.getString(R.string.hair_clipper));
        soundEffectNameList.add(context.getString(R.string.halloween));
        soundEffectNameList.add(context.getString(R.string.burp));
        soundEffectNameList.add(context.getString(R.string.breaking));
        soundEffectNameList.add(context.getString(R.string.stun_gun));
        soundEffectNameList.add(context.getString(R.string.car_horn));
        soundEffectNameList.add(context.getString(R.string.engine_sound));
        soundEffectNameList.add(context.getString(R.string.police_siren));
        soundEffectNameList.add(context.getString(R.string.door_bell));
        soundEffectNameList.add(context.getString(R.string.man_sneeze));
        soundEffectNameList.add(context.getString(R.string.toilet_flushing));
        soundEffectNameList.add(context.getString(R.string.scary));
        soundEffectNameList.add(context.getString(R.string.man_cough));
        soundEffectNameList.add(context.getString(R.string.gun));
        soundEffectNameList.add(context.getString(R.string.laugh_clap));
        soundEffectNameList.add(context.getString(R.string.scissors));
        soundEffectNameList.add(context.getString(R.string.woman_cough));
        soundEffectNameList.add(context.getString(R.string.woman_sneeze));

        bgColorList.add(ContextCompat.getColor(context, R.color.light_purple_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_pink_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_blue_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_orange_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_green_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_yellow_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_purple_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_pink_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_blue_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_orange_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_green_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_yellow_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_purple_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_pink_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_blue_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_orange_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_green_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_yellow_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_purple_6));
        bgColorList.add(ContextCompat.getColor(context, R.color.light_pink_6));


        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_purple_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_pink_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_blue_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_orange_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_green_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_yellow_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_purple_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_pink_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_blue_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_orange_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_green_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_yellow_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_purple_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_pink_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_blue_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_orange_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_green_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_yellow_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_purple_detail_bg));
        bgImgList.add(ContextCompat.getDrawable(context, R.drawable.ic_pink_detail_bg));

    }

}

