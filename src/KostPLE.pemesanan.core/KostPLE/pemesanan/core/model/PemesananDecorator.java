package KostPLE.pemesanan.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PemesananDecorator extends PemesananComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PemesananComponent record;

	public PemesananDecorator () {
		super();
		this.record = record;
		this.idPemesanan =  idPemesanan.randomUUID();
		
	public PemesananDecorator (PemesananComponent record) {
		this.idPemesanan =  idPemesanan.randomUUID();
		this.record = record;
	}

	public PemesananDecorator (int idPemesanan, PemesananComponent record) {
		this.idPemesanan =  idPemesanan;
		this.record = record;
	}
	
	public PemesananDecorator (PemesananComponent record, String objectName) {
		this.idPemesanan =  idPemesanan.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public PemesananDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
