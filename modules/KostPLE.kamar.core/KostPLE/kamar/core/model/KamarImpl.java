package KostPLE.kamar.core;

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


@Entity(name="kamar_impl")
@Table(name="kamar_impl")
public class KamarImpl extends KamarComponent {

	public KamarImpl(int idKamar, boolean isAvailable, String tipeKamar, String deskripsiKamar, String Property6, EFloat Property7, PropertiImpl propertiimpl) {
		this.idKamar = idKamar;
		this.isAvailable = isAvailable;
		this.tipeKamar = tipeKamar;
		this.deskripsiKamar = deskripsiKamar;
		this.Property6 = Property6;
		this.Property7 = Property7;
		this.propertiimpl = propertiimpl;
	}

	public KamarImpl(boolean isAvailable, String tipeKamar, String deskripsiKamar, String Property6, EFloat Property7, PropertiImpl propertiimpl) {
		this.idKamar =  idKamar.randomUUID();;
		this.isAvailable = isAvailable;
		this.tipeKamar = tipeKamar;
		this.deskripsiKamar = deskripsiKamar;
		this.Property6 = Property6;
		this.Property7 = Property7;
		this.propertiimpl = propertiimpl;
	}

	public KamarImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> kamarMap = new HashMap<String,Object>();
		kamarMap.put("idKamar",getIdKamar());
		kamarMap.put("isAvailable",getIsAvailable());
		kamarMap.put("tipeKamar",getTipeKamar());
		kamarMap.put("deskripsiKamar",getDeskripsiKamar());
		kamarMap.put("Property6",getProperty6());
		kamarMap.put("Property7",getProperty7());
		kamarMap.put("propertiimpl",getPropertiimpl());

        return kamarMap;
    }

}
