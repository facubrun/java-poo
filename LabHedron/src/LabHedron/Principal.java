package LabHedron;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {
        int accionJuego = -1;
        Scanner sc = new Scanner(System.in);

        // Posiciones
        Posicion posInicial = new Posicion(0, 5);
        Posicion posFinal = new Posicion(5, Habitacion.ALTO - 1);
        Posicion posH = new Posicion(3, 5);
        Posicion posJugador = new Posicion(1, 5); // a la derecha de la puerta de entrada


        // Generamos objetos
        Habitacion hab = new Habitacion();

        // configurar jugador
        Jugador jugador = new Jugador();
        jugador.setPos(posJugador);
        jugador.setLetra('J');

        // configurar hedron
        Hedron hedron = new Hedron();
        hedron.setPos(posH);
        hedron.setLetra('H');
    
        // configurar puertas
        ObjetoJuego puertaEntrada = new ObjetoJuego();
        puertaEntrada.setPos(posInicial);
        puertaEntrada.setLetra(' ');
        hab.setObjeto(puertaEntrada);

        ObjetoJuego puertaSalida = new ObjetoJuego();
        puertaSalida.setPos(posFinal);
        puertaSalida.setLetra(' ');
        hab.setObjeto(puertaSalida);
        
        // configurar habitacion
        hab.setObjeto(hedron);
        hab.setObjeto(jugador);
    
        hab.setPuertaEntrada(posInicial);
        hab.setPuertaSalida(posFinal);

        // juego
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
