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

    public void mover(int dado, int movX, int movY) {
        if (movX + movY > dado) {
            System.out.println("No podes moverte tanto, te pasaste del valor del dado.");
            return;
        }

        int nuevaX = pos.getX() + movX;
        int nuevaY = pos.getY() + movY;

        // Validar que no se salga de los limites de la habitacion
        if (nuevaX < 0 || nuevaX >= Habitacion.ANCHO ||
            nuevaY < 0 || nuevaY >= Habitacion.ALTO) {
            System.out.println("Movimiento invalido, te vas fuera del rango de la habitacion.");
            return;
        }

        pos.setX(nuevaX);
        pos.setY(nuevaY);
        System.out.println("Te moviste a la posicion (" + nuevaX + ", " + nuevaY + ")");
    }
}