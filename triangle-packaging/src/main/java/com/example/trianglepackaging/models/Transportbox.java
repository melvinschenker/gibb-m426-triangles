package com.example.trianglepackaging.models;

import javafx.geometry.Point2D;

import java.util.ArrayList;

/**
 * Transportbox model which is used for displaying to JavaFX
 * @author Alexander Gogas
 * @version 1.1
 */
public class Transportbox {
    private Point2D coord;
    private final double height;
    private final double width;
    private final Vector[] transportboxVectors = new Vector[4];
    private ArrayList<Triangle> triangles = new ArrayList<>();

    public Transportbox(int x, int y, double height, double width){
        this.coord = new Point2D(x, y);
        this.height = height;
        this.width = width;
        initializeVectors();
    }

    private void initializeVectors(){
        transportboxVectors[0] = new Vector(width, 0);
        transportboxVectors[1] = new Vector(0, height);
        transportboxVectors[2] = new Vector(-width, 0);
        transportboxVectors[3] = new Vector(0, -height);
    }

    public Vector[] getTransportboxVectors(){
        return  this.transportboxVectors;
    }

    //TODO: Implement draw method
    /**
     * Draw the Transportbox to the JavaFX display.
     */
    public void draw(){}

    //TODO: Implement placeTriangles method
    /**
     * Places triangles into the box after calculations.
     * Checks for collisions of triangles before placing.
     */
    public void placeTriangles(){}
}
