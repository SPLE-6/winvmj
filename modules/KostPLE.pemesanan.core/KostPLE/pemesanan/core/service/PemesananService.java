package KostPLE.pemesanan.core;
import java.util.*;

import KostPLE.pemesanan.core.Pemesanan;
import vmj.routing.route.VMJExchange;

public interface PemesananService {
	Pemesanan savePemesanan(Map<String, Object> requestBody);
	Pemesanan savePemesananByUser(Map<String, Object> requestBody, String email, UUID kamarId);
    Pemesanan updatePemesanan(Map<String, Object> requestBody);
    Pemesanan updateStatusPemesanan(UUID id);
    Pemesanan updateStatusKamarFromPemesanan(UUID idKamar);
    Pemesanan getPemesananById(UUID id);
    List<Pemesanan> getAllPemesanan();
    List<Pemesanan> getAllPemesananByUser(String email);
    List<Pemesanan> deletePemesanan(UUID id);
	List<HashMap<String, Object>> transformListToHashMap(List<Pemesanan> propertiList);
}
