package Lab6;

public class ComplexNumber {

    private int real;
    private int imaginary;

    public ComplexNumber() {
        real = 0;
        imaginary = 0;
    }

    public ComplexNumber(int val) {
        this.real = val;
        this.imaginary = val;
    }

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(ComplexNumber complexNumber) {
        this.real = complexNumber.real;
        this.imaginary = complexNumber.imaginary;
    }

    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        this.real = num1.real + num2.real;
        this.imaginary = num1.imaginary + num2.imaginary;

        return this;
    }

    public ComplexNumber add(ComplexNumber num) {
        this.real += num.real;
        this.imaginary += num.imaginary;

        return this;
    }

    public ComplexNumber add(int num) {
        this.real += num;
        this.imaginary += num;

        return this;
    }

    public void display() {
        System.out.println("Real: " + this.real + " Imaginary: " + this.imaginary);
    }

    public static void main(String[] args) {
        ComplexNumber complexNumber1 = new ComplexNumber();
        ComplexNumber complexNumber2 = new ComplexNumber(10);
        ComplexNumber complexNumber3 = new ComplexNumber(20 , 30);
        ComplexNumber complexNumber4 = new ComplexNumber(complexNumber2);

        complexNumber4.add(10);
        complexNumber4.display();

        complexNumber1.add(complexNumber3, complexNumber4);
        complexNumber1.display();

        complexNumber3.display();

        complexNumber4.display();

        ComplexNumber complexNumber5 = complexNumber1.add(complexNumber4);

        complexNumber1.display();
        complexNumber4.display();
        complexNumber5.display();
    }
}
