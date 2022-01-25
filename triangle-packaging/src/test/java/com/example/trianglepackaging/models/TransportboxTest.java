package com.example.trianglepackaging.models;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportboxTest {

    Transportbox box;

    @BeforeEach
    void setUp(){
        box = new Transportbox(10, 150, 100, 100);
    }

    @Test
    @DisplayName("Ensure correct transportbox initialization")
    void testTransportbox(){
        Vector[] vectors = box.getTransportboxVectors();

        assertEquals(100, vectors[0].getX(), 0.001);
        assertEquals(0, vectors[0].getY(), 0.001);

        assertEquals(0, vectors[1].getX(), 0.001);
        assertEquals(100, vectors[1].getY(), 0.001);

        assertEquals(-100, vectors[2].getX(), 0.001);
        assertEquals(0, vectors[2].getY(), 0.001);

        assertEquals(0, vectors[3].getX(), 0.001);
        assertEquals(-100, vectors[3].getY(), 0.001);
    }

    @Test
    void draw() {
        // placeholder
    }

    @Test
    void placeTriangles() {
        // placeholder
    }
}