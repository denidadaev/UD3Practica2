package com.ieschabas;

/**
 * @author Deni Dadaev
 * Evitar errores por índices fuera de rango
 * verion 1.0
 */
class BuscadorArray {
    public String obtener(String[] lista, int indice) {
        try {
            // Intentamos acceder al índice
            return lista[indice];
        } catch (ArrayIndexOutOfBoundsException e) {
            // Si el índice está fuera del rango
            System.out.println("Error: Índice fuera de rango");
            return null;
        }
    }
}