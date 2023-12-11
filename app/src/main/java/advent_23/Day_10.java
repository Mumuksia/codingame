package advent_23;

import java.io.IOException;
import java.util.*;

public class Day_10 {

    private static class Pipe{
        private int directions; // 4bit: N E S W
        private boolean visited;
        private String type;
        private int x, y;
        private int distance = 0;

        public Pipe(int x, int y, String type){
            this.x = x;
            this.y = y;
            this.type = type;
            if (this.type.equals("|")){
                this.directions = 10;
            } else if (this.type.equals("-")){
                this.directions = 5;
            } else if (this.type.equals("L")){
                this.directions = 12;
            } else if (this.type.equals("J")){
                this.directions = 9;
            } else if (this.type.equals("7")){
                this.directions = 3;
            } else if (this.type.equals("F")){
                this.directions = 6;
            }
        }

        public void applyStartConnections(Pipe[][] map){
            if (this.type.equals("S")){
                Pipe p1 = getPipeAt(map, this.x, this.y-1);
                Pipe p2 = getPipeAt(map, this.x, this.y+1);
                Pipe p3 = getPipeAt(map, this.x-1, this.y);
                Pipe p4 = getPipeAt(map, this.x+1, this.y);
                if (p1 != null && (p1.type.equals("|") || p1.type.equals("7") || p1.type.equals("F"))){
                    this.directions |= 8;
                }
                if (p2 != null && (p2.type.equals("|") || p2.type.equals("L") || p2.type.equals("J"))){
                    this.directions |= 2;
                }
                if (p3 != null && (p3.type.equals("-") || p3.type.equals("L") || p3.type.equals("F"))){
                    this.directions |= 1;
                }
                if (p4 != null && (p4.type.equals("-") || p4.type.equals("J") || p4.type.equals("7"))){
                    this.directions |= 4;
                }
            }
        }

        public static Pipe getPipeAt(Pipe[][] map, int x, int y){
            if (x >= 0 && y >= 0 && x < map.length && y < map[0].length){
                return map[x][y];
            } else return null;
        }

        public static void setPipeAt(Pipe[][] map, Pipe pipe){
            if (pipe.x >= 0 && pipe.y >= 0 && pipe.x < map.length && pipe.y < map[0].length){
                map[pipe.x][pipe.y] = pipe;
            }
        }
    }

    public void labyrinth(List<String> lines){

        Pipe[][] map = new Pipe[lines.get(0).length()][lines.size()];
        int startX = 0, startY = 0;

        for (int y = 0; y < lines.size(); y++){
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                String p = String.valueOf(line.charAt(x));
                if (p.equals("S")){
                    startX = x;
                    startY = y;
                }
                map[x][y] = new Pipe(x, y, p);
            }
        }

        map[startX][startY].applyStartConnections(map);

        // Calculate distance
        walk(map, startX, startY);
        int maxDistance = 0;
        for (int x = 0; x < map.length; x++){
            for (int y = 0; y < map[x].length; y++){
                Pipe pipe = map[x][y];
                if (!pipe.type.equals(".") && pipe.distance > maxDistance){
                    maxDistance = pipe.distance;
                }
            }
        }

        System.out.println(maxDistance);

        // Delete the pipes that are not in the mainloop
        for (int y = 0; y < map[0].length; y++){
            for (int x = 0; x < map.length; x++){
                Pipe pipe = map[x][y];
                if (!pipe.visited){
                    map[x][y] = new Pipe(x, y, ".");
                }
            }
        }

        // Calculate the area
        Pipe[][] zoomed = zoom(map); // x2 zoom
        boolean[][] outside = new boolean[zoomed.length][zoomed[0].length];
        makeOutsideMap(zoomed, 0, 0, outside);

        int area = 0;
        for (int y = 0; y < outside[0].length; y++){
            for (int x = 0; x < outside.length; x++){
                if (!(outside[x][y] && zoomed[x][y].type.equals("."))){ // it's inside and it's not a pipe
                    Pipe pipe = map[(x-1)/2][(y-1)/2];
                    if (pipe.type.equals(".") && x % 2 == 1 && y % 2 == 1){
                        area++;
                    }
                }
            }
        }

        System.out.println(area);
    }

    private static void makeOutsideMap(Pipe[][] zoomed, int x, int y, boolean[][] outside){
        Pipe pipe = Pipe.getPipeAt(zoomed, x, y);
        List<Pipe> pipes = new ArrayList<>();
        if (pipe != null){
            pipes.add(pipe);
            while (pipes.size() != 0){
                Pipe p = pipes.remove(0);
                if (p.visited) continue;
                p.visited = true;
                outside[p.x][p.y] = true;

                Pipe n = Pipe.getPipeAt(zoomed, p.x, p.y-1);
                Pipe e = Pipe.getPipeAt(zoomed, p.x+1, p.y);
                Pipe s = Pipe.getPipeAt(zoomed, p.x, p.y+1);
                Pipe w = Pipe.getPipeAt(zoomed, p.x-1, p.y);
                if (n != null && n.type.equals(".") && !n.visited){
                    pipes.add(n);
                }
                if (e != null && e.type.equals(".") && !e.visited){
                    pipes.add(e);
                }
                if (s != null && s.type.equals(".") && !s.visited){
                    pipes.add(s);
                }
                if (w != null && w.type.equals(".") && !w.visited){
                    pipes.add(w);
                }
            }
        }
    }

    private static Pipe[][] zoom(Pipe[][] map){
        Pipe[][] output = new Pipe[map.length*2+1][map[0].length*2+1];
        for (int x = 0; x < map.length; x++){
            for (int y = 0; y < map[x].length; y++){
                int px = x*2+1;
                int py = y*2+1;
                if (!map[x][y].type.equals(".")){
                    output[px][py] = new Pipe(px, py, map[x][y].type);
                    if (map[x][y].type.equals("|")){
                        Pipe.setPipeAt(output, new Pipe(px, py-1, "|"));
                        Pipe.setPipeAt(output, new Pipe(px, py+1, "|"));
                    } else if (map[x][y].type.equals("-")){
                        Pipe.setPipeAt(output, new Pipe(px-1, py, "-"));
                        Pipe.setPipeAt(output, new Pipe(px+1, py, "-"));
                    } else if (map[x][y].type.equals("L")){
                        Pipe.setPipeAt(output, new Pipe(px, py-1, "|"));
                        Pipe.setPipeAt(output, new Pipe(px+1, py, "-"));
                    } else if (map[x][y].type.equals("J")){
                        Pipe.setPipeAt(output, new Pipe(px, py-1, "|"));
                        Pipe.setPipeAt(output, new Pipe(px-1, py, "-"));
                    } else if (map[x][y].type.equals("7")){
                        Pipe.setPipeAt(output, new Pipe(px, py+1, "|"));
                        Pipe.setPipeAt(output, new Pipe(px-1, py, "-"));
                    } else if (map[x][y].type.equals("F")){
                        Pipe.setPipeAt(output, new Pipe(px, py+1, "|"));
                        Pipe.setPipeAt(output, new Pipe(px+1, py, "-"));
                    }
                }
            }
        }

        for (int x = 0; x < output.length; x++){
            for (int y = 0; y < output[x].length; y++){
                if (output[x][y] == null){ // Null pipes are empty tiles ('.')
                    output[x][y] = new Pipe(x, y, ".");
                }
            }
        }

        return output;
    }

    private static void walk(Pipe[][] map, int x, int y){
        Pipe pipe = Pipe.getPipeAt(map, x, y);
        List<Pipe> pipes = new ArrayList<>();
        if (pipe != null && !pipe.type.equals(".")){
            pipes.add(pipe);
            while (!pipes.isEmpty()){
                Pipe p = pipes.remove(0);
                if (p.visited) continue;
                p.visited = true;

                Pipe n = Pipe.getPipeAt(map, p.x, p.y-1);
                Pipe e = Pipe.getPipeAt(map, p.x+1, p.y);
                Pipe s = Pipe.getPipeAt(map, p.x, p.y+1);
                Pipe w = Pipe.getPipeAt(map, p.x-1, p.y);
                if ((p.directions & 8) == 8 && !n.visited){
                    n.distance = p.distance+1;
                    pipes.add(n);
                }
                if ((p.directions & 4) == 4 && !e.visited){
                    e.distance = p.distance+1;
                    pipes.add(e);
                }
                if ((p.directions & 2) == 2 && !s.visited){
                    s.distance = p.distance+1;
                    pipes.add(s);
                }
                if ((p.directions & 1) == 1 && !w.visited){
                    w.distance = p.distance+1;
                    pipes.add(w);
                }
            }
        }
    }
}
