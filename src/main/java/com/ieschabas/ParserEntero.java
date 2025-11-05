package com.ieschabas;

/**
 * @author Deni Dadaev
 * Manejar errores de formato y valores nulos al convertir cadenas en enteros.
 * version 1.0
 */
class ParserEntero {
    public Integer aEnteroSeguro(String texto) {
        try {
            // Intentamos convertir el texto a entero
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            // Si el texto no es un número válido (ej: "12x")
            System.out.println("Error: formato inválido");
            return null;
        } catch (NullPointerException e) {
            // Si el texto es null
            System.out.println("Error: texto nulo");
            return null;
        }
    }
}
