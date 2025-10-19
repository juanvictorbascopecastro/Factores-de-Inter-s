package usfx.tarea.ind210;

public class FormulariesDisplay {

    // Retorna F
    public static String FCCPU(String i, String n, String P) {
        return "\\displaystyle "
                + "\\textcolor{red}{\\textbf{FCCPU}} \\\\ "
                + "F_n = P(1+i)^n \\\\ "
                + "F_n = " + P + "(1+" + i + ")^{" + n + "} \\\\ "
                + "\\boxed{F_n = " + redondear(Calculate.FCCPU(Double.parseDouble(i), Double.parseDouble(n), Double.parseDouble(P))) + "}";
    }

    // Retorna P
    public static String FVPPU(String i, String n, String F) {
        return "\\displaystyle "
                + "\\textcolor{red}{\\textbf{FVPPU}} \\\\ "
                + "P = F\\left(\\frac{1}{(1+i)^n}\\right) \\\\ "
                + "P = " + F + "\\left(\\frac{1}{(1+" + i + ")^{" + n + "}}\\right) \\\\ "
                + "\\boxed{P = " + redondear(Calculate.FVPPU(Double.parseDouble(i), Double.parseDouble(n), Double.parseDouble(F))) + "}";
    }

    // Retorna P
    public static String FVPSU(String i, String n, String A) {
        return "\\displaystyle "
                + "\\textcolor{red}{\\textbf{FVPSU}} \\\\ "
                + "P = A\\left(\\frac{(1+i)^n-1}{i(1+i)^n}\\right) \\\\ "
                + "P = " + A + "\\left(\\frac{(1+" + i + ")^{" + n + "}-1}{" + i + "(1+" + i + ")^{" + n + "}}\\right) \\\\ "
                + "\\boxed{P = " + redondear(Calculate.FVPSU(Double.parseDouble(i), Double.parseDouble(n), Double.parseDouble(A))) + "}";
    }

    // Retorna A
    public static String FRC(String i, String n, String P) {
        return "\\displaystyle "
                + "\\textcolor{red}{\\textbf{FRC}} \\\\ "
                + "A = P\\left(\\frac{i(1+i)^n}{(1+i)^n-1}\\right) \\\\ "
                + "A = " + P + "\\left(\\frac{" + i + "(1+" + i + ")^{" + n + "}}{(1+" + i + ")^{" + n + "}-1}\\right) \\\\ "
                + "\\boxed{A = " + redondear(Calculate.FRC(Double.parseDouble(i), Double.parseDouble(n), Double.parseDouble(P))) + "}";
    }

    // Retorna A
    public static String FFA(String i, String n, String F) {
        return "\\displaystyle "
                + "\\textcolor{red}{\\textbf{FFA}} \\\\ "
                + "A = F\\left(\\frac{i}{(1+i)^n-1}\\right) \\\\ "
                + "A = " + F + "\\left(\\frac{" + i + "}{(1+" + i + ")^{" + n + "}-1}\\right) \\\\ "
                + "\\boxed{A = " + redondear(Calculate.FFA(Double.parseDouble(i), Double.parseDouble(n), Double.parseDouble(F))) + "}";
    }

    // Retorna F
    public static String FCCSU(String i, String n, String A) {
        return "\\displaystyle "
                + "\\textcolor{red}{\\textbf{FCCSU}} \\\\ "
                + "F = A\\left(\\frac{(1+i)^n-1}{i}\\right) \\\\ "
                + "F = " + A + "\\left(\\frac{(1+" + i + ")^{" + n + "}-1}{" + i + "}\\right) \\\\ "
                + "\\boxed{F = " + redondear(Calculate.FCCSU(Double.parseDouble(i), Double.parseDouble(n), Double.parseDouble(A))) + "}";
    }

    // Utilidad para redondear valores a 4 decimales
    private static String redondear(double valor) {
        return String.format("%.2f", valor);
    }
}
