package spring.masterclass.sages.products;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.masterclass.sages.common.PagedResult;
import spring.masterclass.sages.common.web.PagedResultTransferObject;
import spring.masterclass.sages.common.web.UriBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final UriBuilder uriBuilder = new UriBuilder();

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductTransferObject productTransferObject,
                                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }

        var product = productMapper.toProduct(productTransferObject);
        Long productId = productService
                .add(product)
                .getId();

        URI locationUri = uriBuilder.requestUriWithId(productId);

        return ResponseEntity
                .created(locationUri)
                .build();
    }

    @GetMapping
    public PagedResultTransferObject<ProductTransferObject> getProductsByName(@RequestParam String nameFragment,
                                                                              @RequestParam(defaultValue = "0") int pageNumber,
                                                                              @RequestParam(defaultValue = "5") int pageSize) {

        var products = productService.getByName(nameFragment);

        return productMapper.toProductTransferObjectPage(new PagedResult<>(products, pageNumber, pageSize));
    }

    @GetMapping("/all")
    public PagedResultTransferObject<ProductTransferObject> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber,
                                                                           @RequestParam(defaultValue = "5") int pageSize) {

        var products = productService.getAll(pageNumber, pageSize);

        return productMapper.toProductTransferObjectPage(products);
    }

    // Check MvcConfiguration and WebInitializer config
    @RequestMapping(value = "{id}/files", method = RequestMethod.POST)
    public String submit(@PathVariable Long id, @RequestParam MultipartFile file) {
        // Save file to some kind of storage
        return "File " + file.getOriginalFilename() + " uploaded";
    }

}