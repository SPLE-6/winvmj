package KostPLE.pemesanan.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PememesanServiceComponent implements PemesananService{
	protected RepositoryUtil<Pemesanan> Repository;

    public PememesanServiceComponent(){
        this.Repository = new RepositoryUtil<Pemesanan>(KostPLE.pemesanan.core.PememesanComponent.class);
    }	

    public abstract List<HashMap<String,Object>> savePemesanan(VMJExchange vmjExchange);
    public abstract Pemesanan createPemesanan(Map<String, Object> requestBodye);
	public abstract Pemesanan createPemesanan(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updatePemesanan(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getPemesanan(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllPemesanan(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Pemesanan> List);
    public abstract List<HashMap<String,Object>> deletePemesanan(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getPemesananById(int id);

}
