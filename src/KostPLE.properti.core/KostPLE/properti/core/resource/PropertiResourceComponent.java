package KostPLE.properti.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PropertiResourceComponent implements PropertiResource{
	
	public PropertiResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveProperti(VMJExchange vmjExchange);
    public abstract Properti createProperti(VMJExchange vmjExchange);
	public abstract Properti createProperti(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateProperti(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getProperti(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllProperti(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteProperti(VMJExchange vmjExchange);

}
