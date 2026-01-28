package LabHedron;

import java.util.concurrent.ThreadLocalRandom;

public class Juego {
    final static int LANZAR_DADO = 1;
    final static int SALIR_JUEGO = 2;

public static void formarHabitacion(Habitacion hab) {
		System.out.println("--------------         MAPA          --------------");
		// Buscar el jugador en la habitacion
		Jugador jugador = null;
		for (int i = 0; i < 20; i++) {
			ObjetoJuego obj = hab.getObjeto(i);
			if (obj != null && obj.getTipoObjeto() == ObjetoJuego.JUGADOR) {
				jugador = (Jugador) obj;
				break;
			}
		}
		
		for(int fila=-1;fila<Habitacion.ALTO;fila++) {
			for (int col=0;col<=Habitacion.ANCHO;col++){
				Posicion posicionActual=new Posicion(col,fila);

				// Buscar todos los objetos en esta posicion, priorizando al jugador
				ObjetoJuego obj = null;
				int posObj = -1;
				
				// Primero buscar si hay un jugador en esta posicion
				for (int i = 0; i < 20; i++) {
					ObjetoJuego objTemp = hab.getObjeto(i);
					if (objTemp != null && objTemp.getPos().esIgual(posicionActual)) {
						if (objTemp.getTipoObjeto() == ObjetoJuego.JUGADOR) {
							obj = objTemp;
							posObj = i;
							break;
						}
						if (obj == null) {
							obj = objTemp;
							posObj = i;
						}
					}
				}
				
				if(posObj!=-1) {
					//Comprobamos si el jugador ha conseguido la pieza para pintar la salida
					if(obj.getTipoObjeto()==ObjetoJuego.PUERTA_OUT)
						if(jugador != null && jugador.getPiezaHabitacion()) {
							System.out.print(obj.getLetra());
						}else {
							if(col==0 || col==Habitacion.ANCHO-1) System.out.print("|"); //Paredes izquierda y derecha
							if(fila==0 || fila==Habitacion.ALTO-1) System.out.print("="); //Paredes primera y ultima fila							
						}
						else System.out.print(obj.getLetra());
				}
				else if(fila==-1 && col!=Habitacion.ANCHO) {
					if(col>9) System.out.print(col%10);
					else System.out.print(col);
				}
				else if(col==Habitacion.ANCHO && fila!=-1) System.out.print(fila);
				else if(col==0 || col==Habitacion.ANCHO-1) System.out.print("|"); //Paredes izquierda y derecha
				else if(fila==0 || fila==Habitacion.ALTO-1) System.out.print("="); //Paredes primera y ultima fila
				else System.out.print(" "); //Mapa
				
				if(col==Habitacion.ANCHO) System.out.println();//Siguiente linea
			}
		}
		System.out.println("---------------------------------------------------");
	}

    public static void pintarMenu() {
        System.out.println("----- MENU LABHEDRON -----");
        System.out.println("[" + LANZAR_DADO + "] LANZAR DADO PARA MOVER");
        System.out.println("[" + SALIR_JUEGO + "] SALIR DEL JUEGO");
        System.out.println("---------------------------");
    }

    public static int lanzarDado(int caras) {
        int dado = ThreadLocalRandom.current().nextInt(1, caras + 1);
        System.out.println("Has lanzado un " + dado);
        return dado;
    }

    public static int explotaHedron(int vidaPerdida) {
        int muerte = -1;
        System.out.println("----- HEDRON EXPLOTA -----");
        System.out.println("¡¡¡¡¡¡ Chocaste contra un Hedron !!!!!!!");
        System.out.println("Perdiste " + vidaPerdida + " puntos de vida.");
        if (vidaPerdida >= Jugador.VIDA_INICIAL) {
            System.out.println("GAME OVER");
            muerte = Juego.SALIR_JUEGO;
        } else
            System.out.println("Tuviste suerte, sobreviviste al choque.");
        System.out.println("---------------------------");

        return muerte;
    }
}
