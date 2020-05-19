package academy.pocu.comp2500.lab2;

public class ComplexNumberAnotherMan {
    public final double real;
    public final double imaginary;

    public ComplexNumberAnotherMan() {
        this(0.0, 0.0);
    }

    public ComplexNumberAnotherMan(double real) {
        this(real, 0.0);
    }

    public ComplexNumberAnotherMan(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public boolean isReal() {
        return this.imaginary == 0.0;
    }

    public boolean isImaginary() {
        return this.real == 0.0;
    }

    public ComplexNumber getConjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }

    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber(this.real + num.real, this.imaginary + num.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber num) {
        return new ComplexNumber(this.real - num.real, this.imaginary - num.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber num) {
        return new ComplexNumber(this.real * num.real + this.imaginary * num.imaginary * -1, this.real * num.imaginary + this.imaginary * num.real);
    }

    public ComplexNumber divide(ComplexNumber num) {
        double denominator = num.real * num.real + num.imaginary * num.imaginary;
        return new ComplexNumber(this.multiply(num.getConjugate()).real / denominator, this.multiply(num.getConjugate()).imaginary / denominator);
    }

}
