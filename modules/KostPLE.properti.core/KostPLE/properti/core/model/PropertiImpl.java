package KostPLE.properti.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;

import KostPLE.profilpengguna.core.ProfilPengguna;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="properti_impl")
@Table(name="properti_impl")
public class PropertiImpl extends PropertiComponent {

	public PropertiImpl(UUID idProperti, String namaProperti, String deskripsiProperti, String lokasiProperti, String fotoUrlProperti, ProfilPengguna profilpengguna) {
		this.idProperti = idProperti;
		this.namaProperti = namaProperti;
		this.deskripsiProperti = deskripsiProperti;
		this.lokasiProperti = lokasiProperti;
		this.fotoUrlProperti = fotoUrlProperti;
		this.profilPengguna = profilpengguna;
	}

	public PropertiImpl(String namaProperti, String deskripsiProperti, String lokasiProperti, String fotoUrlProperti, ProfilPengguna profilpengguna) {
		this.idProperti =  UUID.randomUUID();
		this.namaProperti = namaProperti;
		this.deskripsiProperti = deskripsiProperti;
		this.lokasiProperti = lokasiProperti;
		this.fotoUrlProperti = fotoUrlProperti;
		this.profilPengguna = profilpengguna;
	}

	public PropertiImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> propertiMap = new HashMap<String,Object>();
		propertiMap.put("idProperti",getIdProperti());
		propertiMap.put("namaProperti",getNamaProperti());
		propertiMap.put("deskripsiProperti",getDeskripsiProperti());
		propertiMap.put("lokasiProperti",getLokasiProperti());
		propertiMap.put("fotoUrlProperti",getFotoUrlProperti());
		propertiMap.put("profilpenggunaimpl", getProfilPengguna());

        return propertiMap;
    }

	@Override
	public UUID getIdProperti() {
		return this.idProperti;
	}

	@Override
	public void setIdProperti(UUID idProperti) {
		this.idProperti = idProperti;
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
	public void setProfilPengguna(ProfilPengguna profilPengguna) {
		this.profilPengguna = profilPengguna;
	}

	@Override
	public ProfilPengguna getProfilPengguna() {
		return this.profilPengguna;
	}

}
