package org.example;

public class Philosopher extends Thread {
    Fork fork;
    private static int countPhilosopher = 0;
    private final int id;

    public Philosopher(Fork fork) {
        this.fork = fork;
        countPhilosopher++;
        id = countPhilosopher;
    }

    public void run() {
        try {
            int countEat = 3;

            while (countEat > 0) {
                sleep(1000);
                think();
                sleep(1000);
                while (!fork.getFork(getLeftForkPhilosopher(),getRightForkPhilosopher()));
                {
                    sleep(1000);
                }
                eat(getLeftForkPhilosopher(),getRightForkPhilosopher());
                sleep(1000);
                putFork(getLeftForkPhilosopher(),getRightForkPhilosopher());
                fork.giveFork(getLeftForkPhilosopher(),getRightForkPhilosopher());
                countEat--;
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void eat(int leftForkPhilosopher, int rightForkPhilosopher) {
        System.out.println("\u001B[32m"
                + "Philosopher " + id + " is eating. Fork "
                + leftForkPhilosopher + " and " + rightForkPhilosopher + "\u001B[0m" );
    }
    public void putFork(int leftForkPhilosopher, int rightForkPhilosopher) {
        System.out.println("Philosopher " + id + " putFork "
                + leftForkPhilosopher + " and " + rightForkPhilosopher);
    }
    public void think() {
        System.out.println("Philosopher " + id + " is thinking");
    }
    public int getLeftForkPhilosopher() {
        if(id == 1) return countPhilosopher;
        return id - 1;
    }
    public int getRightForkPhilosopher() {
        return id;
    }
}
