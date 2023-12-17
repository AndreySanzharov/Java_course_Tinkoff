package edu.hw7;

import edu.hw7.Task1.AtomicCounter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    void testIncrementAndPrint() throws InterruptedException {
        AtomicCounter atomicCounter = new AtomicCounter();

        // Создаем и запускаем поток
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                atomicCounter.incrementAndPrint();
            }
        });

        thread.start();

        // Ждем завершения потока
        thread.join();

        // Проверяем, что значение счетчика равно ожидаемому
        assertEquals(5, atomicCounter.getCounter());
    }
}
