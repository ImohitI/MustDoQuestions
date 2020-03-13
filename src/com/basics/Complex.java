package com.basics;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Complex {

    private final double real;
    private final double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(final Complex other){
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }


    @Test
    public void complexNumberAddition(){
        final Complex expected = new Complex(6,2);

        final Complex a = new Complex(8,0);
        final Complex b = new Complex(-2,2);

        assertEquals(a.add(b), expected);
    }
}
