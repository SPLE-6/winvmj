package KostPLE.payment.core.model;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import KostPLE.pemesanan.core.Pemesanan;
import KostPLE.pemesanan.core.PemesananComponent;
import KostPLE.pemesanan.core.PemesananImpl;

import javax.persistence.ManyToOne;

@Entity
@Table(name="_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentComponent implements Payment{
	@Id
	public String idPayment; 
	public Float amount;
	public boolean status;
	public Date createdAt;
	@ManyToOne(targetEntity=PemesananComponent.class)
	public Pemesanan pemesananimpl;
	protected String objectName = PaymentComponent.class.getName();

	public PaymentComponent() {

	} 

	public PaymentComponent(
        String idPayment, Float amount, boolean status, Date createdAt, PemesananImpl pemesananimpl
    ) {
        this.idPayment = idPayment;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
        this.pemesananimpl = pemesananimpl;
    }

	public abstract String getIdPayment();
	public abstract void setIdPayment(String idPayment);
	
	public abstract Float getAmount();
	public abstract void setAmount(Float amount);
	
	public abstract boolean getStatus();
	public abstract void setStatus(boolean status);
	
	public abstract Date getCreatedAt();
	public abstract void setCreatedAt(Date createdAt);
	
	public abstract PemesananImpl getPemesananimpl();
	public abstract void setPemesananimpl(PemesananImpl pemesananimpl);
	
 
	public abstract void Pay();

	public abstract void Cancel();

	@Override
    public String toString() {
        return "{" +
            " idPayment='" + getIdPayment() + "'" +
            " amount='" + getAmount() + "'" +
            " status='" + getStatus() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " pemesananimpl='" + getPemesananimpl() + "'" +
            "}";
    }
	
}
