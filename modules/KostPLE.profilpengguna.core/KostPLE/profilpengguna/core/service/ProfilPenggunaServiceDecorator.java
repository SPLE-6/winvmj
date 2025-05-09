package KostPLE.profilpengguna.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class ProfilPenggunaServiceDecorator extends ProfilPenggunaServiceComponent{
	protected ProfilPenggunaServiceComponent record;

    public ProfilPenggunaServiceDecorator(ProfilPenggunaServiceComponent record) {
        this.record = record;
    }

	public List<HashMap<String,Object>> createProfilPengguna(Map<String, Object> requestBody){
		return record.createProfilPengguna(requestBody);
	}


	public HashMap<String, Object> getProfilPengguna(Map<String, Object> requestBody){
		return record.getProfilPengguna(requestBody);
	}

	public List<HashMap<String,Object>> getAllProfilPengguna(Map<String, Object> requestBody){
		return record.getAllProfilPengguna(requestBody);
	}

    public HashMap<String, Object> updateProfilPengguna(Map<String, Object> requestBody){
		return record.updateProfilPengguna(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ProfilPengguna> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteProfilPengguna(Map<String, Object> requestBody){
		return record.deleteProfilPengguna(requestBody);
	}

	public HashMap<String, Object> getProfilPenggunaById(UUID id){
        return record.getProfilPenggunaById(id);
    }

}
