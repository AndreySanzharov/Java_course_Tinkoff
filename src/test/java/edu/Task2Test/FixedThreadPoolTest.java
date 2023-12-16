package edu.Task2Test;

import edu.Task2.FixedThreadPool;
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
            latch.countDown();
        });

        threadPool.execute(() -> {
            latch.countDown();
        });

        threadPool.execute(() -> {
            latch.countDown();
        });

        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }

    @Test(expected = IllegalStateException.class)
    public void testExecuteAfterShutdownThrowsException() {
        threadPool.close();
        threadPool.execute(() -> {
        });
    }

    @Test
    public void testThreadPoolShutsDown() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        threadPool.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        threadPool.close();
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }
}

