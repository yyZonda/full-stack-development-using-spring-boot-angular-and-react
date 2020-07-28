package com.yy.customerdata.demo.res;

import com.yy.customerdata.demo.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
