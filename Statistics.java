/**
 * Clase Statistics
 * Fernando Rueda - 23748
 * Descripción: Clase que proporciona métodos para calcular estadísticas sobre una lista de exámenes.
 * Fecha de creación: [02/09/2023]
 * Fecha de última modificación: [02/09/2023]
 */
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

public class Statistics {

    /** Lista de puntuaciones de exámenes. */
    private List<Exam> examScores;

    /**
     * Constructor que inicializa la lista de puntuaciones de exámenes.
     *
     * @param examScores Lista de exámenes.
     */
    public Statistics(List<Exam> examScores) {
        this.examScores = examScores;
    }

    /**
     * Calcula el promedio de las puntuaciones de los exámenes.
     *
     * @return El promedio de las puntuaciones.
     */

    public double calculateAverage() {
        double sum = 0;
        for (Exam exam : examScores) {
            sum += exam.getScore();
        }
        return sum / examScores.size();
    }

    /**
     * Calcula la mediana de las puntuaciones de los exámenes.
     *
     * @return La mediana de las puntuaciones.
     */
    public double calculateMedian() {
        int size = examScores.size();
        Collections.sort(examScores, (a, b) -> Double.compare(a.getScore(), b.getScore()));
        if (size % 2 == 0) {
            return (examScores.get(size / 2 - 1).getScore() + examScores.get(size / 2).getScore()) / 2.0;
        } else {
            return examScores.get(size / 2).getScore();
        }
    }

    /**
     * Calcula la moda de las puntuaciones de los exámenes.
     *
     * @return La moda de las puntuaciones.
     */
    public double calculateMode() {
        HashMap<Double, Integer> scoreFrequency = new HashMap<>();
        for (Exam exam : examScores) {
            scoreFrequency.put(exam.getScore(), scoreFrequency.getOrDefault(exam.getScore(), 0) + 1);
        }
        double mode = Collections.max(scoreFrequency.entrySet(), HashMap.Entry.comparingByValue()).getKey();
        return mode;
    }

    /**
     * Calcula la desviación estándar de las puntuaciones de los exámenes.
     *
     * @return La desviación estándar de las puntuaciones.
     */
    public double calculateStandardDeviation() {
        double mean = calculateAverage();
        double sum = 0;
        for (Exam exam : examScores) {
            sum += Math.pow(exam.getScore() - mean, 2);
        }
        return Math.sqrt(sum / examScores.size());
    }

    /**
     * Encuentra la puntuación más alta entre los exámenes.
     *
     * @return La puntuación más alta.
     */
    public double highestScore() {
        double max = Double.MIN_VALUE;
        for (Exam exam : examScores) {
            if (exam.getScore() > max) {
                max = exam.getScore();
            }
        }
        return max;
    }

    /**
     * Encuentra la puntuación más baja entre los exámenes.
     *
     * @return La puntuación más baja.
     */
    public double lowestScore() {
        double min = Double.MAX_VALUE;
        for (Exam exam : examScores) {
            if (exam.getScore() < min) {
                min = exam.getScore();
            }
        }
        return min;
    }
}

