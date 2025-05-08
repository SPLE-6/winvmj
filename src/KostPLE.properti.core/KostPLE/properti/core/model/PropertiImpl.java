package KostPLE.properti.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;

import KostPLE.profilpengguna.core.ProfilPengguna;
import KostPLE.profilpengguna.core.ProfilPenggunaImpl;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="properti_impl")
@Table(name="properti_impl")
public class PropertiImpl extends PropertiComponent {

	public PropertiImpl(String idProperti, String namaProperti, String deskripsiProperti, String lokasiProperti, String fotoUrlProperti, ProfilPenggunaImpl profilpenggunaimpl) {
		this.idProperti = idProperti;
		this.namaProperti = namaProperti;
		this.deskripsiProperti = deskripsiProperti;
		this.lokasiProperti = lokasiProperti;
		this.fotoUrlProperti = fotoUrlProperti;
		this.profilpenggunaimpl = profilpenggunaimpl;
	}

	public PropertiImpl(String namaProperti, String deskripsiProperti, String lokasiProperti, String fotoUrlProperti, ProfilPenggunaImpl profilpenggunaimpl) {
		this.idProperti =  UUID.randomUUID().toString();
		this.namaProperti = namaProperti;
		this.deskripsiProperti = deskripsiProperti;
		this.lokasiProperti = lokasiProperti;
		this.fotoUrlProperti = fotoUrlProperti;
		this.profilpenggunaimpl = profilpenggunaimpl;
	}

	public PropertiImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> propertiMap = new HashMap<String,Object>();
		propertiMap.put("idProperti",getIdProperti());
		propertiMap.put("namaProperti",getNamaProperti());
		propertiMap.put("deskripsiProperti",getDeskripsiProperti());
		propertiMap.put("lokasiProperti",getLokasiProperti());
		propertiMap.put("fotoUrlProperti",getFotoUrlProperti());
		propertiMap.put("profilpenggunaimpl",getProfilPenggunaImpl());

        return propertiMap;
    }

	@Override
	public String getIdProperti() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getIdProperti'");
	}

	@Override
	public void setIdProperti(int idProperti) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setIdProperti'");
	}

	@Override
	public String getNamaProperti() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getNamaProperti'");
	}

	@Override
	public void setNamaProperti(String namaProperti) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setNamaProperti'");
	}

	@Override
	public String getDeskripsiProperti() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getDeskripsiProperti'");
	}

	@Override
	public void setDeskripsiProperti(String deskripsiProperti) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setDeskripsiProperti'");
	}

	@Override
	public String getLokasiProperti() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getLokasiProperti'");
	}

	@Override
	public void setLokasiProperti(String lokasiProperti) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setLokasiProperti'");
	}

	@Override
	public String getFotoUrlProperti() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getFotoUrlProperti'");
	}

	@Override
	public void setFotoUrlProperti(String fotoUrlProperti) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setFotoUrlProperti'");
	}

	public void setProfilpenggunaimpl(ProfilPenggunaImpl profilpenggunaimpl) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setProfilpenggunaimpl'");
	}

	public ProfilPenggunaImpl getProfilPenggunaImpl() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getProfilpenggunaimpl'");
	}

	public void setProfilPenggunaImpl(ProfilPengguna profilpenggunaimpl) {
		
	}

	@Override
	public ProfilPenggunaImpl getProfilpenggunaimpl() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getProfilpenggunaimpl'");
	}

	@Override
	public void setProfilPenggunaImpl(ProfilPenggunaImpl profilpenggunaimpl) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setProfilPenggunaImpl'");
	}

}
