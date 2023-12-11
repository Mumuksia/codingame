package advent_23;

import java.util.ArrayList;
import java.util.List;

public class Day_11 {

    int expander = 1000000-1;

    public long galaxyDistance(List<String> input){
        char[][] galaxyTemp = new char[input.size()+2][input.get(0).length()+2];
        boolean[] emptyRow = new boolean[input.size()+2];
        for (int i=0; i<input.size(); i++){
            galaxyTemp[i] = input.get(i).toCharArray();
            if (!input.get(i).contains("#")){
                emptyRow[i] = true;
            }
        }
        boolean[] emptyColumn = new boolean[input.get(0).length()+2];
        List<Point> galaxies = new ArrayList<>();

        for (int j = 0; j<galaxyTemp[0].length; j++){
            emptyColumn[j] = true;
            for (int i = 0; i<galaxyTemp.length; i++) {
                if (galaxyTemp[i][j] == '#'){
                    galaxies.add(new Point(i, j));
                    emptyColumn[j] = false;
                }
            }
        }
        long sum = 0;
        for (int i=0;i<galaxies.size();i++){
            for (int j = i+1; j<galaxies.size(); j++){
                sum+=distanceBetweenPoints(galaxies.get(i), galaxies.get(j), emptyColumn, emptyRow);
            }
        }
        return sum;
    }

    private long distanceBetweenPoints(Point p1, Point p2, boolean[] emptyColumn, boolean[] emptyRow){
        return Math.abs(p1.x- p2.x) + Math.abs(p1.y-p2.y) + findEmptyBetweenPoints(p1, p2, emptyColumn, emptyRow);
    }

    private long findEmptyBetweenPoints(Point p1, Point p2, boolean[] emptyColumn, boolean[] emptyRow){
        long counter =0;
        if (p1.y < p2.y){
            for (int i = p1.y;i<p2.y; i++){
                if (emptyColumn[i]){
                    counter++;
                }
            }
        } else{
            for (int i = p2.y;i<p1.y; i++){
                if (emptyColumn[i]){
                    counter++;
                }
            }
        }
        if (p1.x < p2.x){
            for (int i = p1.x;i<p2.x; i++){
                if (emptyRow[i]){
                    counter++;
                }
            }
        } else{
            for (int i = p2.x;i<p1.x; i++){
                if (emptyRow[i]){
                    counter++;
                }
            }
        }
        return counter*expander;
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
