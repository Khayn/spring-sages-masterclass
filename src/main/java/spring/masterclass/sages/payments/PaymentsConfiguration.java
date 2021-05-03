package spring.masterclass.sages.payments;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class PaymentsConfiguration {

    @Bean(name = "paymentIdGenerator")
    public PaymentIdGenerator incrementalPaymentIdGenerator() {
        return new IncrementalPaymentIdGenerator();
    }

    @Bean
    public PaymentIdGenerator uuidPaymentIdGenerator() {
        return new UuidPaymentIdGenerator();
    }

    @Bean
    public PaymentRepository paymentRepository() {

        return new JpaPaymentsRepository();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public PaymentService paymentService(PaymentIdGenerator uuidPaymentIdGenerator,
                                         PaymentRepository paymentRepository,
                                         ApplicationEventPublisher eventPublisher) {

        return new FakePaymentService(uuidPaymentIdGenerator, paymentRepository, eventPublisher);
    }

    @Bean
    public PaymentConsoleLogger paymentConsoleLogger(MessageSource messageSource) {
        return new PaymentConsoleLogger(messageSource);
    }

}
