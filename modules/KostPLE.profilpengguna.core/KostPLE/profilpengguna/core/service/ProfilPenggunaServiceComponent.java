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

    public abstract ProfilPengguna saveProfilPengguna(Map<String, Object> requestBody);
	public abstract ProfilPengguna updateProfilPengguna(Map<String, Object> requestBody);
    public abstract List<ProfilPengguna> getAllProfilPengguna();
    public abstract List<HashMap<String, Object>> transformListToHashMap(List<ProfilPengguna> List);
    public abstract List<ProfilPengguna> deleteProfilPengguna(UUID id);
	public abstract ProfilPengguna getProfilPenggunaById(UUID id);

}