package com.demo.data.repository;

import com.demo.data.domain.Agent;
import com.demo.data.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository
 * 购物车模型
 *
 * @author kxw
 * @version 2017/1/20 11:45
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByAgent(Agent agent);
}
