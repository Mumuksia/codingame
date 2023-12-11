package leet;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiningPhilosophersTest {

    @Test
    public void wantsToEat() throws InterruptedException {
        DiningPhilosophers dp = new DiningPhilosophers();
        for (int i =0;i<5;i++){
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    dp.wantsToEat(finalI, () -> System.out.println(finalI + "left fork"), () -> System.out.println(finalI + "right fork"),
                            () -> System.out.println(finalI + "eat fork"), () -> System.out.println(finalI + "put left fork"),
                            () -> System.out.println(finalI + "put right fork"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();

        }

    }
}