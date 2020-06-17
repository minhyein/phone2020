package kr.ac.kpu.game.mhi.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

import kr.ac.kpu.game.mhi.practice.util.Button;
import kr.ac.kpu.game.mhi.practice.util.ui.bg.ImageScrollBackground;

public class FlowerActivity extends AppCompatActivity {
    private static final String TAG = FlowerActivity.class.getSimpleName();

    private ImageView backGroundImageView;
    private ImageView vase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower);

//        backButton = findViewById(R.id.backButton);
        backGroundImageView = findViewById(R.id.backgroundImageView);

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
    }

    public void roseBtnClick(View view) {
        vase.setImageResource(R.drawable.rose_1);
    }

    public void lilyBtnClick(View view) {
        vase.setImageResource(R.drawable.lily_1);
    }

    public void tulipBtnClick(View view) {
        vase.setImageResource(R.drawable.tulip_1);
    }

    public void maylilyBtnClick(View view) {
        vase.setImageResource(R.drawable.lily_1);
    }

    public void irisBtnClick(View view) {
        vase.setImageResource(R.drawable.iris_1);
    }
}
