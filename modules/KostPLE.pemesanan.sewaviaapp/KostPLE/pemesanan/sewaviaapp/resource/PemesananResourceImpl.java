package KostPLE.pemesanan.sewaviaapp;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import KostPLE.pemesanan.core.PemesananResourceDecorator;
import KostPLE.pemesanan.core.PemesananImpl;
import KostPLE.pemesanan.core.PemesananResourceComponent;

public class PemesananResourceImpl extends PemesananResourceDecorator {
    public PemesananResourceImpl (PemesananResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/sewaviaapp/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PemesananSewaViaApp pemesanansewaviaapp = createPemesananSewaViaApp(vmjExchange);
		pemesanansewaviaappRepository.saveObject(pemesanansewaviaapp);
		return getAllPemesananSewaViaApp(vmjExchange);
	}

    public Pemesanan createPemesananSewaViaApp(VMJExchange vmjExchange){
		
		PemesananSewaViaApp pemesanansewaviaapp = record.createPemesananSewaViaApp(vmjExchange);
		PemesananSewaViaApp pemesanansewaviaappdeco = PemesananSewaViaAppFactory.createPemesananSewaViaApp("KostPLE.sewaviaapp.core.PemesananImpl", pemesanansewaviaapp, idPemesanan, startDate, endDate, totalPay, statusPemesanan, detail, createdAt, kamarimpl, profilpenggunaimpl
		downPayment
		);
			return pemesanansewaviaappdeco;
	}


    public Pemesanan createPemesananSewaViaApp(VMJExchange vmjExchange, int id){
		PemesananSewaViaApp pemesanansewaviaapp = pemesanansewaviaappRepository.getObject(id);
		int recordPemesananSewaViaAppId = (((PemesananSewaViaAppDecorator) savedPemesananSewaViaApp.getRecord()).getId();
		
		PemesananSewaViaApp pemesanansewaviaapp = record.createPemesananSewaViaApp(vmjExchange);
		PemesananSewaViaApp pemesanansewaviaappdeco = PemesananSewaViaAppFactory.createPemesananSewaViaApp("KostPLE.sewaviaapp.core.PemesananImpl", id, pemesanansewaviaapp, idPemesanan, startDate, endDate, totalPay, statusPemesanan, detail, createdAt, kamarimpl, profilpenggunaimpl
		downPayment
		);
			return pemesanansewaviaappdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/sewaviaapp/update")
    public HashMap<String, Object> updatePemesananSewaViaApp(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("idPemesanan");
		int id = Integer.parseInt(idStr);
		
		PemesananSewaViaApp pemesanansewaviaapp = pemesanansewaviaappRepository.getObject(id);
		pemesanansewaviaapp = createPemesananSewaViaApp(vmjExchange, id);
		
		pemesanansewaviaappRepository.updateObject(pemesanansewaviaapp);
		pemesanansewaviaapp = pemesanansewaviaappRepository.getObject(id);
		//to do: fix association attributes
		
		return pemesanansewaviaapp.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/sewaviaapp/detail")
    public HashMap<String, Object> getPemesananSewaViaApp(VMJExchange vmjExchange){
		return record.getPemesananSewaViaApp(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/sewaviaapp/list")
    public List<HashMap<String,Object>> getAllPemesananSewaViaApp(VMJExchange vmjExchange){
		List<PemesananSewaViaApp> pemesanansewaviaappList = pemesanansewaviaappRepository.getAllObject("pemesanansewaviaapp_impl");
		return transformPemesananSewaViaAppListToHashMap(pemesanansewaviaappList);
	}

    public List<HashMap<String,Object>> transformPemesananSewaViaAppListToHashMap(List<PemesananSewaViaApp> PemesananSewaViaAppList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PemesananSewaViaAppList.size(); i++) {
            resultList.add(PemesananSewaViaAppList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/sewaviaapp/delete")
    public List<HashMap<String,Object>> deletePemesananSewaViaApp(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("idPemesanan");
		int id = Integer.parseInt(idStr);
		pemesanansewaviaappRepository.deleteObject(id);
		return getAllPemesananSewaViaApp(vmjExchange);
	}

	public void sumTotal() {
		// TODO: implement this method
	}

	public void addNewPesanan() {
		// TODO: implement this method
	}
	
}
