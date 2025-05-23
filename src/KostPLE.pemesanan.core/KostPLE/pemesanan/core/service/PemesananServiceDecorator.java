package KostPLE.pemesanan.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class PemesananServiceDecorator extends PemesananServiceComponent{
	protected PemesananServiceComponent record;

    public PemesananServiceDecorator(PemesananServiceComponent record) {
        this.record = record;
    }

    public Pemesanan savePemesanan(Map<String, Object> requestBody){
		return record.savePemesanan(requestBody);
	}
    
	public Pemesanan savePemesananByUser(Map<String, Object> requestBody, String email) {
		return record.savePemesananByUser(requestBody, email);
	}


	public List<Pemesanan> getAllPemesanan(){
		return record.getAllPemesanan();
	}

    public Pemesanan updatePemesanan(Map<String, Object> requestBody){
		return record.updatePemesanan(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Pemesanan> List){
		return record.transformListToHashMap(List);
	}

    public List<Pemesanan> deletePemesanan(UUID pemesananId){
		return record.deletePemesanan(pemesananId);
	}

	public Pemesanan getPemesananById(UUID pemesananId){
        return record.getPemesananById(pemesananId);
    }
	
    public List<Pemesanan> getAllPemesananByUser(String email){
    	return record.getAllPemesananByUser(email);
    }


}
