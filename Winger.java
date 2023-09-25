/**
 * Clase Winger
 * Fernando Rueda - 23748
 * Descripción: Representa un extremo en el campeonato de balonmano.
 * Fecha de creación: [24/09/2023]
 * Fecha de última modificación: [24/09/2023]
 */
public class Winger extends Player {
    /**
     * Número de pases realizados por el extremo.
     */
    private int passes;
    
    /**
     * Número de asistencias efectivas realizadas por el extremo.
     */
    private int effectiveAssists;

    /**
     * Constructor para inicializar un extremo con sus atributos específicos.
     * @param name Nombre del extremo.
     * @param country País del extremo.
     * @param fouls Número de faltas cometidas por el extremo.
     * @param directGoals Número de goles directos anotados por el extremo.
     * @param totalThrows Número total de lanzamientos realizados por el extremo.
     * @param passes Número de pases realizados por el extremo.
     * @param effectiveAssists Número de asistencias efectivas realizadas por el extremo.
     */
    public Winger(String name, String country, int fouls, int directGoals, int totalThrows, int passes, int effectiveAssists) {
        super(name, country, fouls, directGoals, totalThrows);
        this.passes = passes;
        this.effectiveAssists = effectiveAssists;
    }

    /**
     * Calcula la efectividad del extremo basándose en sus pases, asistencias efectivas, faltas, goles directos y lanzamientos totales.
     * @return la efectividad del extremo.
     */
    @Override
    public double calculateEffectiveness() {
        return ((double) (passes + effectiveAssists - fouls) * 100 / (passes + effectiveAssists + fouls)) + ((double) directGoals * 100 / totalThrows);
    }
}

