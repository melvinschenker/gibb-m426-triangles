package com.example.trianglepackaging.models;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    Triangle triangle;

    @BeforeEach
    void setUp(){
        triangle = new Triangle(10, 150, Color.RED);
    }

    @Test
    @DisplayName("Ensure correct triangle instantiation")
    void testTriangle(){
        int length = 10;
        double triangleHeight = (Math.sqrt(3) / 2) * length;
        Vector[] vectors = triangle.getTriangleVector();

        assertEquals(length,vectors[0].getX(), 0.001);
        assertEquals(0, vectors[0].getY(), 0.001);

        assertEquals(-length/2,vectors[1].getX(), 0.001);
        assertEquals(triangleHeight, vectors[1].getY(), 0.001);

        assertEquals(length/2,vectors[2].getX(), 0.001);
        assertEquals(-triangleHeight, vectors[2].getY(), 0.001);
    }

    @Test
    void draw() {
        // placeholder
    }

    @Test
    @DisplayName("Ensure correct placement of triangle")
    void positionTriangle() {
        assertEquals(new Point2D(4,7), triangle.positionTriangle(4,7));
    }
}