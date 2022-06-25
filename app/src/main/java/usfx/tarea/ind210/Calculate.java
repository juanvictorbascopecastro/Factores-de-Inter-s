package usfx.tarea.ind210;

public class Calculate {
    // Retorna F
    public static double FCCPU(double i, double n, double P){
        return P*Math.pow((1+i), n);
    }
    // Retorna P
    public static  double FVPPU(double i, double n, double F){
        return F*(1/Math.pow((1+i), n));
    }
    //Retorna P
    public static  double FVPSU (double i, double n, double A){
        return A*((Math.pow((1+i), n) - 1)/(i*Math.pow((1+i), n)));
    }
    //Retorna A
    public static  double FRC (double i, double n, double P){
        return P*((i*Math.pow((1+i), n))/(Math.pow((1+i), n)-1));
    }
    // Retorna A
    public static  double FFA (double i, double n, double F){
        return F*(i/(Math.pow((1+i), n)-1));
    }
    //Retorna F
    public static  double FCCSU(double i, double n, double A){
        return A*((Math.pow((1+i), n)-1)/i);
    }
}
