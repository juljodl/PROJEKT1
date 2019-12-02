package edu.ib;

public class Sieczne extends Metoda
{
    private double xRs2;

    public Sieczne(double xL, double ea2, double e, double a, double T, Funkcja f, double xRs2) {
        super(xL, ea2, e, a, T, f);
        this.xRs2 = xRs2;

    }

    public double getxRs2() {
        return xRs2;
    }

    public void setxRs2(double xRs2) {
        this.xRs2 = xRs2;
    }

    @Override
    public double solve(double t) {
        double xRs2=getxRs2();
        double xL=getxL();
        double xR;
        double xRs=getxL();

        do {
            xR=xL-(getF().f(xL,t,getE(),getT())*(xRs2-xL))/(getF().f(xRs2,t,getE(),getT())-getF().f(xL,t,getE(),getT()));
            xRs2=xL;
            xL=xR;
            xRs=xR;

            xR=xL-(getF().f(xL,t,getE(),getT())*(xRs2-xL))/(getF().f(xRs2,t,getE(),getT())-getF().f(xL,t,getE(),getT()));


        }while (ea(xR,xRs)>getEa2());

        return xR;

    }
}
