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

	public ProfilPenggunaImpl(int idProfil, String fullName, String email, boolean jenisKelamin, String pekerjaan, String kotaAsal, String statusPernikahan, String pendidikanTerakhir, int kontakDarurat, String fotoUrlProfil, int noHP) {
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
		this.idProfil =  idProfil.randomUUID();;
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

	public ProfilPenggunaImpl() { }


	
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

}
