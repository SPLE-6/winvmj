package KostPLE.properti.core;

import java.util.*;
import KostPLE.profilpengguna.core.ProfilPengguna;
import KostPLE.profilpengguna.core.ProfilPenggunaImpl;
import KostPLE.profilpengguna.core.ProfilPenggunaComponent;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;


@Entity
@Table(name="properti_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PropertiComponent implements Properti{
	@Id
	protected UUID idProperti; 
	protected String namaProperti;
	protected String deskripsiProperti;
	protected String lokasiProperti;
	protected String fotoUrlProperti;
	
	@ManyToOne(targetEntity=KostPLE.profilpengguna.core.ProfilPenggunaComponent.class)
	public ProfilPengguna profilpenggunaimpl;
	protected String objectName = PropertiComponent.class.getName();

	public PropertiComponent() {

	} 

	public PropertiComponent(
        UUID idProperti, String namaProperti, String deskripsiProperti, String lokasiProperti, String fotoUrlProperti, ProfilPenggunaImpl profilpenggunaimpl
    ) {
        this.idProperti = idProperti;
        this.namaProperti = namaProperti;
        this.deskripsiProperti = deskripsiProperti;
        this.lokasiProperti = lokasiProperti;
        this.fotoUrlProperti = fotoUrlProperti;
        this.profilpenggunaimpl = profilpenggunaimpl;
    }

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
	
	public abstract ProfilPenggunaImpl getProfilpenggunaimpl();
	public abstract void setProfilpenggunaimpl(ProfilPenggunaImpl profilpenggunaimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " idProperti='" + getIdProperti() + "'" +
            " namaProperti='" + getNamaProperti() + "'" +
            " deskripsiProperti='" + getDeskripsiProperti() + "'" +
            " lokasiProperti='" + getLokasiProperti() + "'" +
            " fotoUrlProperti='" + getFotoUrlProperti() + "'" +
            " profilpenggunaimpl='" + getProfilpenggunaimpl() + "'" +
            "}";
    }
	
}
