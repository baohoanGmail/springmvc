package com.ntatvr.springmvc.service;

import java.util.List;
import com.ntatvr.springmvc.entity.Customer;

/**
 * The Interface CustomerService.
 */
public interface CustomersService extends GenericService<Customer> {

  List<Customer> excuteQuery();
}
