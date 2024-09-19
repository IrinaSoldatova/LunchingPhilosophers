package example;

import java.util.Random;

class Philosopher extends Thread {
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private final Random random = new Random();
    private static final int MEALS = 3;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void eat() {
        System.out.println(name + " is eating.");
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think() {
        System.out.println(name + " is thinking.");
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < MEALS; i++) {
            think();

            leftFork.pickUp();
            rightFork.pickUp();

            eat();

            rightFork.putDown();
            leftFork.putDown();
        }
    }
}