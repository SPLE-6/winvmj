package KostPLE.pemesanan.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PememesanResourceComponent implements PemesananResource{
	
	public PememesanResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> savePemesanan(VMJExchange vmjExchange);
    public abstract Pemesanan createPemesanan(VMJExchange vmjExchange);
	public abstract Pemesanan createPemesanan(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updatePemesanan(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getPemesanan(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllPemesanan(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deletePemesanan(VMJExchange vmjExchange);

}
