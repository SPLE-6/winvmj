package KostPLE.pemesanan.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import KostPLE.kamar.core.Kamar;
import KostPLE.profilpengguna.core.ProfilPengguna;


public interface Pemesanan {
	public UUID getIdPemesanan();
	public void setIdPemesanan(UUID idPemesanan);
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public Float getTotalPay();
	public void setTotalPay(Float totalPay);
	public String getStatusPemesanan();
	public void setStatusPemesanan(String statusPemesanan);
	public String getDetail();
	public void setDetail(String detail);
	public Date getCreatedAt();
	public void setCreatedAt(Date createdAt);
	public Kamar getKamar();
	public void setKamar(Kamar kamar);
	public ProfilPengguna getProfilPengguna();
	public void setProfilPengguna(ProfilPengguna profilPengguna);
	HashMap<String, Object> toHashMap();
}
