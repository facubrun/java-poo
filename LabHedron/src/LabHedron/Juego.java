package LabHedron;

import java.util.concurrent.ThreadLocalRandom;

public class Juego {
    final static int LANZAR_DADO = 1;
    final static int SALIR_JUEGO = 2;

    public static void formarHabitacion(Habitacion hab) {
        for (int fila = 0; fila < Habitacion.ALTO; fila++) {
            for (int col= 0; col < Habitacion.ANCHO; col++) {
                Posicion posActual = new Posicion(col, fila);

                if (hab.esJugador(posActual)) {
                    System.out.print("J"); // jugador

                } else if (hab.esPuerta(posActual)) {
                    System.out.print(" "); // puertas
                
                } else if (col == 0 || col == Habitacion.ANCHO - 1) {
                    System.out.print("|"); // paredes laterales
                
                } else if (fila == 0 || fila == Habitacion.ALTO - 1) {
                    System.out.print("#"); // paredes horizontales
                
                } else {
                    System.out.print(" "); // espacio libre
                }

                if (col == Habitacion.ANCHO - 1) {
                    System.out.println(); // nueva linea al final de la fila
                }
            }
        }
    }

    public static void pintarMenu() {
        System.out.println("----- MENU LABHEDRON -----");
        System.out.println("[" + LANZAR_DADO + "] LANZAR DADO PARA MOVER");
        System.out.println("[" + SALIR_JUEGO + "] SALIR DEL JUEGO");
        System.out.println("---------------------------");
    }

    public static int lanzarDado() {
        int dado = ThreadLocalRandom.current().nextInt(1, 7);
        System.out.println("Has lanzado un " + dado);
        return dado;
    }
}
