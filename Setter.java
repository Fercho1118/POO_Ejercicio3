/**
 * Clase Setter
 * Fernando Rueda - 23748
 * Descripción: Clase que representa a un jugador de tipo Pasador en un torneo de voleibol.
 * Fecha de creación: [14/10/2023]
 * Fecha de última modificación: [16/10/2023]
 */

public class Setter extends Player {
    private int passes;
    private int feints;

    /**
     * Constructor para la clase Setter.
     *
     * @param name           Nombre del jugador.
     * @param country        País de origen del jugador.
     * @param errors         Número de errores cometidos por el jugador.
     * @param aces           Número de aces realizados por el jugador.
     * @param totalServices  Total de servicios realizados por el jugador.
     * @param passes         Número de pases realizados por el jugador.
     * @param feints         Número de fintas realizadas por el jugador.
     */
    public Setter(String name, String country, int errors, int aces, int totalServices, int passes, int feints) {
        super(name, country, errors, aces, totalServices);
        this.passes = passes;
        this.feints = feints;
    }

    /**
     * Crea un objeto de tipo Setter a partir de una cadena CSV.
     *
     * @param csv Cadena CSV que contiene los datos del jugador.
     * @return Objeto de tipo Setter creado a partir de la cadena CSV.
     */
    public static Setter fromCSV(String csv) {
        String[] parts = csv.split(",");
        String name = parts[0];
        String country = parts[1];
        int errors = Integer.parseInt(parts[2]);
        int aces = Integer.parseInt(parts[3]);
        int totalServices = Integer.parseInt(parts[4]);
        int passes = Integer.parseInt(parts[5]);
        int feints = Integer.parseInt(parts[6]);
        return new Setter(name, country, errors, aces, totalServices, passes, feints);
    }

    /**
     * Calcula la efectividad del jugador de tipo Pasador.
     *
     * @return El valor de efectividad del jugador de tipo Pasador.
     */
    @Override
    public double calculateEffectiveness() {
        // Fórmula para calcular la efectividad de un Pasador
        return ((passes + feints - errors) * 100.0 / (passes + feints + errors)) + (aces * 100.0 / totalServices);
    }

    /**
     * Obtiene el número de pases realizados por el jugador.
     *
     * @return Número de pases realizados.
     */
    public int getPasses() {
        return passes;
    }

    /**
     * Establece el número de pases realizados por el jugador.
     *
     * @param passes Número de pases a establecer.
     */
    public void setPasses(int passes) {
        this.passes = passes;
    }

    /**
     * Obtiene el número de fintas realizadas por el jugador.
     *
     * @return Número de fintas realizadas.
     */
    public int getFeints() {
        return feints;
    }

    /**
     * Establece el número de fintas realizadas por el jugador.
     *
     * @param feints Número de fintas a establecer.
     */
    public void setFeints(int feints) {
        this.feints = feints;
    }

    /**
     * Representación en cadena del jugador de tipo Pasador.
     *
     * @return Cadena que describe al jugador de tipo Pasador.
     */
    @Override
    public String toString() {
        return super.toString() + ", Pases: " + passes + ", Fintas: " + feints;
    }
}
