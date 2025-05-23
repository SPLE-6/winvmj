package KostPLE.pemesanan.core;
import java.util.*;

import KostPLE.pemesanan.core.Pemesanan;
import vmj.routing.route.VMJExchange;

public interface PemesananResource {
	HashMap<String,Object> savePemesanan(VMJExchange vmjExchange);
	HashMap<String,Object> savePemesananByUser(VMJExchange vmjExchange);
    HashMap<String, Object> updatePemesanan(VMJExchange vmjExchange);
    HashMap<String, Object> updateStatusKamarFromPemesanan(VMJExchange vmjExchange);
    HashMap<String, Object> getPemesanan(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPemesananByUser(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPemesanan(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePemesanan(VMJExchange vmjExchange);
}
