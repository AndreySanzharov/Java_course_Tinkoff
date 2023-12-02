package edu.Task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int PORT = 5555;
    private static final int MAX_CONNECTIONS = 5;

    public static void main(String[] args) {
        // Создаем пул потоков для обработки соединений
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONNECTIONS);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                // Принимаем новое соединение
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getInetAddress());

                // Добавляем задачу в пул потоков для обработки клиента
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Завершаем пул потоков при завершении работы сервера
            executorService.shutdown();
        }
    }
}
