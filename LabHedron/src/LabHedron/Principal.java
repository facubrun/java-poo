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
        Posicion posP = new Posicion(4, 5);
        Posicion posObjOculto = new Posicion(2, 5);


        // Generamos objetos
        Habitacion hab = new Habitacion();

        // configurar jugador
        Jugador jugador = new Jugador();
        jugador.setPos(posJugador);
        jugador.setLetra('J');
        jugador.setTipoObjeto(ObjetoJuego.JUGADOR);

        // configurar hedron
        Hedron hedron = new Hedron();
        hedron.setPos(posH);
        hedron.setLetra('O');
        hedron.setTipoObjeto(ObjetoJuego.HEDRON);
    
        // configurar pieza
        ObjetoJuego pieza = new ObjetoJuego();
        pieza.setPos(posP);
        pieza.setLetra('P');
        pieza.setTipoObjeto(ObjetoJuego.PIEZA);

        // configurar pieza
        ObjetoJuego objOculto = new ObjetoJuego();
        objOculto.setPos(posObjOculto);
        objOculto.setLetra('O');
        objOculto.setTipoObjeto(ObjetoJuego.OBJETO);

        // configurar puertas
        ObjetoJuego puertaEntrada = new ObjetoJuego();
        puertaEntrada.setPos(posInicial);
        puertaEntrada.setLetra(' ');
        puertaEntrada.setTipoObjeto(ObjetoJuego.PUERTA_IN);

        ObjetoJuego puertaSalida = new ObjetoJuego();
        puertaSalida.setPos(posFinal);
        puertaSalida.setLetra(' ');
        puertaSalida.setTipoObjeto(ObjetoJuego.PUERTA_OUT);
        
        // configurar habitacion
        hab.setObjeto(hedron);
        hab.setObjeto(jugador);
        hab.setObjeto(puertaEntrada);
        hab.setObjeto(puertaSalida);

        hab.setPuertaEntrada(posInicial);
        hab.setPuertaSalida(posFinal);

        // juego
        while (accionJuego != Juego.SALIR_JUEGO) {
            int objeto = -1;
            int dado = 0;
            Juego.formarHabitacion(hab); // metodo estatico
            Juego.pintarMenu();
            accionJuego = sc.nextInt();

            switch (accionJuego) {
                case Juego.LANZAR_DADO:
                    dado = Juego.lanzarDado(10);
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
                    // verificar si hay objeto en la nueva posicion
                    objeto = hab.hayObjetoSinJugador(jugador.getPos());
                    
                    // procesar la colision inmediatamente
                    if (objeto != -1) {
                        // se choca con un hadron 
                        if (hab.getObjeto(objeto).getTipoObjeto() == ObjetoJuego.HEDRON) {
                            int vidaPerdida = Juego.lanzarDado(2) * dado;
                            int resultadoExplosion = Juego.explotaHedron(vidaPerdida);
                            if (resultadoExplosion == Juego.SALIR_JUEGO) {
                                accionJuego = Juego.SALIR_JUEGO;
                            }
                        } else if (hab.getObjeto(objeto).getTipoObjeto() == ObjetoJuego.PIEZA) {
                            jugador.setPiezaHabitacion();
                            System.out.println("¡Has conseguido la pieza de la habitacion!");
                        } else if (hab.getObjeto(objeto).getTipoObjeto() == ObjetoJuego.PUERTA_OUT) {
                            if (jugador.getPiezaHabitacion()) {
                                System.out.println("¡Has llegado a la salida con la pieza! ¡Ganaste!");
                                accionJuego = Juego.SALIR_JUEGO;
                            } else {
                                System.out.println("Necesitas la pieza para salir.");
                            }
                        }
                        hab.eliminarObjeto(objeto);
                        objeto = -1;
                    }
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
