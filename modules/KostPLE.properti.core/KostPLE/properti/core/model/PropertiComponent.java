package KostPLE.properti.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="properti_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PropertiComponent implements Properti{
	@Id
	public int idProperti; 
	public String namaProperti;
	public String deskripsiProperti;
	public String lokasiProperti;
	public String fotoUrlProperti;
	@ManyToOne(targetEntity=KostPLE.profilpengguna.core.ProfilPenggunaComponent.class)
	public ProfilPengguna profilpenggunaimpl;
	protected String objectName = PropertiComponent.class.getName();

	public PropertiComponent() {

	} 

	public PropertiComponent(
        int idProperti, String namaProperti, String deskripsiProperti, String lokasiProperti, String fotoUrlProperti, ProfilPenggunaImpl profilpenggunaimpl
    ) {
        this.idProperti = idProperti;
        this.namaProperti = namaProperti;
        this.deskripsiProperti = deskripsiProperti;
        this.lokasiProperti = lokasiProperti;
        this.fotoUrlProperti = fotoUrlProperti;
        this.profilpenggunaimpl = profilpenggunaimpl;
    }

	public abstract int getIdProperti();
	public abstract void setIdProperti(int idProperti);
	
	public abstract String getNamaProperti();
	public abstract void setNamaProperti(String namaProperti);
	
	public abstract String getDeskripsiProperti();
	public abstract void setDeskripsiProperti(String deskripsiProperti);
	
	public abstract String getLokasiProperti();
	public abstract void setLokasiProperti(String lokasiProperti);
	
	public abstract String getFotoUrlProperti();
	public abstract void setFotoUrlProperti(String fotoUrlProperti);
	
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
