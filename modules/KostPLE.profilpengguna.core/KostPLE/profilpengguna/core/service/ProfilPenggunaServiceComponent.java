package KostPLE.profilpengguna.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ProfilPenggunaServiceComponent implements ProfilPenggunaService{
	protected RepositoryUtil<ProfilPengguna> Repository;

    public ProfilPenggunaServiceComponent(){
        this.Repository = new RepositoryUtil<ProfilPengguna>(KostPLE.profilpengguna.core.ProfilPenggunaComponent.class);
    }	

    public abstract List<HashMap<String,Object>> createProfilPengguna(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> updateProfilPengguna(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getProfilPengguna(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllProfilPengguna(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<ProfilPengguna> List);
    public abstract List<HashMap<String,Object>> deleteProfilPengguna(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getProfilPenggunaById(UUID id);

}
