package KostPLE.payment.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="_impl")
@Table(name="_impl")
public class PaymentImpl extends PaymentComponent {

	public PaymentImpl(int idPayment, EFloat amount, boolean status, EDate createdAt, PemesananImpl pemesananimpl) {
		this.idPayment = idPayment;
		this.amount = amount;
		this.status = status;
		this.createdAt = createdAt;
		this.pemesananimpl = pemesananimpl;
	}

	public PaymentImpl(EFloat amount, boolean status, EDate createdAt, PemesananImpl pemesananimpl) {
		this.idPayment =  idPayment.randomUUID();;
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

}
