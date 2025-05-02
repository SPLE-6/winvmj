package KostPLE.pemesanan.sewaviaapp;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import KostPLE.pemesanan.core.PemesananDecorator;
import KostPLE.pemesanan.core.Pemesanan;
import KostPLE.pemesanan.core.PemesananComponent;

@Entity(name="pemesanan_sewaviaapp")
@Table(name="pemesanan_sewaviaapp")
public class PemesananImpl extends PemesananDecorator {

	public EFloat downPayment;
	public PemesananImpl() {
        super();
    }
    
    public PemesananImpl(EFloat downPayment) {
    	super();
		this.downPayment = downPayment;
    }
	
	public PemesananImpl(PemesananComponent record, EFloat downPayment) {
		super(record);
		this.downPayment = downPayment;
	}


	public void sumTotal() {
		// TODO: implement this method
	}

	public void addNewPesanan() {
		// TODO: implement this method
	}

}
