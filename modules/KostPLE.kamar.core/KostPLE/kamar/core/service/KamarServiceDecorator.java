package KostPLE.kamar.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class KamarServiceDecorator extends KamarServiceComponent {
	protected KamarServiceComponent record;

	public KamarServiceDecorator(KamarServiceComponent record) {
		this.record = record;
	}

	public Kamar saveKamar(Map<String, Object> requestBody) {
		return record.saveKamar(requestBody);
	}

	public List<Kamar> getAllKamar() {
		return record.getAllKamar();
	}

	public Kamar updateKamar(Map<String, Object> requestBody) {
		return record.updateKamar(requestBody);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Kamar> kamarList) {
		return record.transformListToHashMap(kamarList);
	}

	public List<Kamar> deleteKamar(UUID kamarId) {
		return record.deleteKamar(kamarId);
	}

	public Kamar getKamarById(UUID id) {
		return record.getKamarById(id);
	}

}
