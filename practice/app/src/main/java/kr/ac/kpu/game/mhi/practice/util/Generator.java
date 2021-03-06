package kr.ac.kpu.game.mhi.practice.util;

import java.util.Random;

public class Generator {
    public static int[][] generate(int bombnum, final int width, final int height){
        Random rand = new Random();

        int [][] grid = new int[width][height];
        for(int x = 0; x < width; x++){
            grid[x] = new int [height];
        }

        while (bombnum > 0){
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);

            // -1 = 지뢰
            if (grid[x][y] != -1){
                grid[x][y] = -1;
                bombnum--;
            }
        }
        grid = calcNeighbours(grid, width, height);

        return grid;
    }

    private static int[][] calcNeighbours(int[][] grid, final int width, final int height){
        for(int x = 0;x<width;x++){
            for(int y = 0;y<height;y++){
                grid[x][y] = getNeibourNum(grid, x, y, width, height);
            }
        }
        return grid;
    }

    private static int getNeibourNum(final int grid[][], final int x, final int y, final int width, final int height) {
        if (grid[x][y] == -1){
            return -1;
        }
        int cnt = 0;

        if (isMine(grid, x - 1, y + 1, width, height)) cnt++;   //좌상단
        if (isMine(grid, x, y + 1, width, height)) cnt++; //상단
        if (isMine(grid, x + 1, y + 1, width, height)) cnt++;   //우상단
        if (isMine(grid, x - 1, y, width, height)) cnt++;   //좌측
        if (isMine(grid, x + 1, y, width, height)) cnt++;   //우측
        if (isMine(grid, x - 1, y - 1, width, height)) cnt++;   //하단
        if (isMine(grid, x, y - 1, width, height)) cnt++;   //좌하단
        if (isMine(grid, x + 1, y - 1, width, height)) cnt++;   //우하단


        return cnt;
    }

    private static boolean isMine(final int[][] grid, final int x, final int y, final int width, final int height){
        if (x >= 0 && y >= 0 && x < width && y < height){
            if (grid[x][y] == -1){
                return true;
            }
        }
        return false;
    }
}
