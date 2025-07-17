package com.ign.springcloud.msvc.oauth;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

/*     @Bean
    @LoadBalanced
    WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder().baseUrl("http://msvc-users");
    } */

    /**
     * Creates a load-balanced {@link WebClient} bean configured with a base URL and a load balancer filter function.
     *
     * @param builder the {@link WebClient.Builder} used to configure and build the {@link WebClient}.
     * @param lbFunction the {@link ReactorLoadBalancerExchangeFilterFunction} used to enable load balancing for the WebClient.
     * @return a configured {@link WebClient} instance with load balancing capabilities.
     */
    @Bean
    WebClient loadBalancedWebClientBuilder(WebClient.Builder builder, ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        return builder.baseUrl("http://msvc-users").filter(lbFunction).build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
