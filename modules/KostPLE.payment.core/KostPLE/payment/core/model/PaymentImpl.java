package KostPLE.payment.core.model;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;

import KostPLE.pemesanan.core.PemesananImpl;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="_impl")
@Table(name="_impl")
public class PaymentImpl extends PaymentComponent {

	public PaymentImpl(String idPayment, Float amount, boolean status, Date createdAt, PemesananImpl pemesananimpl) {
		this.idPayment = idPayment;
		this.amount = amount;
		this.status = status;
		this.createdAt = createdAt;
		this.pemesananimpl = pemesananimpl;
	}

	public PaymentImpl(Float amount, boolean status, Date createdAt, PemesananImpl pemesananimpl) {
		this.idPayment =  UUID.randomUUID().toString();
		this.amount = amount;
		this.status = status;
		this.createdAt = createdAt;
		this.pemesananimpl = pemesananimpl;
	}

	public PaymentImpl() { }


	public void Pay() {
		// TODO: implement this method
	}

	public void Cancel() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> Map = new HashMap<String,Object>();
		Map.put("idPayment",getIdPayment());
		Map.put("amount",getAmount());
		Map.put("status",getStatus());
		Map.put("createdAt",getCreatedAt());
		Map.put("pemesananimpl",getPemesananimpl());

        return Map;
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
