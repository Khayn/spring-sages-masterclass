package spring.masterclass.sages.products;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import spring.masterclass.sages.common.PagedResult;
import spring.masterclass.sages.common.retry.Retry;

import javax.transaction.Transactional;
import java.util.List;

@Log
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @CacheEvict("products")
    @Retry
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Cacheable("products")
    public List<Product> getByName(String name) {
        log.info("Reading products from database...");

        return productRepository.findByNameContaining(name);
    }

    public PagedResult<Product> getAll(int pageNumber, int pageSize) {
        var productPage = productRepository.findAll(PageRequest.of(pageNumber, pageSize));

        return new PagedResult<>(productPage.getContent(), pageNumber, productPage.getTotalPages());
    }

}
