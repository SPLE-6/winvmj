package KostPLE.payment.paymentva;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import KostPLE.payment.core.repository.PaymentRepository;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import KostPLE.payment.core.PaymentResourceDecorator;
import KostPLE.payment.PaymentFactory;
import KostPLE.payment.core.Payment;
import KostPLE.payment.core.PaymentImpl;
import KostPLE.payment.core.PaymentResourceComponent;

public class PaymentResourceImpl extends PaymentResourceDecorator {
    public PaymentResourceImpl (PaymentResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/paymentva/save")
	public List<HashMap<String,Object>> save(VMJExchange vmjExchange) {
		Payment payment = create(vmjExchange);
		PaymentRepository.saveObject(payment);
		return getAll(vmjExchange);
	}

	public Payment create(VMJExchange vmjExchange){
		String accountNumberStr = (String) vmjExchange.getRequestBodyForm("accountNumber");
		int accountNumber = Integer.parseInt(accountNumberStr);

		Payment payment = record.create(vmjExchange);
		PaymentImpl deco = (PaymentImpl) PaymentFactory.create("KostPLE.paymentva.core.PaymentImpl", payment, accountNumber, provider);
		return deco;
	}

	public Payment create(VMJExchange vmjExchange, int id){
		String accountNumberStr = (String) vmjExchange.getRequestBodyForm("accountNumber");
		int accountNumber = Integer.parseInt(accountNumberStr);
		
		Payment saved = PaymentRepository.getObject(id);
		int recordId = ((Decorator) saved.getRecord()).getId();
		
		Payment payment = record.create(vmjExchange);
		PaymentImpl deco = (PaymentImpl) PaymentFactory.create("KostPLE.paymentva.core.PaymentImpl", id, payment, accountNumber, provider);
		return deco;
	}

    // @Restriced(permission = "")
	@Route(url="call/paymentva/update")
	public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Payment existingPayment = PaymentRepository.getObject(id);
		Payment updatedPayment = create(vmjExchange, id);
		
		PaymentRepository.updateObject(updatedPayment);
		Payment finalPayment = PaymentRepository.getObject(id);
		// TODO: fix association attributes
		
		return finalPayment.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentva/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getPayment(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentva/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<Payment> List = PaymentRepository.getAllObject("_impl");
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
    @Route(url="call/paymentva/delete")
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
