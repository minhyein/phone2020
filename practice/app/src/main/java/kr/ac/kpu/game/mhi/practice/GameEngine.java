package kr.ac.kpu.game.mhi.practice;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import kr.ac.kpu.game.mhi.practice.util.Generator;
import kr.ac.kpu.game.mhi.practice.util.PrintGrid;
import kr.ac.kpu.game.mhi.practice.views.grid.Cell;

public class GameEngine {
    private static final String TAG = GameEngine.class.getSimpleName();
    private static GameEngine instance;

    public static final int BOMB_NUMBER = 10;
    public static final int WIDTH = 15;
    public static final int HEIGHT = 10;
    public static int flags = 0;
    public boolean isClear;


    private Context mContext;

    private Cell[][] MinesweeperGrid = new Cell[WIDTH][HEIGHT];
    private int experience;

    public static GameEngine getInstance() {
        if( instance == null ){
            instance = new GameEngine();
        }
        return instance;
    }

    public int getBombNumber(){
        return BOMB_NUMBER;
    }

    public int getFlags(){
        return flags;
    }

    private GameEngine(){}

    public GameEngine(Context context){
        mContext = context;
    }

    public void createGrid(Context context){
        Log.e(TAG,"createGrid is working");
        this.mContext = context;

        int[][] GeneratedGrid = Generator.generate(BOMB_NUMBER, WIDTH, HEIGHT);
        PrintGrid.gridPrint(GeneratedGrid,WIDTH,HEIGHT);
        setGrid(context,GeneratedGrid);
    }

    private void setGrid( final Context context, final int[][] grid ){
        for( int x = 0 ; x < WIDTH ; x++ ){
            for( int y = 0 ; y < HEIGHT ; y++ ){
                if( MinesweeperGrid[x][y] == null ){
                    MinesweeperGrid[x][y] = new Cell( context, x, y);
                }
                MinesweeperGrid[x][y].setValue(grid[x][y]);
                MinesweeperGrid[x][y].invalidate();
            }
        }
    }

    public Cell getCellAt(int position) {
        int x = position % WIDTH;
        int y = position / WIDTH;

        return MinesweeperGrid[x][y];
    }

    public Cell getCellAt( int x , int y ){
        return MinesweeperGrid[x][y];
    }

    public void click( int x , int y ){
        if( x >= 0 && y >= 0 && x < WIDTH && y < HEIGHT && !getCellAt(x,y).isClicked() ){
            getCellAt(x,y).setClicked();

            if( getCellAt(x,y).getValue() == 0 ){
                for( int xt = -1 ; xt <= 1 ; xt++ ){
                    for( int yt = -1 ; yt <= 1 ; yt++){
                        if( xt != yt ){
                            click(x + xt , y + yt);
                        }
                    }
                }
            }

            if( getCellAt(x,y).isBomb() ){
                onGameLost();
            }
        }

        checkEnd();
    }

    private boolean checkEnd(){
        int bombNotFound = BOMB_NUMBER;
        int notRevealed = WIDTH * HEIGHT;
        for ( int x = 0 ; x < WIDTH ; x++ ){
            for( int y = 0 ; y < HEIGHT ; y++ ){
                if( getCellAt(x,y).isRevealed() || getCellAt(x,y).isFlagged() ){
                    notRevealed--;
                }

                if( getCellAt(x,y).isFlagged() && getCellAt(x,y).isBomb() ){
                    bombNotFound--;
                }
            }
        }

        if( bombNotFound == 0 && notRevealed == 0 ){
            Toast.makeText(mContext,"Game won", Toast.LENGTH_SHORT).show();
            int min = ((GameActivity)mContext).getMin();
            isClear = true;
            flags = 0;

            experience = (min+1) * 10;
            ((GameActivity)mContext).save(experience);
            ((GameActivity)mContext).setMineText(BOMB_NUMBER, 0);

            Intent intent = new Intent(mContext.getApplicationContext(), GameoverActivity.class);
            mContext.startActivity(intent);

        }
        return false;
    }


    public void flag( int x , int y ){
        boolean isFlagged = getCellAt(x,y).isFlagged();
        if (!getCellAt(x, y).isRevealed()){
            getCellAt(x,y).setFlagged(!isFlagged);
        }
        getCellAt(x,y).invalidate();
        if (isFlagged){
            flags--;
        } else{
            if (!getCellAt(x, y).isRevealed())
                flags++;
        }
        ((GameActivity)mContext).setMineText(BOMB_NUMBER, flags);
    }

    private void onGameLost(){
        isClear = false;
        flags = 0;
        ((GameActivity)mContext).setMineText(BOMB_NUMBER, 0);
        Intent intent = new Intent(mContext.getApplicationContext(), GameoverActivity.class);
        mContext.startActivity(intent);

    }
}
