package LabHedron;

public class Principal {

    public static void main(String[] args) throws Exception {
        Posicion posInicial = new Posicion(3, 0);

        // Generamos objetos
        Habitacion hab = new Habitacion();
        Personaje jugador = new Personaje();

        jugador.setPos(posInicial);

        hab.setJugador(jugador);
        hab.setPuertaEntrada(new Posicion(0,5));
        hab.setPuertaSalida(new Posicion(5,0));
        
        Juego.formarHabitacion(hab); // metodo estatico
    }
}
