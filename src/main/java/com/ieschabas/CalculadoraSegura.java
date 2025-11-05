package com.ieschabas;

/**
 * @author Deni Dadaev
 * Practicar el manejo de excepciones unchecked (ArithmeticException) al dividir entre cero.
 * version 1.0
 */

class CalculadoraSegura {
    public double dividir(int numerador, int denominador) {
        try {
            return (double) numerador / denominador;
        } catch (ArithmeticException e) {
            System.out.println("Error: divisor cero no permitido");
            return Double.NaN;
        }
    }
}