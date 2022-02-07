package codingame.lineracing;

import java.util.*;

import java.io.*;

import java.math.*;



/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/


class Player
{

    static  boolean[][] abMatrix = new boolean[30][20];  /* Initialization of a boolean matrix
                                                            false : cell is free
                                                            true : cell is taken */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        /* Initialize matrix with false (not occupied) */
        for (int i = 0; i < 30; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                abMatrix[i][j] = false;
            }
        }


        // game loop

        while (true) {

            int N = in.nextInt(); // total number of players (2 to 4).

            int P = in.nextInt(); // your player number (0 to 3).
            /* Current position */
            int PrevX = 0;
            int PrevY = 0;
            int CurrX = 0;
            int CurrY = 0;

            int CountUp = 0;
            int CountDown = 0;
            int CountLeft = 0;
            int CountRight = 0;
            /* 0 = up, 1 = down, 2 = left, 3 right, 4 unknown */
            int Dir = 4;

            for (int i = 0; i < N; i++) {

                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)

                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)

                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)

                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)

                if ((X1 != -1)
                        && (Y1 != -1)) {
                    abMatrix[X1][Y1] = true;
                }

                /* Refresh current position */
                if (i == P) {
                    PrevX = CurrX;
                    PrevY = CurrY;
                    CurrX = X1;
                    CurrY = Y1;

                    if (PrevX < CurrX) {
                        Dir = 3;
                    } else if (PrevX > CurrX) {
                        Dir = 2;
                    } else if (PrevY < CurrY) {
                        Dir = 1;
                    } else if (PrevY > CurrY) {
                        Dir = 0;
                    }
                    /* Supposed to happen only at first round */
                    else {
                        Dir = 4;
                    }
                }
            }

            do {
                if ((CurrY - CountUp - 1) <= 0) {
                    break;
                } else if (abMatrix[CurrX][CurrY - CountUp - 1]) /* is true */ {
                    break;
                }
                CountUp = CountUp + 1;
            } while (CountUp < 20);


            do {
                if ((CurrY + CountDown + 1) >= 20) {
                    break;
                } else if (abMatrix[CurrX][CurrY + CountDown + 1]) /*is true */ {
                    break;
                }

                CountDown = CountDown + 1;
            } while (CountDown < 20);

            do {
                if ((CurrX + CountRight + 1) >= 30) {
                    break;
                } else if (abMatrix[CurrX + CountRight + 1][CurrY]) /*is true */ {
                    break;
                }
                CountRight = CountRight + 1;
            } while (CountRight < 20);

            do {
                if ((CurrX - CountLeft - 1) >= 30) {
                    break;
                } else if (abMatrix[CurrX - CountLeft + 1][CurrY]) /* is true */ {
                    break;
                }
                CountLeft = CountLeft + 1;
            } while (CountLeft < 20);


            /* Dir unknown == init */
            if (Dir == 4) {


                if ((CountUp >= CountDown)
                        && (CountUp >= CountLeft)
                        && (CountUp >= CountRight)) {
                    System.out.println("UP");
                } else if ((CountDown >= CountUp)
                        && (CountDown >= CountLeft)
                        && (CountDown >= CountRight)) {
                    System.out.println("DOWN");
                } else if ((CountLeft >= CountUp)
                        && (CountLeft >= CountDown)
                        && (CountLeft >= CountRight)) {
                    System.out.println("LEFT");
                } else if (CountRight >= CountDown) {
                    System.out.println("RIGHT");
                } else {
                    System.out.println("RIGHT");
                }
            }
            /* Up */
            else if (Dir == 0) {
                if ((CountUp >= CountDown)
                        && (CountUp >= CountLeft)
                        && (CountUp >= CountRight)) {
                    System.out.println("UP");
                } else if ((CountLeft >= CountUp)
                        && (CountLeft >= CountDown)
                        && (CountLeft >= CountRight)) {
                    System.out.println("LEFT");
                } else if ((CountRight >= CountUp)
                        && (CountRight >= CountLeft)
                        && (CountRight >= CountDown)) {
                    System.out.println("RIGHT");
                } else {
                    System.out.println("RIGHT");
                }
            }
            /* Down */
            else if (Dir == 1) {
                if ((CountDown >= CountUp)
                        && (CountDown >= CountLeft)
                        && (CountDown >= CountRight)) {
                    System.out.println("DOWN");
                } else if ((CountLeft >= CountUp)
                        && (CountLeft >= CountDown)
                        && (CountLeft >= CountRight)) {
                    System.out.println("LEFT");
                } else if (CountRight >= CountUp) {
                    System.out.println("RIGHT");
                } else {
                    System.out.println("RIGHT");
                }
            }
            /* Left */
            else if (Dir == 2) {
                if ((CountUp >= CountDown)
                        && (CountUp >= CountLeft)
                        && (CountUp >= CountRight)) {
                    System.out.println("UP");
                } else if ((CountDown >= CountUp)
                        && (CountDown >= CountLeft)
                        && (CountDown >= CountRight)) {
                    System.out.println("DOWN");
                } else if ((CountLeft >= CountUp)
                        && (CountLeft >= CountDown)
                        && (CountLeft >= CountRight)) {
                    System.out.println("LEFT");
                } else {
                    System.out.println("RIGHT");
                }
            }
            /* Right */
            else if (Dir == 3) {
                if ((CountUp >= CountDown)
                        && (CountUp >= CountLeft)
                        && (CountUp >= CountRight)) {
                    System.out.println("UP");
                } else if ((CountDown >= CountUp)
                        && (CountDown >= CountLeft)
                        && (CountDown >= CountRight)) {
                    System.out.println("DOWN");
                } else if (CountRight >= CountUp && CountRight >= CountLeft) {
                    System.out.println("RIGHT");
                } else {
                    System.out.println("RIGHT");
                }
            }

        }

    }
}
