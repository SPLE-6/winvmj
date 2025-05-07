package KostPLE.payment.paymentva.model;

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

@Entity(name="payment_paymentva")
@Table(name="payment_paymentva")
public class PaymentImpl extends PaymentDecorator {

	public int accountNumber;
	public String provider;
	public PaymentImpl() {
        super();
    }
    
    public PaymentImpl(int accountNumber, String provider) {
    	super();
		this.accountNumber = accountNumber;
		this.provider = provider;
    }
	
	public PaymentImpl(PaymentComponent record, int accountNumber, String provider) {
		super(record);
		this.accountNumber = accountNumber;
		this.provider = provider;
	}


	public void pay() {
		// TODO: implement this method
	}

	@Override
	public void setPemesananimpl(PemesananImpl pemesananimpl) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setPemesananimpl'");
	}

	@Override
	public String getIdPayment() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getIdPayment'");
	}

	@Override
	public void setIdPayment(String idPayment) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setIdPayment'");
	}

	@Override
	public Float getAmount() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAmount'");
	}

	@Override
	public void setAmount(Float amount) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setAmount'");
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
	}

	@Override
	public void setStatus(boolean status) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
	}

	@Override
	public Date getCreatedAt() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getCreatedAt'");
	}

	@Override
	public void setCreatedAt(Date createdAt) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setCreatedAt'");
	}

	@Override
	public PemesananImpl getPemesananimpl() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPemesananimpl'");
	}


}
