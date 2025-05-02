package KostPLE.properti.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PropertiResource {
    List<HashMap<String,Object>> saveProperti(VMJExchange vmjExchange);
    HashMap<String, Object> updateProperti(VMJExchange vmjExchange);
    HashMap<String, Object> getProperti(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllProperti(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteProperti(VMJExchange vmjExchange);
	HashMap<String, Object> Properti(VMJExchange vmjExhange);
}
