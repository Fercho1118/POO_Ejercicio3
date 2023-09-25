/**
 * Clase Championship
 * Fernando Rueda - 23748
 * Descripción: Representa el campeonato de balonmano y gestiona los jugadores registrados.
 * Fecha de creación: [24/09/2023]
 * Fecha de última modificación: [24/09/2023]
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Championship {
    /**
     * Lista que almacena los jugadores registrados en el campeonato.
     */
    private final List<Player> playersList = new ArrayList<>();

    /**
     * Registra un nuevo jugador en el campeonato.
     * @param player el jugador a registrar.
     */
    public void registerPlayer(Player player) {
        playersList.add(player);
    }

    /**
     * Muestra todos los jugadores registrados en el campeonato junto con su efectividad.
     */
    public void displayAllPlayers() {
        for (Player player : playersList) {
            System.out.println(player.name + " - " + player.country + " - Efectividad: " + player.calculateEffectiveness());
        }
    }

    /**
     * Obtiene los 3 mejores porteros basándose en su efectividad.
     * @return una lista de los 3 mejores porteros.
     */
    public List<Goalkeeper> getTopGoalkeepers() {
        return playersList.stream()
                .filter(player -> player instanceof Goalkeeper)
                .map(player -> (Goalkeeper) player)
                .sorted(Comparator.comparingDouble(Goalkeeper::calculateEffectiveness).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene el número de extremos con más de un 85% de efectividad.
     * @return el número de extremos con alta efectividad.
     */
    public long getHighEffectiveWingers() {
        return playersList.stream()
                .filter(player -> player instanceof Winger)
                .map(player -> (Winger) player)
                .filter(winger -> winger.calculateEffectiveness() > 85)
                .count();
    }
}


