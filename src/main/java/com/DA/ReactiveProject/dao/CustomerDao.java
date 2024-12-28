package com.DA.ReactiveProject.dao;

import com.DA.ReactiveProject.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepExecution(int i)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getCustomer()
    {
        return IntStream.rangeClosed(1,50)
                .peek(CustomerDao::sleepExecution) // method reference
                .peek(i-> System.out.println("processing count :  "+i))
                .mapToObj(i-> new Customer(i,"customer"+i))
                .collect(Collectors.toList());
    }

    // Untill it get all the records it will stop and not give the response. Synchronous and blocking.
    // To avoid this we will use Reactive Programing.


    public Flux<Customer> getAllCustomer()
    {
        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing count ::"+ i))
                .map(i-> new Customer(i, "customer " + i));

    }

}
