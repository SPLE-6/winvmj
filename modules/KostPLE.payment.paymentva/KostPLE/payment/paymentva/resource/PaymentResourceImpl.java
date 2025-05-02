package KostPLE.payment.paymentva;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import KostPLE.payment.core.PaymentResourceDecorator;
import KostPLE.payment.core.PaymentImpl;
import KostPLE.payment.core.PaymentResourceComponent;

public class PaymentResourceImpl extends PaymentResourceDecorator {
    public PaymentResourceImpl (PaymentResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/paymentva/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PaymentPaymentVA paymentpaymentva = createPaymentPaymentVA(vmjExchange);
		paymentpaymentvaRepository.saveObject(paymentpaymentva);
		return getAllPaymentPaymentVA(vmjExchange);
	}

    public Payment createPaymentPaymentVA(VMJExchange vmjExchange){
		String accountNumberStr = (String) vmjExchange.getRequestBodyForm("accountNumber");
		int accountNumber = Integer.parseInt(accountNumberStr);
		
		PaymentPaymentVA paymentpaymentva = record.createPaymentPaymentVA(vmjExchange);
		PaymentPaymentVA paymentpaymentvadeco = PaymentPaymentVAFactory.createPaymentPaymentVA("KostPLE.paymentva.core.PaymentImpl", paymentpaymentva, idPayment, amount, status, createdAt, pemesananimpl
		accountNumber, provider
		);
			return paymentpaymentvadeco;
	}


    public Payment createPaymentPaymentVA(VMJExchange vmjExchange, int id){
		String accountNumberStr = (String) vmjExchange.getRequestBodyForm("accountNumber");
		int accountNumber = Integer.parseInt(accountNumberStr);
		PaymentPaymentVA paymentpaymentva = paymentpaymentvaRepository.getObject(id);
		int recordPaymentPaymentVAId = (((PaymentPaymentVADecorator) savedPaymentPaymentVA.getRecord()).getId();
		
		PaymentPaymentVA paymentpaymentva = record.createPaymentPaymentVA(vmjExchange);
		PaymentPaymentVA paymentpaymentvadeco = PaymentPaymentVAFactory.createPaymentPaymentVA("KostPLE.paymentva.core.PaymentImpl", id, paymentpaymentva, idPayment, amount, status, createdAt, pemesananimpl
		accountNumber, provider
		);
			return paymentpaymentvadeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentva/update")
    public HashMap<String, Object> updatePaymentPaymentVA(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("idPayment");
		int id = Integer.parseInt(idStr);
		
		PaymentPaymentVA paymentpaymentva = paymentpaymentvaRepository.getObject(id);
		paymentpaymentva = createPaymentPaymentVA(vmjExchange, id);
		
		paymentpaymentvaRepository.updateObject(paymentpaymentva);
		paymentpaymentva = paymentpaymentvaRepository.getObject(id);
		//to do: fix association attributes
		
		return paymentpaymentva.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentva/detail")
    public HashMap<String, Object> getPaymentPaymentVA(VMJExchange vmjExchange){
		return record.getPaymentPaymentVA(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentva/list")
    public List<HashMap<String,Object>> getAllPaymentPaymentVA(VMJExchange vmjExchange){
		List<PaymentPaymentVA> paymentpaymentvaList = paymentpaymentvaRepository.getAllObject("paymentpaymentva_impl");
		return transformPaymentPaymentVAListToHashMap(paymentpaymentvaList);
	}

    public List<HashMap<String,Object>> transformPaymentPaymentVAListToHashMap(List<PaymentPaymentVA> PaymentPaymentVAList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PaymentPaymentVAList.size(); i++) {
            resultList.add(PaymentPaymentVAList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentva/delete")
    public List<HashMap<String,Object>> deletePaymentPaymentVA(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("idPayment");
		int id = Integer.parseInt(idStr);
		paymentpaymentvaRepository.deleteObject(id);
		return getAllPaymentPaymentVA(vmjExchange);
	}

	public void Pay() {
		// TODO: implement this method
	}
	
}
