package LabHedron;

public class Hedron extends Personaje {
    private String tipoHedron;
    private boolean visible = true;

    public Hedron(String tipoHedron) {
        this.tipoHedron = tipoHedron;
    }

    public boolean cambioVisibilidad() {
        this.visible = !this.visible;
        return this.visible;
    }
}
