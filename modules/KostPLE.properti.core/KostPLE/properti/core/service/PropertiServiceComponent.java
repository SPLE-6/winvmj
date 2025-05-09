package KostPLE.properti.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PropertiServiceComponent implements PropertiService{
	protected RepositoryUtil<Properti> Repository;

    public PropertiServiceComponent(){
        this.Repository = new RepositoryUtil<Properti>(KostPLE.properti.core.PropertiComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveProperti(VMJExchange vmjExchange);
    public abstract Properti createProperti(Map<String, Object> requestBodye);
	public abstract Properti createProperti(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateProperti(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getProperti(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllProperti(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Properti> List);
    public abstract List<HashMap<String,Object>> deleteProperti(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getPropertiById(int id);

}
