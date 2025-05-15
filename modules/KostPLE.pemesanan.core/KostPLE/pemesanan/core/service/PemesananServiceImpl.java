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
		UUID idKamar = UUID.fromString(idKamar);
		
		ProfilPengguna profilPengguna = profilPenggunaService.getProfilPenggunaById(idProfilPengguna);
		Kamar kamar = kamarService.getKamarById(idKamar);

		
		//to do: fix association attributes
		Pemesanan pemesanan = PemesananFactory.createPemesanan(
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
		PemesananRepository.saveObject(pemesanan);
		return pemesanan;
	}

    public Pemesanan updatePemesanan(Map<String, Object> requestBody){
		String id = (String) requestBody.get("idPemesanan");
		Pemesanan pemesanan = Repository.getObject(id);
		
		pemesanan.setStatusPemesanan((String) requestBody.get("statusPemesanan"));
		pemesanan.setDetail((String) requestBody.get("detail"));
		
		Repository.updateObject(pemesanan);
		
		//to do: fix association attributes
		
		return pemesanan;
		
	}

	public HashMap<String, Object> getPemesananById(UUID id){
		Pemesanan pemesanan = Repository.getObject(id);
		return pemesanan;
	}

	public List<Pemesanan> getAllPemesanan(){
		List<Pemesanan> pemesananList = Repository.getAllObject("pemesanan_impl");
		return pemesanan.toHashMap();
	}

    public List<HashMap<String,Object>> getAllPemesanan(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Pemesanan> list = PemesananRepository.getAllObject(table);
		return transformListToHashMap(list);
	}

	@Override
    public List<HashMap<String,Object>> transformListToHashMap(List<Pemesanan> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deletePemesanan(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		PemesananRepository.deleteObject(id);
		return getAllPemesanan(requestBody);
	}

	@Override
	public List<HashMap<String, Object>> savePemesanan(Map<String, Object> requestBody) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'savePemesanan'");
	}

	@Override
	public Pemesanan createPemesanan(Map<String, Object> requestBody,
			Map<String, Object> response) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createPemesanan'");
	}

	@Override
	public HashMap<String, Object> getPemesanan(Map<String, Object> requestBody) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPemesanan'");
	}

}
