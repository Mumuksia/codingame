package codingame.codersstrikeback;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int maxCheckPointDist = 0;

        int rounds = 0;

        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();

            if (nextCheckpointDist > maxCheckPointDist)
                maxCheckPointDist = nextCheckpointDist;

            rounds ++;

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // You have to output the target position
            // followed by the power (0 <= thrust <= 100)
            // i.e.: "x y thrust"
            String thrust = " 100";
            if (nextCheckpointAngle > 90 || nextCheckpointAngle < -90){
                thrust = " 0";
            }
            if (rounds > 7 && nextCheckpointDist == maxCheckPointDist && thrust.equals(" 100")){
                thrust = " BOOST";
            }
            System.out.println(nextCheckpointX + " " + nextCheckpointY + thrust);
        }
    }
}
