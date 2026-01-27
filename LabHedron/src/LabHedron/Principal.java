package LabHedron;

public class Principal {

    public static void main(String[] args) throws Exception {
        Posicion posInicial = new Posicion(3, 0);

        // Generamos objetos
        Habitacion hab1 = new Habitacion();
        Personaje pers1 = new Personaje();

        pers1.setPos(posInicial);
    }
}
