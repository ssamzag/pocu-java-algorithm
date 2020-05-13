package academy.pocu.comp2500.lab2;

public class ComplexNumber {
    public double real;
    public double imaginary;

    public ComplexNumber() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0.0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public boolean isReal() {

        return true;
    }

    public boolean isImaginary() {

        return true;
    }

    public ComplexNumber add() {

        return new ComplexNumber(0,0);
    }

    public ComplexNumber subtract() {

        return new ComplexNumber(0,0);
    }

    public ComplexNumber multiply() {

        return new ComplexNumber(0,0);
    }

    public ComplexNumber divide() {

        return new ComplexNumber(0,0);
    }

}
