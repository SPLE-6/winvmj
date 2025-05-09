package KostPLE.properti.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import KostPLE.profilpengguna.core.ProfilPengguna;
import KostPLE.profilpengguna.core.ProfilPenggunaImpl;


@Entity(name="properti_impl")
@Table(name="properti_impl")
public class PropertiImpl extends PropertiComponent {

	public PropertiImpl(UUID idProperti, String namaProperti, String deskripsiProperti, String lokasiProperti, String fotoUrlProperti, ProfilPenggunaImpl profilpenggunaimpl) {
		this.idProperti = idProperti;
		this.namaProperti = namaProperti;
		this.deskripsiProperti = deskripsiProperti;
		this.lokasiProperti = lokasiProperti;
		this.fotoUrlProperti = fotoUrlProperti;
		this.profilpenggunaimpl = profilpenggunaimpl;
	}

	public PropertiImpl(String namaProperti, String deskripsiProperti, String lokasiProperti, String fotoUrlProperti, ProfilPenggunaImpl profilpenggunaimpl) {
		this.idProperti =  idProperti.randomUUID();;
		this.namaProperti = namaProperti;
		this.deskripsiProperti = deskripsiProperti;
		this.lokasiProperti = lokasiProperti;
		this.fotoUrlProperti = fotoUrlProperti;
		this.profilpenggunaimpl = profilpenggunaimpl;
	}

	public PropertiImpl() { }

	public UUID getIdProperti() {
		return this.idProperti;
	}

	public void setIdProperti(UUID idProperti) {
		this.idProperti = idProperti;
	}
	public String getNamaProperti() {
		return this.namaProperti;
	}

	public void setNamaProperti(String namaProperti) {
		this.namaProperti = namaProperti;
	}
	public String getDeskripsiProperti() {
		return this.deskripsiProperti;
	}

	public void setDeskripsiProperti(String deskripsiProperti) {
		this.deskripsiProperti = deskripsiProperti;
	}
	public String getLokasiProperti() {
		return this.lokasiProperti;
	}

	public void setLokasiProperti(String lokasiProperti) {
		this.lokasiProperti = lokasiProperti;
	}
	public String getFotoUrlProperti() {
		return this.fotoUrlProperti;
	}

	public void setFotoUrlProperti(String fotoUrlProperti) {
		this.fotoUrlProperti = fotoUrlProperti;
	}
	
	public ProfilPengguna getProfilpenggunaimpl() {
		return this.profilpenggunaimpl;
	}
	
	public void setProfilpenggunaimpl(ProfilPenggunaImpl profilpenggunaimpl) {
		this.profilpenggunaimpl = profilpenggunaimpl;
	}
	
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

}
