package KostPLE.kamar.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class KamarDecorator extends KamarComponent {
	@OneToOne(cascade = CascadeType.ALL)
	protected KamarComponent record;

	public KamarDecorator() {
		super();
		this.record = record;
		this.idKamar = idKamar.randomUUID();
	}

	public KamarDecorator(KamarComponent record) {
		this.idKamar = idKamar.randomUUID();
		this.record = record;
	}

	public KamarDecorator(UUID idKamar, KamarComponent record) {
		this.idKamar = idKamar;
		this.record = record;
	}

	public KamarDecorator(KamarComponent record, String objectName) {
		this.idKamar = idKamar.randomUUID();
		this.record = record;
		this.objectName = objectName;
	}

	public UUID getIdKamar() {
		return record.getIdKamar();
	}

	public void setIdKamar(UUID idKamar) {
		record.setIdKamar(idKamar);
	}

	public boolean getIsAvailable() {
		return record.getIsAvailable();
	}

	public void setIsAvailable(boolean isAvailable) {
		record.setIsAvailable(isAvailable);
	}

	public String getTipeKamar() {
		return record.getTipeKamar();
	}

	public void setTipeKamar(String tipeKamar) {
		record.setTipeKamar(tipeKamar);
	}

	public String getDeskripsiKamar() {
		return record.getDeskripsiKamar();
	}

	public void setDeskripsiKamar(String deskripsiKamar) {
		record.setDeskripsiKamar(deskripsiKamar);
	}

	public String getFotoUrlKamar() {
		return record.getFotoUrlKamar();
	}

	public void setFotoUrlKamar(String fotoUrlKamar) {
		record.setFotoUrlKamar(fotoUrlKamar);
	}

	public Float getHargaKamar() {
		return record.getHargaKamar();
	}

	public void setHargaKamar(Float hargaKamar) {
		record.setHargaKamar(hargaKamar);
	}

	public HashMap<String, Object> toHashMap() {
		return this.record.toHashMap();
	}

}
