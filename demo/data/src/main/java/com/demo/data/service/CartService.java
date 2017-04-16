package com.demo.data.service;

import com.demo.data.domain.Agent;
import com.demo.data.domain.Cart;
import com.demo.data.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DB对外服务
 * 购物车模型 cart
 *
 * @author kxw
 * @version 2017/1/20 11:46
 */
@Component
public class CartService {

    @Autowired
    CartRepository cartRepository;

    /**
     * 根据代理商获取其购物车列表
     * <p>created by kxw on 2017/1/20 11:47</p>
     */
    public List<Cart> findByAgent(Agent agent) {
        return cartRepository.findByAgent(agent);
    }
}
