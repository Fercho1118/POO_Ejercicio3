/**
 * Clase Player
 * Fernando Rueda - 23748
 * Descripción: Representa un jugador genérico en el campeonato de balonmano.
 * Fecha de creación: [24/09/2023]
 * Fecha de última modificación: [24/09/2023]
 */
public abstract class Player {
    /**
     * Nombre del jugador.
     */
    protected String name;
    
    /**
     * País del jugador.
     */
    protected String country;
    
    /**
     * Número de faltas cometidas por el jugador.
     */
    protected int fouls;
    
    /**
     * Número de goles directos anotados por el jugador.
     */
    protected int directGoals;
    
    /**
     * Número total de lanzamientos realizados por el jugador.
     */
    protected int totalThrows;

    /**
     * Constructor para inicializar un jugador con sus atributos básicos.
     * @param name Nombre del jugador.
     * @param country País del jugador.
     * @param fouls Número de faltas cometidas por el jugador.
     * @param directGoals Número de goles directos anotados por el jugador.
     * @param totalThrows Número total de lanzamientos realizados por el jugador.
     */
    public Player(String name, String country, int fouls, int directGoals, int totalThrows) {
        this.name = name;
        this.country = country;
        this.fouls = fouls;
        this.directGoals = directGoals;
        this.totalThrows = totalThrows;
    }

    /**
     * Método abstracto para calcular la efectividad del jugador.
     * Debe ser implementado por las subclases.
     * @return la efectividad del jugador.
     */
    public abstract double calculateEffectiveness();
}

