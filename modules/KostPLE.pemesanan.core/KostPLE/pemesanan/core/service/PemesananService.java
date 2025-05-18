package KostPLE.pemesanan.core;
import java.util.*;

import KostPLE.pemesanan.core.Pemesanan;
import vmj.routing.route.VMJExchange;

public interface PemesananService {
	Pemesanan savePemesanan(Map<String, Object> requestBody);
    Pemesanan updatePemesanan(Map<String, Object> requestBody);
    Pemesanan getPemesananById(UUID id);
    List<Pemesanan> getAllPemesanan();
    List<Pemesanan> deletePemesanan(UUID id);
	List<HashMap<String, Object>> transformListToHashMap(List<Pemesanan> pemesananList);
}
