package spring.masterclass.sages.payments;

import lombok.extern.java.Log;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Log
public class PaymentStatusChangeListener {

	@EventListener
	public void onPaymentStatusChanged(PaymentStatusChangedEvent statusChangedEvent) {
		log.info("Payment changed status: " + statusChangedEvent.getPayment());
	}
}
