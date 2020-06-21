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
    private int flowerType = 1;

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
    }

    public void backButtonClick(View view) {
        finish();
        ((GameActivity)GameActivity.context).pause();
    }

    private int levelCheck(){
        SharedPreferences pref = getSharedPreferences("Exp", 0);
        int exp = pref.getInt("experience", 0);
        int level;
        flowerType = exp / 400;
        exp = exp  % 400;
        Log.d(TAG, "flowerType : " + flowerType + " exp : " + exp);

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
        if (flowerType == 1) {
            switch (level) {
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
        } else{
            vase.setImageResource(R.drawable.rose_4);
            pBar.setProgress(400);
        }

    }

    public void lilyBtnClick(View view) {
        int level = levelCheck();
        if (flowerType == 2){
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
        } else if (flowerType < 2){
            vase.setImageResource(R.drawable.lily_1);
            pBar.setProgress(0);
        } else{
            vase.setImageResource(R.drawable.lily_4);
            pBar.setProgress(400);
        }

    }

    public void tulipBtnClick(View view) {
        int level = levelCheck();
        if (flowerType == 3) {
            switch (level) {
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
        } else if (flowerType < 3){
            vase.setImageResource(R.drawable.tulip_1);
            pBar.setProgress(0);
        } else {
            vase.setImageResource(R.drawable.tulip_4);
            pBar.setProgress(400);
        }
    }

    public void maylilyBtnClick(View view) {
        int level = levelCheck();
        if (flowerType == 4){
            switch (level) {
                case 1:
                    vase.setImageResource(R.drawable.maylily_1);
                    break;
                case 2:
                    vase.setImageResource(R.drawable.maylily_2);
                    break;
                case 3:
                    vase.setImageResource(R.drawable.maylily_3);
                    break;
                case 4:
                    vase.setImageResource(R.drawable.maylily_4);
                    break;
            }
        } else if (flowerType < 4){
            vase.setImageResource(R.drawable.maylily_1);
            pBar.setProgress(0);
        } else {
            vase.setImageResource(R.drawable.maylily_4);
            pBar.setProgress(400);
        }
    }

    public void irisBtnClick(View view) {
        int level = levelCheck();
        if (flowerType >= 5) {
            switch (level) {
                case 1:
                    vase.setImageResource(R.drawable.iris_1);
                    break;
                case 2:
                    vase.setImageResource(R.drawable.iris_2);
                    break;
                case 3:
                    vase.setImageResource(R.drawable.iris_3);
                    break;
                case 4:
                    vase.setImageResource(R.drawable.iris_4);
                    break;
            }
        } else{
            vase.setImageResource(R.drawable.iris_1);
            pBar.setProgress(0);
        }
    }
}
