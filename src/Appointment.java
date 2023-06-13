import java.time.LocalDateTime;

public class Appointment {
    private final String id;
    private final LocalDateTime dateTime;
    private final String reason;
    private final Doctor doctor;
    private final Patient patient;

    public Appointment(String id, LocalDateTime dateTime, String reason, Doctor doctor, Patient patient) {
        this.id = id;
        this.dateTime = dateTime;
        this.reason = reason;
        this.doctor = doctor;
        this.patient = patient;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getReason() {
        return reason;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }
}
