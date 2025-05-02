package KostPLE.kamar.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Kamar {
	public String getIdKamar();
	public void setIdKamar(int idKamar);
	public boolean getIsAvailable();
	public void setIsAvailable(boolean isAvailable);
	public String getTipeKamar();
	public void setTipeKamar(String tipeKamar);
	public String getDeskripsiKamar();
	public void setDeskripsiKamar(String deskripsiKamar);
	public String getProperty6();
	public void setProperty6(String Property6);
	public EFloat getProperty7();
	public void setProperty7(EFloat Property7);
	public PropertiImpl getPropertiimpl();
	public void setPropertiimpl(PropertiImpl propertiimpl);
	HashMap<String, Object> toHashMap();
}
