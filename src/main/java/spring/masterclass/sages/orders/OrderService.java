package spring.masterclass.sages.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import spring.masterclass.sages.common.PagedResult;
import spring.masterclass.sages.common.validator.Validate;
import spring.masterclass.sages.payments.Payment;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order add(@Validate(exception = InvalidOrderException.class) Order order) {
        order.setTimestamp(Instant.now());
        order.setPayment(Payment
                .builder()
                .id(UUID
                        .randomUUID()
                        .toString())
                .timestamp(Instant.now())
                .money(order.getTotalPrice())
                .build());

        return orderRepository.save(order);
    }

    public Order getBy(Long orderId) {
        return orderRepository
                .findById(orderId)
                .orElseThrow(OrderNotFoundException::new);
    }

    public void update(Order order) {
        orderRepository.save(order);
    }

    public PagedResult<Order> getAll(int pageNumber, int pageSize) {
        var orderPage = orderRepository.findAll(PageRequest.of(pageNumber, pageSize));

        return new PagedResult<>(orderPage.getContent(), pageNumber, orderPage.getTotalPages());
    }

}
