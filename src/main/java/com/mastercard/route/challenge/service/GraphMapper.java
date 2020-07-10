package com.mastercard.route.challenge.service;

import com.mastercard.route.challenge.domain.GraphNode;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Optional;

@Slf4j
@Service
public class GraphMapper {

    private GraphNode<String> graphNode = new GraphNode<>("ROOT");
    private static String DELIMITER = ",";

    /**
     * Read input resource
     * @param routesMap
     * @return
     */
    @SneakyThrows
    public GraphNode<String> buildTree(Resource routesMap) {
        assert routesMap != null;
        try (InputStreamReader instream = new FileReader(routesMap.getFile())) {
            BufferedReader buffer = new BufferedReader(instream);
            buffer.lines().forEach(route -> {
                String[] singleRoute = route.split(DELIMITER);
                if (singleRoute.length != 2) {
                    log.error("route must contain 2 cities");
                } else {
                    addChild(singleRoute[0].trim(), singleRoute[1].trim());
                }
            });
        }
        return graphNode;
    }

    private void addChild(String start, String destination) {
        Optional<GraphNode<String>> node = graphNode.stream().filter(city -> city.getData().equals(start)).findFirst();
        Optional<GraphNode<String>> destinationNode = graphNode.stream().filter(city -> city.getData().equals(destination)).findFirst();
        if (node.isPresent()) {
            addDestination(destination, node.get(), destinationNode);
        } else {
            addDestination(destination, graphNode.addChild(start), destinationNode);
        }
    }

    private void addDestination(String destination, GraphNode<String> node, Optional<GraphNode<String>> destinationNode) {
        if (destinationNode.isPresent()) {
            node.addChild(destinationNode);
        } else {
            node.addChild(destination);
        }
    }
}
