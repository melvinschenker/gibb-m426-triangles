package com.example.trianglepackaging.models;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

/**
 * Triangle model which is used for displaying to JavaFX
 * @author Alexander Gogas, Melvin Schenker
 * @version 1.1
 */
public class Triangle {
    /**
     * Length of the triangle side. The triangle is equilateral.
     */
    private final double length;
    private final double height;
    private final Color color;
    private final int weight;
    private Point2D coord;
    /**
     * Vector array which contains the vectors of each triangle side.
     * Vector consists of 2 components, x and y.
     */
    private final Vector[] triangleVector = new Vector[3];

    public Triangle(double length, int weight, Color color){
        this.length = length;
        this.weight = weight;
        this.color = color;
        this.height = (Math.sqrt(3) / 2) * length;
        initializeVectors();
    }

    /**
     * Initializes vectors from the (0,0) point
     */
    private void initializeVectors(){
        triangleVector[0] = new Vector(length, 0);
        triangleVector[1] = new Vector(-length/2, height);
        triangleVector[2] = new Vector(length/2, -height);
    }

    //TODO: Implement draw method with JavaFX
    /**
     * Draw the triangle to the JavaFX display.
     */
    public void draw(){

    }

    /**
     * Position the triangle in the box.
     * Mostly used after calculations.
     * @param x
     * @param y
     */
    public Point2D positionTriangle(int x, int y){
        //TODO: Complex logic to convert the vectors to correct coordinates
        this.coord = new Point2D(x, y);
        return this.coord;
    }

    public Vector[] getTriangleVector(){
        return this.triangleVector;
    }
}
