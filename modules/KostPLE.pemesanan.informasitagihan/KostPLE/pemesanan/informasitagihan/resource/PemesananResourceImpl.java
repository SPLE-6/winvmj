package KostPLE.pemesanan.informasitagihan;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import KostPLE.pemesanan.core.repository.PemesananRepository;
import KostPLE.pemesanan.core.PemesananResourceDecorator;
import KostPLE.pemesanan.PemesananFactory;
import KostPLE.pemesanan.core.Pemesanan;
import KostPLE.pemesanan.core.PemesananImpl;
import KostPLE.pemesanan.core.PemesananResourceComponent;

public class PemesananResourceImpl extends PemesananResourceDecorator {
    public PemesananResourceImpl (PemesananResourceComponent record) {
        super(record);
		this.record = record;
    }

    // @Restriced(permission = "")
    @Route(url="call/informasitagihan/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Pemesanan pemesanan = create(vmjExchange); // Added variable assignment
		PemesananRepository.saveObject(pemesanan); // Pass the created object to save
		return getAll(vmjExchange);
	}

	public Pemesanan create(VMJExchange vmjExchange){
		Pemesanan pemesanan = record.createPemesanan(vmjExchange); // Ensure 'record' is properly initialized elsewhere
		PemesananImpl deco = (PemesananImpl) PemesananFactory.createPemesanan("KostPLE.informasitagihan.core.PemesananImpl", pemesanan); // Ensure 'PemesananFactory' is properly imported or defined
		return deco;
	}

	public Pemesanan create(VMJExchange vmjExchange, String id) {
		Pemesanan saved = (Pemesanan) PemesananRepository.getObject(id); // Ensure PemesananRepository and Pemesanan are properly imported
		String recordId = saved.getIdPemesanan(); // Ensure Decorator is properly imported and getRecord() is valid
		
		Pemesanan newRecord = record.createPemesanan(vmjExchange); // Ensure 'record' is initialized elsewhere
		PemesananImpl deco = (PemesananImpl) PemesananFactory.createPemesanan(id, newRecord, recordId); // Ensure PemesananFactory is properly imported and create() is valid
		return deco;
	}

    // @Restriced(permission = "")
	@Route(url="call/informasitagihan/update")
	public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String id = (String) vmjExchange.getRequestBodyForm("id");
		
		Pemesanan existingPemesanan = (Pemesanan) PemesananRepository.getObject(id);
		Pemesanan updatedPemesanan = create(vmjExchange, id);
		
		PemesananRepository.updateObject(updatedPemesanan);
		Pemesanan resultPemesanan = (Pemesanan) PemesananRepository.getObject(id);
		// TODO: fix association attributes if needed
		
		return resultPemesanan.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/informasitagihan/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getPemesanan(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/informasitagihan/list")
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
    @Route(url="call/informasitagihan/delete")
    public List<HashMap<String,Object>> deletePemesanan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		PemesananRepository.deleteObject(id);
		return getAll(vmjExchange);
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

	@Override
	public List<HashMap<String, Object>> savePemesanan(VMJExchange vmjExchange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'savePemesanan'");
	}
}
