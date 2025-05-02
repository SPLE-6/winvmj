package KostPLE.payment.paymentva;

import java.util.*;

import vmj.routing.route.VMJExchange;

import KostPLE.payment.core.PaymentServiceDecorator;
import KostPLE.payment.core.PaymentImpl;
import KostPLE.payment.core.PaymentServiceComponent;

public class PaymentServiceImpl extends PaymentServiceDecorator {
    public PaymentServiceImpl (PaymentServiceComponent record) {
        super(record);
    }

    
	public void Pay() {
		// TODO: implement this method
	}
}
