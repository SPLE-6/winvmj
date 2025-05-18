package KostPLE.pemesanan.sewaviaapp;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import KostPLE.pemesanan.core.PemesananDecorator;
import KostPLE.pemesanan.core.Pemesanan;
import KostPLE.pemesanan.core.PemesananComponent;
import KostPLE.kamar.core.Kamar;
import KostPLE.profilpengguna.core.ProfilPengguna;

@Entity(name="pemesanan_sewaviaapp")
@Table(name="pemesanan_sewaviaapp")
public class PemesananImpl extends PemesananDecorator {

	protected int totalHarga;
	protected int downPayment;
	public PemesananImpl() {
        super();
    }
    
    public PemesananImpl(int downPayment) {
    	super();
		this.downPayment = downPayment;
    }
	
	public PemesananImpl(PemesananComponent record, int downPayment) {
		super(record);
		this.downPayment = downPayment;
	}

	public int sumTotal() {
		// TODO: implement this method
		int dp = totalHarga / 10;
		setTotalHarga(totalHarga-dp);
		setDownPayment(dp);
		return totalHarga;
	}

	public void setTotalHarga(int totalHarga) {
		this.totalHarga = totalHarga;
	}
	public int getTotalHarga() {
		return totalHarga;
	}
	public int getDownPayment() {
		return downPayment;
	}
	public void setDownPayment(int downPayment) {
		this.downPayment = downPayment;
	}

	public void setProfilPengguna(ProfilPengguna profilPengguna) {
		this.profilPengguna = profilPengguna;
	}

	public UUID getIdPemesanan() {
		return this.idPemesanan;
	}

	public void setIdPemesanan(UUID idPemesanan) {
		this.idPemesanan = idPemesanan;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Float getTotalPay() {
		return this.totalPay;
	}

	public void setTotalPay(Float totalPay) {
		this.totalPay = totalPay;
	}

	public String getStatusPemesanan() {
		return this.statusPemesanan;
	}

	public void setStatusPemesanan(String statusPemesanan) {
		this.statusPemesanan = statusPemesanan;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Kamar getKamar() {
		return this.kamar;
	}

	public void setKamar(Kamar kamar) {
		this.kamar = kamar;
	}

	public ProfilPengguna getProfilPengguna() {
		return this.profilPengguna;
	}
	
}
