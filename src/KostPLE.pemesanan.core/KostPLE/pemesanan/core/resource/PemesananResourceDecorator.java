package KostPLE.pemesanan.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class PemesananResourceDecorator extends PemesananResourceComponent{
	protected PemesananResourceComponent record;

    public PemesananResourceDecorator(PemesananResourceComponent record) {
        this.record = record;
    }

    public HashMap<String, Object> savePemesanan(VMJExchange vmjExchange){
		return record.savePemesanan(vmjExchange);
	}

    public HashMap<String, Object> updatePemesanan(VMJExchange vmjExchange){
		return record.updatePemesanan(vmjExchange);
	}

    public HashMap<String, Object> getPemesanan(VMJExchange vmjExchange){
		return record.getPemesanan(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllPemesanan(VMJExchange vmjExchange){
		return record.getAllPemesanan(vmjExchange);
	}

    public List<HashMap<String,Object>> deletePemesanan(VMJExchange vmjExchange){
		return record.deletePemesanan(vmjExchange);
	}

}
