package KostPLE.properti.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import vmj.auth.core.*;
import vmj.auth.annotations.Restricted;

import KostPLE.properti.PropertiFactory;
import KostPLE.properti.core.Properti;



//add other required packages

public class PropertiResourceImpl extends PropertiResourceComponent{
	
	private PropertiServiceImpl propertiServiceImpl = new PropertiServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/properti/save")
    public HashMap<String,Object> saveProperti(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
			HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload(); 
			Properti result = propertiServiceImpl.saveProperti(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/properti/update")
    public HashMap<String, Object> updateProperti(VMJExchange vmjExchange){
    	HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		Properti result = propertiServiceImpl.updateProperti(body);
		return result.toHashMap();
		
	}
    
	// @Restriced(permission = "")
    @Route(url="call/properti/detail")
    public HashMap<String, Object> getProperti(VMJExchange vmjExchange){
    	Map<String, Object> requestBody = vmjExchange.getPayload(); 
		String propertiStr = vmjExchange.getGETParam("propertiId");
		
		if (propertiStr == "") {
			propertiStr = (String) requestBody.get("propertiId");
		} 
		
		UUID propertiId = UUID.fromString(propertiStr);
		return propertiServiceImpl.getPropertiById(propertiId).toHashMap();
	}
    
    @Restricted(permissionName= "")
    @Route(url="call/properti/user-properti")
    public List<HashMap<String, Object>> getAllPropertiByUser(VMJExchange vmjExchange){
    	String email = vmjExchange.getAuthPayload().getEmail();
    	List <Properti> propertiList = propertiServiceImpl.getAllPropertiByUser(email);
    	return propertiServiceImpl.transformListToHashMap(propertiList);
    }

	// @Restriced(permission = "")
    @Route(url="call/properti/list")
    public List<HashMap<String,Object>> getAllProperti(VMJExchange vmjExchange){
    	List <Properti> propertiList = propertiServiceImpl.getAllProperti(); 
		return propertiServiceImpl.transformListToHashMap(propertiList);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/properti/delete")
    public List<HashMap<String,Object>> deleteProperti(VMJExchange vmjExchange){
    	HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload(); 
		String propertiStr = (String) body.get("propertiId");
		UUID properiId = UUID.fromString(propertiStr);
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		List <Properti> propertiList = propertiServiceImpl.deleteProperti(properiId);
		return propertiServiceImpl.transformListToHashMap(propertiList);

	}

	

}
