package com.DA.ReactiveProject.controller;

import com.DA.ReactiveProject.dao.CustomerDao;
import com.DA.ReactiveProject.dto.Customer;
import com.DA.ReactiveProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/cutomers")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

//    http://localhost:9191/cutomers/Normal

    @GetMapping("/Normal")
    public List<Customer> getAll()
    {
        return customerService.loadAllCustomer();
    }


    // http://localhost:9191/cutomers/ReactiveExample
//    produces = MediaType.TEXT_EVENT_STREAM_VALUE
//    To achieve reactive programing we are using Media type and sending data as stream not as a object.
    @GetMapping(value = "/ReactiveExample", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomer()
    {
        return customerService.loadAllData();
    }

}
