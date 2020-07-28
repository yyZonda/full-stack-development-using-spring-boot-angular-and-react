package com.yy.customerdata.demo;

import com.yy.customerdata.demo.entities.Customer;
import com.yy.customerdata.demo.res.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testCreateStudent(){
        Customer customer=new Customer();
        customer.setName("john");
        customer.setEmail("john@gmail.com");
        customerRepository.save(customer);
    }

    @Test
    public void testFindStudentById(){
        Optional<Customer> s=customerRepository.findById(1l);
        Customer customer=s.get();
        System.out.println(customer);
    }

    @Test
    public void updateStudent(){
        Customer customer=customerRepository.findById(1l).get();
        customer.setName("jack");
        customerRepository.save(customer);
    }

    @Test
    public void testDeleteStudent(){
        customerRepository.deleteById(1l);
    }

}
