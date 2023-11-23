package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void incrementAndPrint() {
        synchronized (this) {
            int newValue = counter.incrementAndGet();
            System.out.println("Counter Value: " + newValue);
        }
    }
    public int getCounter() {
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicCounter atomicCounter = new AtomicCounter();

        // Создаем и запускаем несколько потоков
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                atomicCounter.incrementAndPrint();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                atomicCounter.incrementAndPrint();
            }
        });

        thread1.start();
        thread2.start();

        // Ждем завершения потоков
        thread1.join();
        thread2.join();
    }
}
