package kr.ac.kpu.game.mhi.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import kr.ac.kpu.game.mhi.practice.util.sound.SoundEffects;

public class GameActivity extends AppCompatActivity {

    private static final String TAG = GameActivity.class.getSimpleName();
    private ProgressBar progressBar;
    private Button restartBtn;
    GameEngine gameEngine;
    private TimerTask timetask;
    boolean isTimertaskCompleted;
    private Timer timer;
    private int currentProg = 0;
    private int minText;
    private int secText;
    private TextView timerTextView;
    private TextView fineMineText;
    private SharedPreferences pref;
    private SharedPreferences.Editor edit;
    private ImageView backGroundImageView;
    public static Context context;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        restartBtn = findViewById(R.id.restartBtn);
        timerTextView = findViewById(R.id.timerTextView);
        fineMineText = findViewById(R.id.fineMine);
        context = this;

        initProgressBar();
        startTimerThread();

        gameEngine = new GameEngine(this);
        gameEngine.getInstance().createGrid(this);
        setMineText(gameEngine.getBombNumber(), gameEngine.getFlags());

        backGroundImageView = findViewById(R.id.backGround);

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

        mediaPlayer = MediaPlayer.create(this, R.raw.maingame_bgm);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();



    }

    public void setMineText(int total, int found) {
        fineMineText.setText("총 새싹 : " + total + "개 찾은 새싹 : " + found + "개");
    }

    public void initProgressBar() {
        progressBar.setMax(600);
        progressBar.setProgress(600);
        minText = 10;
        secText = 00;
    }

    public void startTimerThread() {
        timetask = new TimerTask() {
            @Override
            public void run() {
                Log.d(TAG, "Timer Start");
                increaseBar();
                isTimertaskCompleted = true;
            }
        };
        timer = new Timer();
        timer.schedule(timetask, 0, 1000);
        timerTextView.setText(minText + " : " + secText);
    }

    private void increaseBar() {
        runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        currentProg = progressBar.getProgress();
                        if(currentProg > 0){
                            currentProg--;
                            if (secText == 0){
                                minText--;
                                secText = 59;
                            } else{
                                secText--;
                            }
                        } else if(currentProg == 0){
                            stopTimer();
                        }
                        progressBar.setProgress(currentProg);
                        timerTextView.setText(minText + " : " + secText);
                    }
                }
        );
    }

    public void pause(){
        if (timer != null){
            timer.cancel();
            timer.purge();
            timer = null;
        } else if (timer == null){
            startTimerThread();
        }
    }

    public void stopTimer(){
        if (timetask != null){
            timetask.cancel();
            timetask = null;
        }
        if (timer != null){
            timer.cancel();;
            timer.purge();
            timer = null;
        }
    }

    public void restartBtnClick(View view) {

        gameEngine.getInstance().createGrid(this);
        stopTimer();
        initProgressBar();
        startTimerThread();
        setMineText(gameEngine.getBombNumber(), 0);
    }

    public void flowerBtnClick(View view) {
        pause();
        Intent intent = new Intent(getApplicationContext(), FlowerActivity.class);
        startActivity(intent);
    }

    public void pauseBtnClick(View view) {
        pause();
    }

    public int getMin(){return minText;}

    public void save(int exp){
        pref = getSharedPreferences("Exp", 0);
        int oldExp = pref.getInt("experience", 0);
        exp += oldExp;
        edit = pref.edit();
        edit.putInt("experience", exp);
        edit.commit();
    }

}
