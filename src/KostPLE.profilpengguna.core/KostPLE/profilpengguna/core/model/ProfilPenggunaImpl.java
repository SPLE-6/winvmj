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

	public ProfilPenggunaImpl(String idProfil, String fullName, String email, boolean jenisKelamin, String pekerjaan, String kotaAsal, String statusPernikahan, String pendidikanTerakhir, int kontakDarurat, String fotoUrlProfil, int noHP) {
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
		this.idProfil =  UUID.randomUUID().toString();
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

	@Override
	public int getIdProfil() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getIdProfil'");
	}

	@Override
	public void setIdProfil(int idProfil) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setIdProfil'");
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getFullName'");
	}

	@Override
	public void setFullName(String fullName) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setFullName'");
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
	}

	@Override
	public boolean getJenisKelamin() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getJenisKelamin'");
	}

	@Override
	public void setJenisKelamin(boolean jenisKelamin) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setJenisKelamin'");
	}

	@Override
	public String getPekerjaan() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPekerjaan'");
	}

	@Override
	public void setPekerjaan(String pekerjaan) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setPekerjaan'");
	}

	@Override
	public String getKotaAsal() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getKotaAsal'");
	}

	@Override
	public void setKotaAsal(String kotaAsal) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setKotaAsal'");
	}

	@Override
	public String getStatusPernikahan() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getStatusPernikahan'");
	}

	@Override
	public void setStatusPernikahan(String statusPernikahan) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setStatusPernikahan'");
	}

	@Override
	public String getPendidikanTerakhir() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPendidikanTerakhir'");
	}

	@Override
	public void setPendidikanTerakhir(String pendidikanTerakhir) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setPendidikanTerakhir'");
	}

	@Override
	public int getKontakDarurat() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getKontakDarurat'");
	}

	@Override
	public void setKontakDarurat(int kontakDarurat) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setKontakDarurat'");
	}

	@Override
	public String getFotoUrlProfil() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getFotoUrlProfil'");
	}

	@Override
	public void setFotoUrlProfil(String fotoUrlProfil) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setFotoUrlProfil'");
	}

	@Override
	public int getNoHP() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getNoHP'");
	}

	@Override
	public void setNoHP(int noHP) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setNoHP'");
	}

}
