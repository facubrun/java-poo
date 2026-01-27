import java.util.Random;
import java.util.Scanner;

public class Principal {
    private static int points[] = new int[2];
    private static int turnPoints = 0;
    private static int winningScore = 100;
    private static int currentPlayer = 0;
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean stopTurn = false;

    // Simula tirar un dado
    public static int rollDie() {
        return random.nextInt(6) + 1;
    }

    // Verifica si un jugador ha ganado
    public static boolean hasPlayerWon(int player) {
        return points[player] >= winningScore;
    }

    // Cambia al siguiente jugador
    public static void switchPlayer() {
        turnPoints = 0;
        currentPlayer = currentPlayer == 0 ? 1 : 0;

        if (currentPlayer == 1) {
            iaTurn();
        } else {
            humanTurn(false);
        }
    }

    // Turno del jugador humano
    public static void humanTurn(boolean error) {
        if (error) {
            System.out.println("Entrada invalida. Por favor, ingrese 'r' para tirar o 'h' para pasar turno.");
        }
        System.out.println("---- Turno del Jugador ----");
        System.out.println("Puntuación: Jugador " + points[0] + " - IA " + points[1]);
        System.out.println("Puntos en este turno: " + turnPoints);
        System.out.print("Ingrese 'r' para tirar el dado o 'h' para pasar turno: ");

        String option = scanner.nextLine();

        while (!option.equals("r") && !option.equals("h")) {
            humanTurn(true);
        }
        if (option.equals("r")) {
            int die = rollDie();
            System.out.println("Has sacado un " + die);

            if (die == 1) {
                System.out.println("¡Turno perdido!");
                switchPlayer();
            } else {
                turnPoints += die;
                humanTurn(false);
            }
        } else if (option.equals("h")) {
            points[currentPlayer] += turnPoints;
            if (hasPlayerWon(currentPlayer)) {
                System.out.println("¡Jugador gana con " + points[0] + " puntos!");
                return;
            } else {
                switchPlayer();
            }
        }
    }

    // turno IA
    private static void iaTurn() {

        System.out.println("\n---- Turno de la IA ----");

        System.out.println("Puntuación actual: Humano: " + points[0] + " - IA: " + points[1]);

        int die = rollDie();

        System.out.println("La IA ha sacado un " + die);

        if (die == 1) {

            System.out.println("La IA pierde los puntos del turno.");

            switchPlayer();
        } else {

            turnPoints += die;

            //FUNCION DONDE DAMOS MEJORAS AL LA IA
            stopTurn = iaDecision(points);

        }

        if (stopTurn) {
            points[1] += turnPoints;

            System.out.println("La IA se planta. Puntuación total: " + points[1]);

            if (hasPlayerWon(currentPlayer)) {
                System.out.println("¡La IA ha ganado!");
                return;
            } else {
                switchPlayer();
            }
        } else {
            iaTurn();
        }
    }

    // Función para iniciar el juego
    public static void iniciarJuego() {

        System.out.println("¡Bienvenido al juego de mesa PIG!");
        System.out.println("El objetivo es ser el primero en alcanzar 100 puntos.");
        System.out.println("Si sacas 1, perdes los puntos acumulados DURANTE EL TURNO.");

        while (!hasPlayerWon(0) && !hasPlayerWon(1))
            humanTurn(false);
        scanner.close();
    }

    public static boolean iaDecision(int[] points) {
        if (turnPoints >= 10 || (points[1] + turnPoints) >= winningScore) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        iniciarJuego();
    }
}
