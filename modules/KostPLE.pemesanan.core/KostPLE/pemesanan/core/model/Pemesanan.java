package KostPLE.pemesanan.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import KostPLE.kamar.core.KamarImpl;
import KostPLE.profilpengguna.core.ProfilPenggunaImpl;

public interface Pemesanan {
	public String getIdPemesanan();
	public void setIdPemesanan(int idPemesanan);
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
	public KamarImpl getKamarImpl();
	public void setKamarImpl(KamarImpl kamarimpl);
	public ProfilPenggunaImpl getProfilPenggunaImpl();
	public void setProfilpenggunaimpl(ProfilPenggunaImpl profilpenggunaimpl);
	HashMap<String, Object> toHashMap();
}
