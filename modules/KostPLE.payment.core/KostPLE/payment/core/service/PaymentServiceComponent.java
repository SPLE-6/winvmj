package KostPLE.payment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PaymentServiceComponent implements Service{
	protected RepositoryUtil<Payment> Repository;

    public PaymentServiceComponent(){
        this.Repository = new RepositoryUtil<Payment>(KostPLE.payment.core.PaymentComponent.class);
    }	

    public abstract List<HashMap<String,Object>> save(VMJExchange vmjExchange);
    public abstract Payment createPayment(Map<String, Object> requestBodye);
	public abstract Payment createPayment(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> update(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> get(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAll(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Payment> List);
    public abstract List<HashMap<String,Object>> delete(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getById(int id);

	public abstract void Pay();

	public abstract void Cancel();
}
