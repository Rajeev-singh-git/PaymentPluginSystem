package gateways;

import core.BasePaymentGateway;


public class PayPalGateway extends BasePaymentGateway {

    @Override
    public String getGatewayName() {
        return "PayPal";
    }
}
