package KostPLE.pemesanan.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;

import KostPLE.kamar.core.KamarImpl;
import KostPLE.profilpengguna.core.ProfilPenggunaImpl;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="pemesanan_impl")
@Table(name="pemesanan_impl")
public class PemesananImpl extends PemesananComponent {

	public PemesananImpl(UUID idPemesanan, Date startDate, Date endDate, Float totalPay, String statusPemesanan, String detail, Date createdAt, Kamar kamar, ProfilPengguna profilPengguna) {
		this.idPemesanan = idPemesanan;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPay = totalPay;
		this.statusPemesanan = statusPemesanan;
		this.detail = detail;
		this.createdAt = createdAt;
		this.kamar = kamar;
		this.profilPengguna = profilPengguna;
	}

	public PemesananImpl(Date startDate, Date endDate, Float totalPay, String statusPemesanan, String detail, Date createdAt, Kamar kamar, ProfilPengguna profilPengguna) {
		this.idPemesanan =  UUID.randomUUID();
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPay = totalPay;
		this.statusPemesanan = statusPemesanan;
		this.detail = detail;
		this.createdAt = createdAt;
		this.kamar = kamar;
		this.profilPengguna = profilPengguna;
	}

	public PemesananImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> pemesananMap = new HashMap<String,Object>();
		pemesananMap.put("idPemesanan",getIdPemesanan());
		pemesananMap.put("startDate",getStartDate());
		pemesananMap.put("endDate",getEndDate());
		pemesananMap.put("totalPay",getTotalPay());
		pemesananMap.put("statusPemesanan",getStatusPemesanan());
		pemesananMap.put("detail",getDetail());
		pemesananMap.put("createdAt",getCreatedAt());
		pemesananMap.put("kamar",getKamar());
		pemesananMap.put("profilPengguna",getProfilPengguna());

        return pemesananMap;
    }

	@Override
	public void setKamar(Kamar kamar) {
		this.kamar = kamar;
	}

	@Override
	public void setProfilPengguna(ProfilPengguna profilPengguna) {
		this.profilPengguna = profilPengguna;
	}

	@Override
	public String getIdPemesanan() {
		return this.idPemesanan;
	}

	public void setIdPemesanan(String idPemesanan) {
		this.idPemesanan = idPemesanan;
	}

	@Override
	public Date getStartDate() {
		return this.startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public Date getEndDate() {
		return endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public Float getTotalPay() {
		return this.totalPay;
	}

	@Override
	public void setTotalPay(Float totalPay) {
		this.totalPay = totalPay;
	}

	@Override
	public String getStatusPemesanan() {
		return this.statusPemesanan;
	}

	@Override
	public void setStatusPemesanan(String statusPemesanan) {
		this.statusPemesanan = statusPemesanan;
	}

	@Override
	public String getDetail() {
		return this.detail;
	}

	@Override
	public void setDetail(String detail) {
		return this.detail = detail;
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
	public KamarImpl getKamar() {
		return this.kamar;
	}

	@Override
	public void setKamar(Kamar kamar) {
		this.kamar = kamar;
	}

	@Override
	public ProfilPenggunaImpl getProfilPengguna() {
		return this.profilPengguna;
	}


}
