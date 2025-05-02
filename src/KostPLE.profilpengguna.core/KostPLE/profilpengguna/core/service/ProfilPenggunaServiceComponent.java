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

    public abstract List<HashMap<String,Object>> saveProfilPengguna(VMJExchange vmjExchange);
    public abstract ProfilPengguna createProfilPengguna(Map<String, Object> requestBodye);
	public abstract ProfilPengguna createProfilPengguna(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateProfilPengguna(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getProfilPengguna(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllProfilPengguna(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<ProfilPengguna> List);
    public abstract List<HashMap<String,Object>> deleteProfilPengguna(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getProfilPenggunaById(int id);

}
