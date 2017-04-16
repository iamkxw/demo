package com.demo.data.repository;

import com.demo.data.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lixusheng on 1/19/17.
 */
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
