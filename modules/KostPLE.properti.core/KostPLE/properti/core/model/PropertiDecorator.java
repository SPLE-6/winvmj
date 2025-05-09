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
    
	public PropertiDecorator (UUID idProperti, PropertiComponent record) {
		this.idProperti =  idProperti;
		this.record = record;
	}

	public PropertiDecorator () {
		super();
		this.record = record;
		this.idProperti =  UUID.randomUUID();
	}

	public PropertiDecorator (PropertiComponent record) {
		this.idProperti =  UUID.randomUUID();
		this.record = record;
	}
	
	public PropertiDecorator (PropertiComponent record, String objectName) {
		this.idProperti =  UUID.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}
	
//	public UUID getIdProperti() {
//		return this.idProperti;
//	}
//	public void setIdProperti(int idProperti) {
//		this.idProperti = idProperti;
//	}
//	
//	public String getNamaProperti() {
//		return this.namaProperti;
//	}
//	public void setNamaProperti(String namaProperti) {
//		this.namaProperti = namaProperti;
//	}
//	
//	public String getDeskripsiProperti() {
//		
//	}
//	
//	public void setDeskripsiProperti(String deskripsiProperti);
//	
//	public String getLokasiProperti();
//	public void setLokasiProperti(String lokasiProperti);
//	
//	public String getFotoUrlProperti();
//	public void setFotoUrlProperti(String fotoUrlProperti);
//	
//	public ProfilPengguna getProfilPengguna();
//	public void setProfilPengguna(ProfilPengguna profilPengguna);



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
