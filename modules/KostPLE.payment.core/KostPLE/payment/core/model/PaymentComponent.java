package KostPLE.payment.core;

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


import javax.persistence.ManyToOne;

@Entity
@Table(name="payment_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentComponent implements Payment{
	@Id
	public UUID idPayment; 
	public Float amount;
	public boolean status;
	public Date createdAt;
	@ManyToOne(targetEntity=KostPLE.pemesanan.core.PemesananComponent.class)
	public Pemesanan pemesanan;
	protected String objectName = PaymentComponent.class.getName();

	public PaymentComponent() {

	} 

	public PaymentComponent(
         UUID idPayment, Float amount, boolean status, Date createdAt, Pemesanan pemesanan
    ) {
        this.idPayment = idPayment;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
        this.pemesanan = pemesanan;
    }

	public abstract UUID getIdPayment();
	public abstract void setIdPayment(UUID idPayment);
	
	public abstract Float getAmount();
	public abstract void setAmount(Float amount);
	
	public abstract boolean getStatus();
	public abstract void setStatus(boolean status);
	
	public abstract Date getCreatedAt();
	public abstract void setCreatedAt(Date createdAt);
	
	public abstract Pemesanan getPemesanan();
	public abstract void setPemesanan(Pemesanan pemesanan);
	
 
	public abstract void Pay();

	public abstract void Cancel();

	@Override
    public String toString() {
        return "{" +
            " idPayment='" + getIdPayment() + "'" +
            " amount='" + getAmount() + "'" +
            " status='" + getStatus() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " pemesanan='" + getPemesanan() + "'" +
            "}";
    }
	
}
