package KostPLE.payment.paymentva;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import KostPLE.payment.core.PaymentDecorator;
import KostPLE.payment.core.Payment;
import KostPLE.payment.core.PaymentComponent;

@Entity(name="payment_paymentva")
@Table(name="payment_paymentva")
public class PaymentImpl extends PaymentDecorator {

	public int accountNumber;
	public String provider;
	public PaymentImpl(
        super();
        this.objectName = PaymentImpl.class.getName();
    }
    
    public PaymentImpl(int accountNumber, String provider) {
    	super();
		this.accountNumber = accountNumber;
		this.provider = provider;
		this.objectName = PaymentImpl.class.getName();
    }
	
	public PaymentImpl(PaymentComponent record, int accountNumber, String provider) {
		super(record);
		this.accountNumber = accountNumber;
		this.provider = provider;
		this.objectName = PaymentImpl.class.getName();
	}


	public void Pay() {
		// TODO: implement this method
	}

}
