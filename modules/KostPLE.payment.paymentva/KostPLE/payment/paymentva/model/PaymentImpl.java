package KostPLE.payment.paymentva;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import KostPLE.payment.core.model.PaymentDecorator;
import KostPLE.pemesanan.core.model.PemesananImpl;
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
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> paymentMap = new HashMap<String, Object>();
		paymentMap.put("idPayment", getIdPayment());
		paymentMap.put("amount", getAmount());
		paymentMap.put("status", getStatus());
		paymentMap.put("createdAt", getCreatedAt());
		paymentMap.put("accountNumber", accountNumber);
		paymentMap.put("provider", provider);
		paymentMap.put("pemesananimpl", getPemesananimpl());

        return paymentMap;
    }


	public void pay() {
		// Payment logic using VA
		if (this.record != null) {
			this.record.Pay();
		}
	}

	@Override
	public void setPemesananimpl(PemesananImpl pemesananimpl) {
		if (this.record != null) {
			this.record.setPemesananimpl(pemesananimpl);
		}
	}

	@Override
	public String getIdPayment() {
		if (this.record != null) {
			return this.record.getIdPayment();
		}
		return null;
	}

	@Override
	public void setIdPayment(String idPayment) {
		if (this.record != null) {
			this.record.setIdPayment(idPayment);
		}
	}

	@Override
	public Float getAmount() {
		if (this.record != null) {
			return this.record.getAmount();
		}
		return null;
	}

	@Override
	public void setAmount(Float amount) {
		if (this.record != null) {
			this.record.setAmount(amount);
		}
	}

	@Override
	public boolean getStatus() {
		if (this.record != null) {
			return this.record.getStatus();
		}
		return false;
	}

	@Override
	public void setStatus(boolean status) {
		if (this.record != null) {
			this.record.setStatus(status);
		}
	}

	@Override
	public Date getCreatedAt() {
		if (this.record != null) {
			return this.record.getCreatedAt();
		}
		return null;
	}

	@Override
	public void setCreatedAt(Date createdAt) {
		if (this.record != null) {
			this.record.setCreatedAt(createdAt);
		}
	}

	@Override
	public PemesananImpl getPemesananimpl() {
		if (this.record != null) {
			return this.record.getPemesananimpl();
		}
		return null;
	}


}
