package spring.masterclass.sages;

import lombok.RequiredArgsConstructor;
import spring.masterclass.sages.common.PagedResult;
import spring.masterclass.sages.orders.Order;
import spring.masterclass.sages.orders.OrderService;
import spring.masterclass.sages.payments.Payment;
import spring.masterclass.sages.payments.PaymentRequest;
import spring.masterclass.sages.payments.PaymentService;
import spring.masterclass.sages.products.Product;
import spring.masterclass.sages.products.ProductService;
import spring.masterclass.sages.users.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
public class ShopService {

    private final OrderService orderService;
    private final PaymentService paymentService;
    private final ProductService productService;
    private final UserService userService;


    public Product addProduct(Product product) {
        return productService.add(product);
    }

    public List<Product> getByName(String name) {
        return productService.getByName(name);
    }

    public PagedResult<Product> getProducts(int pageNumber, int pageSize) {
        return productService.getAll(pageNumber, pageSize);
    }


    public Order placeOrder(Order order) {
        return orderService.add(order);
    }

    public Payment payForOrder(long orderId) {
        var order = orderService.getBy(orderId);

        var paymentRequest = PaymentRequest
                .builder()
                .money(order.getTotalPrice())
                .build();

        var payment = paymentService.process(paymentRequest);
        order.setPayment(payment);

        orderService.update(order);

        return payment;
    }

}

