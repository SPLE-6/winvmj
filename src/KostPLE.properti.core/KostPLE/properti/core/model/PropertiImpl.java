package KostPLE.properti.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="properti_impl")
@Table(name="properti_impl")
public class PropertiImpl extends PropertiComponent {

	public PropertiImpl(int idProperti, String namaProperti, String deskripsiProperti, String lokasiProperti, String fotoUrlProperti, ProfilPenggunaImpl profilpenggunaimpl) {
		this.idProperti = idProperti;
		this.namaProperti = namaProperti;
		this.deskripsiProperti = deskripsiProperti;
		this.lokasiProperti = lokasiProperti;
		this.fotoUrlProperti = fotoUrlProperti;
		this.profilpenggunaimpl = profilpenggunaimpl;
	}

	public PropertiImpl(String namaProperti, String deskripsiProperti, String lokasiProperti, String fotoUrlProperti, ProfilPenggunaImpl profilpenggunaimpl) {
		this.idProperti =  idProperti.randomUUID();;
		this.namaProperti = namaProperti;
		this.deskripsiProperti = deskripsiProperti;
		this.lokasiProperti = lokasiProperti;
		this.fotoUrlProperti = fotoUrlProperti;
		this.profilpenggunaimpl = profilpenggunaimpl;
	}

	public PropertiImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> propertiMap = new HashMap<String,Object>();
		propertiMap.put("idProperti",getIdProperti());
		propertiMap.put("namaProperti",getNamaProperti());
		propertiMap.put("deskripsiProperti",getDeskripsiProperti());
		propertiMap.put("lokasiProperti",getLokasiProperti());
		propertiMap.put("fotoUrlProperti",getFotoUrlProperti());
		propertiMap.put("profilpenggunaimpl",getProfilpenggunaimpl());

        return propertiMap;
    }

}
