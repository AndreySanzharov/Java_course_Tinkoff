package edu.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@SuppressWarnings({"ReturnCount", "RegexpSinglelineJava", "OperatorWrap"})
public class ClientHandler implements Runnable {

    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println("Received message from " + clientSocket.getInetAddress() + ": " + inputLine);
                String response = processInput(inputLine);
                writer.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processInput(String input) {
        switch (input.toLowerCase()) {
            case "личности":
                return "Не переходи на личности там, где их нет";
            case "оскорбления":
                return "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами";
            case "глупый":
                return "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог " +
                    "идиотизма.";
            case "интеллект":
                return "Чем ниже интеллект, тем громче оскорбления";
            default:
                return "Неизвестная команда";
        }
    }
}
