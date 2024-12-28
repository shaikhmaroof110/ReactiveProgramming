package com.DA.ReactiveProject.handler;

import com.DA.ReactiveProject.dao.CustomerDao;
import com.DA.ReactiveProject.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

    @Autowired
    private CustomerDao Streamdao;

    public Mono<ServerResponse> getCustomers(ServerRequest request)
    {
        Flux<Customer> customersStream = Streamdao.getCustomersStream();

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM) // we want data as stream not as object
                .body(customersStream, Customer.class);

    }


}
