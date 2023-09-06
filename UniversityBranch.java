/**
 * Clase UniversityBranch
 * Fernando Rueda - 23748
 * Descripción: Representa una sede universitaria, con un nombre y una lista de estudiantes.
 * Fecha de creación: [02/09/2023]
 * Fecha de última modificación: [02/09/2023]
 */
import java.util.List;
import java.util.ArrayList;

public class UniversityBranch {

    /** Nombre de la sede universitaria. */
    private String name;

    /** Lista de estudiantes registrados en esta sede. */
    private List<Student> studentsList;

    /**
     * Obtiene el nombre de la sede universitaria.
     *
     * @return El nombre de la sede.
     */
    public String getName() {
        return name;
    }

    /**
     * Constructor que inicializa una nueva sede universitaria con un nombre específico.
     *
     * @param name El nombre de la sede universitaria.
     */
    public UniversityBranch(String name) {
        this.name = name;
        this.studentsList = new ArrayList<>();
    }

    /**
     * Añade un nuevo estudiante a la lista de estudiantes de esta sede.
     *
     * @param student El estudiante a añadir.
     */
    public void addStudent(Student student) {
        studentsList.add(student);
    }

    /**
     * Obtiene la lista de estudiantes registrados en esta sede.
     *
     * @return Una lista de estudiantes.
     */
    public List<Student> listStudents() {
        return studentsList;
    }
}

