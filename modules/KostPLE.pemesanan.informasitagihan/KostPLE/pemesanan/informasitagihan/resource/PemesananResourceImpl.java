package KostPLE.pemesanan.informasitagihan;
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
    @Route(url="call/informasitagihan/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PemesananInformasiTagihan pemesananinformasitagihan = createPemesananInformasiTagihan(vmjExchange);
		pemesananinformasitagihanRepository.saveObject(pemesananinformasitagihan);
		return getAllPemesananInformasiTagihan(vmjExchange);
	}

    public Pemesanan createPemesananInformasiTagihan(VMJExchange vmjExchange){
		
		PemesananInformasiTagihan pemesananinformasitagihan = record.createPemesananInformasiTagihan(vmjExchange);
		PemesananInformasiTagihan pemesananinformasitagihandeco = PemesananInformasiTagihanFactory.createPemesananInformasiTagihan("KostPLE.informasitagihan.core.PemesananImpl", pemesananinformasitagihan, idPemesanan, startDate, endDate, totalPay, statusPemesanan, detail, createdAt, kamarimpl, profilpenggunaimpl
		);
			return pemesananinformasitagihandeco;
	}


    public Pemesanan createPemesananInformasiTagihan(VMJExchange vmjExchange, int id){
		PemesananInformasiTagihan pemesananinformasitagihan = pemesananinformasitagihanRepository.getObject(id);
		int recordPemesananInformasiTagihanId = (((PemesananInformasiTagihanDecorator) savedPemesananInformasiTagihan.getRecord()).getId();
		
		PemesananInformasiTagihan pemesananinformasitagihan = record.createPemesananInformasiTagihan(vmjExchange);
		PemesananInformasiTagihan pemesananinformasitagihandeco = PemesananInformasiTagihanFactory.createPemesananInformasiTagihan("KostPLE.informasitagihan.core.PemesananImpl", id, pemesananinformasitagihan, idPemesanan, startDate, endDate, totalPay, statusPemesanan, detail, createdAt, kamarimpl, profilpenggunaimpl
		);
			return pemesananinformasitagihandeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/informasitagihan/update")
    public HashMap<String, Object> updatePemesananInformasiTagihan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("idPemesanan");
		int id = Integer.parseInt(idStr);
		
		PemesananInformasiTagihan pemesananinformasitagihan = pemesananinformasitagihanRepository.getObject(id);
		pemesananinformasitagihan = createPemesananInformasiTagihan(vmjExchange, id);
		
		pemesananinformasitagihanRepository.updateObject(pemesananinformasitagihan);
		pemesananinformasitagihan = pemesananinformasitagihanRepository.getObject(id);
		//to do: fix association attributes
		
		return pemesananinformasitagihan.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/informasitagihan/detail")
    public HashMap<String, Object> getPemesananInformasiTagihan(VMJExchange vmjExchange){
		return record.getPemesananInformasiTagihan(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/informasitagihan/list")
    public List<HashMap<String,Object>> getAllPemesananInformasiTagihan(VMJExchange vmjExchange){
		List<PemesananInformasiTagihan> pemesananinformasitagihanList = pemesananinformasitagihanRepository.getAllObject("pemesananinformasitagihan_impl");
		return transformPemesananInformasiTagihanListToHashMap(pemesananinformasitagihanList);
	}

    public List<HashMap<String,Object>> transformPemesananInformasiTagihanListToHashMap(List<PemesananInformasiTagihan> PemesananInformasiTagihanList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PemesananInformasiTagihanList.size(); i++) {
            resultList.add(PemesananInformasiTagihanList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/informasitagihan/delete")
    public List<HashMap<String,Object>> deletePemesananInformasiTagihan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("idPemesanan");
		int id = Integer.parseInt(idStr);
		pemesananinformasitagihanRepository.deleteObject(id);
		return getAllPemesananInformasiTagihan(vmjExchange);
	}

	public void ShowAllTagihan() {
		// TODO: implement this method
	}

	public void ShowTagihanDetail() {
		// TODO: implement this method
	}

	public void PayTagihan() {
		// TODO: implement this method
	}
	
}
