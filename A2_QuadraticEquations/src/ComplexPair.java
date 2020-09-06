public class ComplexPair {

    private Complex first;
    private Complex second;

    public ComplexPair(Complex first, Complex second) {
        this.first = first;
        this.second = second;
    }

    boolean bothIdentical() {
        return first.equals(second);
    }

    @Override
    public String toString() {
        if (second == null)
            return "first: " + first;
        else
            return "first: " + first + ", second: " + second;
    }

    public Complex getFirst() {
        return first;
    }
    public Complex getSecond() {
        return second;
    }
}
