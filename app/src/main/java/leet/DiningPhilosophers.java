package leet;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    private Semaphore[] forks = new Semaphore[5];

    ReentrantLock lockP = new ReentrantLock();

    public DiningPhilosophers() {
        for(int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int nextPhil = (philosopher+1)%5;
        boolean left = false;
        boolean right = false;
        while (!left || !right){

            if (philosopher%2==0){
                if (!left && forks[philosopher].tryAcquire()){
                    System.out.println(philosopher + "picks left");
                    pickLeftFork.run();
                    left = true;
                }
                if (left && forks[nextPhil].tryAcquire()){
                    System.out.println(philosopher + "picks right");
                    pickRightFork.run();
                    right = true;
                }
            } else {
                if (!right && forks[nextPhil].tryAcquire()){
                    System.out.println(philosopher + "picks right");
                    right = true;
                    pickRightFork.run();
                }
                if (right && forks[philosopher].tryAcquire()){
                    System.out.println(philosopher + "picks left");
                    left = true;
                    pickLeftFork.run();
                }
            }
        }

        eat.run();
        putLeftFork.run();
        putRightFork.run();
        forks[nextPhil].release();
        forks[philosopher].release();
    }
}
