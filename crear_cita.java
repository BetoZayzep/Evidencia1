import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrearCita {
    public static void main(String[] args) {
        // Obtener los valores de entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el identificador de la cita: ");
        String appointmentId = scanner.nextLine();
        System.out.print("Ingrese la fecha y hora de la cita (formato: yyyy-MM-dd HH:mm): ");
        String dateTimeString = scanner.nextLine();
        System.out.print("Ingrese el motivo de la cita: ");
        String reason = scanner.nextLine();

        // Obtener el doctor relacionado
        System.out.print("Ingrese el identificador del doctor: ");
        String doctorIdInput = scanner.nextLine();
        Doctor selectedDoctor = null;
        for (Doctor doc : doctors) {
            if (doc.getId().equals(doctorIdInput)) {
                selectedDoctor = doc;
                break;
            }
        }

        // Obtener el paciente relacionado
        System.out.print("Ingrese el identificador del paciente: ");
        String patientIdInput = scanner.nextLine();
        Patient selectedPatient = null;
        for (Patient pat : patients) {
            if (pat.getId().equals(patientIdInput)) {
                selectedPatient = pat;
                break;
            }
        }
        if (selectedDoctor != null && selectedPatient != null) {
            // Convertir la fecha y hora a LocalDateTime
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            // Crear la cita y agregarla a la lista de citas
            Appointment appointment = new Appointment(appointmentId, dateTime, reason, selectedDoctor, selectedPatient);
            appointments.add(appointment);
            saveAppointments();
            System.out.println("Cita creada exitosamente.");
        } else {
            System.out.println("Doctor o paciente no encontrado. Intente nuevamente.");
        }
    }
}
