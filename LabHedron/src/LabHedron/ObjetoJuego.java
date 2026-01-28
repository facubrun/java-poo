package LabHedron;

public class ObjetoJuego {
    final static int JUGADOR = 0;
    final static int HEDRON = 1;
    final static int PIEZA = 2;
    final static int OBJETO = 3;
    final static int PUERTA_IN = 4;
    final static int PUERTA_OUT = 5;

    private String nombre;
    private Posicion pos;
    // letra en mapa
    private char letra = ' ';
    private int tipoObjeto = -1;

    public ObjetoJuego () {

    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Posicion getPos() {
        return pos;
    }
    public void setPos(Posicion pos) {
        this.pos = pos;
    }

    public char getLetra() {
        return letra;
    }
    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getTipoObjeto() {
        return tipoObjeto;
    }
    public void setTipoObjeto(int tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

}
