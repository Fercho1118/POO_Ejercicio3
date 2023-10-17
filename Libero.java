/**
 * Clase Tournament
 * Fernando Rueda - 23748
 * Descripción: Jugador tipo libero
 * Fecha de creación: [14/10/2023]
 * Fecha de última modificación: [16/10/2023]
 */
public class Libero extends Player {
    private int effectiveReceives;

    /**
     * Constructor para la clase Libero.
     *
     * @param name           Nombre del jugador.
     * @param country        País de origen del jugador.
     * @param errors         Número de errores cometidos por el jugador.
     * @param aces           Número de aces realizados por el jugador.
     * @param totalServices  Total de servicios realizados por el jugador.
     * @param effectiveReceives Número de recepciones efectivas realizadas por el jugador.
     */
    public Libero(String name, String country, int errors, int aces, int totalServices, int effectiveReceives) {
        super(name, country, errors, aces, totalServices);
        this.effectiveReceives = effectiveReceives;
    }

    @Override
    public double calculateEffectiveness() {
        return ((aces + effectiveReceives) - errors) / (double) totalServices;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + effectiveReceives + ",LIBERO";
    }

    public static Libero fromCSV(String csv) {
        String[] parts = csv.split(",");
        String name = parts[0];
        String country = parts[1];
        int errors = Integer.parseInt(parts[2]);
        int aces = Integer.parseInt(parts[3]);
        int totalServices = Integer.parseInt(parts[4]);
        int effectiveReceives = Integer.parseInt(parts[5]);
        return new Libero(name, country, errors, aces, totalServices, effectiveReceives);
    }

    public int getEffectiveReceives() {
        return effectiveReceives;
    }

    public void setEffectiveReceives(int effectiveReceives) {
        this.effectiveReceives = effectiveReceives;
    }

    @Override
    public String toString() {
        return super.toString() + ", Recibos efectivos: " + effectiveReceives;
    }
}



