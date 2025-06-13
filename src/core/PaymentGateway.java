package core;

public interface PaymentGateway {

    void processPayment(double amount);
    String getGatewayName();

}
