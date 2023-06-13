import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MainApp {
    private static final List<Doctor> doctors = new ArrayList<>();
    private static final List<Patient> patients = new ArrayList<>();
    private static final List<Appointment> appointments = new ArrayList<>();

    private static final String DOCTORS_FILE_PATH = "db/doctors.csv";
    private static final String PATIENTS_FILE_PATH = "db/patients.csv";
    private static final String APPOINTMENTS_FILE_PATH = "db/appointments.csv";

    public static void main(String[] args) {
        loadDoctors();
        loadPatients();
        loadAppointments();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("===== Sistema de Administración de Citas =====");
            System.out.println("1. Dar de alta doctor");
            System.out.println("2. Dar de alta paciente");
            System.out.println("3. Crear cita");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el identificador del doctor: ");
                    String doctorId = scanner.nextLine();
                    System.out.print("Ingrese el nombre completo del doctor: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Ingrese la especialidad del doctor: ");
                    String doctorSpecialization = scanner.nextLine();
                    Doctor doctor = new Doctor(doctorId, doctorName, doctorSpecialization);
                    doctors.add(doctor);
                    saveDoctors();
                    System.out.println("Doctor dado de alta exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el identificador del paciente: ");
                    String patientId = scanner.nextLine();
                    System.out.print("Ingrese el nombre completo del paciente: ");
                    String patientName = scanner.nextLine();
                    Patient patient = new Patient(patientId, patientName);
                    patients.add(patient);
                    savePatients();
                    System.out.println("Paciente dado de alta exitosamente.");
                    break;
                case 3:
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
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println();
        }
    }

    private static void loadDoctors() {
        try (CSVReader reader = new CSVReader(new FileReader(DOCTORS_FILE_PATH))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length == 3) {
                    String id = line[0];
                    String name = line[1];
                    String specialization = line[2];
                    Doctor doctor = new Doctor(id, name, specialization);
                    doctors.add(doctor);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de doctores: " + e.getMessage());
        }
    }

    private static void saveDoctors() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(DOCTORS_FILE_PATH))) {
            for (Doctor doctor : doctors) {
                String[] line = {doctor.getId(), doctor.getName(), doctor.getSpecialization()};
                writer.writeNext(line);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo de doctores: " + e.getMessage());
        }
    }

    private static void loadPatients() {
        try (CSVReader reader = new CSVReader(new FileReader(PATIENTS_FILE_PATH))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length == 2) {
                    String id = line[0];
                    String name = line[1];
                    Patient patient = new Patient(id, name);
                    patients.add(patient);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de pacientes: " + e.getMessage());
        }
    }

    private static void savePatients() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(PATIENTS_FILE_PATH))) {
            for (Patient patient : patients) {
                String[] line = {patient.getId(), patient.getName()};
                writer.writeNext(line);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo de pacientes: " + e.getMessage());
        }
    }

    private static void loadAppointments() {
        try (CSVReader reader = new CSVReader(new FileReader(APPOINTMENTS_FILE_PATH))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length == 6) {
                    String id = line[0];
                    LocalDateTime dateTime = LocalDateTime.parse(line[1]);
                    String reason = line[2];
                    String doctorId = line[3];
                    String patientId = line[4];

                    Doctor doctor = findDoctorById(doctorId);
                    Patient patient = findPatientById(patientId);

                    if (doctor != null && patient != null) {
                        Appointment appointment = new Appointment(id, dateTime, reason, doctor, patient);
                        appointments.add(appointment);
                    } else {
                        System.err.println("Error al cargar la cita. Doctor o paciente no encontrado.");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de citas: " + e.getMessage());
        }
    }

    private static void saveAppointments() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(APPOINTMENTS_FILE_PATH))) {
            for (Appointment appointment : appointments) {
                String[] line = {
                        appointment.getId(),
                        appointment.getDateTime().toString(),
                        appointment.getReason(),
                        appointment.getDoctor().getId(),
                        appointment.getPatient().getId()
                };
                writer.writeNext(line);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo de citas: " + e.getMessage());
        }
    }

    private static Doctor findDoctorById(String id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    private static Patient findPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }
}
