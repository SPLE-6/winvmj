package KostPLE.pemesanan.core;
import java.util.*;

import KostPLE.pemesanan.core.Pemesanan;
import vmj.routing.route.VMJExchange;

public interface PemesananService {
	Pemesanan createPemesanan(Map<String, Object> requestBody);
	Pemesanan createPemesanan(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getPemesanan(Map<String, Object> requestBody);
    List<HashMap<String,Object>> savePemesanan(Map<String, Object> requestBody);
    HashMap<String, Object> updatePemesanan(Map<String, Object> requestBody);
    HashMap<String, Object> getPemesananById(String id);
    List<HashMap<String,Object>> getAllPemesanan(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deletePemesanan(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Pemesanan> List);
}
