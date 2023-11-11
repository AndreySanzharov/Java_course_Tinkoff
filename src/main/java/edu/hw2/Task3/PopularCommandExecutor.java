package edu.hw2.Task3;

public final class PopularCommandExecutor {
    private static final String COMMAND = "apt update && apt upgrade -y";
    public static final int MAX_NUM = 10;
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.manager = manager;
    }

    public void updatePackages() {
        tryExecute(COMMAND);
    }

    void tryExecute(String command) {
        for (int i = 1; i <= maxAttempts; i++) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                break;
            } catch (Exception conExp) {
                if (i == maxAttempts) {
                    throw new ConnectionException("Все попытки подключения закончились", conExp);
                }
            }
        }
    }
}
