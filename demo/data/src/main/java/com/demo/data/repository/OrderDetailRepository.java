package com.demo.data.repository;

import com.demo.data.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lixusheng on 1/16/17.
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
