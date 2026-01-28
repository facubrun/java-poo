package LabHedron;

public class Hedron extends Personaje {
    private boolean visible = true;

    public Hedron() {

    }

    public boolean cambioVisibilidad() {
        this.visible = !this.visible;
        return this.visible;
    }
}
