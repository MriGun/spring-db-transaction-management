package com.mri.transactional.controller;

import com.mri.transactional.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaveProduct {

    private final ProductService productService;

    public SaveProduct(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public void saveProduct() {
        productService.saveProductInfo();
        System.out.println("finished!!");
    }

}
