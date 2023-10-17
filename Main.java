/**
 * Clase Main
 * Fernando Rueda - 23748
 * Descripción: Clase principal para ejecutar el sistema del torneo de voleibol.
 * Fecha de creación: [14/10/2023]
 * Fecha de última modificación: [16/10/2023]
 */

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tournament tournament = new Tournament();

        while (true) {
            System.out.println("1. Añadir jugador");
            System.out.println("2. Mostrar todos los jugadores");
            System.out.println("3. Mostrar los 3 mejores líberos");
            System.out.println("4. Mostrar cantidad de pasadores con más de un 80% de efectividad");
            System.out.println("5. Salir");

            int option = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (option) {
                case 1:
                    System.out.println("Ingrese el tipo de jugador (Libero, Pasador, Auxiliar, Opuesto):");
                    String type = scanner.nextLine();

                    System.out.println("Ingrese el nombre:");
                    String name = scanner.nextLine();

                    System.out.println("Ingrese el país:");
                    String country = scanner.nextLine();

                    System.out.println("Ingrese errores:");
                    int errors = scanner.nextInt();

                    System.out.println("Ingrese aces:");
                    int aces = scanner.nextInt();

                    System.out.println("Ingrese total de servicios:");
                    int totalServices = scanner.nextInt();

                    switch (type.toLowerCase()) {
                        case "libero":
                            System.out.println("Ingrese recibos efectivos:");
                            int effectiveReceives = scanner.nextInt();
                            Libero libero = new Libero(name, country, errors, aces, totalServices, effectiveReceives);
                            tournament.addPlayer(libero);
                            break;
                        case "pasador":
                            System.out.println("Ingrese asistencias:");
                            int assists = scanner.nextInt();
                            System.out.println("Ingrese fintas:");
                            int feints = scanner.nextInt();  // Agregado
                            Setter setter = new Setter(name, country, errors, aces, totalServices, assists, feints);
                            tournament.addPlayer(setter);
                            break;
                        case "auxiliar":
                            System.out.println("Ingrese bloqueos efectivos:");
                            int effectiveBlocksAux = scanner.nextInt();  // Agregado
                            System.out.println("Ingrese bloqueos fallidos:");
                            int failedBlocksAux = scanner.nextInt();  // Agregado
                            Auxiliary auxiliary = new Auxiliary(name, country, errors, aces, totalServices, effectiveBlocksAux, failedBlocksAux, errors);
                            tournament.addPlayer(auxiliary);
                            break;
                        case "opuesto":
                            System.out.println("Ingrese bloqueos efectivos:");
                            int effectiveBlocksOpp = scanner.nextInt();  // Agregado
                            System.out.println("Ingrese bloqueos fallidos:");
                            int failedBlocksOpp = scanner.nextInt();  // Agregado
                            Opposite opposite = new Opposite(name, country, errors, aces, totalServices, effectiveBlocksOpp, failedBlocksOpp, errors);
                            tournament.addPlayer(opposite);
                            break;
                        default:
                            System.out.println("Tipo de jugador no reconocido.");
                            break;
                    }
                    break;
                case 2:
                    tournament.displayAllPlayers();
                    break;
                case 3:
                    tournament.getTop3Liberos();
                    List<Libero> topLiberos = tournament.getTop3Liberos();
                    System.out.println("Los 3 mejores líberos son:");
                    for (Libero libero : topLiberos) {
                        System.out.println(libero);
                    }
                    break;
                case 4:
                    int count = (int) tournament.getCountOfSettersAbove80();
                    System.out.println("Cantidad de pasadores con más de un 80% de efectividad: " + count);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}




