package KostPLE.kamar.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class KamarServiceComponent implements KamarService{
	protected RepositoryUtil<Kamar> Repository;

    public KamarServiceComponent(){
        this.Repository = new RepositoryUtil<Kamar>(KostPLE.kamar.core.KamarComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveKamar(VMJExchange vmjExchange);
    public abstract Kamar createKamar(Map<String, Object> requestBodye);
	public abstract Kamar createKamar(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateKamar(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getKamar(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllKamar(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Kamar> List);
    public abstract List<HashMap<String,Object>> deleteKamar(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getKamarById(int id);

}
