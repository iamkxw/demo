package com.demo.data.repository;

import com.demo.data.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lixusheng on 1/12/17.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    Product findByProductId(int id);
}
