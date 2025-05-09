package KostPLE.properti.core;
import java.util.*;

import KostPLE.properti.core.Properti;
import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PropertiResourceComponent implements PropertiResource{
	
	protected RepositoryUtil<Properti> propertiRepository;
	
	public PropertiResourceComponent() { 
		this.propertiRepository = new RepositoryUtil<Properti>(KostPLE.properti.core.PropertiComponent.class);
	}


    public abstract HashMap<String, Object> saveProperti(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateProperti(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getProperti(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllProperti(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteProperti(VMJExchange vmjExchange);

}
