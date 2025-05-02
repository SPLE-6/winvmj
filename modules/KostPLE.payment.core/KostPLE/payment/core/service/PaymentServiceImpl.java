package KostPLE.payment.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.payment.PaymentFactory;
import KostPLE.payment.core.Payment;
import KostPLE.payment.core.repository.PaymentRepository;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PaymentServiceImpl extends PaymentServiceComponent{

    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Payment payment = create(vmjExchange);
		PaymentRepository.saveObject(payment);
		return getAll(vmjExchange);
	}

    public Payment create(Map<String, Object> requestBody){
		String idPaymentStr = (String) requestBody.get("idPayment");
		int idPayment = Integer.parseInt(idPaymentStr);
		boolean status = (boolean) requestBody.get("status");
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);
		String createdAt = (String) requestBody.get("createdAt");
		String pemesananimpl= (String) requestBody.get("pemesananimpl");
		
		//to do: fix association attributes
		Payment payment = PaymentFactory.create(
			"KostPLE.payment.core.PaymentImpl",
		idPayment
		, amount
		, status
		, createdAt
		, pemesananimpl
		);
		PaymentRepository.saveObject(payment);
		return payment ;
	}

    public Payment create(Map<String, Object> requestBody, int id){
		boolean status = (boolean) vmjExchange.getRequestBodyForm("status");
		
		//to do: fix association attributes
		
		Payment payment = PaymentFactory.create("KostPLE.payment.core.PaymentImpl", amount, status, createdAt, pemesananimpl);
		return payment;
	}

    public HashMap<String, Object> update(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPayment");
		int id = Integer.parseInt(idStr);
		Payment payment = PaymentRepository.getObject(id);
		
		payment.setStatus((String) requestBody.get("status"));
		
		PaymentRepository.updateObject(payment);
		
		//to do: fix association attributes
		
		return payment.toHashMap();
		
	}

    public HashMap<String, Object> get(Map<String, Object> requestBody){
		List<HashMap<String, Object>> List = getAll("_impl");
		for (HashMap<String, Object> payment : List){
			String record_id = ((String) payment.get("record_id"));
			if (record_id.equals(requestBody.get("idPayment"))){
				return payment;
			}
		}
		return null;
	}

	public HashMap<String, Object> getById(String id, VMJExchange vmjExchange){
		Payment payment = PaymentRepository.getObject(id);
		return payment.toHashMap();
	}

    public List<HashMap<String,Object>> getAll(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Payment> List = PaymentRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Payment> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> delete(Map<String, Object> requestBody){
		String id = ((String) requestBody.get("id"));
		PaymentRepository.deleteObject(id);
		return getAll(requestBody);
	}

	public void Pay() {
		// TODO: implement this method
	}

	public void Cancel() {
		// TODO: implement this method
	}
}
