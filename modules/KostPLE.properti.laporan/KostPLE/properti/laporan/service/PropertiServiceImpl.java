package KostPLE.properti.laporan.service;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;
import KostPLE.properti.PropertiFactory;
import KostPLE.properti.core.Properti;
import KostPLE.properti.core.PropertiServiceDecorator;
import KostPLE.properti.core.PropertiServiceComponent;
import KostPLE.profilpengguna.core.ProfilPengguna;
import KostPLE.properti.laporan.model.PropertiImpl;
import KostPLE.properti.PropertiFactory;
import KostPLE.properti.core.Properti;
import KostPLE.properti.core.PropertiServiceDecorator;
import KostPLE.properti.core.PropertiServiceComponent;
import KostPLE.profilpengguna.core.ProfilPengguna;
import KostPLE.properti.laporan.model.PropertiImpl;

public class PropertiServiceImpl extends PropertiServiceDecorator {
    private RepositoryUtil<Properti> Repository;
    private PropertiFactory propertiFactory = new PropertiFactory();
    
    public PropertiServiceImpl(PropertiServiceComponent record) {
        super(record);
        this.Repository = new RepositoryUtil<Properti>(KostPLE.properti.core.PropertiComponent.class);
    }
    
    @Override
    public Properti saveProperti(Map<String, Object> requestBody) {
        // Use the base implementation to save core properties
        Properti baseProperti = record.saveProperti(requestBody);
        
        // Extract additional laporan-specific properties
        float pemasukan = 0f;
        float pengeluaran = 0f;
        
        if (requestBody.containsKey("pemasukan")) {
            pemasukan = Float.parseFloat(requestBody.get("pemasukan").toString());
        }
        
        if (requestBody.containsKey("pengeluaran")) {
            pengeluaran = Float.parseFloat(requestBody.get("pengeluaran").toString());
        }
        
        // Create laporan-specific implementation
        PropertiImpl deco = (PropertiImpl) propertiFactory.createProperti(
            "KostPLE.properti.laporan.model.PropertiImpl",
            baseProperti, // Pass the base properti as a decorator
            pemasukan,
            pengeluaran
        );
        
        // Save and return
        Repository.saveObject(deco);
        return deco;
    }
    
    @Override
    public Properti updateProperti(Map<String, Object> requestBody) {
        // Use the base implementation to update core properties
        Properti baseProperti = record.updateProperti(requestBody);
        
        // Get the ID
        String idStr = (String) requestBody.get("idProperti");
        UUID id = UUID.fromString(idStr);
        
        // Extract laporan-specific properties
        float pemasukan = 0f;
        float pengeluaran = 0f;
        
        if (requestBody.containsKey("pemasukan")) {
            pemasukan = Float.parseFloat(requestBody.get("pemasukan").toString());
        }
        
        if (requestBody.containsKey("pengeluaran")) {
            pengeluaran = Float.parseFloat(requestBody.get("pengeluaran").toString());
        }
        
        // Create updated laporan implementation
        PropertiImpl properti = (PropertiImpl) propertiFactory.createProperti(
            "KostPLE.properti.laporan.model.PropertiImpl",
            baseProperti,
            pemasukan,
            pengeluaran
        );
        
        // Save and return
        Repository.updateObject(properti);
        return Repository.getObject(id);
    }
    
    @Override
    public Properti getPropertiById(UUID id) {
        // Delegate to the base implementation to get core properties
        Properti baseProperti = record.getPropertiById(id);
        
        // Try to find the laporan-specific implementation first
        Properti properti = Repository.getObject(id);
        if (properti instanceof PropertiImpl) {
            return properti;
        }
        
        // If not found as a laporan properti, return the base implementation
        return baseProperti;
    }
    
    @Override
    public List<Properti> getAllProperti() {
        // Get all laporan-specific properties
        List<Properti> list = Repository.getAllObject("properti_laporan");
        
        // If no laporan properties are found, delegate to the base implementation
        if (list == null || list.isEmpty()) {
            return record.getAllProperti();
        }
        
        return list;
    }
    
    @Override
    public List<HashMap<String, Object>> transformListToHashMap(List<Properti> list) {
        List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < list.size(); i++) {
            resultList.add(list.get(i).toHashMap());
        }
        return resultList;
    }
    
    @Override
    public List<Properti> deleteProperti(UUID id) {
        // Delete from both repositories to ensure complete removal
        Repository.deleteObject(id);
        return getAllProperti();
    }
}
