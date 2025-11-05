package com.ieschabas;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
/**
 * @author Deni Dadaev
 * Captura ParseException al analizar fechas
 * version 1.0
 */
class ConversorFecha {
    public Date parsear(String texto, String patron) {
        try {
            // Crear el formateador con el patrón y modo estricto
            SimpleDateFormat sdf = new SimpleDateFormat(patron);
            sdf.setLenient(false);

            // Convertir el texto a Date
            return sdf.parse(texto);
        } catch (ParseException e) {
            // Si el formato no coincide o la fecha es inválida
            System.out.println("Error: Fecha inválida con patrón '" + patron + "'");
            return null;
        } catch (NullPointerException e) {
            // Por si texto o patron es null (opcional, pero seguro)
            System.out.println("Error: texto o patrón nulo");
            return null;
        }
    }
}
