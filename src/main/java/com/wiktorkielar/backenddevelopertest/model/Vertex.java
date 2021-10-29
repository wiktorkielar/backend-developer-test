package com.wiktorkielar.backenddevelopertest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Vertex {
    private Integer index;
    private List<Integer> adjacentVertices;

    public Vertex(Integer index) {
        this.index = index;
    }
}


