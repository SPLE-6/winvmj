package KostPLE.properti.laporan.resource;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import KostPLE.properti.PropertiFactory;
import KostPLE.properti.core.Properti;
import vmj.hibernate.integrator.RepositoryUtil;

import KostPLE.properti.core.PropertiResourceDecorator;
import KostPLE.properti.core.PropertiComponent;
import KostPLE.properti.core.PropertiResourceComponent;
import KostPLE.properti.laporan.model.PropertiImpl;

public class PropertiResourceImpl extends PropertiResourceDecorator {
    private RepositoryUtil<Properti> Repository;
    
    public PropertiResourceImpl (PropertiResourceComponent record) {
        super(record);
        this.Repository = new RepositoryUtil<Properti>(KostPLE.properti.core.PropertiComponent.class);
    }

	@Route(url="call/laporan/save")
	public List<HashMap<String, Object>> save(VMJExchange vmjExchange) {
		Properti properti = create(vmjExchange);
		Repository.saveObject(properti);
		return getAll(vmjExchange);
	}

	public Properti create(VMJExchange vmjExchange){
		// Get the properti data from the request
		Map<String, Object> requestBody = vmjExchange.getPayload();
		
		// Use the base class's saveProperti method to first create a core properti
		Properti baseProperti = null;
		try {
			// Try to extract a properti ID from the result
			HashMap<String, Object> result = record.saveProperti(vmjExchange);
			String idStr = (String) result.get("idProperti");
			if (idStr != null) {
				UUID id = UUID.fromString(idStr);
				baseProperti = Repository.getObject(id);
			}
		} catch (Exception e) {
			// Handle any errors in getting the base properti
			e.printStackTrace();
		}
		
		// Create the custom implementation with laporan-specific attributes
		PropertiImpl deco = null;
		if (baseProperti instanceof PropertiComponent) {
			// If base properti is a component, we can directly use it
			deco = (PropertiImpl) PropertiFactory.createProperti(
				"KostPLE.properti.laporan.model.PropertiImpl", 
				(PropertiComponent) baseProperti,
				requestBody.get("pemasukan") != null ? Float.parseFloat(requestBody.get("pemasukan").toString()) : 0f,
				requestBody.get("pengeluaran") != null ? Float.parseFloat(requestBody.get("pengeluaran").toString()) : 0f
			);
		} else {
			// Otherwise create a new one with just the laporan attributes
			deco = (PropertiImpl) PropertiFactory.createProperti(
				"KostPLE.properti.laporan.model.PropertiImpl", 
				requestBody.get("pemasukan") != null ? Float.parseFloat(requestBody.get("pemasukan").toString()) : 0f,
				requestBody.get("pengeluaran") != null ? Float.parseFloat(requestBody.get("pengeluaran").toString()) : 0f
			);
		}
		
		return deco;
	}

	public Properti create(VMJExchange vmjExchange, UUID id) {
		Properti saved = Repository.getObject(id);
		
		// Get the properti data from the request
		Map<String, Object> requestBody = vmjExchange.getPayload();
		
		// Create the custom implementation with laporan-specific attributes
		PropertiImpl deco = null;
		
		if (saved instanceof PropertiComponent) {
			// If the saved properti is a component, use it directly
			deco = (PropertiImpl) PropertiFactory.createProperti(
				"KostPLE.properti.laporan.model.PropertiImpl", 
				(PropertiComponent) saved,
				requestBody.get("pemasukan") != null ? Float.parseFloat(requestBody.get("pemasukan").toString()) : 0f,
				requestBody.get("pengeluaran") != null ? Float.parseFloat(requestBody.get("pengeluaran").toString()) : 0f
			);
		} else {
			// Otherwise create a new one with just the laporan attributes
			deco = (PropertiImpl) PropertiFactory.createProperti(
				"KostPLE.properti.laporan.model.PropertiImpl", 
				requestBody.get("pemasukan") != null ? Float.parseFloat(requestBody.get("pemasukan").toString()) : 0f,
				requestBody.get("pengeluaran") != null ? Float.parseFloat(requestBody.get("pengeluaran").toString()) : 0f
			);
		}
		
		return deco;
	}

	@Route(url="call/laporan/update")
	public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		// Use the record's updateProperti method first to handle core functionality
		HashMap<String, Object> result = record.updateProperti(vmjExchange);
		
		// Get properti ID from request
		Map<String, Object> requestBody = vmjExchange.getPayload();
		String propertiStr = (String) requestBody.get("idProperti");
		UUID propertiId = UUID.fromString(propertiStr);
		
		// Create an updated laporan-specific properti
		Properti updatedProperti = create(vmjExchange, propertiId);
		
		// Update and retrieve the final result
		Repository.updateObject(updatedProperti);
		Properti finalProperti = Repository.getObject(propertiId);
		
		return finalProperti.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/laporan/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		// Use the record's getProperti method to leverage core functionality
		return record.getProperti(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/laporan/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<Properti> list = Repository.getAllObject("properti_laporan");
		return transformListToHashMap(list);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Properti> list){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < list.size(); i++) {
            resultList.add(list.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/laporan/delete")
    public List<HashMap<String,Object>> deleteProperti(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		// Get properti ID from request
		Map<String, Object> requestBody = vmjExchange.getPayload();
		String propertiStr = (String) requestBody.get("propertiId");
		UUID propertiId = UUID.fromString(propertiStr);
		
		// Delete the object and return updated list
		Repository.deleteObject(propertiId);
		return getAll(vmjExchange);
	}

}
