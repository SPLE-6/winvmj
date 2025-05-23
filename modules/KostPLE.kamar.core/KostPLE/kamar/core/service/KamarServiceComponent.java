package KostPLE.kamar.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class KamarServiceComponent implements KamarService {
    protected RepositoryUtil<Kamar> Repository;

    public KamarServiceComponent() {
        this.Repository = new RepositoryUtil<Kamar>(KostPLE.kamar.core.KamarComponent.class);
    }

    public abstract Kamar saveKamar(Map<String, Object> requestBody);

    public abstract Kamar updateKamar(Map<String, Object> requestBody);
    
    public abstract Kamar updateStatusKamar(UUID id);


    public abstract List<Kamar> getAllKamar();

    public abstract List<HashMap<String, Object>> transformListToHashMap(List<Kamar> List);

    public abstract List<Kamar> deleteKamar(UUID kamarId);

    public abstract Kamar getKamarById(UUID id);

}
