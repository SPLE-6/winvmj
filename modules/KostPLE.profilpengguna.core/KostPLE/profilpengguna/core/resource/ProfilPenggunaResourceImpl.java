package KostPLE.profilpengguna.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.profilpengguna.ProfilPenggunaFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages
import KostPLE.profilpengguna.core.ProfilPengguna;


public class ProfilPenggunaResourceImpl extends ProfilPenggunaResourceComponent{
	
	private ProfilPenggunaServiceImpl profilpenggunaServiceImpl = new ProfilPenggunaServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/profilpengguna")
    public List<HashMap<String,Object>> saveProfilPengguna(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("POST")) {
        Map<String, Object> requestBody = vmjExchange.getPayload();
        profilpenggunaServiceImpl.createProfilPengguna(requestBody);
        return getAllProfilPengguna(vmjExchange);
    }
    throw new NotFoundException("Route not found");
}

    // @Restriced(permission = "")
    @Route(url="call/profilpengguna/update")
    public HashMap<String, Object> updateProfilPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return profilpenggunaServiceImpl.updateProfilPengguna(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/profilpengguna/detail")
    public HashMap<String, Object> getProfilPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return profilpenggunaServiceImpl.getProfilPengguna(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/profilpengguna/list")
    public List<HashMap<String,Object>> getAllProfilPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return profilpenggunaServiceImpl.getAllProfilPengguna(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/profilpengguna/delete")
    public List<HashMap<String,Object>> deleteProfilPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return profilpenggunaServiceImpl.deleteProfilPengguna(requestBody);
	}


}
