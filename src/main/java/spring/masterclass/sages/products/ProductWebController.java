package spring.masterclass.sages.products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ProductWebController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("add-product.html")
    public ModelAndView addProduct() {
        ModelAndView modelAndView = new ModelAndView("add-product");
        modelAndView.addObject(new ProductTransferObject());

        return modelAndView;
    }

    @PostMapping("add-product.html")
    public String saveProduct(@Valid ProductTransferObject productTransferObject, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-product";
        }

        var product = productMapper.toProduct(productTransferObject);
        productService.add(product);

        return "redirect:show-products.html";
    }


    @GetMapping("show-products.html")
    public ModelAndView showProducts(@RequestParam(defaultValue = "0") int pageNumber,
                                     @RequestParam(defaultValue = "5") int pageSize) {

        var products = productService.getAll(pageNumber, pageSize);

        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);

        return modelAndView;
    }


}
