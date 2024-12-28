package com.DA.ReactiveProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveProjectApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Test
//	public void testMono()
//	{
//		Mono<?> monoString = Mono.just("Javatechie")
//				.then(Mono.error(new RuntimeException("Exception occured in mono")))
//		.log();
//		monoString.subscribe(System.out::println, (e)-> System.out.println(e.getMessage()));
//	}
//
//
//	@Test
//	public void testFlux()
//	{
//		Flux<String> fulxString = Flux.just("Spring", "SpringBoot", "Microservice")
//				.concatWithValues("Hibernate","AWS")
//				.concatWith(Flux.error(new RuntimeException("Exception occured in flux")))
//				.concatWithValues("Microservices","Kubernate")
//				.log();
//		fulxString.subscribe(System.out::println);
//	}

}
