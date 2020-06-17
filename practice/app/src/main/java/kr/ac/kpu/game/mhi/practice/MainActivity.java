package kr.ac.kpu.game.mhi.practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private ProgressBar progressBar;
    private Button restartBtn;
    GameEngine gameEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        restartBtn = findViewById(R.id.restartBtn);

        gameEngine = new GameEngine(this);
        gameEngine.getInstance().createGrid(this);
    }

    public void restartBtnClick(View view) {
        gameEngine.getInstance().createGrid(this);
    }

    public void flowerBtnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), FlowerActivity.class);
        startActivity(intent);
        //ThirdScene scene = new ThirdScene();
        //scene.push();
    }
}
