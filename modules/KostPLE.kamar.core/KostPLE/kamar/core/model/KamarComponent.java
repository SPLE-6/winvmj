package KostPLE.kamar.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import KostPLE.properti.core.PropertiImpl;
import KostPLE.properti.core.Properti;

@Entity
@Table(name = "kamar_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KamarComponent implements Kamar {
	@Id
	protected UUID idKamar;
	protected boolean isAvailable;
	protected String tipeKamar;
	protected String deskripsiKamar;
	protected String fotoUrlKamar;
	protected Float hargaKamar;
	
	@ManyToOne(targetEntity = KostPLE.properti.core.PropertiComponent.class)
	public Properti properti;
	protected String objectName = KamarComponent.class.getName();

	public KamarComponent() {

	}

	public KamarComponent(
			UUID idKamar, boolean isAvailable, String tipeKamar, String deskripsiKamar, String fotoUrlKamar,
			Float hargaKamar, PropertiImpl propertiImpl) {
		this.idKamar = idKamar;
		this.isAvailable = isAvailable;
		this.tipeKamar = tipeKamar;
		this.deskripsiKamar = deskripsiKamar;
		this.fotoUrlKamar = fotoUrlKamar;
		this.hargaKamar = hargaKamar;
		this.properti = properti;
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

	@Override
	public String toString() {
		return "{" +
				" idKamar='" + getIdKamar() + "'" +
				" isAvailable='" + getIsAvailable() + "'" +
				" tipeKamar='" + getTipeKamar() + "'" +
				" deskripsiKamar='" + getDeskripsiKamar() + "'" +
				" Property6='" + getFotoUrlKamar() + "'" +
				" Property7='" + getHargaKamar() + "'" +
				" propertiimpl='" + getProperti() + "'" +
				"}";
	}

}
