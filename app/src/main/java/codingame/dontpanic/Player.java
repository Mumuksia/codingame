package codingame.dontpanic;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Coord{
    int x,y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int useless;
        useless = in.nextInt();
        useless = in.nextInt();
        useless = in.nextInt();
        int exitFloor = in.nextInt();
        int exitPos = in.nextInt();
        useless = in.nextInt();
        useless = in.nextInt();
        int nbElevators = in.nextInt();

        List<Coord> elevators = new ArrayList<Coord>();
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt();
            int elevatorPos = in.nextInt();
            elevators.add(new Coord(elevatorFloor, elevatorPos));
        }
        elevators.add(new Coord(exitFloor, exitPos));

        elevators.sort(new Comparator<Coord>() {
            @Override
            public int compare(Coord o1, Coord o2) {
                return Integer.compare(o1.y, o2.y);
            };
        });

        while (true) {
            int cFloor = in.nextInt();
            int cPos = in.nextInt();
            String dir = in.next();

            String a;
            if (dir.equals("NONE")) {
                a = "WAIT";
            } else {
                Coord elevator = elevators.get(cFloor);
                if (elevator.x < cPos && dir.equals("RIGHT") || elevator.x > cPos && dir.equals("LEFT")) {
                    a = "BLOCK";
                } else {
                    a = "WAIT";
                }
            }
            System.out.println(a);
        }
    }

}
