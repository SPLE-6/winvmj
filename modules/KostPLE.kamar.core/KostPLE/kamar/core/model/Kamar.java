package KostPLE.kamar.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;
import KostPLE.properti.core.Properti;

public interface Kamar {
	public UUID getIdKamar();

	public void setIdKamar(UUID idKamar);

	public boolean getIsAvailable();

	public void setIsAvailable(boolean isAvailable);

	public String getTipeKamar();

	public void setTipeKamar(String tipeKamar);

	public String getDeskripsiKamar();

	public void setDeskripsiKamar(String deskripsiKamar);

	public String getFotoUrlKamar();

	public void setFotoUrlKamar(String fotoUrlKamar);

	public Float getHargaKamar();

	public void setHargaKamar(Float hargaKamar);

	public Properti getProperti();

	public void setProperti(Properti properti);

	HashMap<String, Object> toHashMap();
}
