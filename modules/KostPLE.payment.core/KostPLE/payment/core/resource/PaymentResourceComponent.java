package KostPLE.payment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PaymentResourceComponent implements Resource{
	
	public PaymentResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> save(VMJExchange vmjExchange);
    public abstract Payemnt createPayment(VMJExchange vmjExchange);
	public abstract Payment createPayment(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> update(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> get(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAll(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> delete(VMJExchange vmjExchange);

	public abstract void Pay();

	public abstract void Cancel();
}
