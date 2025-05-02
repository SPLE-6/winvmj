package KostPLE.profilpengguna.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ProfilPenggunaResourceDecorator extends ProfilPenggunaResourceComponent{
	protected ProfilPenggunaResourceComponent record;

    public ProfilPenggunaResourceDecorator(ProfilPenggunaResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveProfilPengguna(VMJExchange vmjExchange){
		return record.saveProfilPengguna(vmjExchange);
	}

    public ProfilPengguna createProfilPengguna(VMJExchange vmjExchange){
		return record.createProfilPengguna(vmjExchange);
	}

    public ProfilPengguna createProfilPengguna(VMJExchange vmjExchange, int id){
		return record.createProfilPengguna(vmjExchange, id);
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

}
