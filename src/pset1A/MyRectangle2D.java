package com.company;

public class MyRectangle2D {
    private double _x;
    private double _y;
    private double _width;
    private double _height;

    public double getX(){
        return _x;
    }

    public void setX(double x){
        _x = x;
    }

    public double getY(){
        return _y;
    }

    public void setY(double y){
        _y = y;
    }

    public double getWidth(){
        return _width;
    }

    public void setWidth(double width){
        _width = width;
    }

    public double getHeight(){
        return _height;
    }

    public void setHeight(double height){
        _height = height;
    }

    public MyRectangle2D(){
        _x = 0;
        _y = 0;
        _width = 1;
        _height = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height){
        _x = x;
        _y = y;
        _width = width;
        _height = height;
    }

    public double getArea(){
        return _width * _height;
    }

    public double getPerimeter(){
        return (2 * _width) + (2 * _height);
    }

    public Boolean contains(double x, double y){
        double xmin = _x - (_width/2);
        double xmax = _x + (_width/2);
        double ymin = _y - (_height/2);
        double ymax = _y + (_height/2);
        if (xmin < x && x < xmax && ymin < y && y < ymax){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean contains(MyRectangle2D r){
        double xmin = _x - (_width/2);
        double xmax = _x + (_width/2);
        double ymin = _y - (_height/2);
        double ymax = _y + (_height/2);
        double xminr = r.getX() - (r.getWidth()/2);
        double xmaxr = r.getX() + (r.getWidth()/2);
        double yminr = r.getY() - (r.getHeight()/2);
        double ymaxr = r.getY() + (r.getHeight()/2);
        if (xmin<xminr && xmax>xmaxr && ymin<yminr && ymax<ymaxr){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean overlaps(MyRectangle2D r){
        double x1 = r.getX() - (r.getWidth()/2);
        double x2 = r.getX() + (r.getWidth()/2);
        double y1 = r.getY() - (r.getHeight()/2);
        double y2 = r.getY() + (r.getHeight()/2);
        if (this.contains(x1,y1) || this.contains(x1,y2) || this.contains(x2,y1) || this.contains(x2,y2)){
            return true;
        }
        else{
            return false;
        }
    }
}
