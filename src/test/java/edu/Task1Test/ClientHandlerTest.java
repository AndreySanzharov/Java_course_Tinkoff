package edu.Task1Test;

import edu.Task1.ClientHandler;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientHandlerTest {

    @Test
    public void testProcessInput() throws IOException {
        Socket mockSocket = mock(Socket.class);
        ByteArrayInputStream input = new ByteArrayInputStream("интеллект".getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        when(mockSocket.getInputStream()).thenReturn(input);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        when(mockSocket.getOutputStream()).thenReturn(output);
        ClientHandler clientHandler = new ClientHandler(mockSocket);
        clientHandler.run();
        String result = output.toString().trim();
        assertEquals("Чем ниже интеллект, тем громче оскорбления", result);
    }
}
