package KostPLE.properti.laporan;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import KostPLE.properti.core.PropertiDecorator;
import KostPLE.properti.core.Properti;
import KostPLE.properti.core.PropertiComponent;

@Entity(name="properti_laporan")
@Table(name="properti_laporan")
public class PropertiImpl extends PropertiDecorator {

	public EFloat pemasukan;
	public EFloat pengeluaran;
	public PropertiImpl(
        super();
        this.objectName = PropertiImpl.class.getName();
    }
    
    public PropertiImpl(EFloat pemasukan, EFloat pengeluaran) {
    	super();
		this.pemasukan = pemasukan;
		this.pengeluaran = pengeluaran;
		this.objectName = PropertiImpl.class.getName();
    }
	
	public PropertiImpl(PropertiComponent record, EFloat pemasukan, EFloat pengeluaran) {
		super(record);
		this.pemasukan = pemasukan;
		this.pengeluaran = pengeluaran;
		this.objectName = PropertiImpl.class.getName();
	}



}
