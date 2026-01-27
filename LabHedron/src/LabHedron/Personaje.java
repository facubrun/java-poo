package LabHedron;

public class Personaje {
    // Propiedades
    private String nombre;
    private Posicion pos;

    public Personaje() {
        System.out.println("Personaje creado");
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
}