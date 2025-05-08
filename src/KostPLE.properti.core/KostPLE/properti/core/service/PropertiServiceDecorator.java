package KostPLE.properti.core;
import java.util.*;

import KostPLE.properti.core.Properti;
import KostPLE.properti.core.PropertiImpl;
import vmj.routing.route.VMJExchange;

public abstract class PropertiServiceDecorator extends PropertiServiceComponent{
	protected PropertiServiceComponent record;

    public PropertiServiceDecorator(PropertiServiceComponent record) {
        this.record = record;
    }

	public Properti createProperti(Map<String, Object> requestBody){
		return record.createProperti(requestBody);
	}

    public Properti createProperti(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createProperti(requestBody, response);
	}

	public HashMap<String, Object> getProperti(Map<String, Object> requestBody){
		return record.getProperti(requestBody);
	}

	public List<HashMap<String,Object>> getAllProperti(Map<String, Object> requestBody){
		return record.getAllProperti(requestBody);
	}

    public Properti saveProperti(VMJExchange vmjExchange){
		return record.saveProperti(vmjExchange);
	}

    public HashMap<String, Object> updateProperti(Map<String, Object> requestBody){
		return record.updateProperti(requestBody);
	}

    public List<HashMap<String,Object>> transformListToMap(List<Properti> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteProperti(Map<String, Object> requestBody){
		return record.deleteProperti(requestBody);
	}

	public HashMap<String, Object> getPropertiById(int id){
        return record.getPropertiById(id);
    }

}
