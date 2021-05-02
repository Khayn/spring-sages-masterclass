package spring.masterclass.sages.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.context.ApplicationEventPublisher;
import spring.masterclass.sages.common.profiler.ExecutionTime;

import java.time.Instant;

@Log
@RequiredArgsConstructor
public class FakePaymentService implements PaymentService {

    private final PaymentIdGenerator paymentIdGenerator;
    private final PaymentRepository paymentRepository;
    private final ApplicationEventPublisher eventPublisher;

    @ExecutionTime
    @LogPayments
    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var payment = Payment
                .builder()
                .id(paymentIdGenerator.getNext())
                .money(paymentRequest.getMoney())
                .timestamp(Instant.now())
                .status(PaymentStatus.STARTED)
                .build();

        eventPublisher.publishEvent(new PaymentStatusChangedEvent(this, payment));

        return paymentRepository.save(payment);
    }

    public void init() {
        log.info("PaymentService initialized.");
    }

    public void destroy() {
        log.info("PaymentService is going down.");
    }

}


