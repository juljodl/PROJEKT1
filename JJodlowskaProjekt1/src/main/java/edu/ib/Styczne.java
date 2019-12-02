package edu.ib;

public class Styczne extends Metoda
{

    public Styczne(double xL, double ea2, double e, double a, double T, Funkcja f) {
        super(xL, ea2, e, a, T, f);
    }


    @Override
    public double solve(double t) {
        double xL=getxL();
        double xRs=getxL();
        double xR=0;
        do {
            xR=xL-(getF().f(xL,t,getE(),getT())/getF().p(xL,getE()));
            xL=xR;
            xRs=xR;
            xR=xL-(getF().f(xL,t,getE(),getT())/getF().p(xL,getE()));
        } while(ea(xR,xRs)>getEa2());
        return xR;
        



    }

}
