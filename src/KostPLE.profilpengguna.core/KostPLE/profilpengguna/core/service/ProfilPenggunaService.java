package KostPLE.profilpengguna.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ProfilPenggunaService {
	ProfilPengguna createProfilPengguna(Map<String, Object> requestBody);
	ProfilPengguna createProfilPengguna(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getProfilPengguna(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveProfilPengguna(Map<String, Object> requestBody);
    HashMap<String, Object> updateProfilPengguna(Map<String, Object> requestBody);
    HashMap<String, Object> getProfilPenggunaById(int id);
    List<HashMap<String,Object>> getAllProfilPengguna(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteProfilPengguna(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
