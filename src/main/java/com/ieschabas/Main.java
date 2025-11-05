package com.ieschabas;
import java.util.Scanner;
import java.util.Date;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraSegura calc = new CalculadoraSegura();

        System.out.println("<<<<<EJERCICIO 1:CALCULADORA SEGURA>>>>>>>");

        // Pedimos el numerador
        System.out.print("Ingresa el numerador: ");
        int numerador = scanner.nextInt();

        // Pedimos el denominador
        System.out.print("Ingresa el denominador: ");
        int denominador = scanner.nextInt();

        // Mostramos lo que ingresó
        System.out.println("Numerador: " + numerador);
        System.out.println("Denominador: " + denominador);

        // Hacemos la división
        double resultado1E = calc.dividir(numerador, denominador);

        // Mostramos el resultado
        if (Double.isNaN(resultado1E)) {
            System.out.println("Resultado: NaN");
        } else {
            System.out.println("Resultado: " + resultado1E);
        }


        //Segundo ejercicio
        System.out.println("<<<<<< EJERCICIO.2: PARSER ENTERO SEGURO>>>>>>>");
        System.out.println("Ingresa un texto para convertir a número (o 'siguiente' para terminar):");
        ParserEntero parser = new ParserEntero();
        while (true) {
            System.out.print("Entrada: ");
            String entrada = scanner.nextLine().trim();

            // Opción para salir
            if (entrada.equalsIgnoreCase("siguiente")) {
                System.out.println("¡Adiós!");
                break;
            }

            // Si el usuario no escribe nada, lo tratamos como null
            String texto = entrada.isEmpty() ? null : entrada;

            // Convertimos
            Integer resultado = parser.aEnteroSeguro(texto);

            // Mostramos resultado
            if (resultado != null) {
                System.out.println("Resultado: " + resultado);
            } else {
                System.out.println("Resultado: null");
            }
        }


        //Tercer ejercicio
        System.out.println("<<<<<<<EJERCICIO.3: BUSCADOR DE ARRAY SEGURO>>>>>>>");
        BuscadorArray buscador = new BuscadorArray();
        String[] lista = {"A", "B", "C", "D", "E"};
        System.out.println("Array: [A, B, C, D, E]");
        System.out.println("Índices válidos: 0 a " + (lista.length - 1));
        System.out.println("Escribe 'siguiente' para terminar.");

        while (true) {
            System.out.print("Ingresa el índice: ");
            String entrada = scanner.nextLine().trim();

            // Salir del programa
            if (entrada.equalsIgnoreCase("siguiente")) {
                System.out.println("¡Adiós!");
                break;
            }

            // Validar que sea un número
            int indice;
            try {
                indice = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número entero válido.");
                continue;
            }

            // Buscar en el array
            String resultado = buscador.obtener(lista, indice);

            // Mostrar resultado
            if (resultado != null) {
                System.out.println("Resultado: '" + resultado );
            } else {
                System.out.println("Resultado: null");
            }
        }


        Normalizador normalizador = new Normalizador();

        System.out.println("<<<<<<<<<<EJERCICIO.4: NORMALIZADOR DE TEXTO SEGURO ===");
        System.out.println("Escribe un texto (o 'salir' para terminar):");

        while (true) {
            System.out.print("Entrada: ");
            String entrada = scanner.nextLine();

            // Salir
            if (entrada.equalsIgnoreCase("siguiente")) {
                System.out.println("¡Adiós!");
                break;
            }

            // Convertir entrada vacía en null (para probar null)
            String texto = entrada.isEmpty() ? null : entrada;

            // Normalizar
            String resultado = normalizador.normalizar(texto);

            // Mostrar resultado
            System.out.println("Resultado: '" + resultado);
        }


        //Quinto ejercicio
        ConversorFecha conversor = new ConversorFecha();
        System.out.println("<<<<<<< EERCICIO.5: CONVERSOR DE FECHAS SEGURO>>>>>>>>");
        System.out.println("Ejemplos de patrones: yyyy-MM-dd, dd/MM/yyyy, MM-dd-yyyy");
        System.out.println("Escribe 'salir' para terminar.");

        while (true) {
            // Pedir texto
            System.out.print("Texto de fecha: ");
            String texto = scanner.nextLine().trim();
            if (texto.equalsIgnoreCase("siguiente")) break;

            // Pedir patrón
            System.out.print("Patrón: ");
            String patron = scanner.nextLine().trim();
            if (patron.equalsIgnoreCase("siguiente")) break;

            // Si no escribe nada, tratamos como null
            String textoFinal = texto.isEmpty() ? null : texto;
            String patronFinal = patron.isEmpty() ? null : patron;

            // Parsear
            Date fecha = conversor.parsear(textoFinal, patronFinal);

            // Mostrar resultado
            if (fecha != null) {
                System.out.println("Resultado: " + fecha);
            } else {
                System.out.println("Resultado: null");
            }
        }
        Temporizador temp = new Temporizador();

        System.out.println("<<<<<EJERCICIO.6: Temporizador con control de interrupciones>>>>>>>");
        System.out.println("Ingresa los milisegundos para dormir (o 'siguiente' para terminar):");

        while (true) {
            System.out.print("");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("siguiente")) {
                System.out.println("¡Adiós!");
                break;
            }

            try {
                long ms = Long.parseLong(entrada);
                if (ms < 0) {
                    System.out.println("Por favor ingresa un número positivo.");
                    continue;
                }

                System.out.println("Durmiendo " + ms + " ms... (presiona Enter para interrumpir)");

                // Hilo que permite interrumpir con Enter
                Thread hiloDormilon = new Thread(() -> {
                    boolean resultado = temp.dormir(ms);
                    if (resultado) {
                        System.out.println("¡Desperté naturalmente!");
                    }
                });

                hiloDormilon.start();

                // Hilo que espera Enter para interrumpir
                new Thread(() -> {
                    try {
                        System.in.read();
                        hiloDormilon.interrupt();
                    } catch (Exception ignored) {}
                }).start();

                hiloDormilon.join();

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingresa un número o 'salir'.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        CargadorClases cargador = new CargadorClases();

        System.out.println("<<<<<EJERCICIO.7: Verificador de Existencia de Clases>>>>>>>>");
        System.out.println("Ingresa el nombre completo de una clase (ej: java.lang.String)");
        System.out.println("Escribe 'siguiente' para terminar.");

        while (true) {
            System.out.print("Clase: ");
            String nombre = scanner.nextLine().trim();

            if (nombre.equalsIgnoreCase("ssiguiente")) {
                System.out.println("¡Hasta luego!");
                break;
            }

            if (nombre.isEmpty()) {
                System.out.println("Por favor ingresa un nombre de clase válido.");
                continue;
            }

            boolean existe = cargador.existeClase(nombre);

            if (existe) {
                System.out.println("->  true (la clase existe)");
            }
            // Si no existe, ya se imprimió "Clase no encontrada"
            System.out.println();
        }

        System.out.println("¡Adiós!");
    scanner.close();
    }
}