package gateways;

import core.BasePaymentGateway;

public class RazorpayGateway extends BasePaymentGateway {

    @Override
    public String getGatewayName() {
        return "Razorpay";
    }
}
