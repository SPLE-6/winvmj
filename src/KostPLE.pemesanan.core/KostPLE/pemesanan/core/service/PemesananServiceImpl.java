package KostPLE.pemesanan.core;
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
import KostPLE.kamar.core.*;
import KostPLE.pemesanan.PemesananFactory;
import KostPLE.profilpengguna.core.*;
import vmj.auth.annotations.Restricted;
//add other required packages

public class PemesananServiceImpl extends PemesananServiceComponent{
	
	private PemesananFactory pemesananFactory = new PemesananFactory();
	ProfilPenggunaService profilPenggunaService = new ProfilPenggunaServiceImpl();
	KamarService kamarService = new KamarServiceImpl();

    public Pemesanan savePemesanan(Map<String, Object> requestBody){
		UUID idPemesanan = UUID.randomUUID();
		String statusPemesanan = (String) requestBody.get("statusPemesanan");
		String detail = (String) requestBody.get("detail");
		Date startDate = (Date) requestBody.get("startDate");
		Date endDate = (Date) requestBody.get("endDate");
		Float totalPay = (Float) requestBody.get("totalPay");
		
		
		Date createdAt = new Date();
		
		String idProfilPenggunaStr = (String) requestBody.get("idPofilPengguna");
		UUID idProfilPengguna = UUID.fromString(idProfilPenggunaStr);
		
		String idKamarStr = (String) requestBody.get("idKamar");
		UUID idKamar = UUID.fromString(idKamarStr);
		
		ProfilPengguna profilPengguna = profilPenggunaService.getProfilPenggunaById(idProfilPengguna);
		Kamar kamar = kamarService.getKamarById(idKamar);

		
		//to do: fix association attributes
		Pemesanan pemesanan = pemesananFactory.createPemesanan(
			"KostPLE.pemesanan.core.PemesananImpl",
		idPemesanan
		, startDate
		, endDate
		, totalPay
		, statusPemesanan
		, detail
		, createdAt
		, kamar
		, profilPengguna
		);
		Repository.saveObject(pemesanan);
		return pemesanan;
	}

    public Pemesanan updatePemesanan(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPemesanan");
		UUID id = UUID.fromString(idStr);

		Pemesanan pemesanan = Repository.getObject(id);
		
		pemesanan.setStatusPemesanan((String) requestBody.get("statusPemesanan"));
		pemesanan.setDetail((String) requestBody.get("detail"));
		
		Repository.updateObject(pemesanan);
		
		//to do: fix association attributes
		
		return pemesanan;
		
	}

	public Pemesanan getPemesananById(UUID id){
		Pemesanan pemesanan = Repository.getObject(id);
		return pemesanan;
	}

	public List<Pemesanan> getAllPemesanan(){
		List<Pemesanan> pemesananList = Repository.getAllObject("pemesanan_impl");
		return pemesananList;
	}

	@Override
    public List<HashMap<String,Object>> transformListToHashMap(List<Pemesanan> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<Pemesanan> deletePemesanan(UUID pemesananId){
		Repository.deleteObject(pemesananId);
		return getAllPemesanan();
	}

}
