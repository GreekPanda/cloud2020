package com.github.greekpanda.springcloud2020.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/24 12:25
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_test_id", r -> r.path("/greekpanda")
                //注意这里的规则是http开头，如果需要https必须使用https
                .uri("https://www.github.com/greekpanda"))
                .build();
        return routes.build();
    }
}
