package KostPLE.profilpengguna.core;

import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.profilpengguna.ProfilPenggunaFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ProfilPenggunaServiceImpl extends ProfilPenggunaServiceComponent {
	private ProfilPenggunaFactory profilPenggunaFactory = new ProfilPenggunaFactory();
	
	public ProfilPengguna saveProfilPengguna (Map<String, Object> requestBody) {
		UUID idProfil = UUID.randomUUID();
		String fullName = (String) requestBody.get("fullName");
		String email = (String) requestBody.get("email");
		boolean jenisKelamin = (boolean) requestBody.get("jenisKelamin");
		String pekerjaan = (String) requestBody.get("pekerjaan");
		String kotaAsal = (String) requestBody.get("kotaAsal");
		String statusPernikahan = (String) requestBody.get("statusPernikahan");
		String pendidikanTerakhir = (String) requestBody.get("pendidikanTerakhir");
		String kontakDaruratStr = (String) requestBody.get("kontakDarurat");
		int kontakDarurat = Integer.parseInt(kontakDaruratStr);
		String fotoUrlProfil = (String) requestBody.get("fotoUrlProfil");
		String noHPStr = (String) requestBody.get("noHP");
		int noHP = Integer.parseInt(noHPStr);

		System.out.println("C: " + noHP);

		// to do: fix association attributes
		ProfilPengguna profilPengguna = profilPenggunaFactory.createProfilPengguna(
				"KostPLE.profilpengguna.core.ProfilPenggunaImpl",
				idProfil, fullName, email, jenisKelamin, pekerjaan, kotaAsal, statusPernikahan, pendidikanTerakhir,
				kontakDarurat, fotoUrlProfil, noHP);
		
		System.out.println("Class: " + profilPengguna);

		Repository.saveObject(profilPengguna);
		return Repository.getObject(idProfil);
	}

	public ProfilPengguna updateProfilPengguna(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("idProfil");
		UUID id = UUID.fromString(idStr);
		ProfilPengguna profilpengguna = Repository.getObject(id);

		profilpengguna.setFullName((String) requestBody.get("fullName"));
		profilpengguna.setPendidikanTerakhir((String) requestBody.get("pendidikanTerakhir"));
		profilpengguna.setEmail((String) requestBody.get("email"));
		profilpengguna.setJenisKelamin((Boolean) requestBody.get("jenisKelamin"));
		profilpengguna.setPekerjaan((String) requestBody.get("pekerjaan"));
		profilpengguna.setKotaAsal((String) requestBody.get("kotaAsal"));
		profilpengguna.setStatusPernikahan((String) requestBody.get("statusPernikahan"));
		String kontakDaruratStr = (String) requestBody.get("kontakDarurat");
		profilpengguna.setKontakDarurat(Integer.parseInt(kontakDaruratStr));
		profilpengguna.setFotoUrlProfil((String) requestBody.get("fotoUrlProfil"));
		String noHPStr = (String) requestBody.get("noHP");
		profilpengguna.setNoHP(Integer.parseInt(noHPStr));

		Repository.updateObject(profilpengguna);
		profilpengguna = Repository.getObject(id);

		// to do: fix association attributes

		return profilpengguna;

	}

	public ProfilPengguna getProfilPenggunaById(UUID id) {
		ProfilPengguna profilpengguna = Repository.getObject(id);
		return profilpengguna;
	}

	public List<ProfilPengguna> getAllProfilPengguna() {
		List<ProfilPengguna> profilPenggunaList = Repository.getAllObject("profilpengguna_impl");
		return profilPenggunaList;

	}

	@Override
	public List<HashMap<String, Object>> transformListToHashMap(List<ProfilPengguna> list) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String,Object>>();;
		for (ProfilPengguna profilpengguna : list) {
			resultList.add(profilpengguna.toHashMap());
		}
		return resultList;
	}

	public List<ProfilPengguna> deleteProfilPengguna(UUID id) {
		Repository.deleteObject(id);
		return getAllProfilPengguna();
	}

}