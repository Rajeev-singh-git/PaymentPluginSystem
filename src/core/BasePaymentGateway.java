package core;

import java.util.Random;


public abstract class BasePaymentGateway implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        if (!isValidAmount(amount)) {
            System.out.println("❌ Invalid payment amount: " + amount);
            LoggerUtil.log(getGatewayName(), amount, "Failed - Invalid amount");
            return;
        }

        try {
            simulateNetworkDelay();
            if (simulateFailure()) {
                throw new RuntimeException("Simulated gateway failure.");
            }

            System.out.println("✅ Payment of ₹" + amount + " processed via " + getGatewayName());
            LoggerUtil.log(getGatewayName(), amount, "Success");

        } catch (Exception e) {
            System.out.println("⚠️ Error processing payment via " + getGatewayName() + ": " + e.getMessage());
            LoggerUtil.log(getGatewayName(), amount, "Failed - " + e.getMessage());
        }
    }

    // Validate the amount is positive and within same range
    protected boolean isValidAmount(double amount) {
        return amount > 0 && amount <= 100_00_00;
    }

    // Simulate delay
    protected void simulateNetworkDelay() throws InterruptedException {
        Thread.sleep(500 + new Random().nextInt(1000));
    }

    // Randomly simulate occasional gateway failure
    protected boolean simulateFailure(){
        return new Random().nextInt(10)<2;   // ~ 20 % chance of failure
    }
}
