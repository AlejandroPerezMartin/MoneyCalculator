
package moneycalculator;

public class Number {

    private long numerator;
    private long denominator;

    public Number(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Number(Number number) {
        this(number.numerator, number.denominator);
    }
    
    public Number(long number) {
        this(number, 1);
    }

    public Number(double number) {
        
    }
    
    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }
    
    private void reduce(){
        
    }
    
    @Override
    public boolean equals(Object object) {
        if(object == null) return false;
        if(object instanceof Number) return equals((Number) object);
        
        return false;
    }
    
    private boolean equals(Number number) {
        return (numerator == number.numerator) && (denominator == number.denominator);
    }
    
}
