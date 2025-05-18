package KostPLE.payment.core.model;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import KostPLE.pemesanan.core.PemesananImpl;

public interface Payment {
	public String getIdPayment();
	public void setIdPayment(String idPayment);
	public Float getAmount();
	public void setAmount(Float amount);
	public boolean getStatus();
	public void setStatus(boolean status);
	public Date getCreatedAt();
	public void setCreatedAt(Date createdAt);
	public PemesananImpl getPemesananimpl();
	public void setPemesananimpl(PemesananImpl pemesananimpl);
	public void Pay();
	public void Cancel();
	HashMap<String, Object> toHashMap();
}