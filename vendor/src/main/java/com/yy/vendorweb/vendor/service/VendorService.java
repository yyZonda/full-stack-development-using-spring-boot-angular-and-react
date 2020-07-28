package com.yy.vendorweb.vendor.service;

import com.yy.vendorweb.vendor.entities.Vendor;

import java.util.List;

public interface VendorService {
    Vendor saveVendor(Vendor vendor);
    Vendor updataVendor(Vendor vendor);
    void deleteVendor(Vendor vendor);
    Vendor findVendorById(int id);
    List<Vendor> getAllVendor();
}
