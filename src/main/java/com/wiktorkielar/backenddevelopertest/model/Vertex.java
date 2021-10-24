package com.wiktorkielar.backenddevelopertest.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Vertex {
    private Integer index;
    private List<Integer> adjacentVertices;
}
