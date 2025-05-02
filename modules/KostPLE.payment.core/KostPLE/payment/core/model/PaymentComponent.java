package KostPLE.payment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentComponent implements Payment {
	@Id
	public int idPayment; 
	public EFloat amount;
	public boolean status;
	public EDate createdAt;
	@ManyToOne(targetEntity=KostPLE.pemesanan.core.PemesananComponent.class)
	public Pemesanan pemesananimpl;
	protected String objectName = PaymentComponent.class.getName();

	public PaymentComponent() {

	} 

	public PaymentComponent(
        int idPayment, EFloat amount, boolean status, EDate createdAt, PemesananImpl pemesananimpl
    ) {
        this.idPayment = idPayment;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
        this.pemesananimpl = pemesananimpl;
    }

	public abstract int getIdPayment();
	public abstract void setIdPayment(int idPayment);
	
	public abstract EFloat getAmount();
	public abstract void setAmount(EFloat amount);
	
	public abstract boolean getStatus();
	public abstract void setStatus(boolean status);
	
	public abstract EDate getCreatedAt();
	public abstract void setCreatedAt(EDate createdAt);
	
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
