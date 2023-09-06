/**
 * Clase Exam
 * Fernando Rueda - 23748
 * Descripción: Representa un examen que un estudiante ha tomado.
 * Fecha de creación: [02/09/2023]
 * Fecha de última modificación: [02/09/2023]
 */

public class Exam {

    /** Asignatura o materia del examen. */
    private String subject;

    /** Puntuación o nota obtenida en el examen. */
    private double score;

    /**
     * Constructor para crear un nuevo examen.
     *
     * @param subject  Asignatura o materia del examen.
     * @param score    Puntuación o nota obtenida en el examen.
     */
    public Exam(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    /**
     * Obtiene la asignatura o materia del examen.
     *
     * @return La asignatura del examen.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Obtiene la puntuación o nota del examen.
     *
     * @return La puntuación del examen.
     */
    public double getScore() {
        return score;
    }

    /**
     * Establece una nueva puntuación o nota para el examen.
     *
     * @param score  La nueva puntuación para el examen.
     */
    public void setScore(double score) {
        this.score = score;
    }
}

