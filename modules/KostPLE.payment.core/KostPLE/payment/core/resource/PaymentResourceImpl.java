package KostPLE.payment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.payment.PaymentFactory;
import KostPLE.payment.core.Payment;
import vmj.auth.annotations.Restricted;
//add other required packages
import KostPLE.payment.core.PaymentServiceImpl;

public class PaymentResourceImpl extends PaymentResourceComponent{
	
	private PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/payment/save")
    public HashMap<String,Object> savePayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload(); 
			Payment result = paymentServiceImpl.savePayment(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/payment/update")
    public HashMap<String, Object> updatePayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		Payment result =  paymentServiceImpl.updatePayment(requestBody);
		return result.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/payment/detail")
    public HashMap<String, Object> getPayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		String paymentIdStr = vmjExchange.getGETParam("paymentId");
		
		if (paymentIdStr == "") {
			paymentIdStr = (String) requestBody.get("paymentId");
		} 
		
		UUID paymentId = UUID.fromString(paymentIdStr);
		return paymentServiceImpl.getPaymentById(paymentId).toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/payment/list")
    public List<HashMap<String,Object>> getAllPayment(VMJExchange vmjExchange){
    	List<Payment> paymentList = paymentServiceImpl.getAllPayment();
		return paymentServiceImpl.transformListToHashMap(paymentList);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/payment/delete")
    public List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange){
    	HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload(); 
		String paymentIdStr = (String) body.get("paymentId");
		UUID paymentId = UUID.fromString(paymentIdStr);
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		List <Payment> paymentList =  paymentServiceImpl.deletePayment(paymentId);
		return paymentServiceImpl.transformListToHashMap(paymentList);

	}

	public void Pay() {
		// TODO: implement this method
	}

	public void Cancel() {
		// TODO: implement this method
	}

	
}
