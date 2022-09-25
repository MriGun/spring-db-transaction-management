package com.mri.transactional.service;

import com.mri.transactional.dao.ProductDAO;
import com.mri.transactional.entity.Product;
import com.mri.transactional.repo.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final ProductDAO productDAO;

    public ProductService(ProductRepo productRepo, ProductDAO productDAO) {
        this.productRepo = productRepo;
        this.productDAO = productDAO;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void saveProductInfo() {


        for(int i=1; i<=10; i++) {
            Product product = new Product();
            product.setId(Long.valueOf(i));
            product.setName("Test product " + String.valueOf(i));
            product.setUnit(i);
            product.setPrice(i);

            productDAO.saveProduct(product);

            //productRepo.save(product);
            System.out.println("Product saved!");

            /*if (i == 7) {
                throw new RuntimeException("errr hppened!");
            }*/

        }
    }
}
