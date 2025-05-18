package KostPLE.payment.core.service;
import java.util.*;

import KostPLE.payment.core.model.Payment;
import KostPLE.payment.core.model.PaymentComponent;
import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PaymentServiceComponent implements PaymentService{
	protected RepositoryUtil<Payment> Repository;

    public PaymentServiceComponent(){
        this.Repository = new RepositoryUtil<>(PaymentComponent.class);
    }	

    public abstract Payment save(VMJExchange vmjExchange);
    public abstract Payment create(Map<String, Object> requestBody);
	public abstract Payment create(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> update(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> get(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAll(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Payment> List);
    public abstract List<HashMap<String,Object>> delete(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getById(int id);

	public abstract void Pay();

	public abstract void Cancel();
}