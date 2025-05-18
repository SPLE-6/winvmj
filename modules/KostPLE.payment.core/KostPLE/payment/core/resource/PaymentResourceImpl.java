package KostPLE.payment.core.resource;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.payment.PaymentFactory;
import KostPLE.payment.core.model.Payment;
import vmj.auth.annotations.Restricted;
//add other required packages
import KostPLE.payment.core.service.PaymentServiceImpl;

public class PaymentResourceImpl extends PaymentResourceComponent{
	
	private PaymentServiceImpl ServiceImpl = new PaymentServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/payment")
    public Payment create(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Payment result = ServiceImpl.create(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/payment/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return ServiceImpl.update(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/payment/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return ServiceImpl.get(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/payment/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return ServiceImpl.getAll(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/payment/delete")
    public List<HashMap<String,Object>> delete(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return ServiceImpl.delete(requestBody);
	}

	public void Pay() {
		// TODO: implement this method
	}

	public void Cancel() {
		// TODO: implement this method
	}

	@Override
	public List<HashMap<String, Object>> savePayment(VMJExchange vmjExchange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'savePayment'");
	}

	@Override
	public HashMap<String, Object> updatePayment(VMJExchange vmjExchange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updatePayment'");
	}

	@Override
	public HashMap<String, Object> getPayment(VMJExchange vmjExchange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPayment'");
	}

	@Override
	public List<HashMap<String, Object>> getAllPayment(VMJExchange vmjExchange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAllPayment'");
	}

	@Override
	public List<HashMap<String, Object>> deletePayment(VMJExchange vmjExchange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deletePayment'");
	}

	@Override
	public HashMap<String, Object> createPayment(VMJExchange vmjExhange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createPayment'");
	}
}