package KostPLE.kamar.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.kamar.KamarFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class KamarResourceImpl extends KamarResourceComponent {

	private KamarServiceImpl kamarServiceImpl = new KamarServiceImpl();

	// @Restriced(permission = "")
	@Route(url = "call/kamar/save")
	public HashMap<String, Object> saveKamar(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
			Kamar result = kamarServiceImpl.saveKamar(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
	@Route(url = "call/kamar/edit")
	public HashMap<String, Object> updateKamar(VMJExchange vmjExchange) {
		HashMap<String, Object> requestBody =(HashMap<String, Object>) vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Kamar result = kamarServiceImpl.updateKamar(requestBody);
		return result.toHashMap();

	}

	// @Restriced(permission = "")
	@Route(url = "call/kamar/detail")
	public HashMap<String, Object> getKamar(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		String idKamarStr = (String) requestBody.get("idKamar");
		UUID idKamar = UUID.fromString(idKamarStr);
		return kamarServiceImpl.getKamarById(idKamar).toHashMap();
	}

	// @Restriced(permission = "")
	@Route(url = "call/kamar/list")
	public List<HashMap<String, Object>> getAllKamar(VMJExchange vmjExchange) {
		List<Kamar> kamarList = kamarServiceImpl.getAllKamar();
		return kamarServiceImpl.transformListToHashMap(kamarList);
	}

	// @Restriced(permission = "")
	@Route(url = "call/kamar/delete")
	public List<HashMap<String, Object>> deleteKamar(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		String kamarIdStr = (String) requestBody.get("profilPenggunaId");
    	UUID kamarId = UUID.fromString(kamarIdStr);
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		List<Kamar> kamarList = kamarServiceImpl.deleteKamar(kamarId);
		return kamarServiceImpl.transformListToHashMap(kamarList);
	}

}
