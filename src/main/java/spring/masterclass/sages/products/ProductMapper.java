package spring.masterclass.sages.products;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import spring.masterclass.sages.common.PagedResult;
import spring.masterclass.sages.common.web.FastMoneyMapper;
import spring.masterclass.sages.common.web.PagedResultTransferObject;

import java.util.List;

@Mapper(componentModel = "spring", uses = FastMoneyMapper.class)
public interface ProductMapper {


    Product toProduct(ProductTransferObject productTransferObject);

    ProductTransferObject toProduct(Product product);

    @IterableMapping(elementTargetType = ProductTransferObject.class)
    List<ProductTransferObject> toProductTransferObjects(List<Product> products);

    PagedResultTransferObject<ProductTransferObject> toProductTransferObjectPage(PagedResult<Product> productPage);

    @ValueMapping(source = "BOOK", target = "EBOOK")
    @ValueMapping(source = "AUDIO", target = "MUSIC")
    @ValueMapping(source = "VIDEO", target = "VIDEO")
    ProductTypeTransferObject toProductTypeTransferObject(ProductType productType);

    @InheritInverseConfiguration
    ProductType toProductType(ProductTypeTransferObject productTypeTransferObject);

}
