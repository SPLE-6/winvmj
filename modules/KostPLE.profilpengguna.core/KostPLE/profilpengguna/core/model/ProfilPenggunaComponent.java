package KostPLE.profilpengguna.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="profilpengguna_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProfilPenggunaComponent implements ProfilPengguna{
	@Id
	public UUID idProfil; 
	public String fullName;
	public String email;
	public boolean jenisKelamin;
	public String pekerjaan;
	public String kotaAsal;
	public String statusPernikahan;
	public int kontakDarurat;
	public String fotoUrlProfil;
	public String pendidikanTerakhir;
	public int noHP;
	protected String objectName = ProfilPenggunaComponent.class.getName();

	public ProfilPenggunaComponent() {

	} 

	public ProfilPenggunaComponent(
        UUID idProfil, String fullName, String email, boolean jenisKelamin, String pekerjaan, String kotaAsal, String statusPernikahan, String pendidikanTerakhir, int kontakDarurat, String fotoUrlProfil, int noHP
    ) {
        this.idProfil = idProfil;
        this.fullName = fullName;
        this.email = email;
        this.jenisKelamin = jenisKelamin;
        this.pekerjaan = pekerjaan;
        this.kotaAsal = kotaAsal;
        this.statusPernikahan = statusPernikahan;
        this.pendidikanTerakhir = pendidikanTerakhir;
        this.kontakDarurat = kontakDarurat;
        this.fotoUrlProfil = fotoUrlProfil;
        this.noHP = noHP;
    }

	public abstract UUID getIdProfil();
	public abstract void setIdProfil(UUID idProfil);
	
	public abstract String getFullName();
	public abstract void setFullName(String fullName);
	
	public abstract String getEmail();
	public abstract void setEmail(String email);
	
	public abstract boolean getJenisKelamin();
	public abstract void setJenisKelamin(boolean jenisKelamin);
	
	public abstract String getPekerjaan();
	public abstract void setPekerjaan(String pekerjaan);
	
	public abstract String getKotaAsal();
	public abstract void setKotaAsal(String kotaAsal);
	
	public abstract String getStatusPernikahan();
	public abstract void setStatusPernikahan(String statusPernikahan);
	
	public abstract String getPendidikanTerakhir();
	public abstract void setPendidikanTerakhir(String pendidikanTerakhir);
	
	public abstract int getKontakDarurat();
	public abstract void setKontakDarurat(int kontakDarurat);
	
	public abstract String getFotoUrlProfil();
	public abstract void setFotoUrlProfil(String fotoUrlProfil);
	
	public abstract int getNoHP();
	public abstract void setNoHP(int noHP);
	
 

	@Override
    public String toString() {
        return "{" +
            " idProfil='" + getIdProfil().toString() + "'" +
            " fullName='" + getFullName() + "'" +
            " email='" + getEmail() + "'" +
            " jenisKelamin='" + getJenisKelamin() + "'" +
            " pekerjaan='" + getPekerjaan() + "'" +
            " kotaAsal='" + getKotaAsal() + "'" +
            " statusPernikahan='" + getStatusPernikahan() + "'" +
            " pendidikanTerakhir='" + getPendidikanTerakhir() + "'" +
            " kontakDarurat='" + getKontakDarurat() + "'" +
            " fotoUrlProfil='" + getFotoUrlProfil() + "'" +
            " noHP='" + getNoHP() + "'" +
            "}";
    }
	
}
