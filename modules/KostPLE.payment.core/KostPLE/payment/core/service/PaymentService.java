package KostPLE.payment.core;
import java.util.*;

import KostPLE.payment.core.Payment;
import vmj.routing.route.VMJExchange;

public interface PaymentService {
	Payment savePayment(Map<String, Object> requestBody);
    Payment updatePayment(Map<String, Object> requestBody);
	Payment getPaymentById(UUID id);
    List<Payment> getAllPayment();
    List<Payment> deletePayment(UUID id);
	List<HashMap<String, Object>> transformListToHashMap(List<Payment> List);
}
