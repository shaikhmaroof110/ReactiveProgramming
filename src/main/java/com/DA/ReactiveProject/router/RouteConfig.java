package com.DA.ReactiveProject.router;


import com.DA.ReactiveProject.handler.CustomerHandler;
import com.DA.ReactiveProject.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.logging.StreamHandler;

@Configuration
public class RouteConfig {

    @Autowired
    private CustomerHandler handler;


    @Autowired
    private CustomerStreamHandler streamHandler;

    // This is the functional  Endpoint
    // We just need to create Router Handler to call the endpoint.

    @Bean
    public RouterFunction<ServerResponse> routerFunction()
    {
        return RouterFunctions
                .route()
                .GET("/router/customers", handler::loadCustomers)  // http://localhost:9191/router/customers
                .GET("/router/customers/stream", streamHandler::getCustomers) // http://localhost:9191/router/customers/stream
                .GET("/router/customers/{input}", handler::findCustomer)  // http://localhost:9191/router/8
                .POST("/router/customers/save", handler::saveCustomer) // http://localhost:9191/router/save
                .build();

        // All are working as expected....
        // http://localhost:9191/router/customers

    }
}
