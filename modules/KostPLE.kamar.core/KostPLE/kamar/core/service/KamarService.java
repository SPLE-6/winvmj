package KostPLE.kamar.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public interface KamarService {

    Kamar saveKamar(Map<String, Object> requestBody);

    Kamar updateKamar(Map<String, Object> requestBody);
    
    Kamar updateStatusKamar(UUID id);


    Kamar getKamarById(UUID id);

    List<Kamar> getAllKamar();

    List<Kamar> deleteKamar(UUID kamarId);

    List<HashMap<String, Object>> transformListToHashMap(List<Kamar> kamarList);
}
