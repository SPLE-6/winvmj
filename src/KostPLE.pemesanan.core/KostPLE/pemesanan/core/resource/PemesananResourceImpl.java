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
    @Route(url="call/pemesanan")
    public Pemesanan createpemesanan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pemesanan result = pemesananServiceImpl.createPemesanan(requestBody);
			return result;
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

	@Override
	public List<HashMap<String, Object>> savePemesanan(VMJExchange vmjExchange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'savePemesanan'");
	}

	@Override
	public Pemesanan createPemesanan(VMJExchange vmjExhange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createPemesanan'");
	}

}
