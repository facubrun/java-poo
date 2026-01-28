package LabHedron;

public class ObjetoJuego {
    private String nombre;
    private Posicion pos;
    // letra en mapa
    private char letra = ' ';

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
}
