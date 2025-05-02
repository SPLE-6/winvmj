package KostPLE.pemesanan.sewaviaapp;

import java.util.*;

import vmj.routing.route.VMJExchange;

import KostPLE.pemesanan.core.PemesananServiceDecorator;
import KostPLE.pemesanan.core.PemesananImpl;
import KostPLE.pemesanan.core.PemesananServiceComponent;

public class PemesananServiceImpl extends PemesananServiceDecorator {
    public PemesananServiceImpl (PemesananServiceComponent record) {
        super(record);
    }

    
	public void sumTotal() {
		// TODO: implement this method
	}

	public void addNewPesanan() {
		// TODO: implement this method
	}
}
