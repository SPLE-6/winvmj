package KostPLE.profilpengguna.core;

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


@Entity(name="profilpengguna_impl")
@Table(name="profilpengguna_impl")
public class ProfilPenggunaImpl extends ProfilPenggunaComponent {

	public ProfilPenggunaImpl(UUID idProfil, String fullName, String email, boolean jenisKelamin, String pekerjaan, String kotaAsal, String statusPernikahan, String pendidikanTerakhir, int kontakDarurat, String fotoUrlProfil, int noHP) {
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

	public ProfilPenggunaImpl(String fullName, String email, boolean jenisKelamin, String pekerjaan, String kotaAsal, String statusPernikahan, int kontakDarurat, String fotoUrlProfil, int noHP) {
		this.idProfil =  UUID.randomUUID();
		this.fullName = fullName;
		this.email = email;
		this.jenisKelamin = jenisKelamin;
		this.pekerjaan = pekerjaan;
		this.kotaAsal = kotaAsal;
		this.statusPernikahan = statusPernikahan;
		this.kontakDarurat = kontakDarurat;
		this.fotoUrlProfil = fotoUrlProfil;
		this.noHP = noHP;
	}

	public ProfilPenggunaImpl() {
		this.idProfil =  UUID.randomUUID();
		this.fullName = "";
		this.email = "";
		this.jenisKelamin = false;
		this.pekerjaan = "";
		this.kotaAsal = "";
		this.statusPernikahan = "";
		this.kontakDarurat = 123;
		this.fotoUrlProfil = "";
		this.noHP = 345;
	}


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> profilpenggunaMap = new HashMap<String,Object>();
		profilpenggunaMap.put("idProfil",getIdProfil());
		profilpenggunaMap.put("fullName",getFullName());
		profilpenggunaMap.put("email",getEmail());
		profilpenggunaMap.put("jenisKelamin",getJenisKelamin());
		profilpenggunaMap.put("pekerjaan",getPekerjaan());
		profilpenggunaMap.put("kotaAsal",getKotaAsal());
		profilpenggunaMap.put("statusPernikahan",getStatusPernikahan());
		profilpenggunaMap.put("pendidikanTerakhir",getPendidikanTerakhir());
		profilpenggunaMap.put("kontakDarurat",getKontakDarurat());
		profilpenggunaMap.put("fotoUrlProfil",getFotoUrlProfil());
		profilpenggunaMap.put("noHP",getNoHP());

        return profilpenggunaMap;
    }

	public UUID getIdProfil() {
		return this.idProfil;
	}
	
	public  void setIdProfil(UUID idProfil) {
		this.idProfil = idProfil;
	}
	
	public  String getFullName() {
		return this.fullName;
	}
	public  void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public  String getEmail() {
		return this.email;
	}
	public  void setEmail(String email) {
		this.email = email;
	}
	
	public  boolean getJenisKelamin() {
		return this.jenisKelamin;
	}
	
	public void setJenisKelamin(boolean jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	
	public  String getPekerjaan() {
		return this.pekerjaan;
	}
	
	public  void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}
	
	public  String getKotaAsal() {
		return this.kotaAsal;
	}
	
	public  void setKotaAsal(String kotaAsal) {
		this.kotaAsal = kotaAsal;
	}
	
	public  String getStatusPernikahan() {
		return this.statusPernikahan;
	}
	
	public  void setStatusPernikahan(String statusPernikahan) {
		this.statusPernikahan = statusPernikahan;
	}
	
	public  String getPendidikanTerakhir() {
		return this.pendidikanTerakhir;
	}
	public  void setPendidikanTerakhir(String pendidikanTerakhir) {
		this.pendidikanTerakhir = pendidikanTerakhir;
	}
	
	public  int getKontakDarurat() {
		return this.kontakDarurat;
	}
	
	public  void setKontakDarurat(int kontakDarurat) {
		this.kontakDarurat = kontakDarurat;
	}
	
	public  String getFotoUrlProfil() {
		return this.fotoUrlProfil;
	}
	
	public  void setFotoUrlProfil(String fotoUrlProfil) {
		this.fotoUrlProfil = fotoUrlProfil;
	}
	
	public int getNoHP() {
		return this.noHP;
	}
	
	public void setNoHP(int noHP) {
		this.noHP = noHP;
	}

}
