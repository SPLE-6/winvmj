package KostPLE.pemesanan.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.pemesanan.PemesananFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages
import KostPLE.pemesanan.core.Pemesanan;
import KostPLE.pemesanan.core.PemesananServiceImpl;

public class PemesananResourceImpl extends PemesananResourceComponent{
	
	private PemesananServiceImpl pemesananServiceImpl = new PemesananServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/pemesanan/save")
    public HashMap<String,Object> savePemesanan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload(); 
			Pemesanan result = pemesananServiceImpl.savePemesanan(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/pemesanan/update")
    public HashMap<String, Object> updatePemesanan(VMJExchange vmjExchange){
		Map<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		Pemesanan result = pemesananServiceImpl.updatePemesanan(requestBody);
		return result.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/pemesanan/detail")
    public HashMap<String, Object> getPemesanan(VMJExchange vmjExchange){
    	Map<String, Object> requestBody = vmjExchange.getPayload();
		String pemesananStr = (String) requestBody.get("pemesananId");
		UUID pemesananId = UUID.fromString(pemesananStr);
		return pemesananServiceImpl.getPemesananById(pemesananId).toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/pemesanan/list")
    public List<HashMap<String,Object>> getAllPemesanan(VMJExchange vmjExchange){
		List <Pemesanan> pemesananList = pemesananServiceImpl.getAllPemesanan();
		return pemesananServiceImpl.transformListToHashMap(pemesananList);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/pemesanan/delete")
    public List<HashMap<String,Object>> deletePemesanan(VMJExchange vmjExchange){
    	HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload();
		String pemesananStr = (String) body.get("pemesananId");
		UUID pemesananId = UUID.fromString(pemesananStr);
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		List <Pemesanan> pemesananList = pemesananServiceImpl.deletePemesanan(pemesananId);
		return pemesananServiceImpl.transformListToHashMap(pemesananList);
		
	}

}
