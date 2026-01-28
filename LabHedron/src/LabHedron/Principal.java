package LabHedron;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {
        int accionJuego = -1;
        Scanner sc = new Scanner(System.in);

        // Posicion inicial del jugador
        Posicion posInicial = new Posicion(0, 5);

        // Generamos objetos
        Habitacion hab = new Habitacion();
        Jugador jugador = new Jugador();

        jugador.setPos(posInicial);

        hab.setJugador(jugador);
        hab.setPuertaEntrada(new Posicion(0,5));
        hab.setPuertaSalida(new Posicion(5,0));
        
        while (accionJuego != Juego.SALIR_JUEGO) {
            Juego.formarHabitacion(hab); // metodo estatico
            Juego.pintarMenu();
            accionJuego = sc.nextInt();

            switch (accionJuego) {
                case Juego.LANZAR_DADO:
                    int dado = Juego.lanzarDado();
                    // mover jugador
                    System.out.println("[MOVIMIENTO COLUMNAS/X] ¿Cuantas columnas queres moverte? Tenes " + dado + " movimientos disponibles.");
                    int col = sc.nextInt();
                    if (col > dado) {
                        System.out.println("No podes moverte tanto, te pasaste del valor del dado.");
                        break;
                    }
                    System.out.println("[MOVIMIENTO FILAS/Y] ¿Cuantas filas queres moverte? Tenes " + (dado - col) + " movimientos disponibles.");
                    int fila = sc.nextInt();
                    if (fila > (dado - col)) {
                        System.out.println("No podes moverte tanto, te pasaste del valor del dado.");
                        break;
                    }
                    jugador.mover(dado, col, fila);
                    break;
                case Juego.SALIR_JUEGO:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Accion no valida");
            }
        }
    }
}
