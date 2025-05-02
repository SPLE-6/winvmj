package KostPLE.properti.laporan;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import KostPLE.properti.PropertiFactory;
import KostPLE.properti.core.repository.PropertiRepository;
import KostPLE.properti.core.Properti;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import KostPLE.properti.core.PropertiResourceDecorator;
import KostPLE.properti.core.PropertiImpl;
import KostPLE.properti.core.PropertiResourceComponent;

public class PropertiResourceImpl extends PropertiResourceDecorator {
    public PropertiResourceImpl (PropertiResourceComponent record) {
        super(record);
    }

	@Route(url="call/laporan/save")
	public List<HashMap<String, Object>> save(VMJExchange vmjExchange) {
		Properti properti = create(vmjExchange);
		PropertiRepository.saveObject(properti);
		return getAll(vmjExchange);
	}

	public Properti create(VMJExchange vmjExchange){
		Properti properti = record.create(vmjExchange);
		PropertiImpl deco = (PropertiImpl) PropertiFactory.create("KostPLE.laporan.core.PropertiImpl", properti, 0, 0);
		return deco;
	}

	public Properti create(VMJExchange vmjExchange, int id) {
		Properti saved = PropertiRepository.getObject(id);
		int recordId = ((Decorator) saved.getRecord()).getId();
		
		Properti properti = record.create(vmjExchange);
		PropertiImpl deco = (PropertiImpl) PropertiFactory.create("KostPLE.laporan.core.PropertiImpl", id, properti, 0, 0);
		return deco;
	}

	@Route(url="call/laporan/update")
	public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id"); // Specify the form key
		int id = Integer.parseInt(idStr);
		
		Properti existingProperti = PropertiRepository.getObject(id); // Assign to a variable
		Properti updatedProperti = create(vmjExchange, id); // Assign to a variable
		
		PropertiRepository.updateObject(updatedProperti); // Pass the updated object
		Properti finalProperti = PropertiRepository.getObject(id); // Assign to a variable
		// TODO: Fix association attributes
		
		return finalProperti.toHashMap(); // Return the correct object
	}

	// @Restriced(permission = "")
    @Route(url="call/laporan/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getProperti(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/laporan/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<Properti> List = PropertiRepository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Properti> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/laporan/delete")
    public List<HashMap<String,Object>> deleteProperti(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		PropertiRepository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
