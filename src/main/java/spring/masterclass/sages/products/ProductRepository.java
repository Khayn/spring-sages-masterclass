package spring.masterclass.sages.products;

import spring.masterclass.sages.common.PagedResult;

public interface ProductRepository {

	Product save(Product product);

	PagedResult<Product> findAll(int pageNumber, int pageSize);

}
