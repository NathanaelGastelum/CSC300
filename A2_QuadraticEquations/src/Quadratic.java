import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Quadratic {

    private int a;
    private int b;
    private int c;
    private ComplexPair solution;

    public Quadratic(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    ComplexPair solveQuadratic () {
        Complex firstRoot;
        Complex secondRoot;

        double discriminant = b * b - 4 * a * c;

        if (a == 0) {
            solution = new ComplexPair(new Complex((-c)/b, 0), null);
            return solution;
        }
        else if (discriminant >= 0.0) {
            firstRoot = new Complex((-b + sqrt(b*b - 4*a*c))/(2*a), 0);
            secondRoot = new Complex((-b - sqrt(b*b - 4*a*c))/(2*a), 0);
            solution = new ComplexPair(firstRoot, secondRoot);
            return solution;
        }
        else if(discriminant < 0)
        {
            solution = new ComplexPair(
                    new Complex(-b / (2 * a), Math.sqrt(abs(discriminant)) / (2 * a)),
                    new Complex(-b / (2 * a), -Math.sqrt(abs(discriminant)) / (2 * a)));
            return solution;
        }
        else
        {
            solution = new ComplexPair(new Complex(0, 0), new Complex(0, 0));
            return solution;
        }
    }

    public String getComment() {
        if (solution.getSecond() == null) {
            return "Linear equation: one real root";
        }
        else if (solution.getFirst().isReal() && solution.getSecond().isReal() && solution.bothIdentical()) {
            return "Double real root";
        }
        else if (solution.getFirst().isReal() && solution.getSecond().isReal() && !solution.bothIdentical()) {
            return "Two distinct real roots";
        }
        else {
            return "Two distinct complex roots";
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(a == 0 ? "" : a == 1 ? "x^2" : a == -1 ? "-x^2" : String.format("%sx^2", a));
        s.append(b < 0 && a == 0 ? String.format("-%sx", -b) : b < 0 && a != 0 ? String.format(" - %sx", -b) : b > 0 && a == 0 ? String.format("%sx", b) : String.format(" + %sx", b));
        s.append(c < 0 ? String.format(" - %s", -c) : String.format(" + %s", c));
        s.append(" = 0");
        return s.toString();
    }
}
