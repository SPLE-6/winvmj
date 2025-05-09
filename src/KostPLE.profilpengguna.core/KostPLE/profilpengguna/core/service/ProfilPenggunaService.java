package KostPLE.profilpengguna.core;
import java.util.*;

import KostPLE.profilpengguna.core.ProfilPengguna;
import vmj.routing.route.VMJExchange;

public interface ProfilPenggunaService {
	ProfilPengguna saveProfilPengguna(Map<String, Object> requestBody);
	ProfilPengguna updateProfilPengguna(Map<String, Object> requestBody);
    ProfilPengguna getProfilPenggunaByEmail(String email);
    ProfilPengguna getProfilPenggunaById(UUID id);
    List<ProfilPengguna> getAllProfilPengguna();
    List<ProfilPengguna> deleteProfilPengguna(UUID id);
	List<HashMap<String, Object>> transformListToHashMap(List<ProfilPengguna> profilPenggunaList);
}