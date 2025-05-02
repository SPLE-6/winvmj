package KostPLE.payment.core;
import java.util.*;

import KostPLE.payment.core.PaymentImpl;
import vmj.routing.route.VMJExchange;

public abstract class PaymentServiceDecorator extends PaymentServiceComponent{
	protected PaymentServiceComponent record;

    public PaymentServiceDecorator(PaymentServiceComponent record) {
        this.record = record;
    }

	public PaymentImpl create(Map<String, Object> requestBody){
		return record.create(requestBody);
	}

    public PaymentImpl create(Map<String, Object> requestBody, Map<String, Object> response){
		record.create(requestBody, response);
	}

	public HashMap<String, Object> get(Map<String, Object> requestBody){
		return record.get(requestBody);
	}

	public List<HashMap<String,Object>> getAll(Map<String, Object> requestBody){
		return record.getAll(requestBody);
	}

    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		return record.save(vmjExchange);
	}

    public HashMap<String, Object> update(Map<String, Object> requestBody){
		return record.update(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Payment> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> delete(Map<String, Object> requestBody){
		return record.delete(requestBody);
	}

	public HashMap<String, Object> getById(int id){
        return record.getById(id);
    }

	public void Pay() {
		return record.Pay();
	}

	public void Cancel() {
		return record.Cancel();
	}
}
