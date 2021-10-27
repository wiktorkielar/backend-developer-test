package com.wiktorkielar.backenddevelopertest.model;

import lombok.Data;

import java.util.List;

@Data
public class Vertex {
    private Integer index;
    private List<Integer> adjacentVertices;

    public Vertex(Integer index) {
        this.index = index;
    }
}


