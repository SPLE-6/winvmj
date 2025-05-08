package KostPLE.kamar.core;
import java.util.*;

import KostPLE.kamar.KamarFactory;
import KostPLE.kamar.core.KamarServiceImpl;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

public class KamarResourceImpl extends KamarResourceComponent{
	
	private KamarServiceImpl kamarServiceImpl = new KamarServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/kamar")
    public Kamar createKamar(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Kamar result = kamarServiceImpl.createKamar(requestBody);
			return result;
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

	@Override
	public List<HashMap<String, Object>> saveKamar(VMJExchange vmjExchange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'saveKamar'");
	}

}
