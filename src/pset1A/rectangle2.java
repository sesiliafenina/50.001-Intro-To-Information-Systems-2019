package com.company;
public class rectangle2 {

    // creating double data fields x and y
    public double x = 0;
    public double y = 0;

    // creating data fields width and height
    public double width;
    public double height;

    // get and set x
    public void setX(double newX){
        x = newX;
    }

    public double getX(){
        return x;
    }

    //get and set y
    public void setY(double newY){
        y = newY;
    }

    public double getY(){
        return this.y;
    }



    //no arg constructor that creates default rectangle
    public rectangle2(){

        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }

    // constructor that creates rectangle with specified width and height
    public rectangle2(double newx, double newy, double newwidth, double newheight){
        x = newx;
        y = newy;
        width = newwidth;
        height = newheight;
    }

    //method getArea()

    public double getArea(){
        return (this.width * this.height);
    }

    //method getPerimeter()

    public double getPerimeter(){
        return ((2 * this.width) + (2 * this.height));
    }

    // method contains(MyRectangle2D r)
    public boolean contains(rectangle2 r){

        if (((r.y + r.height) < (this.y + this.height)) && ((r.x + r.width) < (this.x + this.height)) &&
                (r.x> this.x) && (r.y > this.y)){
            return (true);
        }

        return (false);

    }
    //method contains(double x, double y)
    public boolean contains(double x, double y) {
        if ((x > this.x) && ((x - this.x)<= this.width) && (y > this.y) && ((y - this.y) <= this.height)){
            return true;
        }
        return false;
    }

    //method overlaps(MyRectangle2D r)
    public boolean overlaps(rectangle2 r){

        if (((this.y + this.height) < r.y) || (this.y > (r.y + r.height))){
            return false;
        }

        else if (((this.x + this.width) < r.x) || (this.x > (r.x + r.width))){
            return false;
        }
        return true;

    }




}