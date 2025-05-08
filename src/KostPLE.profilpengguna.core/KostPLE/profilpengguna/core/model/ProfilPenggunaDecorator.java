package KostPLE.profilpengguna.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ProfilPenggunaDecorator extends ProfilPenggunaComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ProfilPenggunaComponent record;

	public ProfilPenggunaDecorator () {
		super();
		this.record = record;
		this.idProfil =  UUID.randomUUID().toString();
	}
	public ProfilPenggunaDecorator (ProfilPenggunaComponent record) {
		this.idProfil =  UUID.randomUUID().toString();
		this.record = record;
	}

	public ProfilPenggunaDecorator (String idProfil, ProfilPenggunaComponent record) {
		this.idProfil =  idProfil;
		this.record = record;
	}
	
	public ProfilPenggunaDecorator (ProfilPenggunaComponent record, String objectName) {
		this.idProfil =  UUID.randomUUID().toString();
		this.record = record;	
		this.objectName=objectName;
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
