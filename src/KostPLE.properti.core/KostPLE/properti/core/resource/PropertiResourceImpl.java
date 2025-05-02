package KostPLE.properti.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.properti.PropertiFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class PropertiResourceImpl extends PropertiResourceComponent{
	
	private PropertiServiceImpl propertiServiceImpl = new PropertiServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/properti/save")
    public List<HashMap<String,Object>> saveProperti(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Properti properti = createProperti(vmjExchange);
		propertiRepository.saveObject(properti);
		return getAllProperti(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/properti")
    public HashMap<String,Object> properti(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Properti result = propertiServiceImpl.createProperti(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Properti createProperti(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Properti result = propertiServiceImpl.createProperti(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Properti createProperti(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Properti result = propertiServiceImpl.createProperti(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/properti/update")
    public HashMap<String, Object> updateProperti(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return propertiServiceImpl.updateProperti(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/properti/detail")
    public HashMap<String, Object> getProperti(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return propertiServiceImpl.getProperti(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/properti/list")
    public List<HashMap<String,Object>> getAllProperti(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return propertiServiceImpl.getAllProperti(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/properti/delete")
    public List<HashMap<String,Object>> deleteProperti(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return propertiServiceImpl.deleteProperti(requestBody);
	}


}
