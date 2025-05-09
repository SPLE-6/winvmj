package KostPLE.properti.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PropertiDecorator extends PropertiComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PropertiComponent record;

	public PropertiDecorator () {
		super();
		this.record = record;
		this.idProperti =  idProperti.randomUUID();
	}
	
	public PropertiDecorator (PropertiComponent record) {
		this.idProperti =  idProperti.randomUUID();
		this.record = record;
	}

	public PropertiDecorator (UUID idProperti, PropertiComponent record) {
		this.idProperti =  idProperti;
		this.record = record;
	}
	
	public PropertiDecorator (PropertiComponent record, String objectName) {
		this.idProperti =  idProperti.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}


	public UUID getIdProperti() {
		return record.getIdProperti();
	}
	public void setIdProperti(UUID idProperti) {
		record.setIdProperti(idProperti);
	}
	public String getNamaProperti() {
		return record.getNamaProperti();
	}
	public void setNamaProperti(String namaProperti) {
		record.setNamaProperti(namaProperti);
	}
	public String getDeskripsiProperti() {
		return record.getDeskripsiProperti();
	}
	public void setDeskripsiProperti(String deskripsiProperti) {
		record.setDeskripsiProperti(deskripsiProperti);
	}
	public String getLokasiProperti() {
		return record.getLokasiProperti();
	}
	public void setLokasiProperti(String lokasiProperti) {
		record.setLokasiProperti(lokasiProperti);
	}
	public String getFotoUrlProperti() {
		return record.getFotoUrlProperti();
	}
	public void setFotoUrlProperti(String fotoUrlProperti) {
		record.setFotoUrlProperti(fotoUrlProperti);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
