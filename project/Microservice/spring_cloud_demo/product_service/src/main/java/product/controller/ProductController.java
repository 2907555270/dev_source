package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import product.entity.Product;
import product.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping()
    public String save(@RequestBody Product product){
        productService.save(product);
        return "保存成功";
    }
}
