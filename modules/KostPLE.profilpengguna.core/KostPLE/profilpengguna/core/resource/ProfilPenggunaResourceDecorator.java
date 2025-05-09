package KostPLE.profilpengguna.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ProfilPenggunaResourceDecorator extends ProfilPenggunaResourceComponent{
	protected ProfilPenggunaResourceComponent record;

    public ProfilPenggunaResourceDecorator(ProfilPenggunaResourceComponent record) {
        this.record = record;
    }

    public HashMap<String,Object> saveProfilPengguna(VMJExchange vmjExchange){
		return record.saveProfilPengguna(vmjExchange);
	}

    public HashMap<String, Object> updateProfilPengguna(VMJExchange vmjExchange){
		return record.updateProfilPengguna(vmjExchange);
	}

    public HashMap<String, Object> getProfilPengguna(VMJExchange vmjExchange){
		return record.getProfilPengguna(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllProfilPengguna(VMJExchange vmjExchange){
		return record.getAllProfilPengguna(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteProfilPengguna(VMJExchange vmjExchange){
		return record.deleteProfilPengguna(vmjExchange);
	}
    
    public HashMap<String, Object> getProfilPenggunaById(VMJExchange vmjExchange){
		return record.getProfilPenggunaById(vmjExchange);
	}
    
    public HashMap<String, Object> getProfilPenggunaByEmail(VMJExchange vmjExchange){
		return record.getProfilPenggunaByEmail(vmjExchange);
	}

}