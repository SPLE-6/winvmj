package KostPLE.payment.paymentkredit;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import KostPLE.payment.core.PaymentResourceDecorator;
import KostPLE.payment.core.repository.PaymentRepository;
import KostPLE.payment.PaymentFactory;
import KostPLE.payment.core.Payment;
import KostPLE.paymentkredit.core.PaymentImpl;
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
		Payment payment = create(vmjExchange);
		PaymentRepository.saveObject(payment);
		return getAll(vmjExchange);
	}

    public Payment create(VMJExchange vmjExchange){
		String accountNumberStr = (String) vmjExchange.getRequestBodyForm("accountNumber");
		int accountNumber = Integer.parseInt(accountNumberStr);
		String ccv = (String) vmjExchange.getRequestBodyForm("ccv");
		String provider = (String) vmjExchange.getRequestBodyForm("provider");

		
		Payment deco = PaymentFactory.create("", accountNumber, 0, false, provider, ccv);
		return deco;
	}

	public Payment create(VMJExchange vmjExchange, int id) {
		String accountNumberStr = (String) vmjExchange.getRequestBodyForm("accountNumber");
		int accountNumber = Integer.parseInt(accountNumberStr);
		String ccv = (String) vmjExchange.getRequestBodyForm("ccv");
		String provider = (String) vmjExchange.getRequestBodyForm("provider");

		Payment saved = (Payment) PaymentRepository.getObject(id);
		int recordId = ((PaymentImpl) saved).getId();

		Payment deco = PaymentFactory.create(PaymentImpl.class.getName(), accountNumber, recordId, false, provider, ccv);
		return deco;
	}

    // @Restriced(permission = "")
	@Route(url="call/paymentkredit/update")
	public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Payment existingPayment = (Payment) PaymentRepository.getObject(id);
		Payment updatedPayment = create(vmjExchange, id);
		
		PaymentRepository.updateObject(updatedPayment);
		Payment finalPayment = (Payment) PaymentRepository.getObject(id);
		// TODO: fix association attributes if necessary
		
		return finalPayment.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentkredit/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getPayment(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentkredit/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<Payment> List = Repository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Payment> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentkredit/delete")
    public List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		PaymentRepository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public void Pay() {
		// TODO: implement this method
	}

}
