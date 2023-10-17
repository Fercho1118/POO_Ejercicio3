/**
 * Clase Player
 * Fernando Rueda - 23748
 * Descripción: Clase base que representa a un jugador en un torneo de voleibol.
 * Fecha de creación: [14/10/2023]
 * Fecha de última modificación: [16/10/2023]
 */
public abstract class Player {
    protected String name;
    protected String country;
    protected int errors;
    protected int aces;
    protected int totalServices;

    /**
     * Constructor de la clase Player.
     *
     * @param name          Nombre del jugador.
     * @param country       País de origen del jugador.
     * @param errors        Número de errores cometidos por el jugador.
     * @param aces          Número de aces realizados por el jugador.
     * @param totalServices Total de servicios realizados por el jugador.
     */
    public Player(String name, String country, int errors, int aces, int totalServices) {
        this.name = name;
        this.country = country;
        this.errors = errors;
        this.aces = aces;
        this.totalServices = totalServices;
    }

    public abstract double calculateEffectiveness();

    public String toCSV() {
        return name + "," + country + "," + errors + "," + aces + "," + totalServices;
    }

    public static Player fromCSV(String csv) {
        String[] parts = csv.split(",");
        String type = parts[parts.length - 1];

        switch (type) {
            case "LIBERO":
                return Libero.fromCSV(csv);
            case "SETTER":
                return Setter.fromCSV(csv);
            case "OPPOSITE":
                return Opposite.fromCSV(csv);
            case "AUXILIARY":
                return Auxiliary.fromCSV(csv);
            default:
                return null;
        }
    }
    
    @Override
    public String toString() {
    return "Nombre: " + name + ", País: " + country + ", Errores: " + errors + ", Aces: " + aces + ", Total de Servicios: " + totalServices;
    }

    
    public String getName() {
        return name;
    }
    
    public String getCountry() {
        return country;
    }
}


