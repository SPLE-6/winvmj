package KostPLE.pemesanan.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PemesananResource {
    List<HashMap<String,Object>> savePemesanan(VMJExchange vmjExchange);
    HashMap<String, Object> updatePemesanan(VMJExchange vmjExchange);
    HashMap<String, Object> getPemesanan(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPemesanan(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePemesanan(VMJExchange vmjExchange);
	HashMap<String, Object> Pemesanan(VMJExchange vmjExhange);
}
