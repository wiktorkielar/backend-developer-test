package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.model.Vertex;
import com.wiktorkielar.backenddevelopertest.service.BreadthFirstSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class BreadthFirstSearchServiceServiceImpl implements BreadthFirstSearchService {

    @Override
    public List<Integer> getShortestPath(int sourceVertex, int destinationVertex, List<Vertex> vertices) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) {
            adjacencyList.add(new ArrayList<>());
        }
        addEdges(adjacencyList, vertices);
        return printShortestDistance(adjacencyList, sourceVertex, destinationVertex, vertices.size());
    }

    private static void addEdges(List<List<Integer>> adjacencyList, List<Vertex> vertices) {
        vertices.forEach(vertex ->
                vertex.getAdjacentVertices().forEach(adjacentVertex -> {
                    adjacencyList.get(vertex.getIndex()).add(adjacentVertex);
                    adjacencyList.get(adjacentVertex).add(vertex.getIndex());
                })
        );
    }

    private static List<Integer> printShortestDistance(List<List<Integer>> adjacencyList, int sourceVertex,
                                                       int destinationVertex, int numberOfVertices) {
        int[] predecessor = new int[numberOfVertices];
        int[] distance = new int[numberOfVertices];
        breadthFirstSearch(adjacencyList, sourceVertex, destinationVertex, numberOfVertices, distance, predecessor);
        List<Integer> path = new LinkedList<>();
        int crawl = destinationVertex;
        path.add(crawl);
        while (predecessor[crawl] != -1) {
            path.add(predecessor[crawl]);
            crawl = predecessor[crawl];
        }
        Collections.reverse(path);
        return path;
    }

    private static boolean breadthFirstSearch(List<List<Integer>> adjacencyList, int sourceVertex,
                                              int destinationVertex, int numberOfVertices, int[] distance,
                                              int[] predecessors) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numberOfVertices];
        initializeTables(sourceVertex, numberOfVertices, visited, distance, predecessors);
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

    private static void initializeTables(int sourceVertex, int numberOfVertices, boolean[] visited,
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

