package KostPLE.payment.paymentkredit;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;


import KostPLE.payment.core.*;
import KostPLE.pemesanan.core.Pemesanan;


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
	
	
	public int getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getProvider() {
		return this.provider = provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public String getCcv() {
		return this.ccv;
	}
	
	public void setCcv(String ccv) {
		this.ccv = ccv;
	}
	
	@Override
	public void setPemesanan(Pemesanan pemesanan) {
		this.pemesanan = pemesanan;
	}

	@Override
	public UUID getIdPayment() {
		return this.idPayment;
	}

	@Override
	public void setIdPayment(UUID idPayment) {
		this.idPayment = idPayment;
	}

	@Override
	public boolean getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public Date getCreatedAt() {
		return this.createdAt;
	}

	@Override
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public Pemesanan getPemesanan() {
		return this.pemesanan;
	}
	
	
	
	
	






}
