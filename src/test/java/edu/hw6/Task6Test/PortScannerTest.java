package edu.hw6.Task6Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task6.PortScanner.checkPorts;
import static edu.hw6.Task6.PortScanner.printUsedPorts;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PortScannerTest {
    @Test
    @DisplayName("Проверка, что список занятых портов не пустой")
    public void checkPorts_shouldReturnListOfUsedPorts() {
        assertThat(checkPorts()).isNotEmpty();
    }

    @Test
    @DisplayName("Вывод информации о портах")
    public void printUsedPorts_shouldPrintListOfUsedPorts() {
        assertDoesNotThrow(() -> printUsedPorts(checkPorts()));
    }
}
