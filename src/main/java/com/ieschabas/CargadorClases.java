package com.ieschabas;

public class CargadorClases {

    /**
     * @author Deni Dadaev
     * Verifica si una clase existe en el classpath.
     * @param nombreClase nombre completo de la clase (ej: java.lang.String)
     * @return true si existe, false si no
     * version 1.0
     */
    public boolean existeClase(String nombreClase) {
        try {
            Class.forName(nombreClase);
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
            return false;
        }
    }
}
