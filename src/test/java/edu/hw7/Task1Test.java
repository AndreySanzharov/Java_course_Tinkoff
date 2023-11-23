package edu.hw7;

import edu.hw7.Task1.AtomicCounter;
import java.util.concurrent.CountDownLatch;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Task1Test {

    @Test
    public void testAtomicCounterThreadSafety() throws InterruptedException {
        final int numThreads = 10;
        final int incrementsPerThread = 1000;

        AtomicCounter atomicCounter = new AtomicCounter();
        CountDownLatch latch = new CountDownLatch(numThreads);

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                try {
                    for (int j = 0; j < incrementsPerThread; j++) {
                        atomicCounter.incrementAndPrint();
                    }
                } finally {
                    latch.countDown();
                }
            });
            thread.start();
        }

        latch.await();

        // Проверяем, что счетчик имеет правильное значение
        assertEquals(numThreads * incrementsPerThread, atomicCounter.getCounter());
    }
}
