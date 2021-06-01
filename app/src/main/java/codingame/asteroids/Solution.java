package codingame.asteroids;


import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.IntStream;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {


    public static void main(String args[]) {
        List<Meteor> meteors1 = new ArrayList<>();
        Map<Character, Meteor> meteors2 = new HashMap<>();
        List<Meteor> meteors3 = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        int T1 = in.nextInt();
        int T2 = in.nextInt();
        int T3 = in.nextInt();
        char[][] mapT1 = new char[H][W];
        char[][] mapT2 = new char[H][W];
        char[][] mapT3 = new char[H][W];
        for (int i = 0; i < H; i++) {
            String firstPictureRow = in.next();
            String secondPictureRow = in.next();

            mapT1[i] = firstPictureRow.toCharArray();
            mapT2[i] = secondPictureRow.toCharArray();

            for (int j=0;j<W;j++) {
                if (mapT1[i][j] >= 'A' && mapT1[i][j] <= 'Z'){
                    meteors1.add(new Meteor(i, j, mapT1[i][j]));
                }
                if (mapT2[i][j] >= 'A' && mapT2[i][j] <= 'Z'){
                    meteors2.put(mapT2[i][j], new Meteor(i, j, mapT2[i][j]));
                }
            }
        }

        for (Meteor m : meteors1){
            if (meteors2.containsKey(m.name)){

                Meteor m2 = meteors2.get(m.name);
                System.err.println("Meteors " + m.x + " " + m.y + "  --   " + m2.x + " " + m2.y);
                float deltaX = (m2.x - m.x)/(float)Math.abs(T2 - T1);
                float deltaY = (m2.y - m.y)/(float)Math.abs(T2 - T1);
                System.err.println("delta " + deltaX + " " + deltaY);
                int newX = m.x + (int)Math.floor(deltaX*Math.abs(T3-T1));
                int newY = m.y + (int)Math.floor(deltaY*Math.abs(T3-T1));
                meteors3.add(new Meteor(newX, newY, m.name));
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j< W; j++){
                mapT3[i][j] = '.';
            }
        }

        meteors3.sort(new MeteorComparator());
        for (Meteor r : meteors3){
            if (r.x >= 0 && r.y>=0 && r.x<H && r.y<W){
                mapT3[r.x][r.y] = r.name;
            }
        }

        for (int i = 0; i < H; i++) {
            System.out.println(String.valueOf(mapT3[i]));
        }


    }

}

class Meteor {
    int x, y;
    char name;

    public Meteor(int x, int y, char name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meteor meteor = (Meteor) o;
        return x == meteor.x && y == meteor.y && name == meteor.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, name);
    }
}

class MeteorComparator implements Comparator<Meteor> {
    public int compare(Meteor a, Meteor b)
    {
        return(int)b.name - (int)a.name;
    }
}
