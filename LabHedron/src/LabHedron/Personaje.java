package LabHedron;

public class Personaje extends ObjetoJuego {
    // Propiedades

    public Personaje() {
        System.out.println("Personaje creado");
    }

    // Getters y Setters

    public void mover(int dado, int movX, int movY) {
        Posicion pos = super.getPos(); // copia de la pos en ObjetoJuego

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
        super.setPos(pos);
        System.out.println("Te moviste a la posicion (" + nuevaX + ", " + nuevaY + ")");
    }
}