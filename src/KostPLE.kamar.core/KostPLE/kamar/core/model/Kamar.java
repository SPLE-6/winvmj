package KostPLE.kamar.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import KostPLE.properti.core.Properti;
import KostPLE.properti.core.PropertiImpl;


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
	public Float getProperty7();
	public void setProperty7(Float Property7);
	public Properti getPropertiImpl();
	public void setPropertiImpl(PropertiImpl propertiimpl);
	HashMap<String, Object> toHashMap();
}
