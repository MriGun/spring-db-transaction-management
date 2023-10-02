package com.mri.transactional.dao;

import com.mri.transactional.entity.Product;
import com.mri.transactional.repo.ProductRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDAO {
    private final ProductRepo productRepo;

    public ProductDAO(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveProduct(Product product) {
        productRepo.save(product);
    }
}
