package KostPLE.kamar.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;

import KostPLE.properti.core.Properti;
import KostPLE.properti.core.PropertiImpl;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "kamar_impl")
@Table(name = "kamar_impl")
public class KamarImpl extends KamarComponent {

	public KamarImpl(String idKamar, boolean isAvailable, String tipeKamar, String deskripsiKamar, String Property6, Float Property7, PropertiImpl propertiimpl) {
		this.idKamar = idKamar;
		this.isAvailable = isAvailable;
		this.tipeKamar = tipeKamar;
		this.deskripsiKamar = deskripsiKamar;
		this.Property6 = Property6;
		this.Property7 = Property7;
		this.propertiImpl = propertiimpl;
	}

	public KamarImpl(boolean isAvailable, String tipeKamar, String deskripsiKamar, String Property6, Float Property7, PropertiImpl propertiimpl) {
		this.idKamar = UUID.randomUUID().toString();
		this.isAvailable = isAvailable;
		this.tipeKamar = tipeKamar;
		this.deskripsiKamar = deskripsiKamar;
		this.Property6 = Property6;
		this.Property7 = Property7;
		this.propertiImpl = propertiimpl;
	}

	public KamarImpl() {
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> kamarMap = new HashMap<String, Object>();
		kamarMap.put("idKamar", getIdKamar());
		kamarMap.put("isAvailable", getIsAvailable());
		kamarMap.put("tipeKamar", getTipeKamar());
		kamarMap.put("deskripsiKamar", getDeskripsiKamar());
		kamarMap.put("Property6", getProperty6());
		kamarMap.put("Property7", getProperty7());
		kamarMap.put("propertiimpl", getPropertiImpl());

		return kamarMap;
	}

	@Override
	public void setProperty7(Float Property7) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setProperty7'");
	}

	@Override
	public void setPropertiimpl(PropertiImpl propertiimpl) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setPropertiimpl'");
	}

	@Override
	public String getIdKamar() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getIdKamar'");
	}

	@Override
	public void setIdKamar(int idKamar) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setIdKamar'");
	}

	@Override
	public boolean getIsAvailable() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getIsAvailable'");
	}

	@Override
	public void setIsAvailable(boolean isAvailable) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setIsAvailable'");
	}

	@Override
	public String getTipeKamar() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getTipeKamar'");
	}

	@Override
	public void setTipeKamar(String tipeKamar) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setTipeKamar'");
	}

	@Override
	public String getDeskripsiKamar() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getDeskripsiKamar'");
	}

	@Override
	public void setDeskripsiKamar(String deskripsiKamar) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setDeskripsiKamar'");
	}

	@Override
	public String getProperty6() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getProperty6'");
	}

	@Override
	public void setProperty6(String Property6) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setProperty6'");
	}

	@Override
	public Float getProperty7() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getProperty7'");
	}

	@Override
	public Properti getPropertiImpl() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPropertiimpl'");
	}

	@Override
	public void setPropertiImpl(PropertiImpl propertiimpl) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setPropertiimpl'");
	}

}
