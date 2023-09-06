/**
 * Clase Student
 * Fernando Rueda - 23748
 * Descripción: Representa a un estudiante con sus detalles y exámenes tomados.
 * Fecha de creación: [02/09/2023]
 * Fecha de última modificación: [02/09/2023]
 */
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class Student {

    /** Nombre del estudiante. */
    private String firstName;

    /** Apellido del estudiante. */
    private String lastName;

    /** Código único del estudiante. */
    private String uniqueCode;

    /** Fecha de nacimiento del estudiante. */
    private Date birthDate;

    /** Correo electrónico del estudiante. */
    private String email;

    /** Lista de exámenes tomados por el estudiante. */
    private List<Exam> examsTaken;

    /**
     * Constructor para crear un nuevo objeto de estudiante.
     *
     * @param firstName   Nombre del estudiante.
     * @param lastName    Apellido del estudiante.
     * @param uniqueCode  Código único del estudiante.
     * @param birthDate   Fecha de nacimiento del estudiante.
     * @param email       Correo electrónico del estudiante.
     */
    public Student(String firstName, String lastName, String uniqueCode, Date birthDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uniqueCode = uniqueCode;
        this.birthDate = birthDate;
        this.email = email;
        this.examsTaken = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del estudiante.
     *
     * @return El nombre del estudiante.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Obtiene el apellido del estudiante.
     *
     * @return El apellido del estudiante.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Obtiene el código único del estudiante.
     *
     * @return El código único del estudiante.
     */
    public String getUniqueCode() {
        return uniqueCode;
    }

    /**
     * Obtiene la fecha de nacimiento del estudiante.
     *
     * @return La fecha de nacimiento del estudiante.
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Obtiene el correo electrónico del estudiante.
     *
     * @return El correo electrónico del estudiante.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Registra un nuevo examen para el estudiante.
     *
     * @param exam El examen a registrar.
     */
    public void registerExam(Exam exam) {
        examsTaken.add(exam);
    }

    /**
     * Obtiene la puntuación del examen para una materia específica.
     *
     * @param subject La materia del examen.
     * @return La puntuación del examen o -1 si el examen no se encuentra.
     */
    public double getExamScore(String subject) {
        for (Exam exam : examsTaken) {
            if (exam.getSubject().equals(subject)) {
                return exam.getScore();
            }
        }
        return -1; // Return -1 if exam not found
    }
}

