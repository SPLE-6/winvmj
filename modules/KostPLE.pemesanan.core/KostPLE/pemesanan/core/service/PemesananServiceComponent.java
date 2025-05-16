package KostPLE.pemesanan.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PemesananServiceComponent implements PemesananService{
	protected RepositoryUtil<Pemesanan> Repository;

    public PemesananServiceComponent(){
        this.Repository = new RepositoryUtil<Pemesanan>(KostPLE.pemesanan.core.PemesananComponent.class);
    }	

	public abstract Pemesanan savePemesanan(Map<String, Object> requestBody);    
	public abstract Pemesanan updatePemesanan(Map<String, Object> requestBody);
    public abstract List<Pemesanan> getAllPemesanan();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Pemesanan> List);
    public abstract List<Pemesanan> deletePemesanan(UUID id);
	public abstract Pemesanan getPemesananById(UUID id);

}
