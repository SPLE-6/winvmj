package KostPLE.payment.paymentkredit;

import java.util.*;

import vmj.routing.route.VMJExchange;
import KostPLE.payment.core.Payment;
import KostPLE.payment.core.PaymentServiceDecorator;
import KostPLE.payment.core.PaymentImpl;
import KostPLE.payment.core.PaymentServiceComponent;

public class PaymentServiceImpl extends PaymentServiceDecorator {
    public PaymentServiceImpl (PaymentServiceComponent record) {
        super(record);
    }

    
	public void Pay() {
		// TODO: implement this method
	}


    @Override
    public Payment createPayment(Map<String, Object> requestBody) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPayment'");
    }


    @Override
    public Payment createPayment(Map<String, Object> requestBody, Map<String, Object> response) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPayment'");
    }


    @Override
    public HashMap<String, Object> getPayment(Map<String, Object> requestBody) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPayment'");
    }


    @Override
    public List<HashMap<String, Object>> savePayment(Map<String, Object> requestBody) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'savePayment'");
    }


    @Override
    public HashMap<String, Object> updatePayment(Map<String, Object> requestBody) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePayment'");
    }


    @Override
    public HashMap<String, Object> getPaymentById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentById'");
    }


    @Override
    public List<HashMap<String, Object>> getAllPayment(Map<String, Object> requestBody) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPayment'");
    }


    @Override
    public List<HashMap<String, Object>> deletePayment(Map<String, Object> requestBody) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePayment'");
    }
}
