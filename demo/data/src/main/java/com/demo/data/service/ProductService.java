package com.demo.data.service;

import com.demo.data.domain.Product;
import com.demo.data.domain.Vendor;
import com.demo.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by lixusheng on 1/12/17.
 */
@Component
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EntityManager entityManager;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findByProductId(int id){
        return productRepository.findByProductId(id);
    }

    public List<Product> findByVendorPage(int offset, int pageSize, Vendor vendor) {
        String QueryStr = "select prod from Product prod where prod.vendor=:vendor ";
        Query query = entityManager.createQuery(QueryStr, Product.class);
        query.setParameter("vendor", vendor);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
 }
