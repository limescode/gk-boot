package pl.limescode.gkboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.limescode.gkboot.dto.ProductCreateDto;
import pl.limescode.gkboot.model.Product;
import pl.limescode.gkboot.service.ProductService;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public String getProducts(Model model) {
        var products = productService.getProducts();
        model.addAttribute("productList", products);
        return "productListForm";
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/add")
    public String addingForm(Model model) {
        model.addAttribute("productCreateDto", new ProductCreateDto());
        return "addProductForm";
    }

    @PostMapping("/add")
    public String greetingSubmit(@ModelAttribute ProductCreateDto productCreateDto, Model model) {
        var product = productService.createProduct(productCreateDto);
        model.addAttribute("product", product);
        return "addedProductForm";
    }


}
