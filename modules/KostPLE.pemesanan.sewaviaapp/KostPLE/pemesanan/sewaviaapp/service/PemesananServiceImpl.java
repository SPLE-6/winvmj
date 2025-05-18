package KostPLE.pemesanan.sewaviaapp;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import KostPLE.pemesanan.core.PemesananServiceDecorator;
import KostPLE.pemesanan.sewaviaapp.PemesananImpl;
import KostPLE.pemesanan.core.PemesananServiceComponent;
import KostPLE.pemesanan.core.Pemesanan;

public class PemesananServiceImpl extends PemesananServiceDecorator {
    private PemesananServiceComponent record;
    private RepositoryUtil<Pemesanan> Repository;
    
    public PemesananServiceImpl (PemesananServiceComponent record) {
        super(record);
        this.record = record;
        this.Repository = new RepositoryUtil<Pemesanan>(KostPLE.pemesanan.core.PemesananComponent.class);
    }

    
	public void sumTotal() {
		// Get all pemesanan records from repository
		List<Pemesanan> allPemesanan = Repository.getAllObject("pemesanan_sewaviaapp");
		
		// Calculate total payments for all pemesanan considering down payments
		for (Pemesanan pemesanan : allPemesanan) {
			if (pemesanan instanceof PemesananImpl) {
				// Call the sumTotal method on each pemesanan
				((PemesananImpl) pemesanan).sumTotal();
				
				// Update the pemesanan in the repository
				Repository.updateObject(pemesanan);
			}
		}
	}

	public void addNewPesanan() {
		// Create a new pemesanan specific to sewaviaapp
		PemesananImpl newPemesanan = new PemesananImpl();
		
		// Initialize with default values
		newPemesanan.addNewPesanan();
		
		// Set a default down payment of 0
		newPemesanan.setDownPayment(0f);
		
		// Save the new pemesanan to repository
		Repository.saveObject(newPemesanan);
	}
	
	// Add additional methods that might be needed for the sewaviaapp module
	@Override
    public Pemesanan updatePemesanan(Map<String, Object> requestBody) {
        // Call the base implementation first
        Pemesanan pemesanan = record.updatePemesanan(requestBody);
        
        // Update downPayment if provided
        if (requestBody.get("downPayment") != null) {
            Float downPayment = Float.parseFloat(requestBody.get("downPayment").toString());
            
            // If pemesanan is already a PemesananImpl, just update the downPayment
            if (pemesanan instanceof PemesananImpl) {
                ((PemesananImpl) pemesanan).setDownPayment(downPayment);
            } 
            // Otherwise, create a decorated pemesanan
            else if (pemesanan instanceof KostPLE.pemesanan.core.PemesananComponent) {
                pemesanan = new PemesananImpl(
                    (KostPLE.pemesanan.core.PemesananComponent)pemesanan, 
                    downPayment
                );
            }
            
            Repository.updateObject(pemesanan);
        }
        
        return pemesanan;
    }


	@Override
    public Pemesanan savePemesanan(Map<String, Object> requestBody, Map<String, Object> response) {
        // Call the existing implementation and return its result
        Pemesanan pemesanan = record.savePemesanan(requestBody);
        
        // Add downPayment for the sewaviaapp module
        if (requestBody.get("downPayment") != null) {
            Float downPayment = Float.parseFloat(requestBody.get("downPayment").toString());
            
            // Create a decorated pemesanan with downPayment
            if (pemesanan instanceof KostPLE.pemesanan.core.PemesananComponent) {
                pemesanan = new PemesananImpl(
                    (KostPLE.pemesanan.core.PemesananComponent)pemesanan, 
                    downPayment
                );
                Repository.updateObject(pemesanan);
            }
        }
        
        // Add any additional processing with the response map if needed
        if (response != null) {
            response.put("success", true);
            response.put("message", "Pemesanan created successfully via sewaviaapp");
            response.put("pemesanan", pemesanan.toHashMap());
        }
        
        return pemesanan;
    }

    @Override
    public Pemesanan savePemesanan(Map<String, Object> requestBody) {
        // Delegate to the base implementation first
        Pemesanan pemesanan = record.savePemesanan(requestBody);
        
        // Add downPayment for the sewaviaapp module
        if (requestBody.get("downPayment") != null) {
            Float downPayment = Float.parseFloat(requestBody.get("downPayment").toString());
            
            // Create a decorated pemesanan with downPayment
            if (pemesanan instanceof KostPLE.pemesanan.core.PemesananComponent) {
                pemesanan = new PemesananImpl(
                    (KostPLE.pemesanan.core.PemesananComponent)pemesanan, 
                    downPayment
                );
                Repository.updateObject(pemesanan);
            }
        }
        
        return pemesanan;
    }
}
