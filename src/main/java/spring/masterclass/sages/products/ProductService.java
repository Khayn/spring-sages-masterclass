package spring.masterclass.sages.products;

import lombok.RequiredArgsConstructor;
import spring.masterclass.sages.common.PagedResult;
import spring.masterclass.sages.common.retry.Retry;

@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Retry
    public Product add(Product product) {
        return productRepository.save(product);
    }

    public PagedResult<Product> getAll(int pageNumber, int pageSize) {
        return productRepository.findAll(pageNumber, pageSize);
    }

}
