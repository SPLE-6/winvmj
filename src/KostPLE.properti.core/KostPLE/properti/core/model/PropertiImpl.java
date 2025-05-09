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
		propertiMap.put("profilpenggunaimpl",getProfilpenggunaimpl());

        return propertiMap;
    }

	@Override
	public String getIdProperti() {
		return this.idProperti;
	}

	@Override
	public void setIdProperti(int idProperti) {
		this.idProperti = String.valueOf(idProperti);
	}

	@Override
	public String getNamaProperti() {
		return this.namaProperti;
	}

	@Override
	public void setNamaProperti(String namaProperti) {
		this.namaProperti = namaProperti;
	}

	@Override
	public String getDeskripsiProperti() {
		return this.deskripsiProperti;
	}

	@Override
	public void setDeskripsiProperti(String deskripsiProperti) {
		this.deskripsiProperti = deskripsiProperti;
	}

	@Override
	public String getLokasiProperti() {
		return this.lokasiProperti;
	}

	@Override
	public void setLokasiProperti(String lokasiProperti) {
		this.lokasiProperti = lokasiProperti;
	}

	@Override
	public String getFotoUrlProperti() {
		return this.fotoUrlProperti;
	}

	@Override
	public void setFotoUrlProperti(String fotoUrlProperti) {
		this.fotoUrlProperti = fotoUrlProperti;
	}

	@Override
	public ProfilPenggunaImpl getProfilpenggunaimpl() {
		if (this.profilpenggunaimpl instanceof ProfilPenggunaImpl) {
			return (ProfilPenggunaImpl) this.profilpenggunaimpl;
		}
		return null;
	}

	public ProfilPenggunaImpl getProfilPenggunaImpl() {
		if (this.profilpenggunaimpl instanceof ProfilPenggunaImpl) {
			return (ProfilPenggunaImpl) this.profilpenggunaimpl;
		}
		return null;
	}

	@Override
	public void setProfilPenggunaImpl(ProfilPenggunaImpl profilpenggunaimpl) {
		this.profilpenggunaimpl = profilpenggunaimpl;
	}

	public void setProfilPenggunaImpl(ProfilPengguna profilpenggunaimpl) {
		this.profilpenggunaimpl = profilpenggunaimpl;
	}

    @Override
    public void setProfilpenggunaimpl(ProfilPenggunaImpl profilpenggunaimpl) {
        this.profilpenggunaimpl = profilpenggunaimpl;
    }

}
