package com.DA.ReactiveProject.service;

import com.DA.ReactiveProject.dao.CustomerDao;
import com.DA.ReactiveProject.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.swing.*;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao dao;
    
    
    public List<Customer> loadAllCustomer()
    {
        long startTime = System.currentTimeMillis();
        List<Customer> customers = dao.getCustomer();
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time ::" + (endTime-startTime));
        return customers;
    }


    public Flux<Customer> loadAllData()
    {
        long startTime = System.currentTimeMillis();

        Flux<Customer> customers = dao.getAllCustomer();

        long endTime = System.currentTimeMillis();

        System.out.println("Total execution time ::" + (endTime-startTime));

        return customers;
    }
    
}
