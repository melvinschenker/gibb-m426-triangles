package com.example.trianglepackaging.models;

import javafx.geometry.Point2D;

/**
 * Custom vector class to make vector calculations.
 * @author Alexander Gogas
 * @version 1.0
 */
public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return x-component of the vector.
     */
    public double getX(){
        return x;
    }

    /**
     * @return y-component of the vector.
     */
    public double getY() {
        return y;
    }

    public String toString(){
        return "{x: " + this.x + ", y: " + this.y + "}";
    }

    public void move(double deltaX, double deltaY){
        this.x += deltaX;
        this.y += deltaY;
    }

    public void rotate(double angle){
        angle = (angle / 180) * Math.PI;
        double[][] rotationMatrix = new double[2][2];

        rotationMatrix[0][0] = rotationMatrix[1][1] = Math.cos(angle);
        rotationMatrix[1][0] = Math.sin(angle);
        rotationMatrix[0][1] = -rotationMatrix[1][0];

        double newX = rotationMatrix[0][0] * this.x + rotationMatrix[0][1] * this.y;
        double newY = rotationMatrix[1][0] * this.x + rotationMatrix[1][1] * this.y;

        this.x = newX;
        this.y = newY;
    }

    /**
     * Check if a number is between 2 numbers
     * @param number
     * @param lowerLimit
     * @param upperLimit
     * @return
     */
    private static boolean isInBetween(double number, double lowerLimit, double upperLimit){
        return number >=lowerLimit && number <= upperLimit;
    }

    /**
     * Check if 2 vectors collide with each other. Parallelism doesn't count as colliding.
     * @param v1 first vector
     * @param p1 point for the first vector
     * @param v2 second vector
     * @param p2 point for the second vector
     * @return
     */
    public static boolean detectVectorCollision(Vector v1, Point2D p1, Vector v2, Point2D p2){
        // Instantiate and fill equation matrix (Cramer's Rule)
        double[][] eq = new double [2][3];

        eq[0][0] = v1.getX();
        eq[0][1] = -v2.getX();
        eq[0][2]  = p2.getX() - p1.getX();

        eq[1][0] = v1.getY();
        eq[1][1] = -v2.getY();
        eq[1][2] = p2.getY() - p1.getX();


        // Get x and y for the equations (Cramer's Rule)
        double firstSolution = (eq[0][2] * eq[1][1] - eq[1][2] - eq[0][1]) / (eq[0][0] * eq[1][1] - eq[0][1] * eq[1][0]);
        double secondSolution = (eq[0][0] * eq[1][2] - eq[0][2] * eq[1][0]) / (eq[0][0] * eq[1][1] - eq[0][1] * eq[1][0]);

        return isInBetween(firstSolution, 0,1) && isInBetween(secondSolution, 0,1);
    }

}
