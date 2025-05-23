package KostPLE.payment.paymentkredit;

import java.util.*;

import vmj.routing.route.VMJExchange;
import KostPLE.payment.core.*;
import KostPLE.payment.paymentkredit.PaymentImpl;
import KostPLE.payment.PaymentFactory;

public class PaymentServiceImpl extends PaymentServiceDecorator {
	
    public PaymentServiceImpl (PaymentServiceComponent record) {
        super(record);
    }

    
	public void Pay() {
		// TODO: implement this method
	}


    @Override
    public Payment savePayment(Map<String, Object> requestBody) {
        int accountNumber = ((Double) requestBody.get("accountNumber")).intValue();;
        String provider = (String) requestBody.get("provider");
        String cvv = (String) requestBody.get("cvv");
        Payment payment = record.savePayment(requestBody);
        Payment paymentKredit = PaymentFactory.createPayment(
        		"KostPLE.payment.paymentkredit.PaymentImpl",
        		payment,
        		accountNumber,
        		provider,
        		cvv
        		);
        Repository.saveObject(paymentKredit);
        return paymentKredit;
    }


    @Override
    public Payment getPaymentById(UUID paymentId) {
       Payment paymentKredit = Repository.getListObject("payment_paymentkredit", "paymentId", paymentId).get(0);
       return paymentKredit;
    }
    

    @Override
    public Payment updatePayment(Map<String, Object> requestBody) {
    	int accountNumber = 0;
        String provider = null;
        String ccv = null;
        
        String idStr = (String) requestBody.get("idPemesanan");
 		UUID paymentId = UUID.fromString(idStr);
 		
 		Payment paymentKredit = Repository.getListObject("payment_paymentkredit", "paymentId", paymentId).get(0);
 		if (requestBody.containsKey("accountNumber")) {
 			accountNumber = (int) requestBody.get("accountNumber");
 			((PaymentImpl) paymentKredit).setAccountNumber(accountNumber);
 			Repository.updateObject(paymentKredit);
 		}
 		
 		if (requestBody.containsKey("provider")) {
 			provider = (String) requestBody.get("provider");
 			((PaymentImpl) paymentKredit).setProvider(provider);
 			Repository.updateObject(paymentKredit);
 		}
 		
 		if (requestBody.containsKey("ccv")) {
 			ccv = (String) requestBody.get("ccv");
 			((PaymentImpl) paymentKredit).setCcv(ccv);
 			Repository.updateObject(paymentKredit);
 		}
 		
 		Payment payment = record.updatePayment(requestBody);
 		
 		Payment paymentKreditUpdated = Repository.getObject(paymentId);
 		return paymentKreditUpdated;
    }

    @Override
    public List<Payment> getAllPayment() {
    	List<Payment> listPayment = Repository.getAllObject("payment_paymentkredit");
    	return listPayment;
    }


    @Override
    public List<Payment> deletePayment(UUID paymentId) {
        Repository.deleteObject(paymentId);
        return getAllPayment();
    }
}
