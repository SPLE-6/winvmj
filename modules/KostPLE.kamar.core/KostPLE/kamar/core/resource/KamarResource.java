package KostPLE.kamar.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public interface KamarResource {

    HashMap<String, Object> updateKamar(VMJExchange vmjExchange);

    HashMap<String, Object> getKamar(VMJExchange vmjExchange);

    List<HashMap<String, Object>> getAllKamar(VMJExchange vmjExchange);

    List<HashMap<String, Object>> deleteKamar(VMJExchange vmjExchange);

    HashMap<String, Object> saveKamar(VMJExchange vmjExhange);
}
