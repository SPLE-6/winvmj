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

@Entity(name="pemesanan_sewaviaapp")
@Table(name="pemesanan_sewaviaapp")
public class PemesananImpl extends PemesananDecorator {

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
		// TODO: implement this method
	}

	public void addNewPesanan() {
		// TODO: implement this method
	}

	@Override
	public void setIdPemesanan(int idPemesanan) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setIdPemesanan'");
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

	@Override
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
