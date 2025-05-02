package KostPLE.pemesanan.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PememesanDecorator extends PememesanComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PememesanComponent record;

	public PememesanDecorator () {
		super();
		this.record = record;
		this.idPemesanan =  idPemesanan.randomUUID();
		
	public PememesanDecorator (PememesanComponent record) {
		this.idPemesanan =  idPemesanan.randomUUID();
		this.record = record;
	}

	public PememesanDecorator (int idPemesanan, PememesanComponent record) {
		this.idPemesanan =  idPemesanan;
		this.record = record;
	}
	
	public PememesanDecorator (PememesanComponent record, String objectName) {
		this.idPemesanan =  idPemesanan.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public PememesanDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
