package com.ieschabas;
/**
 * @author Deni Dadaev
 * Practicar NullPointerException y manejo de cadenas
 * version 1.0
 */
class Normalizador {
    public String normalizar(String texto) {
        try {
            // Quita espacios al inicio y final, luego convierte a mayúsculas
            return texto.trim().toUpperCase();
        } catch (NullPointerException e) {
            // Si el texto es null
            System.out.println("Texto nulo, devuelvo vacío");
            return "";
        }
    }
}
