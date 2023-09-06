/**
 * Clase Main
 * Fernando Rueda - 23748
 * Descripción: Esta clase contiene el método main, que es el punto de entrada al programa.
 * Fecha de creación: [02/09/2023]
 * Fecha de última modificación: [02/09/2023]
 */

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Main {

    /** Lista de sedes universitarias. */
    private static List<UniversityBranch> branches = new ArrayList<>();

    /** Scanner para la entrada de datos del usuario. */
    private static Scanner scanner = new Scanner(System.in);

    /** Formato de fecha para la entrada de datos del usuario. */
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Método principal para iniciar la aplicación.
     *
     * @param args  Argumentos de línea de comando.
     */

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de registro de exámenes.");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Registrar sede");
            System.out.println("2. Registrar estudiante en una sede");
            System.out.println("3. Registrar examen para estudiante en una sede");
            System.out.println("4. Mostrar estadísticas de exámenes en una sede");
            System.out.println("5. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    registerBranch();
                    break;
                case 2:
                    registerStudentInBranch();
                    break;
                case 3:
                    registerExamInBranch();
                    break;
                case 4:
                    showStatisticsInBranch();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    /**
     * Registra una nueva sede universitaria.
     */
    private static void registerBranch() {
        System.out.println("Ingrese el nombre de la sede:");
        String branchName = scanner.nextLine();
        branches.add(new UniversityBranch(branchName));
        System.out.println("Sede registrada exitosamente.");
    }

    /**
     * Selecciona una sede universitaria de la lista.
     *
     * @return La sede universitaria seleccionada o null si la selección no es válida.
     */
    private static UniversityBranch selectBranch() {
        System.out.println("Seleccione una sede:");
        for (int i = 0; i < branches.size(); i++) {
            System.out.println((i + 1) + ". " + branches.get(i).getName());
        }
        int branchIndex = scanner.nextInt() - 1;
        scanner.nextLine();  
        if (branchIndex < 0 || branchIndex >= branches.size()) {
            System.out.println("Selección no válida.");
            return null;
        }
        return branches.get(branchIndex);
    }

    /**
     * Registra un nuevo estudiante en una sede específica.
     */
    private static void registerStudentInBranch() {
        UniversityBranch branch = selectBranch();
        if (branch != null) {
            registerStudent(branch);
        }
    }

    /**
     * Registra un nuevo examen para un estudiante en una sede específica.
     */
    private static void registerExamInBranch() {
        UniversityBranch branch = selectBranch();
        if (branch != null) {
            registerExam(branch);
        }
    }

    /**
     * Muestra las estadísticas de exámenes en una sede específica.
     */
    private static void showStatisticsInBranch() {
        UniversityBranch branch = selectBranch();
        if (branch != null) {
            showStatistics(branch);
        }
    }

    /**
     * Registra un nuevo estudiante en una sede universitaria.
     *
     * @param branch  La sede universitaria en la que se registrará el estudiante.
     */
    private static void registerStudent(UniversityBranch branch) {
        System.out.println("Ingrese el nombre del estudiante:");
        String firstName = scanner.nextLine();

        System.out.println("Ingrese el apellido del estudiante:");
        String lastName = scanner.nextLine();

        System.out.println("Ingrese el código único del estudiante:");
        String uniqueCode = scanner.nextLine();

        System.out.println("Ingrese la fecha de nacimiento del estudiante (dd/MM/yyyy):");
        Date birthDate = null;
        try {
            birthDate = dateFormat.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Formato de fecha incorrecto.");
            return;
        }

        System.out.println("Ingrese el correo electrónico del estudiante:");
        String email = scanner.nextLine();

        Student student = new Student(firstName, lastName, uniqueCode, birthDate, email);
        branch.addStudent(student);
        System.out.println("Estudiante registrado exitosamente en " + branch.getName() + ".");
    }
    /**
     * Registra un nuevo examen para un estudiante en una sede universitaria.
     *
     * @param branch  La sede universitaria en la que se registrará el examen.
     */
    private static void registerExam(UniversityBranch branch) {
        System.out.println("Ingrese el código único del estudiante:");
        String uniqueCode = scanner.nextLine();

        Student student = null;
        for (Student s : branch.listStudents()) {
            if (s.getUniqueCode().equals(uniqueCode)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.println("Ingrese la materia del examen (Matemática, Lenguaje, Química, Física, Comprensión Lectora, Estadística):");
        String subject = scanner.nextLine();

        System.out.println("Ingrese la nota del examen:");
        double score = scanner.nextDouble();
        scanner.nextLine();  

        student.registerExam(new Exam(subject, score));
        System.out.println("Examen registrado exitosamente para el estudiante en " + branch.getName() + ".");
    }

    /**
     * Muestra las estadísticas de exámenes para una materia específica en una sede universitaria.
     *
     * @param branch  La sede universitaria de la que se mostrarán las estadísticas.
     */
    private static void showStatistics(UniversityBranch branch) {
        System.out.println("Seleccione la materia para mostrar estadísticas (Matemática, Lenguaje, Química, Física, Comprensión Lectora, Estadística):");
        String subject = scanner.nextLine();

        List<Exam> examsForSubject = new ArrayList<>();
        for (Student student : branch.listStudents()) {
            double score = student.getExamScore(subject);
            if (score != -1) {
                examsForSubject.add(new Exam(subject, score));
            }
        }

        if (examsForSubject.isEmpty()) {
            System.out.println("No hay exámenes registrados para la materia seleccionada en " + branch.getName() + ".");
            return;
        }

        Statistics stats = new Statistics(examsForSubject);
        System.out.println("\nEstadísticas para " + subject + " en " + branch.getName() + ":");
        System.out.println("Cantidad de alumnos registrados: " + examsForSubject.size());
        System.out.println("Promedio: " + stats.calculateAverage());
        System.out.println("Mediana: " + stats.calculateMedian());
        System.out.println("Moda: " + stats.calculateMode());
        System.out.println("Desviación Estándar: " + stats.calculateStandardDeviation());
        System.out.println("Nota más alta: " + stats.highestScore());
        System.out.println("Nota más baja: " + stats.lowestScore());
    }

   
}
