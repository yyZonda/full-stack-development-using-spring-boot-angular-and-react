package com.yy.vendorweb.vendor.service;

import com.yy.vendorweb.vendor.entities.Vendor;
import com.yy.vendorweb.vendor.respp.VendorResiposory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {
    @Autowired
    private VendorResiposory vendorResiposory;

    @Override
    public Vendor saveVendor(Vendor vendor) {
        return vendorResiposory.save(vendor);
    }

    @Override
    public Vendor updataVendor(Vendor vendor) {
        return vendorResiposory.save(vendor);
    }

    @Override
    public void deleteVendor(Vendor vendor) {
        vendorResiposory.delete(vendor);
    }

    @Override
    public Vendor findVendorById(int id) {
        return vendorResiposory.findById(id).get();
    }

    @Override
    public List<Vendor> getAllVendor() {
        return vendorResiposory.findAll();
    }
}
