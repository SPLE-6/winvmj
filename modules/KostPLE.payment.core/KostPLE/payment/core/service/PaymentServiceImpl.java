package KostPLE.payment.core;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

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

import KostPLE.pemesanan.core.*;
import vmj.auth.annotations.Restricted;
//add other required packages

public class PaymentServiceImpl extends PaymentServiceComponent{

	private PaymentFactory paymentFactory = new PaymentFactory();
	PemesananService pemesananService = new PemesananServiceImpl();
	
    public Payment savePayment(Map<String, Object> requestBody){
    	

		UUID idPayment = UUID.randomUUID();
		boolean status = true;
		
		Date createdAt = new Date();
		
		String idPemesananStr = (String) requestBody.get("idPemesananStr");
		UUID idPemesanan = UUID.fromString(idPemesananStr);
		
		Pemesanan pemesanan = pemesananService.getPemesananById(idPemesanan);
		
		pemesanan = pemesananService.updateStatusPemesanan(idPemesanan);
		
		//to do: fix association attributes
		Payment payment = paymentFactory.createPayment(
		"KostPLE.payment.core.PaymentImpl"
		,idPayment
		, status
		, createdAt
		, pemesanan
		);
		Repository.saveObject(payment);
		return payment;
	}

    public Payment updatePayment(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPayment");
		UUID id = UUID.fromString(idStr);
		Payment payment = Repository.getObject(id);
		
		payment.setStatus((Boolean) requestBody.get("status"));
		
		Repository.updateObject(payment);
		
		//to do: fix association attributes
		
		return payment;
		
	}

	public Payment getPaymentById(UUID id){
		Payment payment = Repository.getObject(id);
		return payment;
	}

    public List<Payment> getAllPayment(){
		List<Payment> paymentList = Repository.getAllObject("payment_impl");
		return paymentList;
	}

	@Override
    public List<HashMap<String,Object>> transformListToHashMap(List<Payment> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<Payment> deletePayment(UUID paymentId){
		Repository.deleteObject(paymentId);
		return getAllPayment();
	}

	public void Pay() {
		// TODO: implement this method
	}

	public void Cancel() {
		// TODO: implement this method
	}

}
