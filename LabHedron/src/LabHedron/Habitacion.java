package LabHedron;

public class Habitacion {
    // tamaño de la habitacion
    public static final int ANCHO = 10;
    public static final int ALTO = 10;

    // puertas
    private Posicion puertaEntrada;
    private Posicion puertaSalida;

    // objetos de la habitacion
    private ObjetoJuego[] objetos = new ObjetoJuego[20];
    private int cantObjetos = 0;

    // jugador
    private ObjetoJuego jugador;


    public Habitacion() {
        System.out.println("Habitacion creada");
    }

    // Getters y Setters
    public Posicion getPuertaEntrada() {
        return puertaEntrada;
    }
    public void setPuertaEntrada(Posicion puertaEntrada) {
        if (puertaEntrada.getX() != 0 && puertaEntrada.getX() != ANCHO - 1 &&
            puertaEntrada.getY() != 0 && puertaEntrada.getY() != ALTO - 1) {
            throw new IllegalArgumentException("La puerta de entrada debe estar en una pared");
        }
        this.puertaEntrada = puertaEntrada;
    }

    public Posicion getPuertaSalida() {
        return puertaSalida;
    }
    public void setPuertaSalida(Posicion puertaSalida) {
        if (puertaSalida.getX() != 0 && puertaSalida.getX() != ANCHO - 1 &&
            puertaSalida.getY() != 0 && puertaSalida.getY() != ALTO - 1) {
            throw new IllegalArgumentException("La puerta de salida debe estar en una pared");
        }
        this.puertaSalida = puertaSalida;
    }

    public void setObjeto(ObjetoJuego objeto) {
        this.objetos[cantObjetos] = objeto;
        cantObjetos++;
    }

    public int hayObjeto(Posicion pos) {
        for (int i = 0; i < cantObjetos; i++) {
            if (objetos[i].getPos().esIgual(pos)) {
                return i;
            }
        }
        return -1;
    }

    public ObjetoJuego getObjeto(int indice) {
        return objetos[indice];
    }
}
