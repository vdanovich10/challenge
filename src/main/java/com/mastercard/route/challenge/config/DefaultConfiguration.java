package com.mastercard.route.challenge.config;

import com.mastercard.route.challenge.domain.GraphNode;
import com.mastercard.route.challenge.service.GraphMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class DefaultConfiguration {

    @Autowired
    private ResourceLoader routesMapLoader;
    @Autowired
    private GraphMapper graphMapper;

    /** Initializing a routes map */
    @Bean
    public GraphNode<String> routesMap() {
        Resource routesMap = routesMapLoader.getResource("classpath:routes.txt");
        return graphMapper.buildTree(routesMap);
    }
}
