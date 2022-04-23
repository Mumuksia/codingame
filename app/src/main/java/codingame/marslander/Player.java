package codingame.marslander;

import java.util.*;
import java.io.*;
import java.math.*;

public class Player {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int surfacesN = in.nextInt(); // the number of points used to draw the surface of Mars.

        int targetLeftX = -1;
        int targetRightX = -1;
        int targetY = -1;

        int previousX = -1;
        int previousY = -1;

        for (int i = 0; i < surfacesN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            if (previousY == landY) {
                targetLeftX = previousX;
                targetRightX = landX;
                targetY = landY;
            } else {
                previousX = landX;
                previousY = landY;
            }
        }

        // game loop
        while (true) {

            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int power = in.nextInt(); // the thrust power (0 to 4).

            int maxSpeedV = 40;
            int maxSpeedH = 20;

            if (X >= targetLeftX && X <= targetRightX) {
                if ((Y - targetY) < 20 || Math.abs(hSpeed) <= (maxSpeedH - 5) && Math.abs(vSpeed) <= (maxSpeedV - 5)) {
                    System.out.println(0 + " " + 3);
                }

                else {
                    double speed = Math.sqrt(Math.pow(hSpeed, 2) + Math.pow(vSpeed, 2));
                    rotate = (int) Math.toDegrees(Math.asin(hSpeed / speed));
                    System.out.println(rotate + " " + 4);
                }
            }
            else {

                if ((X < targetLeftX && hSpeed < 0) || (X > targetRightX && hSpeed > 0) || Math.abs(hSpeed) > 80) {

                    double speed = Math.sqrt(Math.pow(hSpeed, 2) + Math.pow(vSpeed, 2));
                    rotate = (int) Math.toDegrees(Math.asin(hSpeed / speed));
                    System.out.println(rotate + " " + 4);
                }

                else if (Math.abs(hSpeed) < 25) {
                    if(X < targetLeftX){
                        System.out.println(-30 + " " + 4);
                    }
                    else {
                        System.out.println(30 + " " + 4);
                    }
                } else {
                    if(vSpeed > 0){
                        System.out.println(0 + " " + 3);
                    }
                    else {
                        System.out.println(0 + " " + 4);
                    }
                }
            }

        }
    }
}
