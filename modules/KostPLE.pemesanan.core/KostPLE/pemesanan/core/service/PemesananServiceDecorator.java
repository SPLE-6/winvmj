package KostPLE.pemesanan.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class PemesananServiceDecorator extends PemesananServiceComponent{
	protected PemesananServiceComponent record;

    public PemesananServiceDecorator(PemesananServiceComponent record) {
        this.record = record;
    }

	public PemesananImpl createPemesanan(Map<String, Object> requestBody){
		return record.createPemesanan(requestBody);
	}

    public Pemesanan createPemesanan(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createPemesanan(requestBody, response);
	}

	public HashMap<String, Object> getPemesanan(Map<String, Object> requestBody){
		return record.getPemesanan(requestBody);
	}

	public List<HashMap<String,Object>> getAllPemesanan(Map<String, Object> requestBody){
		return record.getAllPemesanan(requestBody);
	}

    public List<HashMap<String,Object>> savePemesanan(VMJExchange vmjExchange){
		return record.savePemesanan(vmjExchange);
	}

    public HashMap<String, Object> updatePemesanan(Map<String, Object> requestBody){
		return record.updatePemesanan(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Pemesanan> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deletePemesanan(Map<String, Object> requestBody){
		return record.deletePemesanan(requestBody);
	}

	public HashMap<String, Object> getPemesananById(int id){
        return record.getPemesananById(id);
    }

}
