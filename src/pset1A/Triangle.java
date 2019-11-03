package com.company;

import java.text.DecimalFormat;

public class Triangle {
    public double getSide1() {
        return _side1;
    }

    public double getSide2() {
        return _side2;
    }

    public double getSide3() {
        return _side3;
    }

    private double _side1 = 1.0;
    private double _side2 = 1.0;
    private double _side3 = 1.0;

    public Triangle(){
    }

    public Triangle(double side1, double side2, double side3){
        _side1 = side1;
        _side2 = side2;
        _side3 = side3;
    }

    public double getArea(){
        double p = (_side1 + _side2 + _side3)/2;
        double area = Math.sqrt((p * (p-_side1)*(p-_side2)*(p-_side3)));
        return area;
    }

    public double getPerimeter(){
        return _side1 + _side2 + _side3;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("#.#");
        String result = "Triangle: side1 = " + df.format(_side1) + " side2 = " + df.format(_side2) + " side 3 = " + df.format(_side3);
        return result;
    }
}
