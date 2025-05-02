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
import KostPLE.pemesanan.PememesanFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PememesanServiceImpl extends PememesanServiceComponent{

    public List<HashMap<String,Object>> savePemesanan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Pemesanan pemesanan = createPemesanan(vmjExchange);
		pemesananRepository.saveObject(pemesanan);
		return getAllPemesanan(vmjExchange);
	}

    public Pemesanan createPemesanan(Map<String, Object> requestBody){
		String idPemesananStr = (String) requestBody.get("idPemesanan");
		int idPemesanan = Integer.parseInt(idPemesananStr);
		String statusPemesanan = (String) requestBody.get("statusPemesanan");
		String detail = (String) requestBody.get("detail");
		
		//to do: fix association attributes
		Pemesanan Pemesanan = PemesananFactory.createPemesanan(
			"KostPLE.pemesanan.core.PememesanImpl",
		idPemesanan
		, startDate
		, endDate
		, totalPay
		, statusPemesanan
		, detail
		, createdAt
		, kamarimpl
		);
		Repository.saveObject(pemesanan);
		return pemesanan;
	}

    public Pemesanan createPemesanan(Map<String, Object> requestBody, int id){
		String statusPemesanan = (String) vmjExchange.getRequestBodyForm("statusPemesanan");
		String detail = (String) vmjExchange.getRequestBodyForm("detail");
		
		//to do: fix association attributes
		
		Pemesanan pemesanan = PemesananFactory.createPemesanan("KostPLE.pemesanan.core.PememesanImpl", startDate, endDate, totalPay, statusPemesanan, detail, createdAt, kamarimpl);
		return pemesanan;
	}

    public HashMap<String, Object> updatePemesanan(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPemesanan");
		int id = Integer.parseInt(idStr);
		Pemesanan pemesanan = Repository.getObject(id);
		
		pemesanan.setStatusPemesanan((String) requestBody.get("statusPemesanan"));
		pemesanan.setDetail((String) requestBody.get("detail"));
		
		Repository.updateObject(pemesanan);
		
		//to do: fix association attributes
		
		return pemesanan.toHashMap();
		
	}

    public HashMap<String, Object> getPemesanan(Map<String, Object> requestBody){
		List<HashMap<String, Object>> pemesananList = getAllPemesanan("pemesanan_impl");
		for (HashMap<String, Object> pemesanan : pemesananList){
			int record_id = ((Double) pemesanan.get("record_id")).intValue();
			if (record_id == id){
				return pemesanan;
			}
		}
		return null;
	}

	public HashMap<String, Object> getPemesananById(int id){
		String idStr = vmjExchange.getGETParam("idPemesanan"); 
		int id = Integer.parseInt(idStr);
		Pemesanan pemesanan = pemesananRepository.getObject(id);
		return pemesanan.toHashMap();
	}

    public List<HashMap<String,Object>> getAllPemesanan(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Pemesanan> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

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
		Repository.deleteObject(id);
		return getAllPemesanan(requestBody);
	}

}
