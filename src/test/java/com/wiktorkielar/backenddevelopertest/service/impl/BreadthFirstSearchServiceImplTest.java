package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.model.Vertex;
import com.wiktorkielar.backenddevelopertest.service.BreadthFirstSearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BreadthFirstSearchServiceImplTest {

    private BreadthFirstSearchService breadthFirstSearchService;

    @BeforeEach
    void setup() {
        breadthFirstSearchService = new BreadthFirstSearchServiceImpl();
    }

    @Test
    void shouldReturnShortestPathFirstScenario() {
        //given
        int sourceVertex = 0;
        int destinationVertex = 7;
        List<Vertex> vertices = createVertices();
        List<Integer> expectedPath = List.of(0, 3, 7);

        //when
        List<Integer> shortestPath = breadthFirstSearchService.getShortestPath(sourceVertex, destinationVertex, vertices);

        //then
        assertEquals(expectedPath, shortestPath);
    }

    @Test
    void shouldReturnShortestPathSecondScenario() {
        //given
        int sourceVertex = 2;
        int destinationVertex = 6;
        List<Vertex> vertices = createVertices();
        List<Integer> expectedPathOne = List.of(2, 1, 0, 3, 4, 6);
        List<Integer> expectedPathTwo = List.of(2, 1, 0, 3, 7, 6);

        //when
        List<Integer> shortestPath = breadthFirstSearchService.getShortestPath(sourceVertex, destinationVertex, vertices);

        //then
        assertTrue(expectedPathOne.equals(shortestPath) || expectedPathTwo.equals(shortestPath));
    }

    @Test
    void shouldReturnShortestPathThirdScenario() {
        //given
        int sourceVertex = 0;
        int destinationVertex = 8;
        List<Vertex> vertices = createVertices();
        List<Integer> expectedPath = List.of(8);

        //when
        List<Integer> shortestPath = breadthFirstSearchService.getShortestPath(sourceVertex, destinationVertex, vertices);

        //then
        assertEquals(expectedPath, shortestPath);
    }

    private List<Vertex> createVertices() {
        return List.of(
                new Vertex(2, List.of(1)),
                new Vertex(1, List.of(2, 0)),
                new Vertex(0, List.of(1, 3)),
                new Vertex(3, List.of(0, 7, 4)),
                new Vertex(7, List.of(3, 4, 6)),
                new Vertex(4, List.of(3, 7, 6, 5)),
                new Vertex(6, List.of(7, 4, 5)),
                new Vertex(5, List.of(4, 6)),
                new Vertex(8, List.of())
        );
    }

}