package KostPLE.properti.core;
import java.util.*;
import com.google.gson.Gson;
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
import KostPLE.profilpengguna.core.ProfilPenggunaImpl;
import KostPLE.profilpengguna.ProfilPenggunaFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class PropertiServiceImpl extends PropertiServiceComponent {
    private PropertiFactory propertiFactory = new PropertiFactory();
    
    @Override
    public List<HashMap<String, Object>> saveProperti(Map<String, Object> requestBody) {
        UUID idProperti = UUID.randomUUID();
        String namaProperti = (String) requestBody.get("namaProperti");
        String deskripsiProperti = (String) requestBody.get("deskripsiProperti");
        String lokasiProperti = (String) requestBody.get("lokasiProperti");
        String fotoUrlProperti = (String) requestBody.get("fotoUrlProperti");
        String idProfilPengguna = (String) requestBody.get("idProfilPengguna");

        // Get ProfilPenggunaImpl object from idProfilPengguna
        UUID profilPenggunaId = UUID.fromString(idProfilPengguna);
        // Assuming we have a way to get a ProfilPenggunaImpl from its UUID
        ProfilPenggunaImpl profilPenggunaImpl = new ProfilPenggunaImpl();
        try {
            // Import and use ProfilPengguna repository if available
            // For now, we'll create a fake implementation to avoid further errors
            profilPenggunaImpl.setIdProfil(profilPenggunaId);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).warning("Failed to get ProfilPenggunaImpl: " + e.getMessage());
        }

        Properti properti = propertiFactory.createProperti(
            "KostPLE.properti.core.PropertiImpl",
            idProperti.toString(),
            namaProperti,
            deskripsiProperti,
            lokasiProperti,
            fotoUrlProperti,
            profilPenggunaImpl
        );
        
        Repository.saveObject(properti);
        List<Properti> all = getAllProperti();
        return transformListToHashMap(all);
    }

    @Override
    public HashMap<String, Object> updateProperti(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("idProperti");
        UUID id = UUID.fromString(idStr);
        Properti properti = Repository.getObject(id);
        properti.setNamaProperti((String) requestBody.get("namaProperti"));
        properti.setDeskripsiProperti((String) requestBody.get("deskripsiProperti"));
        properti.setLokasiProperti((String) requestBody.get("lokasiProperti"));
        properti.setFotoUrlProperti((String) requestBody.get("fotoUrlProperti"));
        Repository.updateObject(properti);
        return properti.toHashMap();
    }

    @Override
    public HashMap<String, Object> getPropertiById(int id) {
        Properti properti = Repository.getObject(id);
        return properti.toHashMap();
    }

    @Override
    public HashMap<String, Object> getPropertiById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            Properti properti = Repository.getObject(uuid);
            return properti.toHashMap();
        } catch (IllegalArgumentException e) {
            try {
                int idInt = Integer.parseInt(id);
                return getPropertiById(idInt);
            } catch (NumberFormatException ex) {
                return new HashMap<>();
            }
        }
    }

    public List<Properti> getAllProperti() {
        return Repository.getAllObject("properti_impl");
    }

    @Override
    public List<HashMap<String, Object>> transformListToHashMap(List<Properti> list) {
        List<HashMap<String, Object>> resultList = new ArrayList<>();
        for (Properti properti : list) {
            resultList.add(properti.toHashMap());
        }
        return resultList;
    }

    @Override
    public List<HashMap<String, Object>> deleteProperti(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("idProperti");
        UUID id = UUID.fromString(idStr);
        Repository.deleteObject(id);
        List<Properti> all = getAllProperti();
        return transformListToHashMap(all);
    }

    @Override
    public HashMap<String, Object> getProperti(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("idProperti");
        UUID id = UUID.fromString(idStr);
        Properti properti = Repository.getObject(id);
        if (properti != null) {
            return properti.toHashMap();
        }
        return new HashMap<>();
    }

    @Override
    public Properti createProperti(Map<String, Object> requestBody, Map<String, Object> response) {
        Properti properti = propertiFactory.createProperti(
            "KostPLE.properti.core.PropertiImpl",
            (String) requestBody.get("namaProperti"),
            (String) requestBody.get("deskripsiProperti"),
            (String) requestBody.get("lokasiProperti"),
            (String) requestBody.get("fotoUrlProperti"),
            (String) requestBody.get("idProfilPengguna")
        );
        return properti;
    }

    @Override
    public Properti createProperti(Map<String, Object> requestBody) {
        Properti properti = propertiFactory.createProperti(
            "KostPLE.properti.core.PropertiImpl",
            (String) requestBody.get("namaProperti"),
            (String) requestBody.get("deskripsiProperti"),
            (String) requestBody.get("lokasiProperti"),
            (String) requestBody.get("fotoUrlProperti"),
            (String) requestBody.get("idProfilPengguna")
        );
        return properti;
    }

    @Override
    public Properti saveProperti(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload();
        Properti properti = createProperti(requestBody);
        Repository.saveObject(properti);
        return properti;
    }

    @Override
    public List<HashMap<String, Object>> getAllProperti(Map<String, Object> requestBody) {
        String table = (String) requestBody.get("table_name");
        if (table == null) {
            table = "properti_impl";
        }
        List<Properti> list = Repository.getAllObject(table);
        return transformListToHashMap(list);
    }
}
