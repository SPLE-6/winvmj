package KostPLE.payment.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;

import KostPLE.pemesanan.core.Pemesanan;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="payment_impl")
@Table(name="payment_impl")
public class PaymentImpl extends PaymentComponent {

	public PaymentImpl(UUID idPayment, boolean status, Date createdAt, Pemesanan pemesanan) {
		this.idPayment = idPayment;
		this.status = status;
		this.createdAt = createdAt;
		this.pemesanan = pemesanan;
	}

	public PaymentImpl(boolean status, Date createdAt, Pemesanan pemesanan) {
		this.idPayment =  UUID.randomUUID();
		this.status = status;
		this.createdAt = createdAt;
		this.pemesanan = pemesanan;
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
		Map.put("status",getStatus());
		Map.put("createdAt",getCreatedAt());
		Map.put("pemesanan",getPemesanan());

        return Map;
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
