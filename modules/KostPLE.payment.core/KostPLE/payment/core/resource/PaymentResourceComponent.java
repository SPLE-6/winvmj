package KostPLE.payment.core.resource;
import java.util.*;

import KostPLE.payment.core.model.Payment;
import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PaymentResourceComponent implements PaymentResource{
	
	public PaymentResourceComponent() { }
 
    public abstract Payment create(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> update(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> get(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAll(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> delete(VMJExchange vmjExchange);

	public abstract void Pay();

	public abstract void Cancel();
}