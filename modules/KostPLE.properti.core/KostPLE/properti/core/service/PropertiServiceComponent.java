package KostPLE.properti.core;
import java.util.*;
import KostPLE.properti.core.Properti;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PropertiServiceComponent implements PropertiService{
	protected RepositoryUtil<Properti> Repository;

    public PropertiServiceComponent(){
        this.Repository = new RepositoryUtil<Properti>(KostPLE.properti.core.PropertiComponent.class);
    }	

    public abstract Properti saveProperti(Map<String, Object> requestBody);
	public abstract Properti updateProperti(Map<String, Object> requestBody);
    public abstract List<Properti> getAllPropertiByUser(String email);
    public abstract List<Properti> getAllProperti();
    public abstract List<HashMap<String, Object>> transformListToHashMap(List<Properti> List);
    public abstract List<Properti> deleteProperti(UUID id);
	public abstract Properti getPropertiById(UUID id);

}
