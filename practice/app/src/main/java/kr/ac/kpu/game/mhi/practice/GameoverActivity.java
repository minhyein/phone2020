package kr.ac.kpu.game.mhi.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameoverActivity extends AppCompatActivity {

    public static Context context;
    private ImageView imageView;
    private GameEngine ge;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        imageView = findViewById(R.id.gameoverImageView);
        btn = findViewById(R.id.returnBtn);
        ge = GameEngine.getInstance();
        if (ge.isClear){
            imageView.setImageResource(R.drawable.gameclear);
            btn.setBackgroundColor(Color.GREEN);
        } else{
            imageView.setImageResource(R.drawable.gameover);
        }
    }

    public void returnBtnClick(View view) {
        ((GameActivity)GameActivity.context).restartBtnClick(view);
        finish();

    }
}
