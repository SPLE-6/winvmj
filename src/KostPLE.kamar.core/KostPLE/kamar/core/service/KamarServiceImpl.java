package KostPLE.kamar.core;
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
import KostPLE.kamar.KamarFactory;
import KostPLE.kamar.core.Kamar;
import KostPLE.kamar.core.KamarImpl; 
import KostPLE.kamar.core.repository.KamarRepository;
import KostPLE.properti.core.Properti;
import KostPLE.properti.core.PropertiImpl;
import vmj.auth.annotations.Restricted;
//add other required packages

public class KamarServiceImpl extends KamarServiceComponent{

	@Override
    public List<HashMap<String,Object>> saveKamar(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Kamar kamar = createKamar(vmjExchange.getPayload());
		KamarRepository.saveObject(kamar);
		return getAllKamar(vmjExchange.getPayload());
	}

    public Kamar createKamar(Map<String, Object> requestBody){
		String idKamarStr = (String) requestBody.get("idKamar");
		int idKamar = Integer.parseInt(idKamarStr);
		boolean isAvailable = (boolean) requestBody.get("isAvailable");
		String tipeKamar = (String) requestBody.get("tipeKamar");
		String deskripsiKamar = (String) requestBody.get("deskripsiKamar");
		String Property6 = (String) requestBody.get("Property6");
		Float Property7 = (Float) requestBody.get("Property7");
		PropertiImpl propertiimpl = (PropertiImpl) requestBody.get("propertiimpl");
		
		//to do: fix association attributes
		Kamar kamar = KamarFactory.createKamar(
			"KostPLE.kamar.core.KamarImpl",
		idKamar
		, isAvailable
		, tipeKamar
		, deskripsiKamar
		, Property6
		, Property7
		, propertiimpl
		);
		KamarRepository.saveObject(kamar);
		return kamar;
	}

    public Kamar createKamar(VMJExchange vmjExchange, int id){
		boolean isAvailable = (boolean) vmjExchange.getRequestBodyForm("isAvailable");
		String tipeKamar = (String) vmjExchange.getRequestBodyForm("tipeKamar");
		String deskripsiKamar = (String) vmjExchange.getRequestBodyForm("deskripsiKamar");
		String Property6 = (String) vmjExchange.getRequestBodyForm("Property6");
		
		//to do: fix association attributes
		
		Kamar kamar = KamarFactory.createKamar("KostPLE.kamar.core.KamarImpl", isAvailable, tipeKamar, deskripsiKamar, Property6 );
		return kamar;
	}

    public HashMap<String, Object> updateKamar(Map<String, Object> requestBody){
		String id = (String) requestBody.get("idKamar");
		Kamar kamar = KamarRepository.getObject(id);
		
		kamar.setIsAvailable((Boolean) requestBody.get("isAvailable"));
		kamar.setTipeKamar((String) requestBody.get("tipeKamar"));
		kamar.setDeskripsiKamar((String) requestBody.get("deskripsiKamar"));
		kamar.setProperty6((String) requestBody.get("Property6"));
		
		KamarRepository.updateObject(kamar);
		
		//to do: fix association attributes
		
		return kamar.toHashMap();
		
	}

    public HashMap<String, Object> getKamar(Map<String, Object> requestBody){
		List<HashMap<String, Object>> kamarList = getAllKamar(requestBody);
		String id = (String) requestBody.get("idKamar");
		for (HashMap<String, Object> kamar : kamarList){

			String record_id = ( kamar.get("record_id")).toString();
			if (record_id.equals(id)){
				return kamar;
			}
		}
		return null;
	}

	public HashMap<String, Object> getKamarById(String id){
		Kamar kamar = KamarRepository.getObject(id);
		return kamar.toHashMap();
	}

    public List<HashMap<String,Object>> getAllKamar(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Kamar> List = KamarRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

	@Override
    public List<HashMap<String,Object>> transformListToHashMap(List<Kamar> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteKamar(Map<String, Object> requestBody){
		String id = ((String) requestBody.get("id"));
		KamarRepository.deleteObject(id);
		return getAllKamar(requestBody);
	}

	@Override
	public List<HashMap<String, Object>> saveKamar(Map<String, Object> requestBody) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'saveKamar'");
	}

	@Override
	public Kamar createKamar(Map<String, Object> requestBody, Map<String, Object> response) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createKamar'");
	}

	@Override
	public HashMap<String, Object> getKamarById(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getKamarById'");
	}

}
