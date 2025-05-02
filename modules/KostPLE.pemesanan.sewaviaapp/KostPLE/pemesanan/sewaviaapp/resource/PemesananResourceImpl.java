package KostPLE.pemesanan.sewaviaapp;
import java.util.*;

import vmj.routing.annotation.Route;
import vmj.routing.exchange.VMJExchange;

import KostPLE.pemesanan.core.PemesananResourceDecorator;
import KostPLE.pemesanan.core.repository.PemesananRepository;
import KostPLE.pemesanan.PemesananFactory;
import KostPLE.pemesanan.core.PemesananImpl;
import KostPLE.pemesanan.core.PemesananResourceComponent;
import vmj.routing.annotation.Route;
import vmj.routing.exchange.VMJExchange;
import KostPLE.pemesanan.repository.Repository;

public class PemesananResourceImpl extends PemesananResourceDecorator {
    public PemesananResourceImpl (PemesananResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
	@Route(url="call/sewaviaapp/save")
	public List<HashMap<String, Object>> save(VMJExchange vmjExchange) {
		Pemesanan pemesanan = create(vmjExchange);
		PemesananRepository.saveObject(pemesanan);
		return getAll(vmjExchange);
	}

	public Pemesanan create(VMJExchange vmjExchange){
		// Ensure 'record' is properly initialized or passed to the class
		Pemesanan pemesanan = record.create(vmjExchange);
		
		// Ensure 'Factory' and 'downPayment' are properly defined or imported
		PemesananImpl deco = (PemesananImpl) Factory.create("KostPLE.sewaviaapp.core.PemesananImpl", pemesanan, downPayment);
		
		return deco;
	}

	public Pemesanan create(VMJExchange vmjExchange, int id) {
		// Ensure PemesananRepository and Pemesanan are properly defined or imported
		Pemesanan saved = (Pemesanan) PemesananRepository.getObject(id);
		int recordId = ((Decorator) saved.getRecord()).getId();

		// Ensure 'record' is initialized and 'downPayment' is defined
		Pemesanan pemesanan = record.create(vmjExchange);
		PemesananImpl deco = (PemesananImpl) PemesananFactory.create("KostPLE.sewaviaapp.core.PemesananImpl", id, pemesanan, downPayment);

		return deco;
	}

    // @Restriced(permission = "")
	@Route(url="call/sewaviaapp/update")
	public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Pemesanan existingPemesanan = (Pemesanan) PemesananRepository.getObject(id);
		Pemesanan updatedPemesanan = create(vmjExchange, id);
		
		PemesananRepository.updateObject(updatedPemesanan);
		Pemesanan savedPemesanan = (Pemesanan) PemesananRepository.getObject(id);
		// TODO: fix association attributes if necessary
		
		return savedPemesanan.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/sewaviaapp/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getPemesanan(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/sewaviaapp/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<Pemesanan> List = PemesananRepository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Pemesanan> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/sewaviaapp/delete")
    public List<HashMap<String,Object>> deletePemesanan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		PemesananRepository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public void sumTotal() {
		// TODO: implement this method
	}

	public void addNewPesanan() {
		// TODO: implement this method
	}
}
