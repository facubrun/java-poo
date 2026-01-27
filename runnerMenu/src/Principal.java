import java.util.Scanner;

public class Principal {
    public static int viewMenu(boolean error) {
        Scanner sc = new Scanner(System.in);
        if (error) 
            System.out.println("Introduce unicamente valores dentro de [0,1,2,3].");
        System.out.println("------------MENU-------------");
        System.out.println("0. Salir");
        System.out.println("1. Nuevos datos");
        System.out.println("2. Mostrar datos");
        System.out.println("3. Borrar ultimo dato");
        System.out.println("-----------------------------");
        System.out.print("Selecciona una opcion: ");
        int response = sc.nextInt();
        while (response < 0 || response > 3) {
            return viewMenu(true);
        }
        return response;
    }  

    public static void newRecord(float times[], float distances[], String labels[], int lastRecord) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la etiqueta del registro: ");
        labels[lastRecord] = sc.nextLine();
        System.out.print("Introduce la distancia recorrida (en km): ");
        distances[lastRecord] = sc.nextFloat();
        System.out.print("Introduce el tiempo empleado (en minutos): ");
        times[lastRecord] = sc.nextFloat();
    }

    public static void showData(float times[], float distances[], String labels[], int lastRecord) {
        System.out.println("-----REGISTROS DE CORREDOR-----");
        for (int i = 0; i < lastRecord; i++) {
            if (times[i] != 0.0f && distances[i] != 0.0f && !labels[i].equals("")) {
                System.out.println("Registro " + (i + 1) + ":");
                System.out.println("Etiqueta: " + labels[i]);
                System.out.println("Distancia: " + distances[i] + " km");
                System.out.println("Tiempo: " + times[i] + " minutos");
                System.out.println("-------------------------------");
            }
        }
    }

    public static void deleteLastData(float times[], float distances[], String labels[], int lastRecord) {
        if (lastRecord > 0) {
            times[lastRecord - 1] = 0.0f;
            distances[lastRecord - 1] = 0.0f;
            labels[lastRecord - 1] = "";
            System.out.println("Ultimo registro borrado.");
        } else {
            System.out.println("No hay registros para borrar.");
        }
    }

    public static void main(String[] args) throws Exception {
        // Definimos arrays
        float times[] = new float[10];
        float distances[] = new float[10];
        String labels[] = new String[10];
        for (int i = 0; i < 10; i++) {
            times[i] = 0.0f;
            distances[i] = 0.0f;
            labels[i] = "";
        
        }

        // Inicializamos variables
        int response = -1;
        int lastRecord = 0;

        response = viewMenu(false);

        while (response != 0) {
            switch (response) {
                case 1:
                    newRecord(times, distances, labels, lastRecord);
                    lastRecord++;
                    break;
                case 2:
                    showData(times, distances, labels, lastRecord);
                    break;
                case 3:
                    deleteLastData(times, distances, labels, lastRecord);
                    lastRecord--;
                    break;
            }
            response = viewMenu(false);
        } 
    }
}
