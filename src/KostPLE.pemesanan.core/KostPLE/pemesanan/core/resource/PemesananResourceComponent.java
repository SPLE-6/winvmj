package KostPLE.pemesanan.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PemesananResourceComponent implements PemesananResource{
	
	protected RepositoryUtil<Pemesanan> pemesananRepository;

	public PemesananResourceComponent() { 
		this.pemesananRepository = new RepositoryUtil<Pemesanan>(KostPLE.pemesanan.core.PemesananComponent.class);
	}
 
    public abstract HashMap<String, Object> savePemesanan(VMJExchange vmjExchange);
	public abstract HashMap<String,Object> savePemesananByUser(VMJExchange vmjExchange);
	public abstract HashMap<String, Object> updatePemesanan(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getPemesanan(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllPemesananByUser(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllPemesanan(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deletePemesanan(VMJExchange vmjExchange);

}
