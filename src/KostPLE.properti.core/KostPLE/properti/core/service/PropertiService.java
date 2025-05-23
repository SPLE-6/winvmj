package KostPLE.properti.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PropertiService {
    Properti saveProperti(Map<String, Object> requestBody);
    Properti updateProperti(Map<String, Object> requestBody);
    Properti getPropertiById(UUID id);
    List<Properti> getAllPropertiByUser(String email);
    List<Properti> getAllProperti();
    List<Properti> deleteProperti(UUID id);
	List<HashMap<String, Object>> transformListToHashMap(List<Properti> propertiList);
}
