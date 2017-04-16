package com.demo.data.repository;

import com.demo.data.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sawyer on 2017/1/19.
 */
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
