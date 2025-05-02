package KostPLE.profilpengguna.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface ProfilPengguna {
	public int getIdProfil();
	public void setIdProfil(int idProfil);
	public String getFullName();
	public void setFullName(String fullName);
	public String getEmail();
	public void setEmail(String email);
	public boolean getJenisKelamin();
	public void setJenisKelamin(boolean jenisKelamin);
	public String getPekerjaan();
	public void setPekerjaan(String pekerjaan);
	public String getKotaAsal();
	public void setKotaAsal(String kotaAsal);
	public String getStatusPernikahan();
	public void setStatusPernikahan(String statusPernikahan);
	public String getPendidikanTerakhir();
	public void setPendidikanTerakhir(String pendidikanTerakhir);
	public int getKontakDarurat();
	public void setKontakDarurat(int kontakDarurat);
	public String getFotoUrlProfil();
	public void setFotoUrlProfil(String fotoUrlProfil);
	public int getNoHP();
	public void setNoHP(int noHP);
	HashMap<String, Object> toHashMap();
}
