package hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point{

    int x,y;

    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class CastlesOnTheGrid {

    static int game[][], helper[][];
    static Queue<Point> move = new LinkedList<>();
    static int n;

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

        n = grid.length;
        game = new int[n][n];
        helper = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j) == '.')
                    game[i][j] = 100;
                else game[i][j] = -1;
            }
        }

        Point start = new Point(startX, startY);
        move.add(start);
        game[startX][startY] = 0;
        while(!move.isEmpty()){
            Point current = move.remove();
            if(helper[current.x][current.y] == 0){
                helper[current.x][current.y] = 1;
                moveGenerator(current);
            }
        }

        return game[goalX][goalY];

    }

    public static void moveGenerator(Point p){

        int x = p.x;
        int y = p.y;
        int value = game[x][y];
        for(int i=x; i<n && game[i][y]!=-1;i++){
            addStep(i,y,value);
            move.add(new Point(i,y));
        }
        for(int i=x; i>=0 && game[i][y]!=-1;i--){
            addStep(i,y,value);
            move.add(new Point(i,y));
        }
        for(int i=y; i<n && game[x][i]!=-1;i++){
            addStep(x,i,value);
            move.add(new Point(x,i));
        }
        for(int i=y; i>=0 && game[x][i]!=-1;i--){
            addStep(x,i,value);
            move.add(new Point(x,i));
        }
    }

    public static void addStep(int x, int y, int value){

        if(game[x][y] > value+1)
            game[x][y] = value+1;
    }



}
