package KostPLE.profilpengguna.core;
import java.util.*;

import KostPLE.profilpengguna.core.ProfilPengguna;
import vmj.routing.route.VMJExchange;

public interface ProfilPenggunaService {
	HashMap<String, Object> getProfilPengguna(Map<String, Object> requestBody);
    List<HashMap<String,Object>> createProfilPengguna(Map<String, Object> requestBody);
    HashMap<String, Object> updateProfilPengguna(Map<String, Object> requestBody);
    HashMap<String, Object> getProfilPenggunaById(UUID id);
    List<HashMap<String,Object>> getAllProfilPengguna(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteProfilPengguna(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<ProfilPengguna> List);
}
