package KostPLE.profilpengguna.core;

import java.util.*;
import java.util.Random;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages


@MappedSuperclass
public abstract class ProfilPenggunaDecorator extends ProfilPenggunaComponent{
	
	private static final Random rand = new Random();

    @OneToOne(cascade=CascadeType.ALL)
	protected ProfilPenggunaComponent record;

	public ProfilPenggunaDecorator () {
		super();
		this.record = record;
		this.idProfil =  rand.nextInt(Integer.MAX_VALUE);
	}
	
	public ProfilPenggunaDecorator (ProfilPenggunaComponent record) {
		this.idProfil =  rand.nextInt(Integer.MAX_VALUE);
		this.record = record;
	}

	public ProfilPenggunaDecorator (int idProfil, ProfilPenggunaComponent record) {
		this.idProfil =  idProfil;
		this.record = record;
	}
	
	public ProfilPenggunaDecorator (ProfilPenggunaComponent record, String objectName) {
		this.idProfil =  rand.nextInt(Integer.MAX_VALUE);
		this.record = record;	
		this.objectName=objectName;
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
