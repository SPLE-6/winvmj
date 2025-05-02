package KostPLE.properti.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PropertiService {
	Properti createProperti(Map<String, Object> requestBody);
	Properti createProperti(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getProperti(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveProperti(Map<String, Object> requestBody);
    HashMap<String, Object> updateProperti(Map<String, Object> requestBody);
    HashMap<String, Object> getPropertiById(int id);
    List<HashMap<String,Object>> getAllProperti(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteProperti(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
