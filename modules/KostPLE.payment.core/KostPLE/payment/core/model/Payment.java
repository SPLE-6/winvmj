package KostPLE.payment.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import KostPLE.pemesanan.core.Pemesanan;

public interface Payment {
	public UUID getIdPayment();
	public void setIdPayment(UUID idPayment);
	public boolean getStatus();
	public void setStatus(boolean status);
	public Date getCreatedAt();
	public void setCreatedAt(Date createdAt);
	public Pemesanan getPemesanan();
	public void setPemesanan(Pemesanan pemesanan);
	public void Pay();
	public void Cancel();
	HashMap<String, Object> toHashMap();
}
