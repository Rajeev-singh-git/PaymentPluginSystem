package core;

public class PaymentProcessor {

    private final PaymentGateway gateway;

    public PaymentProcessor(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void makePayment(double amount) {
        System.out.println("\n🔄 Initiating payment via: " + gateway.getGatewayName());
        gateway.processPayment(amount);
    }

}
