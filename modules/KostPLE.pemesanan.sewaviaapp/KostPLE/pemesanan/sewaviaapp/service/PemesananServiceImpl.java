package KostPLE.pemesanan.sewaviaapp;

import java.util.*;

import vmj.routing.route.VMJExchange;

import KostPLE.pemesanan.core.PemesananServiceDecorator;
import KostPLE.pemesanan.core.Pemesanan;
import KostPLE.pemesanan.core.PemesananServiceComponent;
import KostPLE.pemesanan.sewaviaapp.PemesananImpl;

public class PemesananServiceImpl extends PemesananServiceDecorator {
    public PemesananServiceImpl (PemesananServiceComponent record) {
        super(record);
    }

	public Pemesanan createSewa(Map<String, Object> requestBody) {
		String totalHargaStr = (String) requestBody.get("totalHarga");
		int totalHarga = Integer.parseInt(totalHargaStr);
		String downPaymentStr = (String) requestBody.get("downPayment");
		int downPayment = Integer.parseInt(downPaymentStr);
		
		Pemesanan pemesanan = record.savePemesanan(requestBody);
		Repository.saveObject(pemesanan);
		return pemesanan;
	}

	public Pemesanan getSewaById(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("idPemesanan");
		UUID id = UUID.fromString(idStr);
		Pemesanan pemesanan = Repository.getObject(id);
		return pemesanan;
	}

	public List<Pemesanan> getAllSewa(Map<String, Object> requestBody) {
		String table = (String) requestBody.get("table_name");
		List<Pemesanan> List = Repository.getAllObject(table);
		return List;
	}

	public Pemesanan deleteSewa(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("idPemesanan");
		UUID id = UUID.fromString(idStr);
		Pemesanan pemesanan = Repository.getObject(id);
		Repository.deleteObject(id);
		return pemesanan;
	}

	public Pemesanan updateSewa(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("idPemesanan");
		UUID id = UUID.fromString(idStr);
		Pemesanan pemesanan = Repository.getObject(id);
		String totalHargaStr = (String) requestBody.get("totalHarga");
		int totalHarga = Integer.parseInt(totalHargaStr);
		String downPaymentStr = (String) requestBody.get("downPayment");
		int downPayment = Integer.parseInt(downPaymentStr);		
		Repository.updateObject(pemesanan);
		sumTotal((PemesananImpl) pemesanan);
		return pemesanan;
	}
    
	public void sumTotal(PemesananImpl pemesanan) {
		// TODO: implement this method
		pemesanan.sumTotal();
	}

}
