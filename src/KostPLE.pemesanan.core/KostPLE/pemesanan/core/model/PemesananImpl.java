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

	public PemesananImpl(String idPemesanan, Date startDate, Date endDate, Float totalPay, String statusPemesanan, String detail, Date createdAt, KamarImpl kamarimpl, ProfilPenggunaImpl profilpenggunaimpl) {
		this.idPemesanan = idPemesanan;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPay = totalPay;
		this.statusPemesanan = statusPemesanan;
		this.detail = detail;
		this.createdAt = createdAt;
		this.kamarImpl = kamarimpl;
		this.profilpenggunaimpl = profilpenggunaimpl;
	}

	public PemesananImpl(Date startDate, Date endDate, Float totalPay, String statusPemesanan, String detail, Date createdAt, KamarImpl kamarimpl, ProfilPenggunaImpl profilpenggunaimpl) {
		this.idPemesanan =  UUID.randomUUID().toString();
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPay = totalPay;
		this.statusPemesanan = statusPemesanan;
		this.detail = detail;
		this.createdAt = createdAt;
		this.kamarImpl = kamarimpl;
		this.profilpenggunaimpl = profilpenggunaimpl;
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
		pemesananMap.put("kamarimpl",getKamarImpl());
		pemesananMap.put("profilpenggunaimpl",getProfilPenggunaImpl());

        return pemesananMap;
    }

	@Override
	public void setKamarImpl(KamarImpl kamarimpl) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setKamarImpl'");
	}

	@Override
	public void setProfilpenggunaimpl(ProfilPenggunaImpl profilpenggunaimpl) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setProfilpenggunaimpl'");
	}

	@Override
	public String getIdPemesanan() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getIdPemesanan'");
	}

	public void setIdPemesanan(String idPemesanan) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setIdPemesanan'");
	}

	@Override
	public Date getStartDate() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getStartDate'");
	}

	@Override
	public void setStartDate(Date startDate) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setStartDate'");
	}

	@Override
	public Date getEndDate() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getEndDate'");
	}

	@Override
	public void setEndDate(Date endDate) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setEndDate'");
	}

	@Override
	public Float getTotalPay() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getTotalPay'");
	}

	@Override
	public void setTotalPay(Float totalPay) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setTotalPay'");
	}

	@Override
	public String getStatusPemesanan() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getStatusPemesanan'");
	}

	@Override
	public void setStatusPemesanan(String statusPemesanan) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setStatusPemesanan'");
	}

	@Override
	public String getDetail() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getDetail'");
	}

	@Override
	public void setDetail(String detail) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setDetail'");
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
	public KamarImpl getKamarImpl() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getKamarImpl'");
	}

	@Override
	public void setKamarimpl(KamarImpl kamarimpl) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setKamarimpl'");
	}

	@Override
	public ProfilPenggunaImpl getProfilPenggunaImpl() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getProfilPenggunaImpl'");
	}


}
