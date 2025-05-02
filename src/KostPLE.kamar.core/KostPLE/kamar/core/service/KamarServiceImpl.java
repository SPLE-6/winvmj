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
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class KamarServiceImpl extends KamarServiceComponent{

    public List<HashMap<String,Object>> saveKamar(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Kamar kamar = createKamar(vmjExchange);
		kamarRepository.saveObject(kamar);
		return getAllKamar(vmjExchange);
	}

    public Kamar createKamar(Map<String, Object> requestBody){
		String idKamarStr = (String) requestBody.get("idKamar");
		int idKamar = Integer.parseInt(idKamarStr);
		boolean isAvailable = (boolean) requestBody.get("isAvailable");
		String tipeKamar = (String) requestBody.get("tipeKamar");
		String deskripsiKamar = (String) requestBody.get("deskripsiKamar");
		String Property6 = (String) requestBody.get("Property6");
		
		//to do: fix association attributes
		Kamar Kamar = KamarFactory.createKamar(
			"KostPLE.kamar.core.KamarImpl",
		idKamar
		, isAvailable
		, tipeKamar
		, deskripsiKamar
		, Property6
		, Property7
		, propertiimpl
		);
		Repository.saveObject(kamar);
		return kamar;
	}

    public Kamar createKamar(Map<String, Object> requestBody, int id){
		boolean isAvailable = (boolean) vmjExchange.getRequestBodyForm("isAvailable");
		String tipeKamar = (String) vmjExchange.getRequestBodyForm("tipeKamar");
		String deskripsiKamar = (String) vmjExchange.getRequestBodyForm("deskripsiKamar");
		String Property6 = (String) vmjExchange.getRequestBodyForm("Property6");
		
		//to do: fix association attributes
		
		Kamar kamar = KamarFactory.createKamar("KostPLE.kamar.core.KamarImpl", isAvailable, tipeKamar, deskripsiKamar, Property6, Property7, propertiimpl);
		return kamar;
	}

    public HashMap<String, Object> updateKamar(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idKamar");
		int id = Integer.parseInt(idStr);
		Kamar kamar = Repository.getObject(id);
		
		kamar.setIsAvailable((String) requestBody.get("isAvailable"));
		kamar.setTipeKamar((String) requestBody.get("tipeKamar"));
		kamar.setDeskripsiKamar((String) requestBody.get("deskripsiKamar"));
		kamar.setProperty6((String) requestBody.get("Property6"));
		
		Repository.updateObject(kamar);
		
		//to do: fix association attributes
		
		return kamar.toHashMap();
		
	}

    public HashMap<String, Object> getKamar(Map<String, Object> requestBody){
		List<HashMap<String, Object>> kamarList = getAllKamar("kamar_impl");
		for (HashMap<String, Object> kamar : kamarList){
			int record_id = ((Double) kamar.get("record_id")).intValue();
			if (record_id == id){
				return kamar;
			}
		}
		return null;
	}

	public HashMap<String, Object> getKamarById(int id){
		String idStr = vmjExchange.getGETParam("idKamar"); 
		int id = Integer.parseInt(idStr);
		Kamar kamar = kamarRepository.getObject(id);
		return kamar.toHashMap();
	}

    public List<HashMap<String,Object>> getAllKamar(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Kamar> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Kamar> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteKamar(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllKamar(requestBody);
	}

}
