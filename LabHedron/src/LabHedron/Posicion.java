package LabHedron;

public class Posicion {
    private int x;
    private int y;

    public Posicion() {
        this.x = 0;
        this.y = 0;
    }

    public Posicion(int x, int y) { // sobrecarga de constructor
        this.x = x;
        this.y = y;
    }

    // Getters y Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean esIgual(Posicion pos) {
        return this.x == pos.getX() && this.y == pos.getY();
    }
}