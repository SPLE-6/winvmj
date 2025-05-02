package KostPLE.payment.paymentkredit;
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
    @Route(url="call/paymentkredit/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PaymentPaymentKredit paymentpaymentkredit = createPaymentPaymentKredit(vmjExchange);
		paymentpaymentkreditRepository.saveObject(paymentpaymentkredit);
		return getAllPaymentPaymentKredit(vmjExchange);
	}

    public Payment createPaymentPaymentKredit(VMJExchange vmjExchange){
		String accountNumberStr = (String) vmjExchange.getRequestBodyForm("accountNumber");
		int accountNumber = Integer.parseInt(accountNumberStr);
		String ccv = (String) vmjExchange.getRequestBodyForm("ccv");
		
		PaymentPaymentKredit paymentpaymentkredit = record.createPaymentPaymentKredit(vmjExchange);
		PaymentPaymentKredit paymentpaymentkreditdeco = PaymentPaymentKreditFactory.createPaymentPaymentKredit("KostPLE.paymentkredit.core.PaymentImpl", paymentpaymentkredit, idPayment, amount, status, createdAt, pemesananimpl
		accountNumber, provider, ccv
		);
			return paymentpaymentkreditdeco;
	}


    public Payment createPaymentPaymentKredit(VMJExchange vmjExchange, int id){
		String accountNumberStr = (String) vmjExchange.getRequestBodyForm("accountNumber");
		int accountNumber = Integer.parseInt(accountNumberStr);
		String ccv = (String) vmjExchange.getRequestBodyForm("ccv");
		PaymentPaymentKredit paymentpaymentkredit = paymentpaymentkreditRepository.getObject(id);
		int recordPaymentPaymentKreditId = (((PaymentPaymentKreditDecorator) savedPaymentPaymentKredit.getRecord()).getId();
		
		PaymentPaymentKredit paymentpaymentkredit = record.createPaymentPaymentKredit(vmjExchange);
		PaymentPaymentKredit paymentpaymentkreditdeco = PaymentPaymentKreditFactory.createPaymentPaymentKredit("KostPLE.paymentkredit.core.PaymentImpl", id, paymentpaymentkredit, idPayment, amount, status, createdAt, pemesananimpl
		accountNumber, provider, ccv
		);
			return paymentpaymentkreditdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentkredit/update")
    public HashMap<String, Object> updatePaymentPaymentKredit(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("idPayment");
		int id = Integer.parseInt(idStr);
		
		PaymentPaymentKredit paymentpaymentkredit = paymentpaymentkreditRepository.getObject(id);
		paymentpaymentkredit = createPaymentPaymentKredit(vmjExchange, id);
		
		paymentpaymentkreditRepository.updateObject(paymentpaymentkredit);
		paymentpaymentkredit = paymentpaymentkreditRepository.getObject(id);
		//to do: fix association attributes
		
		return paymentpaymentkredit.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentkredit/detail")
    public HashMap<String, Object> getPaymentPaymentKredit(VMJExchange vmjExchange){
		return record.getPaymentPaymentKredit(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentkredit/list")
    public List<HashMap<String,Object>> getAllPaymentPaymentKredit(VMJExchange vmjExchange){
		List<PaymentPaymentKredit> paymentpaymentkreditList = paymentpaymentkreditRepository.getAllObject("paymentpaymentkredit_impl");
		return transformPaymentPaymentKreditListToHashMap(paymentpaymentkreditList);
	}

    public List<HashMap<String,Object>> transformPaymentPaymentKreditListToHashMap(List<PaymentPaymentKredit> PaymentPaymentKreditList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PaymentPaymentKreditList.size(); i++) {
            resultList.add(PaymentPaymentKreditList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentkredit/delete")
    public List<HashMap<String,Object>> deletePaymentPaymentKredit(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("idPayment");
		int id = Integer.parseInt(idStr);
		paymentpaymentkreditRepository.deleteObject(id);
		return getAllPaymentPaymentKredit(vmjExchange);
	}

	public void Pay() {
		// TODO: implement this method
	}
	
}
