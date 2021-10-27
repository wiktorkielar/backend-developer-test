package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.model.Vertex;
import com.wiktorkielar.backenddevelopertest.service.BreadthFirstSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class BreadthFirstSearchServiceImpl implements BreadthFirstSearchService {

    @Override
    public List<Integer> getShortestPath(int sourceVertex, int destinationVertex, List<Vertex> vertices) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        vertices.forEach(vertex -> adjacencyList.add(new ArrayList<>()));
        addEdges(adjacencyList, vertices);
        return getShortestDistance(adjacencyList, sourceVertex, destinationVertex, vertices.size());
    }

    private void addEdges(List<List<Integer>> adjacencyList, List<Vertex> vertices) {
        vertices.forEach(vertex ->
                vertex.getAdjacentVertices().forEach(adjacentVertex -> {
                    adjacencyList.get(vertex.getIndex()).add(adjacentVertex);
                    adjacencyList.get(adjacentVertex).add(vertex.getIndex());
                })
        );
    }

    private List<Integer> getShortestDistance(List<List<Integer>> adjacencyList, int sourceVertex,
                                                     int destinationVertex, int numberOfVertices) {
        int[] predecessors = new int[numberOfVertices];
        int[] distance = new int[numberOfVertices];
        breadthFirstSearch(adjacencyList, sourceVertex, destinationVertex, numberOfVertices, distance, predecessors);
        List<Integer> path = new LinkedList<>();
        int crawl = destinationVertex;
        path.add(crawl);
        while (predecessors[crawl] != -1) {
            path.add(predecessors[crawl]);
            crawl = predecessors[crawl];
        }
        Collections.reverse(path);
        return path;
    }

    private boolean breadthFirstSearch(List<List<Integer>> adjacencyList, int sourceVertex,
                                              int destinationVertex, int numberOfVertices, int[] distance,
                                              int[] predecessors) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numberOfVertices];
        initializeArrays(sourceVertex, numberOfVertices, visited, distance, predecessors);
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            for (int i = 0; i < adjacencyList.get(vertex).size(); i++) {
                int endVertex = adjacencyList.get(vertex).get(i);
                if (!visited[endVertex]) {
                    visited[endVertex] = true;
                    distance[endVertex] = distance[vertex] + 1;
                    predecessors[endVertex] = vertex;
                    queue.add(endVertex);
                    if (endVertex == destinationVertex)
                        return true;
                }
            }
        }
        return false;
    }

    private void initializeArrays(int sourceVertex, int numberOfVertices, boolean[] visited,
                                         int[] distance, int[] predecessors) {
        for (int i = 0; i < numberOfVertices; i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
            predecessors[i] = -1;
        }
        visited[sourceVertex] = true;
        distance[sourceVertex] = 0;
    }
}

