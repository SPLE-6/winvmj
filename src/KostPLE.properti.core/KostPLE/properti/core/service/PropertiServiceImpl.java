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
import KostPLE.properti.core.Properti;
import KostPLE.properti.core.repository.PropertiRepository;
import vmj.auth.annotations.Restricted;
//add other required packages

public class PropertiServiceImpl extends PropertiServiceComponent{

	PropertiRepository PropertiRepository = new PropertiRepository();

    public Properti saveProperti(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Properti properti = createProperti(vmjExchange.getPayload(), (String) vmjExchange.getRequestBodyForm("id"), vmjExchange);
		PropertiRepository.saveObject(properti.toHashMap());
		return properti;
	
	}

    public Properti createProperti(Map<String, Object> requestBody){
		String idPropertiStr = (String) requestBody.get("idProperti");
		int idProperti = Integer.parseInt(idPropertiStr);
		String namaProperti = (String) requestBody.get("namaProperti");
		String deskripsiProperti = (String) requestBody.get("deskripsiProperti");
		String lokasiProperti = (String) requestBody.get("lokasiProperti");
		String fotoUrlProperti = (String) requestBody.get("fotoUrlProperti");
		String profilPenggunaImpl = (String) requestBody.get("idProfilPengguna");

		
		//to do: fix association attributes
		Properti properti = PropertiFactory.createProperti(
			"KostPLE.properti.core.PropertiImpl",
		idProperti
		, namaProperti
		, deskripsiProperti
		, lokasiProperti
		, fotoUrlProperti
		, profilPenggunaImpl
		);
		PropertiRepository.saveObject(properti.toHashMap());
		return properti;
	}

    public Properti createProperti(Map<String, Object> requestBody, String id, VMJExchange vmjExchange){
		String namaProperti = (String) vmjExchange.getRequestBodyForm("namaProperti");
		String deskripsiProperti = (String) vmjExchange.getRequestBodyForm("deskripsiProperti");
		String lokasiProperti = (String) vmjExchange.getRequestBodyForm("lokasiProperti");
		String fotoUrlProperti = (String) vmjExchange.getRequestBodyForm("fotoUrlProperti");
		String profilPenggunaImpl = (String) vmjExchange.getRequestBodyForm("idProfilPengguna");
		
		//to do: fix association attributes
		
		Properti properti = PropertiFactory.createProperti("KostPLE.properti.core.PropertiImpl", namaProperti, deskripsiProperti, lokasiProperti, fotoUrlProperti, profilPenggunaImpl);
		return properti;
	}

    public HashMap<String, Object> updateProperti(Map<String, Object> requestBody){
		String id = (String) requestBody.get("idProperti");
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

	public HashMap<String, Object> getPropertiById(String id){
		Properti properti = PropertiRepository.getObject(id);
		return properti.toHashMap();
	}

    public List<HashMap<String,Object>> getAllProperti(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Properti> list = PropertiRepository.getAllObject(table);
		return transformListToHashMap(list);
	}

	@Override
	public List<HashMap<String, Object>> transformListToHashMap(List<Properti> list){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
		for(int i = 0; i < list.size(); i++) {
			resultList.add(list.get(i).toHashMap());
		}

		return resultList;
	}

    public List<HashMap<String,Object>> deleteProperti(Map<String, Object> requestBody){
		String id = ((String) requestBody.get("id"));
		PropertiRepository.deleteObject(id);
		return getAllProperti(requestBody);
	}

	@Override
	public List<HashMap<String, Object>> saveProperti(Map<String, Object> requestBody) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'saveProperti'");
	}

	@Override
	public Properti createProperti(Map<String, Object> requestBody,
			Map<String, Object> response) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createProperti'");
	}

	@Override
	public HashMap<String, Object> getPropertiById(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPropertiById'");
	}


	
}
