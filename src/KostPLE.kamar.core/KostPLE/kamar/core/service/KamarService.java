package KostPLE.kamar.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface KamarService {
	Kamar createKamar(Map<String, Object> requestBody);
	Kamar createKamar(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getKamar(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveKamar(Map<String, Object> requestBody);
    HashMap<String, Object> updateKamar(Map<String, Object> requestBody);
    HashMap<String, Object> getKamarById(int id);
    List<HashMap<String,Object>> getAllKamar(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteKamar(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
