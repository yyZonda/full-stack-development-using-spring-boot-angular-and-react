package com.yy.vendorweb.vendor.respp;

import com.yy.vendorweb.vendor.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface VendorResiposory extends JpaRepository<Vendor,Integer> {

    @Query("select code,count(code) from Vendor group by code")
    public List<Object[]> findCodeAndCodeCount();
}
