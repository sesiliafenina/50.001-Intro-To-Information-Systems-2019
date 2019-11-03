package pset2A;

interface I1{
    int p1();
}

interface I2{
    int p2();
}

interface I3{
    int p3();
}

interface I4 extends I1, I2, I3 {
    int p4();
}

interface I5 extends I3{
    int p5();
}
abstract class Test implements I4{
    abstract int q1();
}
