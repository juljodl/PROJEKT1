package edu.ib;

public class MetodaFalsi extends Metoda
{
    private double xU;

    public MetodaFalsi(double xL, double ea2, double e, double a, double T, Funkcja f, double xU) {
        super(xL, ea2, e, a, T, f);
        this.xU = xU;
    }

    public double getxU() { return xU; }
    public void setxU(double xU) { this.xU = xU; }

    @Override
    public double solve(double t) {
        double xL=getxL();
        double xU=getxU();
        if(getF().f(xL,t,getE(),getT())*getF().f(xU,t,getE(),getT())>0.0){
            throw new IllegalArgumentException("Brak miejsca zerowego");
        }

        double xR=0;
        double xRs=getxL();

        do {
            xR=xU-(getF().f(xU,t,getE(),getT())*(xL-xU))/(getF().f(xL,t,getE(),getT())-getF().f(xU,t,getE(),getT()));

            if (getF().f(xL,t,getE(),getT())*getF().f(xR,t,getE(),getT())<0.0)
                xU=xR;
            else if (getF().f(xL,t,getE(),getT())*getF().f(xR,t,getE(),getT())>0.0)
                xL=xR;
            else
                break;

            xRs=xR;
            xR=xU-(getF().f(xU,t,getE(),getT())*(xL-xU))/(getF().f(xL,t,getE(),getT())-getF().f(xU,t,getE(),getT()));

        }while (ea(xR,xRs)>getEa2());
        return xR;



    }
}
