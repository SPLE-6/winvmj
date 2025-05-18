package KostPLE.payment.core.service;
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
import KostPLE.payment.core.model.Payment;
import KostPLE.payment.core.repository.PaymentRepository;
import vmj.auth.annotations.Restricted;
//add other required packages

public class PaymentServiceImpl extends PaymentServiceComponent{

    public Payment save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Payment payment = create(vmjExchange.getPayload());
		PaymentRepository.saveObject(payment);
		return payment;
	}

    public Payment create(Map<String, Object> requestBody){
		String idPayment = (String) requestBody.get("idPayment");
		boolean status = (boolean) requestBody.get("status");
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);
		String createdAt = (String) requestBody.get("createdAt");
		String pemesananimpl= (String) requestBody.get("pemesananimpl");
		
		//to do: fix association attributes
		Payment payment = PaymentFactory.create(
		idPayment
		, amount
		, status
		, createdAt
		, pemesananimpl
		);
		PaymentRepository.saveObject(payment);
		return payment ;
	}

    public Payment create(VMJExchange vmjExchange){
		String idPayment = (String) vmjExchange.getRequestBodyForm("idPayment");
		boolean status = (boolean) vmjExchange.getRequestBodyForm("status");
		String amountStr = (String) vmjExchange.getRequestBodyForm("amount");
		int amount = Integer.parseInt(amountStr);
		String createdAt = (String) vmjExchange.getRequestBodyForm("createdAt");
		String pemesananimpl= (String) vmjExchange.getRequestBodyForm("pemesananimpl");
		
		
		//to do: fix association attributes
		
		Payment payment = PaymentFactory.create(idPayment, amount, status, createdAt, pemesananimpl);
		return payment;
	}

    public HashMap<String, Object> update(Map<String, Object> requestBody){
		String id = (String) requestBody.get("idPayment");
		Payment payment = PaymentRepository.getObject(id);
		
		payment.setStatus((Boolean) requestBody.get("status"));
		
		PaymentRepository.updateObject(payment);
		
		//to do: fix association attributes
		
		return payment.toHashMap();
		
	}

    public HashMap<String, Object> get(Map<String, Object> requestBody){
		List<HashMap<String, Object>> list = getAll(requestBody);
		for (HashMap<String, Object> payment : list){
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

	@Override
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

	@Override
	public Payment createPayment(Map<String, Object> requestBody) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createPayment'");
	}

	@Override
	public Payment createPayment(Map<String, Object> requestBody,
			Map<String, Object> response) {
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

	@Override
	public Payment create(Map<String, Object> requestBody, Map<String, Object> response) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'create'");
	}

	@Override
	public HashMap<String, Object> getById(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getById'");
	}

}