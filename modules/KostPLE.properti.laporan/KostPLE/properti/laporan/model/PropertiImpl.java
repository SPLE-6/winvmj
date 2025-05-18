package KostPLE.properti.laporan.model;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import KostPLE.properti.core.PropertiDecorator;
import KostPLE.properti.core.Properti;
import KostPLE.properti.core.PropertiComponent;
import KostPLE.profilpengguna.core.ProfilPengguna;

@Entity(name="properti_laporan")
@Table(name="properti_laporan")
public class PropertiImpl extends PropertiDecorator {

	@Column(name = "pemasukan")
	public float pemasukan;
	
	@Column(name = "pengeluaran")
	public float pengeluaran;
	
	public PropertiImpl() {
        super();
    }
    
    public PropertiImpl(float pemasukan, float pengeluaran) {
    	super();
		this.pemasukan = pemasukan;
		this.pengeluaran = pengeluaran;
    }
	
	public PropertiImpl(PropertiComponent record, float pemasukan, float pengeluaran) {
		super(record);
		this.pemasukan = pemasukan;
		this.pengeluaran = pengeluaran;
	}
	
	// Getters and setters for the new fields
	public float getPemasukan() {
		return this.pemasukan;
	}
	
	public void setPemasukan(float pemasukan) {
		this.pemasukan = pemasukan;
	}
	
	public float getPengeluaran() {
		return this.pengeluaran;
	}
	
	public void setPengeluaran(float pengeluaran) {
		this.pengeluaran = pengeluaran;
	}
	
	// Override toHashMap to include laporan-specific fields
	@Override
	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> map = super.toHashMap();
		map.put("pemasukan", this.pemasukan);
		map.put("pengeluaran", this.pengeluaran);
		return map;
	}
	
	// Override required abstract methods from PropertiComponent
	@Override
	public UUID getIdProperti() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getIdProperti();
		}
		return this.idProperti;
	}
	
	@Override
	public void setIdProperti(UUID idProperti) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setIdProperti(idProperti);
		} else {
			this.idProperti = idProperti;
		}
	}
	
	@Override
	public String getNamaProperti() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getNamaProperti();
		}
		return null;
	}
	
	@Override
	public void setNamaProperti(String namaProperti) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setNamaProperti(namaProperti);
		}
	}
	
	@Override
	public String getDeskripsiProperti() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getDeskripsiProperti();
		}
		return null;
	}
	
	@Override
	public void setDeskripsiProperti(String deskripsiProperti) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setDeskripsiProperti(deskripsiProperti);
		}
	}
	
	@Override
	public String getLokasiProperti() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getLokasiProperti();
		}
		return null;
	}
	
	@Override
	public void setLokasiProperti(String lokasiProperti) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setLokasiProperti(lokasiProperti);
		}
	}
	
	@Override
	public String getFotoUrlProperti() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getFotoUrlProperti();
		}
		return null;
	}
	
	@Override
	public void setFotoUrlProperti(String fotoUrlProperti) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setFotoUrlProperti(fotoUrlProperti);
		}
	}
	
	@Override
	public ProfilPengguna getProfilPengguna() {
		// Delegate to the decorated instance
		if (record != null) {
			return record.getProfilPengguna();
		}
		return null;
	}
	
	@Override
	public void setProfilPengguna(ProfilPengguna profilPengguna) {
		// Delegate to the decorated instance
		if (record != null) {
			record.setProfilPengguna(profilPengguna);
		}
	}
}
