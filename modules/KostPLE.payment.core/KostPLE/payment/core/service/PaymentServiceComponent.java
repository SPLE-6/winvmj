package KostPLE.payment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PaymentServiceComponent implements PaymentService{
	protected RepositoryUtil<Payment> Repository;

    public PaymentServiceComponent(){
        this.Repository = new RepositoryUtil<Payment>(KostPLE.payment.core.PaymentComponent.class);
    }	

    public abstract Payment savePayment(Map<String, Object> requestBody, UUID idPemesanan);
	public abstract Payment updatePayment(Map<String, Object> requestBody);
	public abstract Payment getPaymentById(UUID id);
	public abstract List<Payment> getAllPayment();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Payment> List);
    public abstract List<Payment> deletePayment(UUID id);

	public abstract void Pay();

	public abstract void Cancel();
}
