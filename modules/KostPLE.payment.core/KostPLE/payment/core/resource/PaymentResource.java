package KostPLE.payment.core;
import java.util.*;

import KostPLE.payment.core.Payment;
import vmj.routing.route.VMJExchange;

public interface PaymentResource {
	HashMap<String,Object> savePayment(VMJExchange vmjExchange);
    HashMap<String, Object> updatePayment(VMJExchange vmjExchange);
    HashMap<String, Object> getPayment(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPayment(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange);
}
