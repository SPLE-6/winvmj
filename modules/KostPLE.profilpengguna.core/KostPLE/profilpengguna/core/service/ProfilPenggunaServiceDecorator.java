package KostPLE.profilpengguna.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class ProfilPenggunaServiceDecorator extends ProfilPenggunaServiceComponent{
	protected ProfilPenggunaServiceComponent record;

    public ProfilPenggunaServiceDecorator(ProfilPenggunaServiceComponent record) {
        this.record = record;
    }

	public ProfilPengguna saveProfilPengguna(Map<String, Object> requestBody){
		return record.saveProfilPengguna(requestBody);
	}

	public List<ProfilPengguna> getAllProfilPengguna(){
		return record.getAllProfilPengguna();
	}

    public ProfilPengguna updateProfilPengguna(Map<String, Object> requestBody){
		return record.updateProfilPengguna(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ProfilPengguna> List){
		return record.transformListToHashMap(List);
	}

    public List<ProfilPengguna> deleteProfilPengguna(UUID profilPenggunaId){
		return record.deleteProfilPengguna(profilPenggunaId);
	}

	public ProfilPengguna getProfilPenggunaByEmail(String email){
        return record.getProfilPenggunaByEmail(email);
    }

}