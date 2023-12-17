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
        String[] quotes = {
            "Не переходи на личности там, где их нет",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
            "Чем ниже интеллект, тем громче оскорбления"
        };

        for (String quote : quotes) {
            if (quote.toLowerCase().contains(input.toLowerCase())) {
                return quote;
            }
        }

        // Если ни в одной цитате нет введенного слова, вернем стандартный ответ
        return "Не найдено цитаты с этим словом";
    }
}
