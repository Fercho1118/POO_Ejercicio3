/**
 * Clase Goalkeeper
 * Fernando Rueda - 23748
 * Descripción: Representa un portero en el campeonato de balonmano.
 * Fecha de creación: [24/09/2023]
 * Fecha de última modificación: [24/09/2023]
 */
public class Goalkeeper extends Player {
    /**
     * Número de paradas efectivas realizadas por el portero.
     */
    private int effectiveStops;
    
    /**
     * Número de goles recibidos por el portero.
     */
    private int receivedGoals;

    /**
     * Constructor para inicializar un portero con sus atributos específicos.
     * @param name Nombre del portero.
     * @param country País del portero.
     * @param fouls Número de faltas cometidas por el portero.
     * @param directGoals Número de goles directos anotados por el portero.
     * @param totalThrows Número total de lanzamientos realizados por el portero.
     * @param effectiveStops Número de paradas efectivas realizadas por el portero.
     * @param receivedGoals Número de goles recibidos por el portero.
     */
    public Goalkeeper(String name, String country, int fouls, int directGoals, int totalThrows, int effectiveStops, int receivedGoals) {
        super(name, country, fouls, directGoals, totalThrows);
        this.effectiveStops = effectiveStops;
        this.receivedGoals = receivedGoals;
    }

    /**
     * Calcula la efectividad del portero basándose en sus paradas efectivas, goles recibidos, goles directos y lanzamientos totales.
     * @return la efectividad del portero.
     */
    @Override
    public double calculateEffectiveness() {
        return ((double) (effectiveStops - receivedGoals) * 100 / (effectiveStops + receivedGoals)) + ((double) directGoals * 100 / totalThrows);
    }
}

