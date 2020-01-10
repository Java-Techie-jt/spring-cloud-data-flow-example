package com.javatechie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableBinding(Source.class)
public class ProductServiceApplication {


	Logger logger=LoggerFactory.getLogger(ProductServiceApplication.class);

	@Bean
	@InboundChannelAdapter(value = Source.OUTPUT,poller = @Poller(fixedDelay = "10000",maxMessagesPerPoll = "1"))
	public MessageSource<List<Product>> addProducts(){
		List<Product> products= Stream.of(new Product(101,"Mobile",8000)
				,new Product(102,"book",6000))
				.collect(Collectors.toList());
		logger.info("products : {}",products);
		return ()-> MessageBuilder.withPayload(products).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
