/**
 * Clase Auxiliary
 * Fernando Rueda - 23748
 * Descripción: Clase que representa a un jugador de tipo Auxiliar en un torneo de voleibol.
 * Fecha de creación: [14/10/2023]
 * Fecha de última modificación: [16/10/2023]
 */
public class Auxiliary extends Player {
    private int attacks;
    private int effectiveBlocks;
    private int failedBlocks;

    public Auxiliary(String name, String country, int errors, int aces, int totalServices, int attacks, int effectiveBlocks, int failedBlocks) {
        super(name, country, errors, aces, totalServices);
        this.attacks = attacks;
        this.effectiveBlocks = effectiveBlocks;
        this.failedBlocks = failedBlocks;
    }

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

    @Override
    public String toString() {
        return super.toString() + ", Ataques: " + attacks +
                ", Bloqueos Efectivos: " + effectiveBlocks +
                ", Bloqueos Fallidos: " + failedBlocks;
    }

    public String toCSV() {
        return super.toCSV() + "," + attacks + "," + effectiveBlocks + "," + failedBlocks + ",AUXILIARY";
    }

    public static Auxiliary fromCSV(String csv) {
        String[] parts = csv.split(",");
        String name = parts[0];
        String country = parts[1];
        int errors = Integer.parseInt(parts[2]);
        int aces = Integer.parseInt(parts[3]);
        int totalServices = Integer.parseInt(parts[4]);
        int attacks = Integer.parseInt(parts[5]);
        int effectiveBlocks = Integer.parseInt(parts[6]);
        int failedBlocks = Integer.parseInt(parts[7]);
        return new Auxiliary(name, country, errors, aces, totalServices, attacks, effectiveBlocks, failedBlocks);
    }
}

