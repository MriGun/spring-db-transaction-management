package com.mri.transactional.repo;

import com.mri.transactional.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepoJdbc {

    private JdbcTemplate jdbcTemplate;

    public void saveProduct(Product product) {

        String sql = "INSERT INTO PRODUCT VALUES (?,?, ?)";

        Object[] args = {product.getId(), product.getName(), product.getUnit(), product.getPrice()};

        jdbcTemplate.update(sql, args);
    }

}
