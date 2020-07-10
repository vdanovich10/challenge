package com.mastercard.route.challenge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class GraphNode<E> {

    private final E data;
    private final List<GraphNode<E>> children;

    /**
     * Creates the graph node with the specified data and no children.
     *
     * @param data
     */
    public GraphNode(final E data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    /**
     * @return the data contained in this node
     */
    public E getData() {
        return data;
    }

    /**
     * Adds a child to this graph node.
     *
     * @param data the data to add
     */
    public GraphNode<E> addChild(final E data) {
        final GraphNode<E> toAdd = new GraphNode<>(data);
        children.add(toAdd);
        return toAdd;
    }

    public GraphNode<E> addChild(final Optional<GraphNode<E>> data) {
        if(data.isPresent())
            children.add(data.get());
        return this;
    }

    /**
     * @return a stream of nodes in this tree in depth first order
     */
    public Stream<GraphNode<E>> stream() {
        return Stream.concat(Stream.of(this), children.stream().flatMap(GraphNode::stream));
    }
}
