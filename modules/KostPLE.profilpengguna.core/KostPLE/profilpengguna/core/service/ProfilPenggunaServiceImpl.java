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

//	public List<HashMap<String, Object>> saveProfilPengguna(VMJExchange vmjExchange) {
//		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
//			return null;
//		}
//		ProfilPengguna profilpengguna = createProfilPengguna(vmjExchange.getPayload());
//		Repository.saveObject(profilpengguna);
//		return getAllProfilPengguna(vmjExchange.getPayload());
//	}

	public List<HashMap<String, Object>> createProfilPengguna(Map<String, Object> requestBody) {
		String idProfilStr = (String) requestBody.get("idProfil");
		UUID idProfil = UUID.fromString(idProfilStr);
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

		// to do: fix association attributes
		ProfilPengguna profilPengguna = ProfilPenggunaFactory.createProfilPengguna(
				"KostPLE.profilpengguna.core.ProfilPenggunaImpl",
				idProfil, fullName, email, jenisKelamin, pekerjaan, kotaAsal, statusPernikahan, pendidikanTerakhir,
				kontakDarurat, fotoUrlProfil, noHP);
		Repository.saveObject(profilPengguna);
		return getAllProfilPengguna(requestBody);
	}

	public ProfilPengguna createProfilPengguna(VMJExchange vmjExchange) {
		String fullName = (String) vmjExchange.getRequestBodyForm("fullName");
		String email = (String) vmjExchange.getRequestBodyForm("email");
		boolean jenisKelamin = (boolean) vmjExchange.getRequestBodyForm("jenisKelamin");
		String pekerjaan = (String) vmjExchange.getRequestBodyForm("pekerjaan");
		String kotaAsal = (String) vmjExchange.getRequestBodyForm("kotaAsal");
		String statusPernikahan = (String) vmjExchange.getRequestBodyForm("statusPernikahan");
		String kontakDaruratStr = (String) vmjExchange.getRequestBodyForm("kontakDarurat");
		int kontakDarurat = Integer.parseInt(kontakDaruratStr);
		String fotoUrlProfil = (String) vmjExchange.getRequestBodyForm("fotoUrlProfil");
		String noHPStr = (String) vmjExchange.getRequestBodyForm("noHP");
		int noHP = Integer.parseInt(noHPStr);

		// to do: fix association attributes

		ProfilPengguna profilpengguna = ProfilPenggunaFactory.createProfilPengguna(
				"KostPLE.profilpengguna.core.ProfilPenggunaImpl", fullName, email, jenisKelamin, pekerjaan, kotaAsal,
				statusPernikahan, kontakDarurat, fotoUrlProfil, noHP);
		return profilpengguna;
	}

	public HashMap<String, Object> updateProfilPengguna(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("idProfil");
		UUID id = UUID.fromString(idStr);
		ProfilPengguna profilpengguna = Repository.getObject(id);

		profilpengguna.setFullName((String) requestBody.get("fullName"));
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

		// to do: fix association attributes

		return profilpengguna.toHashMap();

	}

	public HashMap<String, Object> getProfilPengguna(Map<String, Object> requestBody) {
		List<HashMap<String, Object>> profilpenggunaList = getAllProfilPengguna(requestBody);
		for (HashMap<String, Object> profilpengguna : profilpenggunaList) {
			String record_idStr = ((String) profilpengguna.get("record_id"));
			String idStr = (String) requestBody.get("idProfil");
			UUID record_id = UUID.fromString(record_idStr);
			UUID id = UUID.fromString(idStr);
			if (record_id.equals(id)) {
				return profilpengguna;
			}
		}
		return null;
	}

	public HashMap<String, Object> getProfilPenggunaById(UUID id) {
		ProfilPengguna profilpengguna = Repository.getObject(id);
		return profilpengguna.toHashMap();
	}

	public List<HashMap<String, Object>> getAllProfilPengguna(Map<String, Object> requestBody) {
		String table = (String) requestBody.get("table_name");
		List<ProfilPengguna> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

	@Override
	public List<HashMap<String, Object>> transformListToHashMap(List<ProfilPengguna> list) {
		List<HashMap<String, Object>> resultList = new ArrayList<>();
		for (ProfilPengguna profilpengguna : list) {
			resultList.add(profilpengguna.toHashMap());
		}
		return resultList;
	}

	public List<HashMap<String, Object>> deleteProfilPengguna(Map<String, Object> requestBody) {
		String idStr = ((String) requestBody.get("id"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllProfilPengguna(requestBody);
	}

}
