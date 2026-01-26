public class Principal {
    public static void main(String[] args) throws Exception {
        String name = "Luka";
        String lastName = "Doncic";
        int height = 201;
        int age = 25;

        short number = 77;
        String team = "LA Lakers";

        float points = 28.3f;
        float assists = 8.7f;
        float rebounds = 8.1f;

        System.out.println("----DATOS PERSONALES----");
        System.out.println("Player: " + name + " " + lastName);
        System.out.println("Height (cm): " + height);
        System.out.println("Age: " + age);
        System.out.println("----DATOS EQUIPO----");
        System.out.println("Jersey Number: " + number);
        System.out.println("Team: " + team);
        System.out.println("----ESTADISTICAS----");
        System.out.println("Points per game: " + points);
        System.out.println("Assists per game: " + assists);
        System.out.println("Rebounds per game: " + rebounds);

    }
}
