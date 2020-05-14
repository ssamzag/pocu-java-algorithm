package academy.pocu.comp2500.lab2;

public class ComplexNumber {
    public double real, imaginary;

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
        return this.imaginary == 0.0;
    }

    public boolean isImaginary() {
        return real == 0.0;
    }

    public ComplexNumber getConjugate() {
        return new ComplexNumber(this.real, this.imaginary * -1);
    }

    public ComplexNumber add(ComplexNumber complexNumber) {
        return new ComplexNumber(this.real + complexNumber.real, this.imaginary + complexNumber.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber complexNumber) {
        return new ComplexNumber(this.real - complexNumber.real, this.imaginary - complexNumber.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber complexNumber) {
        if (this.imaginary == 0 && complexNumber.imaginary == 0) {
            return new ComplexNumber(this.real * complexNumber.real, 0);
        }
        double real = this.real * complexNumber.real - this.imaginary * complexNumber.imaginary;
        double imaginary = this.real * complexNumber.imaginary + this.imaginary * complexNumber.real;
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber divide(ComplexNumber complexNumber) {
        if (complexNumber.imaginary == 0) {
            return new ComplexNumber(this.real / complexNumber.real, this.imaginary / complexNumber.imaginary);
        }

        if (Math.abs(complexNumber.real) < Math.abs(complexNumber.imaginary)) {
            double t1 = complexNumber.real / complexNumber.imaginary;
            double t2 = complexNumber.real * t1 + complexNumber.imaginary;

            return new ComplexNumber((this.real * t1 + this.imaginary) / t2, (this.imaginary * t1 - this.real) / t2);
        } else {
            double t1 = complexNumber.imaginary / complexNumber.real;
            double t2 = complexNumber.imaginary * t1 + complexNumber.real;

            return new ComplexNumber((this.real + this.imaginary * t1) / t2, (this.imaginary - this.real * t1) / t2);
        }
    }
}
