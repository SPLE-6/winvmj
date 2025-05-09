package KostPLE.properti.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class PropertiResourceDecorator extends PropertiResourceComponent{
	protected PropertiResourceComponent record;

    public PropertiResourceDecorator(PropertiResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveProperti(VMJExchange vmjExchange){
		return record.saveProperti(vmjExchange);
	}

    public Properti createProperti(VMJExchange vmjExchange){
		return record.createProperti(vmjExchange);
	}

    public Properti createProperti(VMJExchange vmjExchange, int id){
		return record.createProperti(vmjExchange, id);
	}

    public HashMap<String, Object> updateProperti(VMJExchange vmjExchange){
		return record.updateProperti(vmjExchange);
	}

    public HashMap<String, Object> getProperti(VMJExchange vmjExchange){
		return record.getProperti(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllProperti(VMJExchange vmjExchange){
		return record.getAllProperti(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteProperti(VMJExchange vmjExchange){
		return record.deleteProperti(vmjExchange);
	}

}
