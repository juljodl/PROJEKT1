package edu.ib;

public class PktStaly extends Metoda
{
    public PktStaly(double xL, double ea2, double e, double a, double T, Funkcja f) {
        super(xL, ea2, e, a, T, f);
    }

    @Override
    public double solve(double t)
    {
        double xL=getxL();
        double xR=0;
        double xRs=getxL();

        do {
            xR=getF().f(xL,t,getE(),getT())+xL;
            xL=xR;
            xRs=xR;
            xR=getF().f(xL,t,getE(),getT())+xL;

        }while (ea(xR,xRs)>getEa2());

        return xR;


    }
}
