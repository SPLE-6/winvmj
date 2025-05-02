package KostPLE.profilpengguna.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ProfilPenggunaResourceComponent implements ProfilPenggunaResource{
	
	public ProfilPenggunaResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveProfilPengguna(VMJExchange vmjExchange);
    public abstract ProfilPengguna createProfilPengguna(VMJExchange vmjExchange);
	public abstract ProfilPengguna createProfilPengguna(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateProfilPengguna(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getProfilPengguna(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllProfilPengguna(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteProfilPengguna(VMJExchange vmjExchange);

}
