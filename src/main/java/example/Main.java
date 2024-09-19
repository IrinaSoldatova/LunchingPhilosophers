package example;

public class Main {
    public static void main(String[] args) {
        Fork[] forks = new Fork[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork();
        }

        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < 5; i++) {
            // Философу i нужна вилка i и вилка (i + 1) % 5
            philosophers[i] = new Philosopher("Philosopher " + (i + 1), forks[i], forks[(i + 1) % 5]);
        }

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }

        for (Philosopher philosopher : philosophers) {
            try {
                philosopher.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All philosophers have finished eating!");
    }
}
