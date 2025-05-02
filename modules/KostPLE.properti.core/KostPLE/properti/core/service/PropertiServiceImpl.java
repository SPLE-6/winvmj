package KostPLE.properti.core;
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
import KostPLE.properti.PropertiFactory;
import KostPLE.properti.core.repository.PropertiRepository;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PropertiServiceImpl extends PropertiServiceComponent{

    public List<HashMap<String,Object>> saveProperti(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Properti properti = createProperti(vmjExchange);
		PropertiRepository.saveObject(properti);
		return getAllProperti(vmjExchange);
	}

    public Properti createProperti(Map<String, Object> requestBody){
		String idPropertiStr = (String) requestBody.get("idProperti");
		int idProperti = Integer.parseInt(idPropertiStr);
		String namaProperti = (String) requestBody.get("namaProperti");
		String deskripsiProperti = (String) requestBody.get("deskripsiProperti");
		String lokasiProperti = (String) requestBody.get("lokasiProperti");
		String fotoUrlProperti = (String) requestBody.get("fotoUrlProperti");
		
		//to do: fix association attributes
		Properti Properti = PropertiFactory.createProperti(
			"KostPLE.properti.core.PropertiImpl",
		idProperti
		, namaProperti
		, deskripsiProperti
		, lokasiProperti
		, fotoUrlProperti
		, profilpenggunaimpl
		);
		Repository.saveObject(properti);
		return properti;
	}

    public Properti createProperti(Map<String, Object> requestBody, int id){
		String namaProperti = (String) vmjExchange.getRequestBodyForm("namaProperti");
		String deskripsiProperti = (String) vmjExchange.getRequestBodyForm("deskripsiProperti");
		String lokasiProperti = (String) vmjExchange.getRequestBodyForm("lokasiProperti");
		String fotoUrlProperti = (String) vmjExchange.getRequestBodyForm("fotoUrlProperti");
		
		//to do: fix association attributes
		
		Properti properti = PropertiFactory.createProperti("KostPLE.properti.core.PropertiImpl", namaProperti, deskripsiProperti, lokasiProperti, fotoUrlProperti, profilpenggunaimpl);
		return properti;
	}

    public HashMap<String, Object> updateProperti(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idProperti");
		int id = Integer.parseInt(idStr);
		Properti properti = PropertiRepository.getObject(id);
		
		properti.setNamaProperti((String) requestBody.get("namaProperti"));
		properti.setDeskripsiProperti((String) requestBody.get("deskripsiProperti"));
		properti.setLokasiProperti((String) requestBody.get("lokasiProperti"));
		properti.setFotoUrlProperti((String) requestBody.get("fotoUrlProperti"));
		
		PropertiRepository.updateObject(properti);
		
		//to do: fix association attributes
		
		return properti.toHashMap();
		
	}

	public HashMap<String, Object> getProperti(Map<String, Object> requestBody){
		int id = Integer.parseInt((String) requestBody.get("idProperti"));
		List<HashMap<String, Object>> propertiList = getAllProperti(requestBody);
		for (HashMap<String, Object> properti : propertiList){
			int recordId = ((Double) properti.get("record_id")).intValue();
			if (recordId == id){
				return properti;
			}
		}
		return new HashMap<>();
	}

	public HashMap<String, Object> getPropertiById(int id){
		Properti properti = PropertiRepository.getObject(id);
		return properti.toHashMap();
	}

    public List<HashMap<String,Object>> getAllProperti(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Properti> List = PropertiRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Properti> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteProperti(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		PropertiRepository.deleteObject(id);
		return getAllProperti(requestBody);
	}

}
