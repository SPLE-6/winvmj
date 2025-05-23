package KostPLE.kamar.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class KamarResourceComponent implements KamarResource {
	protected RepositoryUtil<Kamar> kamarRepository;

    public KamarResourceComponent() {
		this.kamarRepository = new RepositoryUtil<Kamar>(KostPLE.kamar.core.KamarComponent.class);

    }
    
    public abstract HashMap<String, Object> saveKamar(VMJExchange vmjExchange);

    public abstract HashMap<String, Object> updateKamar(VMJExchange vmjExchange);
    
    public abstract HashMap<String, Object> updateStatusKamar(VMJExchange vmjExchange);


    public abstract HashMap<String, Object> getKamar(VMJExchange vmjExchange);

    public abstract List<HashMap<String, Object>> getAllKamar(VMJExchange vmjExchange);

    public abstract List<HashMap<String, Object>> deleteKamar(VMJExchange vmjExchange);

}
