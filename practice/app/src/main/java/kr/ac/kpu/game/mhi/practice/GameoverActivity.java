package kr.ac.kpu.game.mhi.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class GameoverActivity extends AppCompatActivity {

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
    }

    public void returnBtnClick(View view) {
        ((GameActivity)GameActivity.context).restartBtnClick(view);
        finish();

    }
}
