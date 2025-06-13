package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {

    private static final String LOG_FILE = "transaction.log";
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static synchronized void log(String gatewayName, double amount, String status) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = String.format(
                "[%s] %s - ₹%.2f - %s%n",
                timestamp,
                gatewayName,
                amount,
                status
        );

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            bw.write(logEntry);
        } catch (IOException e) {
            System.err.println("⚠️ Failed to write to log: " + e.getMessage());
        }
    }
}
