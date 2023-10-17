/**
 * Clase Opposite
 * Fernando Rueda - 23748
 * Descripción: Clase que representa a un jugador de tipo Opuesto en un torneo de voleibol.
 * Fecha de creación: [14/10/2023]
 * Fecha de última modificación: [16/10/2023]
 */
public class Opposite extends Player {
    private int attacks;
    private int effectiveBlocks;
    private int failedBlocks;

   /**
     * Constructor para la clase Opposite.
     *
     * @param name           Nombre del jugador.
     * @param country        País de origen del jugador.
     * @param errors         Número de errores cometidos por el jugador.
     * @param aces           Número de aces realizados por el jugador.
     * @param totalServices  Total de servicios realizados por el jugador.
     * @param attacks        Número de ataques realizados por el jugador.
     * @param effectiveBlocks Número de bloqueos efectivos realizados por el jugador.
     * @param failedBlocks   Número de bloqueos fallidos realizados por el jugador.
     */
    public Opposite(String name, String country, int errors, int aces, int totalServices, int attacks, int effectiveBlocks, int failedBlocks) {
        super(name, country, errors, aces, totalServices);
        this.attacks = attacks;
        this.effectiveBlocks = effectiveBlocks;
        this.failedBlocks = failedBlocks;
    }

     /**
     * Calcula la efectividad del jugador de tipo Opuesto.
     *
     * @return El valor de efectividad del jugador de tipo Opuesto.
     */
    @Override
    public double calculateEffectiveness() {
        return ((attacks + effectiveBlocks - failedBlocks - errors) * 100.0 /
                (attacks + effectiveBlocks + failedBlocks + errors)) + (aces * 100.0 / totalServices);
    }

    public int getAttacks() {
        return attacks;
    }

    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    public int getEffectiveBlocks() {
        return effectiveBlocks;
    }

    public void setEffectiveBlocks(int effectiveBlocks) {
        this.effectiveBlocks = effectiveBlocks;
    }

    public int getFailedBlocks() {
        return failedBlocks;
    }

    public void setFailedBlocks(int failedBlocks) {
        this.failedBlocks = failedBlocks;
    }

    /**
     * Representación en cadena del jugador de tipo Opposite.
     *
     * @return Cadena que describe al jugador de tipo Opposite.
     */
    @Override
    public String toString() {
        return super.toString() + ", Ataques: " + attacks +
                ", Bloqueos Efectivos: " + effectiveBlocks +
                ", Bloqueos Fallidos: " + failedBlocks;
    }

    /**
     * Convierte los datos del jugador de tipo Opposite a una cadena CSV.
     *
     * @return Cadena CSV que representa al jugador de tipo Opposite.
     */
    public String toCSV() {
        return super.toCSV() + "," + attacks + "," + effectiveBlocks + "," + failedBlocks + ",OPPOSITE";
    }

    /**
     * Crea un objeto de tipo Opposite a partir de una cadena CSV.
     *
     * @param csv Cadena CSV que contiene los datos del jugador.
     * @return Objeto de tipo Opposite creado a partir de la cadena CSV.
     */
    public static Opposite fromCSV(String csv) {
        String[] parts = csv.split(",");
        String name = parts[0];
        String country = parts[1];
        int errors = Integer.parseInt(parts[2]);
        int aces = Integer.parseInt(parts[3]);
        int totalServices = Integer.parseInt(parts[4]);
        int attacks = Integer.parseInt(parts[5]);
        int effectiveBlocks = Integer.parseInt(parts[6]);
        int failedBlocks = Integer.parseInt(parts[7]);
        return new Opposite(name, country, errors, aces, totalServices, attacks, effectiveBlocks, failedBlocks);
    }
}
