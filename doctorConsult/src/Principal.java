import java.util.Scanner;

public class Principal {

    public static String question(String q) {
        Scanner scanner = new Scanner(System.in); // Scanner to read user input

        System.out.print(q);
        String response = scanner.nextLine().toLowerCase();

        return response;
    }

    public static void traumaDepart(String name) {
        System.out.println(name + ", por favor diríjase al departamento de traumatología.");
    }

    public static void cardioDepart(String name) {
        System.out.println(name + ", por favor diríjase al departamento de cardiología.");
    }

    public static void triage(String name) {
        System.out.println("Proceso de triaje para " + name + ".");

        // triage questions
        String fall = question("Ha sufrido alguna caida? (si/no): ");
        while (!fall.equals("si") && !fall.equals("no")) {
            System.out.println("Respuesta inválida. Por favor, responda 'si' o 'no'.");
            fall = question("Ha sufrido alguna caida? (si/no): ");
        }
        if (fall.equals("si")) {
            traumaDepart(name);
        } else if (fall.equals("no")) {
            String chestPain = question("Le duele el pecho? (si/no): ");
            while (!chestPain.equals("si") && !chestPain.equals("no")) {
                System.out.println("Respuesta inválida. Por favor, responda 'si' o 'no'.");
                chestPain = question("Le duele el pecho? (si/no): ");
            }
            if (chestPain.equals("si")) {
                cardioDepart(name);
            } else if (chestPain.equals("no")) {
                System.out.println(name + ", por favor diríjase al departamento de medicina general.");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        triage("Jorgito");
    }
}
