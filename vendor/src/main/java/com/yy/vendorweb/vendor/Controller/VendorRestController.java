package com.yy.vendorweb.vendor.Controller;

import com.yy.vendorweb.vendor.entities.Vendor;
import com.yy.vendorweb.vendor.respp.VendorResiposory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venders")
public class VendorRestController {

    @Autowired
    VendorResiposory vendorResiposory;

    @GetMapping
    public List<Vendor> getVenders(){
        return vendorResiposory.findAll();
    }

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor){
        return vendorResiposory.save(vendor);
    }

    @PutMapping
    public Vendor updateVendor(@RequestBody Vendor vendor){
        return vendorResiposory.save(vendor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable("id") int id){
        vendorResiposory.deleteById(id);
    }

    @GetMapping("/{id}")
    public Vendor getVendor(@PathVariable("id") int id){
        return vendorResiposory.findById(id).get();
    }
}
