package KostPLE.properti.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import KostPLE.profilpengguna.core.ProfilPengguna;

public interface Properti {
	public UUID getIdProperti();
	public void setIdProperti(UUID idProperti);
	public String getNamaProperti();
	public void setNamaProperti(String namaProperti);
	public String getDeskripsiProperti();
	public void setDeskripsiProperti(String deskripsiProperti);
	public String getLokasiProperti();
	public void setLokasiProperti(String lokasiProperti);
	public String getFotoUrlProperti();
	public void setFotoUrlProperti(String fotoUrlProperti);
	public ProfilPengguna getProfilPengguna();
	public void setProfilPengguna(ProfilPengguna profilpenggunaimpl);
	HashMap<String, Object> toHashMap();
}
