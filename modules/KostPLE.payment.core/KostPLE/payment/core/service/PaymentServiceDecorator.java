package KostPLE.payment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class PaymentServiceDecorator extends PaymentServiceComponent{
	protected PaymentServiceComponent record;

    public PaymentServiceDecorator(PaymentServiceComponent record) {
        this.record = record;
    }

	public Payment savePayment(Map<String, Object> requestBody, UUID idPemesanan){
		return record.savePayment(requestBody, idPemesanan);
	}


	public List<Payment> getAllPayment(){
		return record.getAllPayment();
	}


    public Payment updatePayment(Map<String, Object> requestBody){
		return record.updatePayment(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Payment> List){
		return record.transformListToHashMap(List);
	}

    public List<Payment> deletePayment(UUID paymentId){
		return record.deletePayment(paymentId);
	}

	public Payment getPaymentById(UUID id){
        return record.getPaymentById(id);
    }

	public void Pay() {
		// return record.Pay();
	}

	public void Cancel() {
		// return record.Cancel();
	}
}
