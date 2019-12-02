package edu.ib;

public class Funkcje  implements Funkcja{

    public double M(double t, double T){return 2*Math.PI/T*t;}


    @Override
    public double f(double x, double t, double e, double T) { return M(t,T)+e*Math.sin(x)-x; }

    @Override
    public double p(double x, double e) { return e*Math.cos(x)-1; }
}
