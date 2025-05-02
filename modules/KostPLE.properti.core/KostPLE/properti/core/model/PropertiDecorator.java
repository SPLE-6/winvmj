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
		this.idProperti =  UUID.randomUUID().toString();
	}

	public PropertiDecorator (PropertiComponent record) {
		this.idProperti =  UUID.randomUUID().toString();
		this.record = record;
	}

	public PropertiDecorator (int idProperti, PropertiComponent record) {
		this.idProperti =  idProperti;
		this.record = record;
	}
	
	public PropertiDecorator (PropertiComponent record, String objectName) {
		this.idProperti =  UUID.randomUUID().toString();
		this.record = record;	
		this.objectName=objectName;
	}

	public PropertiDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
