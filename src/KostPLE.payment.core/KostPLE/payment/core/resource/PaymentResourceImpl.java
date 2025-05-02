package KostPLE.payment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.payment.PaymentFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class PaymentResourceImpl extends PaymentResourceComponent{
	
	private PaymentServiceImpl ServiceImpl = new PaymentServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/payment/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/payment")
    public HashMap<String,Object> (VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			 result = ServiceImpl.create(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public  create(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			 result = ServiceImpl.create(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public  create(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			 result = ServiceImpl.create(requestBody, id);
			return result.toHashMap();
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
}
