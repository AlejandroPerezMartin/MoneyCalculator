package moneycalculator.model;

public class Number {

    private long numerator;
    private long denominator;

    public Number(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Number(Number number) {
        this(number.getNumerator(), number.getDenominator());
    }

    public Number(int number) {
        this(number, 1);
    }

    public Number(long number) {
        this((int) number, 1);
    }

    public Number(double number) {
        this((int) number, 1);

        while (number != numerator) {
            number *= 10;
            denominator *= 10;
            numerator = (int) number;
        }
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Number add(Number number) {
        if (this.denominator == number.denominator) {
            return new Number(numerator + number.numerator, number.denominator);
        } else {
            return new Number(minimoComunMultiplo(this, number).numerator + minimoComunMultiplo(number, this).numerator,
                    minimoComunMultiplo(number, this).denominator);
        }
    }

    public Number minimoComunMultiplo(Number firstNumber, Number secondNumber) {
        return new Number(
                firstNumber.numerator * secondNumber.denominator,
                firstNumber.denominator * secondNumber.denominator);
    }

    private void reduce() {

    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof Number) {
            return equals((Number) object);
        }

        return false;
    }

    private boolean equals(Number number) {
        return (numerator == number.numerator) && (denominator == number.denominator);
    }

}
