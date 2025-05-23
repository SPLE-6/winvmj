package KostPLE.pemesanan.core;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.pemesanan.PemesananFactory;
import KostPLE.profilpengguna.core.*;
import KostPLE.kamar.core.*;
import vmj.auth.annotations.Restricted;
//add other required packages

public class PemesananServiceImpl extends PemesananServiceComponent{
	
	private PemesananFactory pemesananFactory = new PemesananFactory();
	ProfilPenggunaService profilPenggunaService = new ProfilPenggunaServiceImpl();
	KamarService kamarService = new KamarServiceImpl();

    public Pemesanan savePemesanan(Map<String, Object> requestBody){
		UUID idPemesanan = UUID.randomUUID();
		String statusPemesanan = "In Progress";
		String detail = (String) requestBody.get("detail");
	
		Date startDate = null;
		Date endDate = null;
		try {
			String startDateStr = (String) requestBody.get("startDate");
			String endDateStr = (String) requestBody.get("endDate");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

			startDate = sdf.parse(startDateStr);
			endDate = sdf.parse(endDateStr);

			// lanjutkan dengan penggunaan startDate dan endDate di sini...

		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("Format tanggal tidak valid: " + e.getMessage());
		}
		
		
		Date createdAt = new Date();
		
		String idProfilPenggunaStr = (String) requestBody.get("idProfilPengguna");

		UUID idProfilPengguna = UUID.fromString(idProfilPenggunaStr);
		
		

		String idKamarStr = (String) requestBody.get("idKamar");
		UUID idKamar = UUID.fromString(idKamarStr);
		
		ProfilPengguna profilPengguna = profilPenggunaService.getProfilPenggunaById(idProfilPengguna);
		Kamar kamar = kamarService.getKamarById(idKamar);
		
		kamar.setIsAvailable(false);
		
		LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		int months = (int) ChronoUnit.MONTHS.between(start, end);
		

		// Ambil harga per bulan dari kamar
		float pricePerMonth = kamar.getHargaKamar(); // asumsi method-nya getPrice()
		
		
		// Hitung total bayar
		Float totalPay = pricePerMonth * months;
		
		if (totalPay < pricePerMonth) {
			totalPay = pricePerMonth;
		}
		


		
		//to do: fix association attributes
		Pemesanan pemesanan = pemesananFactory.createPemesanan(
			"KostPLE.pemesanan.core.PemesananImpl",
		idPemesanan
		, startDate
		, endDate
		, totalPay
		, statusPemesanan
		, detail
		, createdAt
		, kamar
		, profilPengguna
		);
		Repository.saveObject(pemesanan);
		return pemesanan;
	}
    
    public Pemesanan savePemesananByUser(Map<String, Object> requestBody, String email, UUID kamarId) {
    	UUID idPemesanan = UUID.randomUUID();
		String statusPemesanan = "In Progress";
		String detail = (String) requestBody.get("detail");
	
		Date startDate = null;
		Date endDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
		    String startDateStr = (String) requestBody.get("startDate");
		    String endDateStr = (String) requestBody.get("endDate");

		    startDate = sdf.parse(startDateStr);
		    endDate = sdf.parse(endDateStr);

		} catch (ParseException e) {
		    e.printStackTrace();
		    throw new RuntimeException("Format tanggal tidak valid: " + e.getMessage());
		}
		
		
		Date createdAt = new Date();
		
		
		ProfilPengguna profilPengguna = profilPenggunaService.getProfilPenggunaByEmail(email);
		Kamar kamar = kamarService.getKamarById(kamarId);
		
		if (kamar.getIsAvailable() == false) {
			throw new RuntimeException("Kamar sudah dipesan atau tidak tersedia.");
		}
		
		kamar = kamarService.updateStatusKamar(kamarId);

		LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		int months = (int) ChronoUnit.MONTHS.between(start, end);
		

		// Ambil harga per bulan dari kamar
		float pricePerMonth = kamar.getHargaKamar(); // asumsi method-nya getPrice()
		
		
		// Hitung total bayar
		Float totalPay = pricePerMonth * months;
		
		
		if (totalPay < pricePerMonth) {
			totalPay = pricePerMonth;
		}


		
		//to do: fix association attributes
		Pemesanan pemesanan = pemesananFactory.createPemesanan(
			"KostPLE.pemesanan.core.PemesananImpl",
		idPemesanan
		, startDate
		, endDate
		, totalPay
		, statusPemesanan
		, detail
		, createdAt
		, kamar
		, profilPengguna
		);
		Repository.saveObject(pemesanan);
		return pemesanan;
	}

    public Pemesanan updatePemesanan(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPemesanan");
		UUID id = UUID.fromString(idStr);

		Pemesanan pemesanan = Repository.getObject(id);
		
		pemesanan.setStatusPemesanan((String) requestBody.get("statusPemesanan"));
		pemesanan.setDetail((String) requestBody.get("detail"));
		
		Repository.updateObject(pemesanan);
		
		//to do: fix association attributes
		
		return pemesanan;
		
	}
    
    public Pemesanan updateStatusPemesanan(UUID id){
		Pemesanan pemesanan = Repository.getObject(id);
		
		pemesanan.setStatusPemesanan("Success");
		Repository.updateObject(pemesanan);
		
		//to do: fix association attributes
		
		return pemesanan;
		
	}
    
    public Pemesanan updateStatusKamarFromPemesanan(UUID id) {
    	Pemesanan pemesanan = Repository.getObject(id);
    	
    	Kamar kamar = pemesanan.getKamar();
    	UUID kamarId = kamar.getIdKamar();
    	
    	Kamar kamarResult = kamarService.getKamarById(kamarId);
		
		kamarResult = kamarService.updateStatusKamar(kamarId);
		
		pemesanan.setStatusPemesanan("Completed");
		Repository.updateObject(pemesanan);
		return pemesanan;
    }

	public Pemesanan getPemesananById(UUID id){
		Pemesanan pemesanan = Repository.getObject(id);
		return pemesanan;
	}
	
    

	public List<Pemesanan> getAllPemesanan(){
		List<Pemesanan> pemesananList = Repository.getAllObject("pemesanan_impl");
		return pemesananList;
	}
	
	public List<Pemesanan> getAllPemesananByUser(String email){
    	List<Pemesanan> allPemesanan =  getAllPemesanan();
    	List<Pemesanan> filteredPemesanan = new ArrayList<>();
    	
    	
    	for (Pemesanan pemesanan : allPemesanan) {
    		ProfilPengguna pengguna = pemesanan.getProfilPengguna();
            if (pengguna != null && email.equalsIgnoreCase(pengguna.getEmail())) {
                filteredPemesanan.add(pemesanan);
            }
        }

        return filteredPemesanan;
    }

	@Override
    public List<HashMap<String,Object>> transformListToHashMap(List<Pemesanan> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<Pemesanan> deletePemesanan(UUID pemesananId){
		Repository.deleteObject(pemesananId);
		return getAllPemesanan();
	}

}
