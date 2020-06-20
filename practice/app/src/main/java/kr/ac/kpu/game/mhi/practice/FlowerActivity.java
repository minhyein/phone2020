package kr.ac.kpu.game.mhi.practice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FlowerActivity extends AppCompatActivity {
    private static final String TAG = FlowerActivity.class.getSimpleName();

    private ImageView backGroundImageView;
    private ImageView vase;
    private ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower);

        backGroundImageView = findViewById(R.id.backgroundImageView);
        pBar = findViewById(R.id.expBar);

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat mFormat = new SimpleDateFormat("HH");
        int time = Integer.parseInt(mFormat.format(date));
        Log.d(TAG, "time : " + mFormat.format(date));

        if (time > 6 && time < 10){
            backGroundImageView.setImageResource(R.drawable.bg_sky_am);
        }else if (time < 17){
            backGroundImageView.setImageResource(R.drawable.bg_sky_pm);
        }else if (time < 20){
            backGroundImageView.setImageResource(R.drawable.bg_sky_evening);
        }else{
            backGroundImageView.setImageResource(R.drawable.bg_sky_night);
        }

        vase = findViewById(R.id.flowerVase);
        int level = levelCheck();
        switch (level){
            case 1:
                vase.setImageResource(R.drawable.rose_1);
                break;
            case 2:
                vase.setImageResource(R.drawable.rose_2);
                break;
            case 3:
                vase.setImageResource(R.drawable.rose_3);
                break;
            case 4:
                vase.setImageResource(R.drawable.rose_4);
                break;
        }

    }

    public void backButtonClick(View view) {
        finish();
        ((GameActivity)GameActivity.context).pause();
    }

    private int levelCheck(){
        SharedPreferences pref = getSharedPreferences("Exp", 0);
        int exp = pref.getInt("experience", 0);
        int level;

        if (exp < 100){
            level = 1;
            pBar.setMax(100);
            pBar.setProgress(exp);
        } else if (exp < 250){
            level = 2;
            pBar.setMax(250);
            pBar.setProgress(exp);
        } else if (exp < 400){
            level = 3;
            pBar.setMax(400);
            pBar.setProgress(exp);
        } else{
            level = 4;
            pBar.setProgress(400);
        }
        return level;
    }

    public void roseBtnClick(View view) {
        int level = levelCheck();

        switch (level){
            case 1:
                vase.setImageResource(R.drawable.rose_1);
                break;
            case 2:
                vase.setImageResource(R.drawable.rose_2);
                break;
            case 3:
                vase.setImageResource(R.drawable.rose_3);
                break;
            case 4:
                vase.setImageResource(R.drawable.rose_4);
                break;
        }

    }

    public void lilyBtnClick(View view) {
        int level = levelCheck();

        switch (level){
            case 1:
                vase.setImageResource(R.drawable.lily_1);
                break;
            case 2:
                vase.setImageResource(R.drawable.lily_2);
                break;
            case 3:
                vase.setImageResource(R.drawable.lily_3);
                break;
            case 4:
                vase.setImageResource(R.drawable.lily_4);
                break;
        }

    }

    public void tulipBtnClick(View view) {
        int level = levelCheck();

        switch (level){
            case 1:
                vase.setImageResource(R.drawable.tulip_1);
                break;
            case 2:
                vase.setImageResource(R.drawable.tulip_2);
                break;
            case 3:
                vase.setImageResource(R.drawable.tulip_3);
                break;
            case 4:
                vase.setImageResource(R.drawable.tulip_4);
                break;
        }

    }

    public void maylilyBtnClick(View view) {
        int level = levelCheck();

        switch (level){
            case 1:
                vase.setImageResource(R.drawable.lily_1);
                break;
            case 2:
                vase.setImageResource(R.drawable.lily_2);
                break;
            case 3:
                vase.setImageResource(R.drawable.lily_3);
                break;
            case 4:
                vase.setImageResource(R.drawable.lily_4);
                break;
        }
    }

    public void irisBtnClick(View view) {
        int level = levelCheck();

        switch (level){
            case 1:
                vase.setImageResource(R.drawable.lily_1);
                break;
            case 2:
                vase.setImageResource(R.drawable.lily_2);
                break;
            case 3:
                vase.setImageResource(R.drawable.lily_3);
                break;
            case 4:
                vase.setImageResource(R.drawable.lily_4);
                break;
        }
    }
}
