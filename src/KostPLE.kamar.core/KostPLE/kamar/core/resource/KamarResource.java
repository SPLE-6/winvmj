package KostPLE.kamar.core;
import java.util.*;

import KostPLE.kamar.core.Kamar;
import vmj.routing.route.VMJExchange;

public interface KamarResource {
    List<HashMap<String,Object>> saveKamar(VMJExchange vmjExchange);
    HashMap<String, Object> updateKamar(VMJExchange vmjExchange);
    HashMap<String, Object> getKamar(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllKamar(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteKamar(VMJExchange vmjExchange);
	Kamar createKamar(VMJExchange vmjExhange);
}
