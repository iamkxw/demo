package com.demo.data.service;

import com.demo.data.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lixusheng on 1/16/17.
 */
@Component
public class RegionService {

    @Autowired
    RegionRepository regionRepository;
}
