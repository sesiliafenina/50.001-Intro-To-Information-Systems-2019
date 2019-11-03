package com.company;

class LinearEquation {
    private double X;
    private double Y;
    private double _a;
    private double _b;
    private double _c;
    private double _d;
    private double _e;
    private double _f;

    public double getA() {
        return _a;
    }

    public double getB() {
        return _b;
    }

    public double getC() {
        return _c;
    }

    public double getD() {
        return _d;
    }

    public double getE() {
        return _e;
    }

    public double getF() {
        return _f;
    }

    public double getX(){
        solve();
        return X;
    }

    public double getY(){
        solve();
        return Y;
    }

    public LinearEquation(double a, double b, double c, double d, double e, double f){
        _a = a;
        _b = b;
        _c = c;
        _d = d;
        _e = e;
        _f = f;
    }

    public boolean isSolvable(){
        if (_a * _d - _b * _c != 0){
            return true;
        }
        else{
            return false;
        }
    }

    private void solve(){
        double y1coeff = _b * _c;
        double y2coeff = _d * _a;
        Y = (_e*_c - _f*_a)/(y1coeff - y2coeff);
        X = (_e - (_b * Y))/_a;
    }
}
