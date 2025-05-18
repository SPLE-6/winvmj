package KostPLE.pemesanan.sewaviaapp;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import KostPLE.pemesanan.core.PemesananDecorator;
import KostPLE.profilpengguna.core.ProfilPenggunaImpl;
import KostPLE.kamar.core.KamarImpl;
import KostPLE.pemesanan.core.Pemesanan;
import KostPLE.pemesanan.core.PemesananComponent;
import KostPLE.kamar.core.Kamar;
import KostPLE.profilpengguna.core.ProfilPengguna;

@Entity(name="pemesanan_sewaviaapp")
@Table(name="pemesanan_sewaviaapp")
public class PemesananImpl extends PemesananDecorator {

	@Column(name = "down_payment")
	public Float downPayment;
	
	public PemesananImpl() {
        super();
    }
    
    public PemesananImpl(Float downPayment) {
    	super();
		this.downPayment = downPayment;
    }
	
	public PemesananImpl(PemesananComponent record, Float downPayment) {
		super(record);
		this.downPayment = downPayment;
	}


	public void sumTotal() {
		// Calculate total payment considering down payment
		if (record != null) {
			// Get base total payment
			Float baseTotalPay = record.getTotalPay();
			
			// If there is a down payment, subtract it from the total
			if (this.downPayment != null && this.downPayment > 0) {
				Float remainingPayment = baseTotalPay - this.downPayment;
				// Update total pay with remaining amount after down payment
				this.totalPay = remainingPayment > 0 ? remainingPayment : 0f;
			} else {
				// If no down payment, total is the same as base
				this.totalPay = baseTotalPay;
			}
		}
	}

	public void addNewPesanan() {
		// Create a new reservation with default values
		this.idPemesanan = UUID.randomUUID();
		this.startDate = new Date(); // Current date as start date
		// Set end date to 1 month from now by default
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		this.endDate = calendar.getTime();
		this.statusPemesanan = "PENDING"; // Default status
		this.detail = "New reservation via app";
		this.createdAt = new Date(); // Current timestamp
		
		// Down payment is set to 0 if not specified
		if (this.downPayment == null) {
			this.downPayment = 0f;
		}
	}
	
	// Override required abstract methods from PemesananComponent
	@Override
	public UUID getIdPemesanan() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getIdPemesanan();
		}
		return this.idPemesanan;
	}
	
	@Override
	public void setIdPemesanan(UUID idPemesanan) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setIdPemesanan(idPemesanan);
		} else {
			this.idPemesanan = idPemesanan;
		}
	}
	
	@Override
	public Date getStartDate() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getStartDate();
		}
		return this.startDate;
	}
	
	@Override
	public void setStartDate(Date startDate) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setStartDate(startDate);
		} else {
			this.startDate = startDate;
		}
	}
	
	@Override
	public Date getEndDate() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getEndDate();
		}
		return this.endDate;
	}
	
	@Override
	public void setEndDate(Date endDate) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setEndDate(endDate);
		} else {
			this.endDate = endDate;
		}
	}
	
	@Override
	public Float getTotalPay() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getTotalPay();
		}
		return this.totalPay;
	}
	
	@Override
	public void setTotalPay(Float totalPay) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setTotalPay(totalPay);
		} else {
			this.totalPay = totalPay;
		}
	}
	
	@Override
	public String getStatusPemesanan() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getStatusPemesanan();
		}
		return this.statusPemesanan;
	}
	
	@Override
	public void setStatusPemesanan(String statusPemesanan) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setStatusPemesanan(statusPemesanan);
		} else {
			this.statusPemesanan = statusPemesanan;
		}
	}
	
	@Override
	public String getDetail() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getDetail();
		}
		return this.detail;
	}
	
	@Override
	public void setDetail(String detail) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setDetail(detail);
		} else {
			this.detail = detail;
		}
	}
	
	@Override
	public Date getCreatedAt() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getCreatedAt();
		}
		return this.createdAt;
	}
	
	@Override
	public void setCreatedAt(Date createdAt) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setCreatedAt(createdAt);
		} else {
			this.createdAt = createdAt;
		}
	}
	
	@Override
	public Kamar getKamar() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getKamar();
		}
		return this.kamar;
	}
	
	@Override
	public void setKamar(Kamar kamar) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setKamar(kamar);
		} else {
			this.kamar = kamar;
		}
	}
	
	@Override
	public ProfilPengguna getProfilPengguna() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getProfilPengguna();
		}
		return this.profilPengguna;
	}
	
	@Override
	public void setProfilpengguna(ProfilPengguna profilPengguna) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setProfilpengguna(profilPengguna);
		} else {
			this.profilPengguna = profilPengguna;
		}
	}
	
	@Override
	public void setProfilPengguna(ProfilPengguna profilPengguna) {
		// Just call the other method to maintain consistency
		setProfilpengguna(profilPengguna);
	}
	
	// Additional methods for downPayment
	public Float getDownPayment() {
		return this.downPayment;
	}
	
	public void setDownPayment(Float downPayment) {
		this.downPayment = downPayment;
	}
	
	// Override toHashMap to include sewaviaapp-specific fields
	@Override
	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> map = super.toHashMap();
		map.put("downPayment", this.downPayment);
		return map;
	}

}
