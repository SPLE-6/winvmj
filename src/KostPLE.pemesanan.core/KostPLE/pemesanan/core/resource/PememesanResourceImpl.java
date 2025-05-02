package KostPLE.pemesanan.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.pemesanan.PememesanFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class PememesanResourceImpl extends PememesanResourceComponent{
	
	private PememesanServiceImpl pemesananServiceImpl = new PememesanServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/pemesanan/save")
    public List<HashMap<String,Object>> savePemesanan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Pemesanan pemesanan = createPemesanan(vmjExchange);
		pemesananRepository.saveObject(pemesanan);
		return getAllPemesanan(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/pemesanan")
    public HashMap<String,Object> pemesanan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pemesanan result = pemesananServiceImpl.createPemesanan(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Pemesanan createPemesanan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pemesanan result = pemesananServiceImpl.createPemesanan(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Pemesanan createPemesanan(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pemesanan result = pemesananServiceImpl.createPemesanan(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/pemesanan/update")
    public HashMap<String, Object> updatePemesanan(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return pemesananServiceImpl.updatePemesanan(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/pemesanan/detail")
    public HashMap<String, Object> getPemesanan(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return pemesananServiceImpl.getPemesanan(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/pemesanan/list")
    public List<HashMap<String,Object>> getAllPemesanan(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return pemesananServiceImpl.getAllPemesanan(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/pemesanan/delete")
    public List<HashMap<String,Object>> deletePemesanan(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return pemesananServiceImpl.deletePemesanan(requestBody);
	}


}
