package KostPLE.properti.core;
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
import KostPLE.properti.PropertiFactory;
import KostPLE.properti.core.Properti;
import vmj.auth.annotations.Restricted;

import KostPLE.profilpengguna.core.*;
//add other required packages

public class PropertiServiceImpl extends PropertiServiceComponent{
	
	private PropertiFactory propertiFactory = new PropertiFactory();
	ProfilPenggunaService profilPenggunaService = new ProfilPenggunaServiceImpl();

    public Properti saveProperti(Map<String, Object> requestBody){
		UUID idProperti = UUID.randomUUID();
		String namaProperti = (String) requestBody.get("namaProperti");
		String deskripsiProperti = (String) requestBody.get("deskripsiProperti");
		String lokasiProperti = (String) requestBody.get("lokasiProperti");
		String fotoUrlProperti = (String) requestBody.get("fotoUrlProperti");
		String idProfilPenggunaStr = (String) requestBody.get("idProfilPengguna");
		UUID idProfilPengguna = UUID.fromString(idProfilPenggunaStr);
		
		ProfilPengguna profilPengguna = profilPenggunaService.getProfilPenggunaById(idProfilPengguna);
		
		
		System.out.println("HALO: " + idProperti);
		System.out.println("HALO: " + namaProperti);
		System.out.println("HALO: " + deskripsiProperti);
		System.out.println("HALO: " + fotoUrlProperti);
		System.out.println("HALO: " + lokasiProperti);
		System.out.println("HALO: " + profilPengguna);

		
		//to do: fix association attributes
		Properti properti = propertiFactory.createProperti(
			"KostPLE.properti.core.PropertiImpl",
		idProperti
		, namaProperti
		, deskripsiProperti
		, lokasiProperti
		, fotoUrlProperti
		, profilPengguna
		);
		
		
		System.out.println("IXIXIXIXIXI: " + profilPengguna);

		Repository.saveObject(properti);
		
		System.out.println("PPPPPPP");

		
		return Repository.getObject(idProperti);
	}

    public Properti updateProperti(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idProperti");
		UUID id = UUID.fromString(idStr);
		Properti properti = Repository.getObject(id);
		
		properti.setNamaProperti((String) requestBody.get("namaProperti"));
		properti.setDeskripsiProperti((String) requestBody.get("deskripsiProperti"));
		properti.setLokasiProperti((String) requestBody.get("lokasiProperti"));
		properti.setFotoUrlProperti((String) requestBody.get("fotoUrlProperti"));
		
		Repository.updateObject(properti);
		properti = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return properti;
		
	}

	public Properti getPropertiById(UUID id){
		Properti properti = Repository.getObject(id);
		return properti;
	}

    public List<Properti> getAllProperti(){
		List<Properti> list = Repository.getAllObject("properti_impl");
		return list;
	}

	@Override
	public List<HashMap<String, Object>> transformListToHashMap(List<Properti> list){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
		for(int i = 0; i < list.size(); i++) {
			resultList.add(list.get(i).toHashMap());
		}

		return resultList;
	}

    public List<Properti> deleteProperti(UUID id){
		Repository.deleteObject(id);
		return getAllProperti();
	}

}
