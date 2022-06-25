package usfx.tarea.ind210;
public class Formulario {
    // Retorna F
    public static String FCCPU(String i, String n, String P){
        String texto = "$$\\begin{align}"+
                "\\mathbf{\\color{red}{FCCPU}}\\\\\n"+
                " F_n = P(1+i)^n \\\\\n"+
                " F_n = "+P+"(1+"+i+")^"+n+"\\\\\n"+
                " \\mathbf{F_n = "+ Calculate.FCCPU(Double.parseDouble(i), Double.parseDouble(n), Double.parseDouble(P))+"}"+
                "\\end{align}$$";
        return texto;
    }
    // Retorna P
    public static String FVPPU(String i, String n, String F){
        String texto = "$$\\begin{align}"+
                "\\mathbf{\\color{red}{FVPPU}}\\\\\n"+
                " P = F(\\frac{1}{(1+i)^n}) \\\\\n"+
                " P = "+F+"(\\frac{1}{(1+"+i+")^"+n+"})\\\\\n"+
                " \\mathbf{P = "+Calculate.FVPPU(Double.parseDouble(i), Double.parseDouble(n), Double.parseDouble(F))+"}"+
                "\\end{align}$$";
        return texto;
    }
    //Retorna P
    public static String FVPSU (String i, String n, String A){
        String texto = "$$\\begin{align}"+
                "\\mathbf{\\color{red}{FVPSU}}\\\\\n"+
                " P = A(\\frac{(1+i)^n-1}{i(1+i)^n}) \\\\\n"+
                " P = "+A+"(\\frac{(1+"+i+")^"+n+"-1}{"+i+"(1+"+i+")^"+n+"})\\\\\n" +
                "\\mathbf{P = "+Calculate.FVPSU(Double.parseDouble(i),Double.parseDouble(n),Double.parseDouble(A))+"}"+
                "\\end{align}$$";
        return texto;
    }
    //Retorna A
    public static String FRC (String i, String n, String P){
        String texto = "$$\\begin{align}"+
                "\\mathbf{\\color{red}{FRC}}\\\\\n"+
                " A = P(\\frac{i(1+i)^n}{(1+i)^n-1}) \\\\\n"+
                " A = "+P+"(\\frac{"+i+"(1+"+i+")^"+n+"}{(1+"+i+")^"+n+"-1})\\\\\n"+
                "\\mathbf{ A = "+Calculate.FRC(Double.parseDouble(i), Double.parseDouble(n), Double.parseDouble(P))+"}"+
                "\\end{align}$$";
        return texto;
    }
    // Retorna A
    public static String FFA (String i, String n, String F){
        String texto = "$$\\begin{align}"+
                "\\mathbf{\\color{red}{FFA}}\\\\\n"+
                " A = F(\\frac{i}{(1+i)^"+n+"-1}) \\\\\n"+
                " A = "+F+"(\\frac{"+i +"}{(1+"+i+")^"+n+"-1}) \\\\\n"+
                "\\mathbf{A = "+Calculate.FFA(Double.parseDouble(i), Double.parseDouble(n), Double.parseDouble(F))+"}"+
                "\\end{align}$$";
        return texto;
    }
    //Retorna F
    public static String FCCSU(String i, String n, String A){
        String texto = "$$\\begin{align}"+
                "\\mathbf{\\color{red}{FCCSU}}\\\\\n"+
                " F = A(\\frac{(1+i)^n-1}{i}) \\\\\n"+
                " F = "+A+"(\\frac{1+"+i+")^"+n+"-1}{"+i+"})\\\\\n"+
                "\\mathbf{F = "+Calculate.FCCSU(Double.parseDouble(i), Double.parseDouble(n), Double.parseDouble(A))+"}"+
                "\\end{align}$$";
        return texto;
    }
}
