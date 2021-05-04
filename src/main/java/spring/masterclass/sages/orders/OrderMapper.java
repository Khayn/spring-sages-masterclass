package spring.masterclass.sages.orders;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import spring.masterclass.sages.common.web.FastMoneyMapper;
import spring.masterclass.sages.common.web.IdTransferObject;
import spring.masterclass.sages.products.Product;
import spring.masterclass.sages.products.ProductMapper;
import spring.masterclass.sages.products.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {FastMoneyMapper.class, ProductMapper.class})
public abstract class OrderMapper {

    @Autowired
    private ProductService productService;

    public Order toOrder(OrderTransferObject orderTransferObject) {
        List<Product> products = orderTransferObject
                .getProducts()
                .stream()
                .map(IdTransferObject::getId)
                .map(productService::getById)
                .collect(Collectors.toList());

        return new Order(products);
    }

}
