package com.mastercard.route.challenge.service;

import com.mastercard.route.challenge.domain.GraphNode;
import com.mastercard.route.challenge.exceptions.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
public class RouteFinder {

    @Autowired
    private GraphNode<String> routesMap;

    /**
     * Determine if route exists
     * @param origin
     * @param destination
     * @return
     */
    public String routeExists(String origin, String destination) {
        if (origin == null || destination == null || origin.length() == 0 || destination.length() == 0) {
            throw new ApplicationException("origin or destination is NULL");
        }
        return exists(origin, destination) || exists(destination, origin) ? "Yes" : "No";
    }

    private boolean exists(String origin, String destination) {
        return routesMap.stream().filter(city -> city.getData().equals(origin)).anyMatch(node -> node.stream().map(GraphNode::getData).collect(Collectors.toSet()).contains(destination));
    }
}
