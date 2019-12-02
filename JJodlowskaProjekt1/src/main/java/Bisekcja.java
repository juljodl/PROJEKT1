import edu.ib.Funkcja;
import edu.ib.Metoda;

public class Bisekcja  extends Metoda
{
    private double xU;

    public Bisekcja(double xL, double ea2, double e, double a, double T, Funkcja f, double xU) {
        super(xL, ea2, e, a, T, f);
        this.xU = xU;
    }

    public double getxU() { return xU; }
    public void setxU(double xU) { this.xU = xU; }


    @Override
    public double solve(double t) {
        double xL=getxL();
        double xU=getxU();
        if(getF().f(xL,t,getE(),getT())*getF().f(xU,t,getE(),getT())>0.0)
        {
            throw new IllegalArgumentException("Brak miejsca zerowego");
        }

        double xR=0;
        while (ea(xL,xU)>getEa2())
        {
            xR=(xL+xU)/2.0;

            if (getF().f(xL,t,getE(),getT())*getF().f(xR,t,getE(),getT())<0.0)
                xU=xR;
            else if (getF().f(xL, t, getE(), getT())*getF().f(xR,t,getE(),getT())>0.0)
                xL=xR;
            else
                break;

        }
        return xR;

    }
}//class
