package KostPLE.kamar.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class KamarResourceDecorator extends KamarResourceComponent {
	protected KamarResourceComponent record;

	public KamarResourceDecorator(KamarResourceComponent record) {
		this.record = record;
	}

	public HashMap<String, Object> saveKamar(VMJExchange vmjExchange) {
		return record.saveKamar(vmjExchange);
	}

	public HashMap<String, Object> updateKamar(VMJExchange vmjExchange) {
		return record.updateKamar(vmjExchange);
	}
	
    public HashMap<String, Object> updateStatusKamar(VMJExchange vmjExchange){
    	return record.updateStatusKamar(vmjExchange);
    }


	public HashMap<String, Object> getKamar(VMJExchange vmjExchange) {
		return record.getKamar(vmjExchange);
	}

	public List<HashMap<String, Object>> getAllKamar(VMJExchange vmjExchange) {
		return record.getAllKamar(vmjExchange);
	}

	public List<HashMap<String, Object>> deleteKamar(VMJExchange vmjExchange) {
		return record.deleteKamar(vmjExchange);
	}

}
