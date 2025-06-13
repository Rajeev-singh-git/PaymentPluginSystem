package gateways;

import core.BasePaymentGateway;

public class StripeGateway extends BasePaymentGateway {
    @Override
    public String getGatewayName() {
        return "Stripe";
    }
}
