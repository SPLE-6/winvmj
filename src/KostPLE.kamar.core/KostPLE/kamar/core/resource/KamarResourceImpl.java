package KostPLE.kamar.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.kamar.KamarFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class KamarResourceImpl extends KamarResourceComponent{
	
	private KamarServiceImpl kamarServiceImpl = new KamarServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/kamar/save")
    public List<HashMap<String,Object>> saveKamar(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Kamar kamar = createKamar(vmjExchange);
		kamarRepository.saveObject(kamar);
		return getAllKamar(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/kamar")
    public HashMap<String,Object> kamar(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Kamar result = kamarServiceImpl.createKamar(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Kamar createKamar(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Kamar result = kamarServiceImpl.createKamar(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Kamar createKamar(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Kamar result = kamarServiceImpl.createKamar(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/kamar/update")
    public HashMap<String, Object> updateKamar(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return kamarServiceImpl.updateKamar(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/kamar/detail")
    public HashMap<String, Object> getKamar(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return kamarServiceImpl.getKamar(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/kamar/list")
    public List<HashMap<String,Object>> getAllKamar(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return kamarServiceImpl.getAllKamar(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/kamar/delete")
    public List<HashMap<String,Object>> deleteKamar(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return kamarServiceImpl.deleteKamar(requestBody);
	}


}
