package LabHedron;

/*
* Clase Objeto que representa los objetos que se encuentran dentro de la habitacion
*
* @author Facundo Brun
* @version 1.0
* @see LabHedron.ObjetoJuego
*/
public class Objeto extends ObjetoJuego {
    private int peso = 0;

    /**
     * Constructor de la clase Objeto
     *
     */
    public Objeto() {

    }

    // Getters y Setters
    /*
    * getPeso devuelve el peso del objeto
    *
    * @return int peso del objeto
    */
    public int getPeso() {
        return peso;
    }

    /*
    * setPeso establece el peso del objeto
    *
    * @param int peso del objeto
    */
    public void setPeso(int peso) {
        this.peso = peso;
    }
}
