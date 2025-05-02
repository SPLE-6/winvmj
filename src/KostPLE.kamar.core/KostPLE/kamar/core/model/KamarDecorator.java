package KostPLE.kamar.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class KamarDecorator extends KamarComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected KamarComponent record;

	public KamarDecorator () {
		super();
		this.record = record;
		this.idKamar =  idKamar.randomUUID();
		
	public KamarDecorator (KamarComponent record) {
		this.idKamar =  idKamar.randomUUID();
		this.record = record;
	}

	public KamarDecorator (int idKamar, KamarComponent record) {
		this.idKamar =  idKamar;
		this.record = record;
	}
	
	public KamarDecorator (KamarComponent record, String objectName) {
		this.idKamar =  idKamar.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public KamarDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
