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
import KostPLE.kamar.core.KamarImpl;
import KostPLE.pemesanan.PemesananFactory;
import KostPLE.pemesanan.core.Pemesanan;
import KostPLE.pemesanan.core.repository.PemesananRepository;
import KostPLE.profilpengguna.core.ProfilPenggunaImpl;
import vmj.auth.annotations.Restricted;
//add other required packages

public class PemesananServiceImpl extends PemesananServiceComponent{

    public List<HashMap<String,Object>> savePemesanan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Pemesanan pemesanan = createPemesanan(vmjExchange);
		PemesananRepository.saveObject(pemesanan);
		return getAllPemesanan(vmjExchange.getPayload());
	}

    public Pemesanan createPemesanan(Map<String, Object> requestBody){
		String idPemesananStr = (String) requestBody.get("idPemesanan");
		int idPemesanan = Integer.parseInt(idPemesananStr);
		String statusPemesanan = (String) requestBody.get("statusPemesanan");
		String detail = (String) requestBody.get("detail");
		Date startDate = (Date) requestBody.get("startDate");
		Date endDate = (Date) requestBody.get("endDate");
		Float totalPay = (Float) requestBody.get("totalPay");
		Date createdAt = (Date) requestBody.get("createdAt");
		KamarImpl kamarimpl = (KamarImpl) requestBody.get("kamarimpl");
		ProfilPenggunaImpl profilpenggunaimpl = (ProfilPenggunaImpl) requestBody.get("profilpenggunaimpl");
		
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
		, kamarimpl
		, profilpenggunaimpl
		);
		PemesananRepository.saveObject(pemesanan);
		return pemesanan;
	}

    public Pemesanan createPemesanan(VMJExchange vmjExchange){
		String statusPemesanan = (String) vmjExchange.getRequestBodyForm("statusPemesanan");
		String detail = (String) vmjExchange.getRequestBodyForm("detail");
		Date startDate = (Date) vmjExchange.getRequestBodyForm("startDate");
		Date endDate = (Date) vmjExchange.getRequestBodyForm("endDate");
		Float totalPay = (Float) vmjExchange.getRequestBodyForm("totalPay");
		Date createdAt = (Date) vmjExchange.getRequestBodyForm("createdAt");
		KamarImpl kamarimpl = (KamarImpl) vmjExchange.getRequestBodyForm("kamarimpl");
		ProfilPenggunaImpl profilpenggunaimpl = (ProfilPenggunaImpl) vmjExchange.getRequestBodyForm("profilpenggunaimpl");
		
		//to do: fix association attributes
		
		Pemesanan pemesanan = PemesananFactory.createPemesanan("KostPLE.pemesanan.core.PemesananImpl", startDate, endDate, totalPay, statusPemesanan, detail, createdAt, kamarimpl, profilpenggunaimpl);
		return pemesanan;
	}

    public HashMap<String, Object> updatePemesanan(Map<String, Object> requestBody){
		String id = (String) requestBody.get("idPemesanan");
		Pemesanan pemesanan = PemesananRepository.getObject(id);
		
		pemesanan.setStatusPemesanan((String) requestBody.get("statusPemesanan"));
		pemesanan.setDetail((String) requestBody.get("detail"));
		
		PemesananRepository.updateObject(pemesanan);
		
		//to do: fix association attributes
		
		return pemesanan.toHashMap();
		
	}

	public HashMap<String, Object> getPemesanan(Map<String, Object> requestBody, String id){
		List<HashMap<String, Object>> pemesananList = getAllPemesanan(requestBody);
		
		for (HashMap<String, Object> pemesanan : pemesananList){
			String record_id = (String) ( pemesanan.get("record_id"));
			if (record_id.equals(id)){
				return pemesanan;
			}
		}
		return null;
	}

	public HashMap<String, Object> getPemesananById(String id){
		Pemesanan pemesanan = PemesananRepository.getObject(id);
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
