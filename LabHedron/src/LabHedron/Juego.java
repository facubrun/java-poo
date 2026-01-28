package LabHedron;

public class Juego {

    public static void formarHabitacion(Habitacion hab) {
        for (int fila = 0; fila < Habitacion.ALTO; fila++) {
            for (int col= 0; col < Habitacion.ANCHO; col++) {
                Posicion posActual = new Posicion(col, fila);

                if (hab.esPuerta(posActual)) {
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
}
