package LabHedron;

public class Habitacion {
    private Posicion puertaEntrada;
    private Posicion puertaSalida;

    public Habitacion() {
        System.out.println("Habitacion creada");
    }

    // Getters y Setters
    public Posicion getPuertaEntrada() {
        return puertaEntrada;
    }
    public void setPuertaEntrada(Posicion puertaEntrada) {
        this.puertaEntrada = puertaEntrada;
    }
    
    public Posicion getPuertaSalida() {
        return puertaSalida;
    }
    public void setPuertaSalida(Posicion puertaSalida) {
        this.puertaSalida = puertaSalida;
    }
}
