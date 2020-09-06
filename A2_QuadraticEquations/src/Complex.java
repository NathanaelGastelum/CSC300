public class Complex
{
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal()
    {
        return real;
    }
    public void setReal(double real)
    {
        this.real = real;
    }

    public double getImaginary()
    {
        return imaginary;
    }
    public void setImaginary(double imaginary)
    {
        this.imaginary = imaginary;
    }

    public boolean isReal()
    {
        return imaginary == 0;
    }

    public boolean equals(Complex number)
    {
        if(real == number.real && imaginary == number.imaginary)
            return true;
        else
            return false;
    }

    public String toString() {
        if(imaginary == 0)
            return String.format("%.2f", real);
        else
            return imaginary < 0 ?
                    String.format("%.2f - %.2fi", real, -imaginary) :
                    String.format("%.2f + %.2fi", real, imaginary);
    }
}