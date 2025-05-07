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
		this.idPemesanan =  UUID.randomUUID().toString();
	}
	
	public PemesananDecorator (PemesananComponent record) {
		this.idPemesanan =  UUID.randomUUID().toString();
		this.record = record;
	}

	public PemesananDecorator (String idPemesanan, PemesananComponent record) {
		this.idPemesanan =  idPemesanan;
		this.record = record;
	}
	
	public PemesananDecorator (PemesananComponent record, String objectName) {
		this.idPemesanan =  UUID.randomUUID().toString();
		this.record = record;	
		this.objectName=objectName;
	}



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
