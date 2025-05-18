package KostPLE.pemesanan.sewaviaapp;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import KostPLE.pemesanan.core.PemesananResourceDecorator;
import KostPLE.pemesanan.PemesananFactory;
import KostPLE.pemesanan.core.Pemesanan;
import KostPLE.pemesanan.sewaviaapp.PemesananImpl;
import KostPLE.pemesanan.core.PemesananResourceComponent;
import KostPLE.pemesanan.core.PemesananServiceComponent;
import KostPLE.pemesanan.sewaviaapp.PemesananServiceImpl;

public class PemesananResourceImpl extends PemesananResourceDecorator {
	protected PemesananServiceImpl pemesananServiceImpl;

	public PemesananResourceImpl(PemesananResourceComponent record, PemesananServiceComponent records) {
		super(record);
		this.pemesananServiceImpl = new PemesananServiceImpl(records);
	}

    // @Restriced(permission = "")
	@Route(url="call/sewaviaapp/save")
	public HashMap<String, Object> createSewa(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			return null;
		}
		Pemesanan result = pemesananServiceImpl.createSewa(vmjExchange.getPayload());
		return result.toHashMap();
	}

    // @Restriced(permission = "")
	@Route(url="call/sewaviaapp/update")
	public HashMap<String, Object> updateSewa(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
		String idStr = (String) requestBody.get("pemesananId");
		UUID id = UUID.fromString(idStr);
		Pemesanan savedPemesanan = pemesananServiceImpl.updateSewa(vmjExchange.getPayload());
		// TODO: fix association attributes if necessary
		
		return savedPemesanan.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/sewaviaapp/detail")
    public HashMap<String, Object> getSewa(VMJExchange vmjExchange){
		return pemesananServiceImpl.getSewaById(vmjExchange.getPayload()).toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/sewaviaapp/list")
    public List<HashMap<String,Object>> getAllSewa(VMJExchange vmjExchange){
		List<Pemesanan> List = pemesananServiceImpl.getAllSewa(vmjExchange.getPayload());
		return transformListToHashMap(List);
	}

	// @Restriced(permission = "")
    @Route(url="call/sewaviaapp/delete")
    public List<HashMap<String,Object>> deleteSewa(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		pemesananServiceImpl.deleteSewa(vmjExchange.getPayload());
		return getAllSewa(vmjExchange);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Pemesanan> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

}
