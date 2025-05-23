package KostPLE.kamar.core;

import java.util.*;
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
import KostPLE.kamar.KamarFactory;
import KostPLE.properti.core.*;
import vmj.auth.annotations.Restricted;
//add other required packages

public class KamarServiceImpl extends KamarServiceComponent {
	
	private KamarFactory kamarFactory = new KamarFactory();
	PropertiService propertiService = new PropertiServiceImpl();

	public Kamar saveKamar(Map<String, Object> requestBody) {
		UUID idKamar = UUID.randomUUID();
		boolean isAvailable = (boolean) requestBody.get("isAvailable");
		String tipeKamar = (String) requestBody.get("tipeKamar");
		String deskripsiKamar = (String) requestBody.get("deskripsiKamar");
		String fotoUrlKamar = (String) requestBody.get("fotoUrlKamar");
		String hargaKamarStr = (String) requestBody.get("hargaKamar");
		
		Float hargaKamar = Float.parseFloat(hargaKamarStr);
		String idPropertiStr = (String) requestBody.get("idProperti");

		UUID idProperti = UUID.fromString(idPropertiStr);
		
		Properti properti = propertiService.getPropertiById(idProperti);

		// to do: fix association attributes
		Kamar kamar = KamarFactory.createKamar(
				"KostPLE.kamar.core.KamarImpl",
				idKamar, isAvailable, tipeKamar, deskripsiKamar, fotoUrlKamar, hargaKamar, properti);
		Repository.saveObject(kamar);
		return kamar;
	}

	public Kamar updateKamar(Map<String, Object> requestBody) {
	    String idStr = (String) requestBody.get("idKamar");
	    UUID id = UUID.fromString(idStr);
	    Kamar kamar = Repository.getObject(id);

	    if (kamar == null) {
	        throw new RuntimeException("Kamar dengan ID tersebut tidak ditemukan.");
	    }

	    if (requestBody.containsKey("isAvailable")) {
	        kamar.setIsAvailable((boolean) requestBody.get("isAvailable"));
	    }

	    if (requestBody.containsKey("tipeKamar")) {
	        kamar.setTipeKamar((String) requestBody.get("tipeKamar"));
	    }

	    if (requestBody.containsKey("deskripsiKamar")) {
	        kamar.setDeskripsiKamar((String) requestBody.get("deskripsiKamar"));
	    }

	    if (requestBody.containsKey("fotoUrlKamar")) {
	        kamar.setFotoUrlKamar((String) requestBody.get("fotoUrlKamar"));
	    }

	    if (requestBody.containsKey("hargaKamar")) {
	        kamar.setHargaKamar((Float) requestBody.get("hargaKamar"));
	    }

	    if (requestBody.containsKey("properti")) {
	        kamar.setProperti((Properti) requestBody.get("properti"));
	    }

	    Repository.updateObject(kamar);

	    return kamar;
	}
	
	public Kamar updateStatusKamar(UUID id) {
		Kamar kamar = Repository.getObject(id);
		
		
		System.out.println("INI KAMAR:" +  kamar);
		
		if (kamar.getIsAvailable() == true) {
			System.out.println("MASIUK SINI");

			kamar.setIsAvailable(false);
		} else {
			System.out.println("MASIUK SANA");
			kamar.setIsAvailable(true);
		}
		
		

		Repository.updateObject(kamar);

		// to do: fix association attributes

		return kamar;

	}

	public Kamar getKamarById(UUID id) {
		Kamar kamar = Repository.getObject(id);
		return kamar;
	}

	public List<Kamar> getAllKamar() {
		List<Kamar> kamarList = Repository.getAllObject("kamar_impl");
		return kamarList;
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Kamar> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

	public List<Kamar> deleteKamar(UUID kamarId) {
		Repository.deleteObject(kamarId);
		return getAllKamar();
	}

}
