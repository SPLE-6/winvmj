package KostPLE.payment.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Payment {
	public int getIdPayment();
	public void setIdPayment(int idPayment);
	public EFloat getAmount();
	public void setAmount(EFloat amount);
	public boolean getStatus();
	public void setStatus(boolean status);
	public EDate getCreatedAt();
	public void setCreatedAt(EDate createdAt);
	public PemesananImpl getPemesananimpl();
	public void setPemesananimpl(PemesananImpl pemesananimpl);
	public void Pay();
	public void Cancel();
	HashMap<String, Object> toHashMap();
}
