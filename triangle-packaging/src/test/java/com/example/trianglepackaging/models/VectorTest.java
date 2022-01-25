package com.example.trianglepackaging.models;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
    Vector vector;

    @BeforeEach
    void setUp(){
        vector = new Vector(2,4);
    }

    @Test
    @DisplayName("String representation of class should be correct")
    void testToString() {
        assertEquals("{x: 2.0, y: 4.0}", vector.toString());
    }

    @Test
    @DisplayName("Vector moving should be correct")
    void testMove(){
        vector.move(5,-7);
        assertEquals(7, vector.getX());
        assertEquals(-3, vector.getY());
    }

    @Test
    @DisplayName("Vectors should collide")
    void detectVectorCollision() {
        Vector collisionVector1 = new Vector(2,1);
        Point2D collisionPoint1 = new Point2D(1,0);
        Vector collisionVector2 = new Vector(3,0);
        Point2D collisionPoint2 = new Point2D(0.5, 1);

        assertEquals(true, Vector.detectVectorCollision(collisionVector1, collisionPoint1, collisionVector2, collisionPoint2));
    }

    @Test
    @DisplayName("Vectors should not collide")
    void detectVectorsNotColliding() {
        Vector collisionVector1 = new Vector(2,1);
        Point2D collisionPoint1 = new Point2D(5,0);
        Vector collisionVector2 = new Vector(3,0);
        Point2D collisionPoint2 = new Point2D(0.5, 1);

        assertEquals(false, Vector.detectVectorCollision(collisionVector1, collisionPoint1, collisionVector2, collisionPoint2));
    }

    @Test
    @DisplayName("Vectors should not collide because of parallelism")
    void detectVectorsParallelism() {
        Vector collisionVector1 = new Vector(2,1);
        Point2D collisionPoint1 = new Point2D(5,0);
        Vector collisionVector2 = new Vector(2,1);
        Point2D collisionPoint2 = new Point2D(5, 0);

        assertEquals(false, Vector.detectVectorCollision(collisionVector1, collisionPoint1, collisionVector2, collisionPoint2));
    }

    @Test
    @DisplayName("Rotate vector 90°")
    void rotate90() {
        vector.rotate(90);
        assertEquals(-4, vector.getX(), 0.001);
        assertEquals(2, vector.getY(), 0.001);
    }

    @Test
    @DisplayName("Rotate vector 180°")
    void rotate180() {
        vector.rotate(180);
        assertEquals(-2, vector.getX(), 0.001);
        assertEquals(-4, vector.getY(), 0.001);
    }
}