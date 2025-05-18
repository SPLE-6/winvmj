package KostPLE.payment.paymentkredit;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import KostPLE.payment.core.*;

public class PaymentResourceImpl extends PaymentResourceDecorator {
	private PaymentService paymentService;
	
	
    public PaymentResourceImpl (PaymentResourceComponent recordController, PaymentServiceComponent recordService) {
        super(recordController);
        this.paymentService = new PaymentServiceImpl(recordService);
    }

    // @Restriced(permission = "")
    @Route(url="call/paymentkredit/save")
    public HashMap<String,Object> savePaymentKredit(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		Map<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
		Payment result = ((PaymentServiceImpl) paymentService).savePayment(requestBody);
		return result.toHashMap();
	}

  

    // @Restriced(permission = "")
	@Route(url="call/paymentkredit/update")
	public HashMap<String, Object> updatePaymentKredit(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload(); 
		Payment result = ((PaymentServiceImpl) paymentService).updatePayment(requestBody);

		
		return result.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentkredit/detail")
    public HashMap<String, Object> getPaymentKredit(VMJExchange vmjExchange){
    	Map<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload(); 
		String paymentIdStr = vmjExchange.getGETParam("paymentId");
		
		if (paymentIdStr == "") {
			paymentIdStr = (String) requestBody.get("paymentId");
		} 
		
		UUID paymentId = UUID.fromString(paymentIdStr);
		
		Payment payment = paymentService.getPaymentById(paymentId);
		return payment.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentkredit/list")
    public List<HashMap<String,Object>> getAllPayment(VMJExchange vmjExchange){
    	List<Payment> paymentList = paymentService.getAllPayment();
    	return paymentService.transformListToHashMap(paymentList);
	}


	// @Restriced(permission = "")
    @Route(url="call/paymentkredit/delete")
    public List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload(); 
		String paymentIdStr = (String) body.get("paymentId");
		UUID paymentId = UUID.fromString(paymentIdStr);
		List<Payment> paymentList = paymentService.deletePayment(paymentId);
		return paymentService.transformListToHashMap(paymentList);
	}

	public void Pay() {
		// TODO: implement this method
	}

}
