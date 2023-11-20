package com.starv.micro.goods.model;

import org.springframework.boot.autoconfigure.cassandra.CassandraConnectionDetails;

import java.util.List;

public class AppCassandraConnectionDetails implements CassandraConnectionDetails {

    private final List<Node> nodes;
    private final String dc;

    public AppCassandraConnectionDetails(List<Node> nodes, String dc) {
        this.nodes = nodes;
        this.dc = dc;
    }

    @Override
    public List<Node> getContactPoints() {
        return nodes;
    }

    @Override
    public String getLocalDatacenter() {
        return dc;
    }
}
