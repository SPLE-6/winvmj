package KostPLE.pemesanan.informasitagihan;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import KostPLE.pemesanan.core.PemesananDecorator;
import KostPLE.pemesanan.core.Pemesanan;
import KostPLE.pemesanan.core.PemesananComponent;

@Entity(name="pemesanan_informasitagihan")
@Table(name="pemesanan_informasitagihan")
public class PemesananImpl extends PemesananDecorator {

	public PemesananImpl(
        super();
        this.objectName = PemesananImpl.class.getName();
    }
    
    public PemesananImpl() {
    	super();
		this.objectName = PemesananImpl.class.getName();
    }
	
	public PemesananImpl(PemesananComponent record, ) {
		super(record);
		this.objectName = PemesananImpl.class.getName();
	}


	public void ShowAllTagihan() {
		// TODO: implement this method
	}

	public void ShowTagihanDetail() {
		// TODO: implement this method
	}

	public void PayTagihan() {
		// TODO: implement this method
	}

}
