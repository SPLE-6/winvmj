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

public class ProfilPenggunaServiceImpl extends ProfilPenggunaServiceComponent{

    public List<HashMap<String,Object>> saveProfilPengguna(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ProfilPengguna profilpengguna = createProfilPengguna(vmjExchange);
		profilpenggunaRepository.saveObject(profilpengguna);
		return getAllProfilPengguna(vmjExchange);
	}

    public ProfilPengguna createProfilPengguna(Map<String, Object> requestBody){
		String idProfilStr = (String) requestBody.get("idProfil");
		int idProfil = Integer.parseInt(idProfilStr);
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
		
		//to do: fix association attributes
		ProfilPengguna ProfilPengguna = ProfilPenggunaFactory.createProfilPengguna(
			"KostPLE.profilpengguna.core.ProfilPenggunaImpl",
		idProfil
		, fullName
		, email
		, jenisKelamin
		, pekerjaan
		, kotaAsal
		, statusPernikahan
		, pendidikanTerakhir
		, kontakDarurat
		, fotoUrlProfil
		, noHP
		);
		Repository.saveObject(profilpengguna);
		return profilpengguna;
	}

    public ProfilPengguna createProfilPengguna(Map<String, Object> requestBody, int id){
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
		
		//to do: fix association attributes
		
		ProfilPengguna profilpengguna = ProfilPenggunaFactory.createProfilPengguna("KostPLE.profilpengguna.core.ProfilPenggunaImpl", fullName, email, jenisKelamin, pekerjaan, kotaAsal, statusPernikahan, kontakDarurat, fotoUrlProfil, noHP);
		return profilpengguna;
	}

    public HashMap<String, Object> updateProfilPengguna(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idProfil");
		int id = Integer.parseInt(idStr);
		ProfilPengguna profilpengguna = Repository.getObject(id);
		
		profilpengguna.setFullName((String) requestBody.get("fullName"));
		profilpengguna.setEmail((String) requestBody.get("email"));
		profilpengguna.setJenisKelamin((String) requestBody.get("jenisKelamin"));
		profilpengguna.setPekerjaan((String) requestBody.get("pekerjaan"));
		profilpengguna.setKotaAsal((String) requestBody.get("kotaAsal"));
		profilpengguna.setStatusPernikahan((String) requestBody.get("statusPernikahan"));
		String kontakDaruratStr = (String) requestBody.get("kontakDarurat");
		profilpengguna.setKontakDarurat(Integer.parseInt(kontakDaruratStr));
		profilpengguna.setFotoUrlProfil((String) requestBody.get("fotoUrlProfil"));
		String noHPStr = (String) requestBody.get("noHP");
		profilpengguna.setNoHP(Integer.parseInt(noHPStr));
		
		Repository.updateObject(profilpengguna);
		
		//to do: fix association attributes
		
		return profilpengguna.toHashMap();
		
	}

    public HashMap<String, Object> getProfilPengguna(Map<String, Object> requestBody){
		List<HashMap<String, Object>> profilpenggunaList = getAllProfilPengguna("profilpengguna_impl");
		for (HashMap<String, Object> profilpengguna : profilpenggunaList){
			int record_id = ((Double) profilpengguna.get("record_id")).intValue();
			if (record_id == id){
				return profilpengguna;
			}
		}
		return null;
	}

	public HashMap<String, Object> getProfilPenggunaById(int id){
		String idStr = vmjExchange.getGETParam("idProfil"); 
		int id = Integer.parseInt(idStr);
		ProfilPengguna profilpengguna = profilpenggunaRepository.getObject(id);
		return profilpengguna.toHashMap();
	}

    public List<HashMap<String,Object>> getAllProfilPengguna(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<ProfilPengguna> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ProfilPengguna> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteProfilPengguna(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllProfilPengguna(requestBody);
	}

}
