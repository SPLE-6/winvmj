package KostPLE.profilpengguna.core;
import java.util.*;
import java.util.Arrays;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import vmj.auth.core.*;
import vmj.auth.annotations.Restricted;
import KostPLE.profilpengguna.ProfilPenggunaFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages
import KostPLE.profilpengguna.core.ProfilPengguna;


public class ProfilPenggunaResourceImpl extends ProfilPenggunaResourceComponent{
	
	private ProfilPenggunaServiceImpl profilpenggunaServiceImpl = new ProfilPenggunaServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/profilpengguna/save")
    public HashMap<String,Object> saveProfilPengguna(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("POST")) {
        HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
        ProfilPengguna result = profilpenggunaServiceImpl.saveProfilPengguna(requestBody);
        return result.toHashMap();
    }
    throw new NotFoundException("Route not found");
}

     @Restricted(permissionName = "")
    @Route(url="call/profilpengguna/update")
    public HashMap<String, Object> updateProfilPengguna(VMJExchange vmjExchange){
    	HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		ProfilPengguna result = profilpenggunaServiceImpl.updateProfilPengguna(body);
		return result.toHashMap();
		
	}

	 @Restricted(permissionName= "")
    @Route(url="call/profilpengguna/detail")
    public HashMap<String, Object> getProfilPengguna(VMJExchange vmjExchange){
    	String email = vmjExchange.getAuthPayload().getEmail(); 
		return profilpenggunaServiceImpl.getProfilPenggunaByEmail(email).toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/profilpengguna/list")
    public List<HashMap<String,Object>> getAllProfilPengguna(VMJExchange vmjExchange){
		List <ProfilPengguna> profilPenggunaList = profilpenggunaServiceImpl.getAllProfilPengguna();
		return profilpenggunaServiceImpl.transformListToHashMap(profilPenggunaList);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/profilpengguna/delete")
    public List<HashMap<String,Object>> deleteProfilPengguna(VMJExchange vmjExchange){
    	HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload(); 
    	String profilPenggunaStr = (String) body.get("profilPenggunaId");
    	UUID profilPenggunaId = UUID.fromString(profilPenggunaStr);
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		List <ProfilPengguna> profilPenggunaList = profilpenggunaServiceImpl.deleteProfilPengguna(profilPenggunaId);
		return profilpenggunaServiceImpl.transformListToHashMap(profilPenggunaList);

		
	}
    
	// @Restriced(permission = "")
    @Route(url="call/profilpengguna/detail-by-id")
    public HashMap<String, Object> getProfilPenggunaById(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		String profilPenggunaStr = (String) requestBody.get("profilPenggunaId");
    	UUID profilPenggunaId = UUID.fromString(profilPenggunaStr);
		return profilpenggunaServiceImpl.getProfilPenggunaById(profilPenggunaId).toHashMap();
	}
    
    @Route(url="call/profilpengguna/detail-email")
    public HashMap<String, Object> getProfilPenggunaByEmail(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		String email = (String) requestBody.get("email");
		ProfilPengguna profilpengguna = profilpenggunaServiceImpl.getProfilPenggunaByEmail(email);
		return profilpengguna.toHashMap();
	}




}