package KostPLE.payment.paymentkredit.resource;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import KostPLE.payment.core.resource.PaymentResourceDecorator;
import KostPLE.payment.core.repository.PaymentRepository;
import KostPLE.payment.PaymentFactory;
import KostPLE.payment.core.model.Payment;
import KostPLE.payment.paymentkredit.model.PaymentImpl;
import KostPLE.payment.core.resource.PaymentResourceComponent;

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
		String accountNumber = (String) vmjExchange.getRequestBodyForm("accountNumber");
		String ccv = (String) vmjExchange.getRequestBodyForm("ccv");
		String provider = (String) vmjExchange.getRequestBodyForm("provider");
		String recordId = (String) vmjExchange.getRequestBodyForm("recordId");

		
		Payment deco = PaymentFactory.create(accountNumber, 0, false, provider, ccv);
		return deco;
	}

	public Payment create(VMJExchange vmjExchange, String id) {
		String accountNumberStr = (String) vmjExchange.getRequestBodyForm("accountNumber");
		int accountNumber = Integer.parseInt(accountNumberStr);
		String ccv = (String) vmjExchange.getRequestBodyForm("ccv");
		String provider = (String) vmjExchange.getRequestBodyForm("provider");

		Payment saved = (Payment) PaymentRepository.getObject(id);
		String recordId = saved.getIdPayment();

		Payment deco = PaymentFactory.create(recordId, accountNumber, false, provider, ccv);
		return deco;
	}

    // @Restriced(permission = "")
	@Route(url="call/paymentkredit/update")
	public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String id = (String) vmjExchange.getRequestBodyForm("id");
		
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
    @Route(url="call/paymentkredit/delete")
    public List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String id = (String) vmjExchange.getRequestBodyForm("id");
		PaymentRepository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public void Pay() {
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
	public HashMap<String, Object> createPayment(VMJExchange vmjExhange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createPayment'");
	}

}
