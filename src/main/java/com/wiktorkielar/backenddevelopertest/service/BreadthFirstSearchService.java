package com.wiktorkielar.backenddevelopertest.service;

import com.wiktorkielar.backenddevelopertest.model.Vertex;

import java.util.List;

public interface BreadthFirstSearchService {
    List<Integer> getShortestPath(int sourceVertex, int destinationVertex, List<Vertex> vertices);
}
