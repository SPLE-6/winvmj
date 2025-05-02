package KostPLE.profilpengguna.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ProfilPenggunaResource {
    List<HashMap<String,Object>> saveProfilPengguna(VMJExchange vmjExchange);
    HashMap<String, Object> updateProfilPengguna(VMJExchange vmjExchange);
    HashMap<String, Object> getProfilPengguna(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllProfilPengguna(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteProfilPengguna(VMJExchange vmjExchange);
	HashMap<String, Object> ProfilPengguna(VMJExchange vmjExhange);
}
