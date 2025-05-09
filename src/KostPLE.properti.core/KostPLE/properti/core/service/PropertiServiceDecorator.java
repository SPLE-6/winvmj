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
    
    public Properti saveProperti(Map<String, Object> requestBody){
		return record.saveProperti(requestBody);
	}

	public List<Properti> getAllProperti(){
		return record.getAllProperti();
	}

    public Properti updateProperti(Map<String, Object> requestBody){
		return record.updateProperti(requestBody);
	}

    public List<HashMap<String,Object>> transformListToMap(List<Properti> List){
		return record.transformListToHashMap(List);
	}

    public List<Properti> deleteProperti(UUID propertiId){
		return record.deleteProperti(propertiId);
	}

	public Properti getPropertiById(UUID propertiId){
        return record.getPropertiById(propertiId);
    }

}
