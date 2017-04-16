package com.demo.data.service;

import com.demo.data.domain.Vendor;
import com.demo.data.exception.B2BDBException;
import com.demo.data.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lixusheng on 1/19/17.
 */
@Component
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    public Vendor findByVendorId(int id) {
        return vendorRepository.findOne(id);
    }

    /**
     * 保存
     * Created by Sawyer on 2017/1/23.
     */
    public Vendor save(Vendor vendor) throws B2BDBException {
        try {
            return vendorRepository.save(vendor);
        } catch (Exception ex) {
            throw new B2BDBException(String.format("供应商保存失败：{accountId:%s, vendorName:%s } ", vendor.getAccount().getAccountId(), vendor.getName()));
        }
    }
}
