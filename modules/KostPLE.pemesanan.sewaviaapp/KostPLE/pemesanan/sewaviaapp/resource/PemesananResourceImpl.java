package KostPLE.pemesanan.sewaviaapp;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import KostPLE.pemesanan.core.PemesananResourceDecorator;
import KostPLE.pemesanan.PemesananFactory;
import KostPLE.pemesanan.core.Pemesanan;
import KostPLE.pemesanan.core.PemesananComponent;
import KostPLE.pemesanan.sewaviaapp.PemesananImpl;
import KostPLE.pemesanan.core.PemesananResourceComponent;

public class PemesananResourceImpl extends PemesananResourceDecorator {
	private PemesananResourceComponent record;
	private RepositoryUtil<Pemesanan> Repository;

	public PemesananResourceImpl (PemesananResourceComponent record) {
		super(record);
		this.record = record;
		this.Repository = new RepositoryUtil<Pemesanan>(KostPLE.pemesanan.core.PemesananComponent.class);
	}

    // @Restriced(permission = "")
	@Route(url="call/sewaviaapp/save")
	public List<HashMap<String, Object>> save(VMJExchange vmjExchange) {
		Pemesanan pemesanan = create(vmjExchange);
		Repository.saveObject(pemesanan);
		return getAll(vmjExchange);
	}

	public Pemesanan create(VMJExchange vmjExchange){
		// Get request body
		Map<String, Object> requestBody = vmjExchange.getPayload();
		
		// Use HashMap to pass to record's savePemesanan method 
		HashMap<String, Object> result = record.savePemesanan(vmjExchange);
		
		// Extract the pemesanan ID from the result
		String idStr = (String) result.get("idPemesanan");
		if (idStr != null) {
			UUID id = UUID.fromString(idStr);
			Pemesanan basePemesanan = Repository.getObject(id);
			
			// Get downPayment from request
			Float downPayment = null;
			if (requestBody.get("downPayment") != null) {
				downPayment = Float.parseFloat(requestBody.get("downPayment").toString());
			}
			
			// Create decorated object
			if (basePemesanan instanceof PemesananComponent) {
				return new PemesananImpl((PemesananComponent) basePemesanan, downPayment);
			}
		}
		
		// Return default implementation if can't create decorated version
		return new PemesananImpl(requestBody.get("downPayment") != null ? 
			Float.parseFloat(requestBody.get("downPayment").toString()) : null);
	}

	public Pemesanan create(VMJExchange vmjExchange, UUID id) {
		// Get the existing pemesanan
		Pemesanan saved = Repository.getObject(id);
		
		// Get the request body
		Map<String, Object> requestBody = vmjExchange.getPayload();
		
		// Get downPayment from request
		Float downPayment = null;
		if (requestBody.get("downPayment") != null) {
			downPayment = Float.parseFloat(requestBody.get("downPayment").toString());
		}
		
		// Create decorated pemesanan
		if (saved instanceof PemesananComponent) {
			return new PemesananImpl((PemesananComponent) saved, downPayment);
		}
		
		// If not PemesananComponent, create new one
		return new PemesananImpl(downPayment);
	}

    // @Restriced(permission = "")
	@Route(url="call/sewaviaapp/update")
	public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		// Get pemesanan ID from request
		Map<String, Object> requestBody = vmjExchange.getPayload();
		String idStr = (String) requestBody.get("idPemesanan");
		UUID id = UUID.fromString(idStr);
		
		// Get existing pemesanan
		Pemesanan existingPemesanan = Repository.getObject(id);
		
		// Create updated pemesanan
		Pemesanan updatedPemesanan = create(vmjExchange, id);
		
		// Update in repository
		Repository.updateObject(updatedPemesanan);
		Pemesanan savedPemesanan = Repository.getObject(id);
		
		// Return updated pemesanan
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
		List<Pemesanan> pemesananList = Repository.getAllObject("pemesanan_sewaviaapp");
		return transformListToHashMap(pemesananList);
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
		
		// Get pemesanan ID from request
		Map<String, Object> requestBody = vmjExchange.getPayload();
		String idStr = (String) requestBody.get("idPemesanan");
		UUID id = UUID.fromString(idStr);
		
		// Delete from repository
		Repository.deleteObject(id);
		
		// Return updated list
		return getAll(vmjExchange);
	}

	public void sumTotal() {
		// Get all pemesanan records
		List<Pemesanan> pemesananList = Repository.getAllObject("pemesanan_sewaviaapp");
		
		// Update each pemesanan's total based on down payment
		for (Pemesanan pemesanan : pemesananList) {
			if (pemesanan instanceof PemesananImpl) {
				((PemesananImpl) pemesanan).sumTotal();
				// Save the updated pemesanan
				Repository.updateObject(pemesanan);
			}
		}
	}

	public void addNewPesanan() {
		// Create a new pemesanan with default values
		PemesananImpl newPemesanan = new PemesananImpl();
		newPemesanan.addNewPesanan();
		
		// Save the new pemesanan
		Repository.saveObject(newPemesanan);
	}

	@Override
	public HashMap<String, Object> savePemesanan(VMJExchange vmjExchange) {
		// Create and save the pemesanan
		Pemesanan pemesanan = create(vmjExchange);
		Repository.saveObject(pemesanan);
		
		// Return result as HashMap
		HashMap<String, Object> result = new HashMap<>();
		result.put("success", true);
		result.put("message", "Pemesanan created successfully");
		result.put("pemesanan", pemesanan.toHashMap());
		return result;
	}
}
