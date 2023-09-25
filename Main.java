/**
 * Clase Main
 * Fernando Rueda - 23748
 * Descripción: Clase principal para ejecutar el programa.
 * Fecha de creación: [24/09/2023]
 * Fecha de última modificación: [24/09/2023]
 */
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Championship championship = new Championship();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrar Portero");
            System.out.println("2. Registrar Extremo");
            System.out.println("3. Mostrar Todos los Jugadores");
            System.out.println("4. Mostrar los 3 Mejores Porteros");
            System.out.println("5. Mostrar Extremos con Alta Efectividad");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, elige de nuevo.");
                scanner.nextLine(); // consume the invalid input
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        // Registrar Portero
                        System.out.print("Nombre: ");
                        String goalkeeperName = scanner.nextLine();
                        System.out.print("País: ");
                        String goalkeeperCountry = scanner.nextLine();
                        System.out.print("Faltas: ");
                        int goalkeeperFouls = scanner.nextInt();
                        System.out.print("Goles Directos: ");
                        int goalkeeperDirectGoals = scanner.nextInt();
                        System.out.print("Total de Lanzamientos: ");
                        int goalkeeperTotalThrows = scanner.nextInt();
                        System.out.print("Paradas Efectivas: ");
                        int effectiveStops = scanner.nextInt();
                        System.out.print("Goles Recibidos: ");
                        int receivedGoals = scanner.nextInt();
                        scanner.nextLine(); // consume the newline

                        Goalkeeper goalkeeper = new Goalkeeper(goalkeeperName, goalkeeperCountry, goalkeeperFouls, goalkeeperDirectGoals, goalkeeperTotalThrows, effectiveStops, receivedGoals);
                        championship.registerPlayer(goalkeeper);
                        break;
                    case 2:
                        // Registrar Extremo
                        System.out.print("Nombre: ");
                        String wingerName = scanner.nextLine();
                        System.out.print("País: ");
                        String wingerCountry = scanner.nextLine();
                        System.out.print("Faltas: ");
                        int wingerFouls = scanner.nextInt();
                        System.out.print("Goles Directos: ");
                        int wingerDirectGoals = scanner.nextInt();
                        System.out.print("Total de Lanzamientos: ");
                        int wingerTotalThrows = scanner.nextInt();
                        System.out.print("Pases: ");
                        int passes = scanner.nextInt();
                        System.out.print("Asistencias Efectivas: ");
                        int effectiveAssists = scanner.nextInt();
                        scanner.nextLine(); // consume the newline

                        Winger winger = new Winger(wingerName, wingerCountry, wingerFouls, wingerDirectGoals, wingerTotalThrows, passes, effectiveAssists);
                        championship.registerPlayer(winger);
                        break;
                    case 3:
                        championship.displayAllPlayers();
                        break;
                    case 4:
                        // Mostrar los 3 Mejores Porteros
                        List<Goalkeeper> topGoalkeepers = championship.getTopGoalkeepers();
                        for (Goalkeeper topGoalkeeper : topGoalkeepers) {
                            System.out.println(topGoalkeeper.name + " - Efectividad: " + topGoalkeeper.calculateEffectiveness());
                        }
                        break;
                    case 5:
                        // Mostrar Extremos con Alta Efectividad
                        long highEffectiveWingersCount = championship.getHighEffectiveWingers();
                        System.out.println("Número de Extremos con Alta Efectividad: " + highEffectiveWingersCount);
                        break;
                    case 6:
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor, elige de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce el tipo de dato correcto.");
                scanner.nextLine(); // consume the invalid input
            }
        }
    }
}


