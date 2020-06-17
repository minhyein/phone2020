package kr.ac.kpu.game.mhi.practice;

import android.graphics.RectF;
import android.util.Log;
import android.widget.ProgressBar;

import java.text.SimpleDateFormat;
import java.util.Date;

import kr.ac.kpu.game.mhi.practice.util.BitmapObject;
import kr.ac.kpu.game.mhi.practice.util.Button;
import kr.ac.kpu.game.mhi.practice.util.ui.bg.ImageScrollBackground;
import kr.ac.kpu.game.mhi.practice.util.ui.main.GameScene;
import kr.ac.kpu.game.mhi.practice.util.ui.main.UiBridge;

public class ThirdScene extends GameScene {

    private static final String TAG = ThirdScene.class.getSimpleName();
    //private TextMap map;
    private int mdpi_100;

    private RectF rect = new RectF();
//    private ImageScrollBackground skyBackground;
//    private ScoreObject scoreObject;
//    private GameTimer timer;

    public enum Layer {
        bg, platform, item, obstacle, player, ui, COUNT
    }

    @Override
    protected int getLayerCount() {
        return Layer.COUNT.ordinal();
    }

    @Override
    public void update() {
        super.update();
//        Log.d(TAG, "Score: " + timer.getRawIndex());
//        if (timer.done()) {
//            scoreObject.add(100);
//            timer.reset();
//        }



    }

    @Override
    public void enter() {
        super.enter();
        initObjects();
    }

    @Override
    public void exit() {
        super.exit();
    }

    //private Ball vase;
    private BitmapObject vase;
    int exp;

    private void initObjects() {
       /* exp = 10;

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat mFormat = new SimpleDateFormat("HH");
        int time = Integer.parseInt(mFormat.format(date));
        Log.d(TAG, "time : " + mFormat.format(date));

        if (time > 6 && time < 10){
            skyBackground = new ImageScrollBackground(R.mipmap.bg_sky_am, ImageScrollBackground.Orientation.horizontal, -30);
        }else if (time < 17){
            skyBackground = new ImageScrollBackground(R.mipmap.bg_sky_pm, ImageScrollBackground.Orientation.horizontal, -30);
        }else if (time < 20){
            skyBackground = new ImageScrollBackground(R.mipmap.bg_sky_evening, ImageScrollBackground.Orientation.horizontal, -30);
        }else{
            skyBackground = new ImageScrollBackground(R.mipmap.bg_sky_night, ImageScrollBackground.Orientation.horizontal, -30);
        }

        gameWorld.add(Layer.bg.ordinal(), skyBackground);*/
        //gameWorld.add(Layer.bg.ordinal(), new ImageScrollBackground(R.mipmap.bg_window, ImageScrollBackground.Orientation.horizontal, 0));
        //gameWorld.add(Layer.player.ordinal(), vase);

        int x = 20;//UiBridge.metrics.size.x / 5 - UiBridge.x(20);
        int y = 10;//UiBridge.metrics.size.y / 5 - UiBridge.y(10);
        Button roseButton = new Button(x, y, R.mipmap.rose, R.mipmap.green_round_btn, R.mipmap.purple_round_btn);
        roseButton.setOnClickRunnable(new Runnable() {
            @Override
            public void run() {
                if (vase != null)
                    gameWorld.removeObject(vase);
                int vasex = UiBridge.metrics.center.x + UiBridge.x(100);
                int vasey = UiBridge.metrics.center.y - UiBridge.y(100);
                vase = new BitmapObject(vasex, vasey,0,0, R.mipmap.rose_1);
                gameWorld.add(Layer.player.ordinal(), vase);
            }
        });
        gameWorld.add(Layer.ui.ordinal(),roseButton);
        y += UiBridge.y(70);
        Button lilyButton = new Button(x, y, R.mipmap.lily, R.mipmap.green_round_btn, R.mipmap.purple_round_btn);
        lilyButton.setOnClickRunnable(new Runnable() {
            @Override
            public void run() {
                if (vase != null)
                    gameWorld.removeObject(vase);
                int vasex = UiBridge.metrics.center.x + UiBridge.x(100);
                int vasey = UiBridge.metrics.center.y - UiBridge.y(100);
                vase = new BitmapObject(vasex, vasey,0,0, R.mipmap.lily_1);
                gameWorld.add(Layer.player.ordinal(), vase);
            }
        });
        gameWorld.add(Layer.ui.ordinal(),lilyButton);

        y += UiBridge.y(70);
        Button tulipButton = new Button(x, y, R.mipmap.tulip, R.mipmap.green_round_btn, R.mipmap.purple_round_btn);
        tulipButton.setOnClickRunnable(new Runnable() {
            @Override
            public void run() {
                if (vase != null)
                    gameWorld.removeObject(vase);
                int vasex = UiBridge.metrics.center.x + UiBridge.x(100);
                int vasey = UiBridge.metrics.center.y - UiBridge.y(100);
                vase = new BitmapObject(vasex, vasey,0,0, R.mipmap.tulip_1);
                gameWorld.add(Layer.player.ordinal(), vase);
            }
        });
        gameWorld.add(Layer.ui.ordinal(),tulipButton);

        y += UiBridge.y(70);
        Button maylilyButton = new Button(x, y, R.mipmap.maylily, R.mipmap.green_round_btn, R.mipmap.purple_round_btn);
        maylilyButton.setOnClickRunnable(new Runnable() {
            @Override
            public void run() {
                if (vase != null)
                    gameWorld.removeObject(vase);
                int vasex = UiBridge.metrics.center.x + UiBridge.x(100);
                int vasey = UiBridge.metrics.center.y - UiBridge.y(100);
                vase = new BitmapObject(vasex, vasey,0,0, R.mipmap.lily_4);
                gameWorld.add(Layer.player.ordinal(), vase);
            }
        });
        gameWorld.add(Layer.ui.ordinal(),maylilyButton);

        y += UiBridge.y(70);
        Button irisButton = new Button(x, y, R.mipmap.iris, R.mipmap.green_round_btn, R.mipmap.purple_round_btn);
        irisButton.setOnClickRunnable(new Runnable() {
            @Override
            public void run() {
                if (vase != null)
                    gameWorld.removeObject(vase);
                int vasex = UiBridge.metrics.center.x + UiBridge.x(100);
                int vasey = UiBridge.metrics.center.y - UiBridge.y(100);
                vase = new BitmapObject(vasex, vasey,0,0, R.mipmap.iris_1);
                gameWorld.add(Layer.player.ordinal(), vase);
            }
        });
        gameWorld.add(Layer.ui.ordinal(),irisButton);



    }
    public static ThirdScene get() {
        return (ThirdScene) GameScene.getTop();
    }
}

