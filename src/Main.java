import core.PaymentGateway;
import core.PaymentProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {


    private static final String CONFIG_FILE = "src/directory/plugins.config";
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, String> gatewayMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        System.out.println("💳 Welcome to the Payment Plugin System");

        loadPluginsFromConfig();

        if (gatewayMap.isEmpty()) {
            System.out.println("⚠️ No payment gateways found. Please check plugins.config");
            return;
        }

        listAvailableGateways();

        String selectedKey = getUserChoice();

        double amount = getAmountFromUser();

        String className = gatewayMap.get(selectedKey);
        try {
            Class<?> clazz = Class.forName(className);
            PaymentGateway gateway = (PaymentGateway) clazz.getDeclaredConstructor().newInstance();

            PaymentProcessor processor = new PaymentProcessor(gateway);
            processor.makePayment(amount);
        } catch (Exception e) {
            System.out.println("❌ Failed to load plugin: " + className);
            e.printStackTrace();
        }
    }

    private static void loadPluginsFromConfig() {
        try (BufferedReader br = new BufferedReader(new FileReader(CONFIG_FILE))) {
            String line;
            int index = 1;
            while ((line = br.readLine()) != null) {
                String simpleName = line.substring(line.lastIndexOf('.') + 1).replace("Gateway", "");
                gatewayMap.put(String.valueOf(index), line);
                index++;
            }
        } catch (Exception e) {
            System.out.println("❌ Error reading config: " + e.getMessage());
        }
    }

    private static void listAvailableGateways() {
        System.out.println("\nAvailable Payment Gateways:");
        for (Map.Entry<String, String> entry : gatewayMap.entrySet()) {
            String simpleName = entry.getValue().substring(entry.getValue().lastIndexOf('.') + 1)
                    .replace("Gateway", "");
            System.out.println(entry.getKey() + ". " + simpleName);
        }
    }

    private static String getUserChoice() {
        System.out.print("\nSelect gateway [number]: ");
        String choice = scanner.nextLine();
        while (!gatewayMap.containsKey(choice)) {
            System.out.print("Invalid choice. Try again: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    private static double getAmountFromUser() {
        System.out.print("Enter payment amount: ₹");
        while (true) {
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                return amount;
            } catch (NumberFormatException e) {
                System.out.print("Invalid amount. Enter again: ₹");
            }
        }
    }
}
