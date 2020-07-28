package com.yy.vendorweb.vendor.Controller;

import com.yy.vendorweb.vendor.entities.Vendor;
import com.yy.vendorweb.vendor.respp.VendorResiposory;
import com.yy.vendorweb.vendor.service.VendorService;
import com.yy.vendorweb.vendor.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class VendorController {

    @Autowired
    private VendorService service;

    @Autowired
    private VendorResiposory resiposory;

    @Autowired
    ReportUtil reportUtil;

    @Autowired
    ServletContext sc;

    @RequestMapping("/showCreate")
    public String showCreate(){
        return "createVendor";
    }

    @RequestMapping("/saveVendor")
    public String saveVendor(@ModelAttribute("Vendor") Vendor vendor, ModelMap modelMap){
        Vendor vendorsaved=service.saveVendor(vendor);
        String msg="location saved with id:"+vendorsaved.getId();
        modelMap.addAttribute("msg",msg);
        return "createVendor";
    }

    @RequestMapping("/displayVendors")
    public String displayVendor( ModelMap modelMap){
        List<Vendor> vendors=service.getAllVendor();
        modelMap.addAttribute("vendors",vendors);
        return "dispalyVendors";
    }

    @RequestMapping("/generateReport")
    public String generateReport(){
        List<Object[]> data=resiposory.findCodeAndCodeCount();
        reportUtil.generatePieChar(sc.getRealPath("/"),data);
        return "report";
    }
}
