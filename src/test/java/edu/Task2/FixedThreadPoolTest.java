package edu.Task2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class FixedThreadPoolTest {
    private FixedThreadPool threadPool;

    @Before
    public void setUp() {
        threadPool = FixedThreadPool.create(2);
        threadPool.start();
    }

    @After
    public void tearDown() {
        threadPool.close();
    }

    @Test
    public void testThreadPoolExecutesTasks() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        threadPool.execute(() -> {
            // Task 1
            latch.countDown();
        });

        threadPool.execute(() -> {
            // Task 2
            latch.countDown();
        });

        threadPool.execute(() -> {
            // Task 3
            latch.countDown();
        });

        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }

    @Test(expected = IllegalStateException.class)
    public void testExecuteAfterShutdownThrowsException() {
        threadPool.close();
        threadPool.execute(() -> {
            // This should throw IllegalStateException
        });
    }

    @Test
    public void testThreadPoolShutsDown() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        threadPool.execute(() -> {
            try {
                // Simulate a long-running task
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        threadPool.close();

        // Verify that all tasks are completed before shutdown
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }
}

