package KostPLE.kamar.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class KamarServiceDecorator extends KamarServiceComponent{
	protected KamarServiceComponent record;

    public KamarServiceDecorator(KamarServiceComponent record) {
        this.record = record;
    }

	public Kamar createKamar(Map<String, Object> requestBody){
		return record.createKamar(requestBody);
	}

    public Kamar createKamar(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createKamar(requestBody, response);
	}

	public HashMap<String, Object> getKamar(Map<String, Object> requestBody){
		return record.getKamar(requestBody);
	}

	public List<HashMap<String,Object>> getAllKamar(Map<String, Object> requestBody){
		return record.getAllKamar(requestBody);
	}

    public List<HashMap<String,Object>> saveKamar(VMJExchange vmjExchange){
		return record.saveKamar(vmjExchange);
	}

    public HashMap<String, Object> updateKamar(Map<String, Object> requestBody){
		return record.updateKamar(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Kamar> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteKamar(Map<String, Object> requestBody){
		return record.deleteKamar(requestBody);
	}

	public HashMap<String, Object> getKamarById(int id){
        return record.getKamarById(id);
    }

}
