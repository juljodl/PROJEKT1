package edu.ib;

import java.util.ArrayList;

public abstract class Metoda
{
    private double xL;
    private double ea2;
    private double e;
    private double a;
    private double T;
    private Funkcja f;

    public Metoda(double xL, double ea2, double e, double a, double T, Funkcja f) {
        this.xL = xL;
        this.ea2 = ea2;
        this.e = e;
        this.a = a;
        this.T = T;
        this.f = f;
    }
    //getters and setters
    public double getxL() { return xL; }
    public void setxL(double xL) { this.xL = xL; }
    public double getEa2() { return ea2; }
    public void setEa2(double ea2) { this.ea2 = ea2; }
    public double getE() { return e; }
    public void setE(double e) { this.e = e; }
    public double getA() { return a; }
    public void setA(double a) { this.a = a; }
    public double getT() { return T; }
    public void setT(double t) { T = t; }
    public Funkcja getF() { return f; }
    public void setF(Funkcja f) { this.f = f; }


    public double ea(double obecny, double poprzedni){
        return Math.abs((obecny-poprzedni)/obecny)*100;
    }

    public abstract double solve(double t);

    public double[] pozycja (double t)
    {
        double x = a*Math.cos(solve(t)-e);
        double y = a*Math.sqrt(1-Math.pow(e,2))*Math.sin(solve(t));
        double [] wspolrzedne ={x,y};
        return wspolrzedne;
    }

    public ArrayList<double[]> trajektoria()
    {
        ArrayList<double[]> trajektoria = new ArrayList<>();
        for (int t = 1; t <=T ; t++) {
            trajektoria.add(pozycja(t));
        }
        return trajektoria;
    }



}//class
