package codingame.minesweeper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Player {


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        boolean firstTime = true;
        Map.init();

        while (true) {
            Map.read(in);

            if (firstTime) {
                System.out.println("20 7");
                firstTime = false;
            } else {
                Map.findMines();
                Map.findMoves();

                String result = Map.moves.get(0).col + " " + Map.moves.get(0).row;

                for (int r = 0; r < 16; r++) {
                    for (int c = 0; c < 30; c++) {
                        if (Map.cells[r][c].isMine) {
                            result = result + " " + Map.cells[r][c].pos.col + " " + Map.cells[r][c].pos.row;
                        }
                    }
                }

                System.out.println(result);
            }
        }
    }

    public void sweeperStep(char[][] grid) {

        System.out.println("20 7");
    }

    public static class Cell {

    }
}

class Position {
    int row;
    int col;
}

class Cell {
    public Position pos = new Position();
    public boolean isSafe;
    public boolean isMine;
    public boolean isMove;
    public boolean blocked;
    public int nMines;
    public double prob;
    public ArrayList<Position> neighbors = new ArrayList<Position>();

    public final void init(int r, int c) {
        pos.row = r;
        pos.col = c;
        isSafe = false;
        isMine = false;
        isMove = false;
        blocked = false;
        nMines = 0;
        prob = 0.0F;

        Position p = new Position();
        if (r - 1 >= 0) {
            p.row = r - 1;
            p.col = c;
            neighbors.add(p);
        }
        if (r + 1 < 16) {
            p.row = r + 1;
            p.col = c;
            neighbors.add(p);
        }
        if (c - 1 >= 0) {
            p.row = r;
            p.col = c - 1;
            neighbors.add(p);
        }
        if (c + 1 < 30) {
            p.row = r;
            p.col = c + 1;
            neighbors.add(p);
        }
        if (c + 1 < 30 && r + 1 < 16) {
            p.row = r + 1;
            p.col = c + 1;
            neighbors.add(p);
        }
        if (c - 1 >= 0 && r + 1 < 16) {
            p.row = r + 1;
            p.col = c - 1;
            neighbors.add(p);
        }
        if (c + 1 < 30 && r - 1 >= 0) {
            p.row = r - 1;
            p.col = c + 1;
            neighbors.add(p);
        }
        if (c - 1 >= 0 && r - 1 >= 0) {
            p.row = r - 1;
            p.col = c - 1;
            neighbors.add(p);
        }
    }
}

class Map {
    public static Cell[][] cells = new Cell[16][30];
    public static ArrayList<Position> moves = new ArrayList<>();

    public static final void init() {
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 30; c++) {
                cells[r][c] = new Cell();
                cells[r][c].init(r, c);
            }
        }
    }

    public static final void read(Scanner in) {
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 30; c++) {
                cells[r][c].isMove = false;
                String cell; // '?' if unknown, '.' if no mines nearby, '1'-'8' otherwise
                cell = in.next();

                if (!cell.equals("?")) {
                    cells[r][c].isSafe = true;
                    if (cell.equals(".")) {
                        cells[r][c].nMines = 0;
                    } else {
                        cells[r][c].nMines = Integer.parseInt(cell);
                    }
                }
            }
        }
    }

    public static final int getNsafe(int row, int col) {
        int n = 0;
        for (Position p : cells[row][col].neighbors) {
            if (cells[p.row][p.col].isSafe) {
                n++;
            }
        }
        return n;
    }

    public static final int getNmines(int row, int col) {
        int n = 0;
        for (Position p : cells[row][col].neighbors) {
            if (cells[p.row][p.col].isMine) {
                n++;
            }
        }
        return n;
    }

    public static boolean isMineAllowedHere(int rowMine, int colMine, int row, int col) {
        boolean result = true;

        Cell[][] cel = new Cell[16][30];
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 30; c++) {
                cel[r][c] = cells[r][c];
            }
        }

        // set cell temporarily to hold a mine
        cel[rowMine][colMine].isMine = true;
        // set all its neighbours to safe

        for (Position p : cel[row][col].neighbors) {
            if (!cel[p.row][p.col].isSafe && !cel[p.row][p.col].isMine) {
                cel[p.row][p.col].blocked = true;
            }
        }

        // go through all
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 30; c++) {
                if (cel[r][c].isSafe && (cel[r][c].nMines > 0)) {
                    int n = 0; // current number of mines discovered
                    int nFree = 0; //  empty cells to open
                    for (Position p : cel[r][c].neighbors) {
                        if (cel[p.row][p.col].isMine) {
                            n++;
                        }
                        if (!cel[p.row][p.col].isSafe && !cel[p.row][p.col].isMine && !cel[p.row][p.col].blocked) {
                            nFree++;
                        }
                    }
                    if (n + nFree < cel[r][c].nMines) {
                        result = false;
                        // cerr << "FOUND! problem here " << c << " " << r << " n=" << n << " nFree=" << nFree << endl;
                    }
                }
            }
        }

        return result;
    }


    public static void findMines() {
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 30; c++) {

                if (cells[r][c].isSafe && cells[r][c].nMines > 0) {
                    int nSafe = getNsafe(r, c);
                    int nDiscoveredMines = getNmines(r, c);

                    // cerr << r << " " << c << " " << nSafe + nDiscoveredMines + cells[r][c].nMines << "      " << nSafe << " " << nDiscoveredMines << " " << cells[r][c].nMines << endl;

                    if (nSafe + cells[r][c].nMines == cells[r][c].neighbors.size()) {
                        // mine found, all unsafe neighbours are mines
                        for (Position p : cells[r][c].neighbors) {
                            if (cells[p.row][p.col].isSafe == false) {
                                cells[p.row][p.col].isMine = true;
                            }
                        }
                    }
                }
            }
        }

    }


    public static int minesLeftToDiscover() {
        int result = 99;
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 30; c++) {
                if (cells[r][c].isMine) {
                    result--;
                }
            }
        }
        return result;
    }

    public static int unsafeCells() {
        int result = 0;
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 30; c++) {
                if ((cells[r][c].isSafe && !cells[r][c].isMine)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static float setProbabilities() {


        int minesLeft = minesLeftToDiscover();
        int nUnSafe = unsafeCells();
        float p0 = (float) minesLeft / (float) nUnSafe;


        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 30; c++) {
                if (cells[r][c].isSafe) {
                    cells[r][c].prob = 0.0;
                } else if (cells[r][c].isMine) {
                    cells[r][c].prob = 1.0;
                } else {
                    cells[r][c].prob = p0;
                }
            }
        }

        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 30; c++) {

                if ((cells[r][c].isSafe && cells[r][c].nMines > 0)) {

                    if (getNmines(r, c) < cells[r][c].nMines) {
                        int nM = cells[r][c].nMines - getNmines(r, c);
                        int nS = 0;
                        for (Position p : cells[r][c].neighbors) {
                            if (!cells[p.row][p.col].isSafe && !cells[p.row][p.col].isMine) {
                                nS++;
                            }
                        }
                        float pN = (float) nM / (float) nS;
                        for (Position p : cells[r][c].neighbors) {
                            if (!cells[p.row][p.col].isSafe && !cells[p.row][p.col].isMine) {
                                if (p0 == cells[p.row][p.col].prob) {
                                    cells[p.row][p.col].prob = pN;
                                }
                                if (pN > cells[p.row][p.col].prob) {
                                    cells[p.row][p.col].prob = pN;
                                }
                            }
                        }
                    }
                }
            }
        }

        return p0;
    }

    public static void findMoves() {
        System.err.println(" FIND MOVES");

        moves.clear();
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 30; c++) {

                if ((cells[r][c].isSafe && cells[r][c].nMines > 0)) {

                    if (getNmines(r, c) == cells[r][c].nMines) {
                        for (Position p : cells[r][c].neighbors) {
                            if (!cells[p.row][p.col].isSafe && !cells[p.row][p.col].isMine) {
                                moves.add(p);
                                cells[p.row][p.col].isMove = true;
                            }
                        }
                    }
                }
            }
        }

        // consider placing mines in neighbours + check if this violates something
        if (moves.size() == 0) {
            for (int r = 0; r < 16; r++) {
                for (int c = 0; c < 30; c++) {
                    if ((cells[r][c].isSafe && cells[r][c].nMines > 0)) {
                        if (cells[r][c].nMines - getNmines(r, c) == 1) { // one mine is missing
                            // place a mine temporarily into one of the neighbours
                            for (Position p : cells[r][c].neighbors) {
                                if (!cells[p.row][p.col].isSafe && !cells[p.row][p.col].isMine) {
                                    if (!isMineAllowedHere(p.row, p.col, r, c)) {
                                        moves.add(p);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        // set probabilities
        float backgroundProb = setProbabilities();

        // add move with minimum probability
        Position minProb = new Position();
        double minp = 1E10F;
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 30; c++) {
                if ((cells[r][c].isSafe && !cells[r][c].isMine)) {
                    if (cells[r][c].prob < minp) {
                        minp = cells[r][c].prob;
                        minProb.row = r;
                        minProb.col = c;
                    }
                }
            }
        }

        if (cells[minProb.row][minProb.col].prob < backgroundProb) {
            moves.add(minProb);
        }


        // add a random position
        boolean found = false;
        Random rand = new Random();
        while (!found) {
            int r = rand.nextInt(16);
            int c = rand.nextInt(30);
            if (!cells[r][c].isSafe && !cells[r][c].isMine) {
                Position p = new Position();
                p.row = r;
                p.col = c;
                moves.add(p);
                found = true;
            }
        }
    }


}
