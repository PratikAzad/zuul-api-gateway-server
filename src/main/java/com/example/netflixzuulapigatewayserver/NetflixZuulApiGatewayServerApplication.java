package com.example.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import brave.sampler.Sampler;


@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
//@Import({JWTSecurityConfig.class})
public class NetflixZuulApiGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
    }
    
    //adding sleuth to this app for enable distributed tracing
    @Bean
    public Sampler defaultSampler() {
    	return Sampler.ALWAYS_SAMPLE;
    }
}

//To make all the request through api gateway we have to follow the following url :
//     http://localhost:8765/{application-name-registered with eureka}/{uri}


//  Example:   http://localhost:8765/currency-exchange-service/exchange/from/USD/to/INR
