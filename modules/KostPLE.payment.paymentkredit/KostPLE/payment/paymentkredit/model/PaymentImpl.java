package KostPLE.payment.paymentkredit.model;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;


import KostPLE.payment.core.model.PaymentDecorator;
import KostPLE.pemesanan.core.PemesananImpl;
import KostPLE.payment.core.model.Payment;
import KostPLE.payment.core.model.PaymentComponent;

@Entity(name="payment_paymentkredit")
@Table(name="payment_paymentkredit")
public class PaymentImpl extends PaymentDecorator {

	public int accountNumber;
	public String provider;
	public String ccv;
	public PaymentImpl() {
        super();
    }
    
    public PaymentImpl(int accountNumber, String provider, String ccv) {
    	super();
		this.accountNumber = accountNumber;
		this.provider = provider;
		this.ccv = ccv;
    }
	
	public PaymentImpl(PaymentComponent record, int accountNumber, String provider, String ccv) {
		super(record);
		this.accountNumber = accountNumber;
		this.provider = provider;
		this.ccv = ccv;
	}


	public void Pay() {
		// TODO: implement this method
	}

	@Override
	public void setPemesananimpl(PemesananImpl pemesananimpl) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setPemesananimpl'");
	}

	public String getIdPayment() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getIdPayment'");
	}

	public void setIdPayment(String idPayment) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setIdPayment'");
	}

	public Float getAmount() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAmount'");
	}

	public void setAmount(Float amount) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setAmount'");
	}

	public boolean getStatus() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
	}

	public void setStatus(boolean status) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
	}

	public Date getCreatedAt() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getCreatedAt'");
	}

	public void setCreatedAt(Date createdAt) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setCreatedAt'");
	}

	public PemesananImpl getPemesananimpl() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPemesananimpl'");
	}

}
