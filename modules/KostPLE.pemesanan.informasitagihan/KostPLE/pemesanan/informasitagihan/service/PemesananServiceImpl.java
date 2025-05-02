package KostPLE.pemesanan.informasitagihan;

import java.util.*;

import vmj.routing.route.VMJExchange;

import KostPLE.pemesanan.core.PemesananServiceDecorator;
import KostPLE.pemesanan.core.PemesananImpl;
import KostPLE.pemesanan.core.PemesananServiceComponent;

public class PemesananServiceImpl extends PemesananServiceDecorator {
    public PemesananServiceImpl (PemesananServiceComponent record) {
        super(record);
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
