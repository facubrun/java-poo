package LabHedron;

public class Jugador extends Personaje {
    //private Mochila mochila;
    final static int VIDA_INICIAL = 10;

    private int vida = VIDA_INICIAL;
    private boolean piezaHabitacion = false;
    
    public Jugador() {
    }

    public boolean getPiezaHabitacion() {
        return this.piezaHabitacion;
    }
    public void setPiezaHabitacion() {
        this.piezaHabitacion = true;
    }

    public int getVida() {
        return this.vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
}
