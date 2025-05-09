package KostPLE.kamar.core;

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

import KostPLE.properti.core.Properti;

@Entity(name = "kamar_impl")
@Table(name = "kamar_impl")
public class KamarImpl extends KamarComponent {

	public KamarImpl(UUID idKamar, boolean isAvailable, String tipeKamar, String deskripsiKamar, String fotoUrlKamar,
			Float hargaKamar, Properti properti) {
		this.idKamar = idKamar;
		this.isAvailable = isAvailable;
		this.tipeKamar = tipeKamar;
		this.deskripsiKamar = deskripsiKamar;
		this.fotoUrlKamar = fotoUrlKamar;
		this.hargaKamar = hargaKamar;
		this.properti = properti;
	}

	public KamarImpl(boolean isAvailable, String tipeKamar, String deskripsiKamar, String fotoUrlKamar, Float hargaKamar,
			Properti properti) {
		this.idKamar = UUID.randomUUID();
		this.isAvailable = isAvailable;
		this.tipeKamar = tipeKamar;
		this.deskripsiKamar = deskripsiKamar;
		this.fotoUrlKamar = fotoUrlKamar;
		this.hargaKamar = hargaKamar;
		this.properti = properti;
	}

	public KamarImpl() {
	}

	public UUID getIdKamar() {
		return this.idKamar;
	}

	public void setIdKamar(UUID idKamar) {
		this.idKamar = idKamar;
	}

	public boolean getIsAvailable() {
		return this.isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getTipeKamar() {
		return this.tipeKamar;
	}

	public void setTipeKamar(String tipeKamar) {
		this.tipeKamar = tipeKamar;
	}

	public String getDeskripsiKamar() {
		return this.deskripsiKamar;
	}

	public void setDeskripsiKamar(String deskripsiKamar) {
		this.deskripsiKamar = deskripsiKamar;
	}

	public String getFotoUrlKamar() {
		return this.fotoUrlKamar;
	}

	public void setFotoUrlKamar(String fotoUrlKamar) {
		this.fotoUrlKamar = fotoUrlKamar;
	}

	public Float getHargaKamar() {
		return this.hargaKamar;
	}

	public void setHargaKamar(Float hargaKamar) {
		this.hargaKamar = hargaKamar;
	}

	public Properti getProperti() {
		return this.properti;
	}

	public void setProperti(Properti properti) {
		this.properti = properti;
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> kamarMap = new HashMap<String, Object>();
		kamarMap.put("idKamar", getIdKamar());
		kamarMap.put("isAvailable", getIsAvailable());
		kamarMap.put("tipeKamar", getTipeKamar());
		kamarMap.put("deskripsiKamar", getDeskripsiKamar());
		kamarMap.put("Property6", getFotoUrlKamar());
		kamarMap.put("Property7", getHargaKamar());
		kamarMap.put("propertiimpl", getProperti());

		return kamarMap;
	}

}
