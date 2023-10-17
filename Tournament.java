/**
 * Clase Tournament
 * Fernando Rueda - 23748
 * Descripción: Gestiona el torneo de voleibol.
 * Fecha de creación: [14/10/2023]
 * Fecha de última modificación: [16/10/2023]
 */
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Tournament {
    private Map<String, Player> playersMap;

    public Tournament() {
        playersMap = new HashMap<>();
        loadPlayersFromCSV();
    }

    /**
     * Añade un jugador al torneo.
     * 
     * @param player Jugador a añadir.
     */
    public void addPlayer(Player player) {
        playersMap.put(player.getName(), player);
        savePlayersToCSV(); // Guarda los datos en el archivo después de añadir un jugador.
    }

    /**
     * Muestra todos los jugadores inscritos en el torneo.
     */
    public void displayAllPlayers() {
        for (Player player : playersMap.values()) {
            System.out.println(player);
        }
    }

    /**
     * Guarda la lista de jugadores en un archivo CSV.
     */
    public void savePlayersToCSV() {
        try (PrintWriter writer = new PrintWriter(new File("players.csv"))) {
            for (Player player : playersMap.values()) {
                if (player instanceof Libero) {
                    Libero libero = (Libero) player;
                    writer.println(libero.toCSV());
                } else if (player instanceof Setter) {
                    Setter setter = (Setter) player;
                    writer.println(setter.toCSV());
                } else if (player instanceof Auxiliary) {
                    Auxiliary auxiliary = (Auxiliary) player;
                    writer.println(auxiliary.toCSV());
                } else if (player instanceof Opposite) {
                    Opposite opposite = (Opposite) player;
                    writer.println(opposite.toCSV());
                } else {
                    // Puedes manejar otros tipos de jugadores aquí si es necesario
                    writer.println(player.toCSV());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al guardar en CSV: " + e.getMessage());
        }
    }

    /**
     * Carga la lista de jugadores desde un archivo CSV.
     */
    public void loadPlayersFromCSV() {
        File file = new File("players.csv");
        if (!file.exists()) {
            try {
                file.createNewFile(); // Si el archivo no existe, lo crea.
            } catch (IOException e) {
                System.out.println("Error al crear el archivo CSV: " + e.getMessage());
                return;
            }
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Player player = Player.fromCSV(line);
                if (player != null) {
                    playersMap.put(player.getName(), player);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar desde CSV: " + e.getMessage());
        }
    }

    /**
     * Devuelve una lista de los 3 mejores líberos.
     * 
     * @return Lista de los 3 mejores líberos.
     */
    public List<Libero> getTop3Liberos() {
        return playersMap.values().stream()
                .filter(player -> player instanceof Libero)
                .map(player -> (Libero) player)
                .sorted(Comparator.comparingDouble(Libero::calculateEffectiveness).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Devuelve la cantidad de pasadores con más del 80% de efectividad.
     * 
     * @return Cantidad de pasadores con alta efectividad.
     */
    public int getCountOfSettersAbove80() {
        return (int) playersMap.values().stream()
                .filter(player -> player instanceof Setter)
                .map(player -> (Setter) player)
                .filter(setter -> setter.calculateEffectiveness() > 80)
                .count();
    }

    // ... (Otros métodos relacionados con la lógica del torneo)
}





