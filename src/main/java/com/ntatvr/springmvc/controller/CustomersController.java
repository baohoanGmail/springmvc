package com.ntatvr.springmvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ntatvr.springmvc.entity.Customer;
import com.ntatvr.springmvc.exception.ApiData;
import com.ntatvr.springmvc.repository.CustomersRepository;
import com.ntatvr.springmvc.service.CustomersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * [@Api] – We can add this Annotation to the controller to add basic information regarding the
 * controller.
 * 
 * [@ApiOperation] and [@ApiResponses] – We can add these annotations to any rest method in the
 * controller to add basic information related to that method. e.g.
 * 
 * @author AnhNT
 *
 */
@CrossOrigin(maxAge = 3600)
@Api(value = "CustomersController", description = "REST APIs related to Customers Entity!",
    tags = "customers-controller")
@Controller
@RequestMapping("/customers")
public class CustomersController extends RESTController<Customer, Integer> {

  @Autowired
  private CustomersService customersService;

  public CustomersController(CustomersRepository repository) {
    super(repository);
  }

  @ApiOperation(value = "Excute query", response = ApiData.class)
  @GetMapping("/excuteQuery")
  @ResponseBody
  public ResponseEntity<Object> findById() {

    List<Customer> list = customersService.excuteQuery();
    return new ResponseEntity<>(new ApiData(list.size(), list), HttpStatus.OK);
  }
}
