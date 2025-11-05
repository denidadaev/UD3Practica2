package com.ieschabas;

public class Temporizador {

    /**
     * @author Deni Dadaev
     * Intenta dormir el hilo durante los milisegundos indicados.
     * @param milisegundos tiempo a dormir
     * @return true si durmió completamente, false si fue interrumpido
     * version 1.0
     */
    public boolean dormir(long milisegundos) {
        try {
            Thread.sleep(milisegundos);
            return true;
        } catch (InterruptedException e) {
            System.out.println("Interrumpido");
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
