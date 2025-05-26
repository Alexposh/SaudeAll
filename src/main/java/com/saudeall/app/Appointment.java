import java.util.Date;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private Date dateOfAppointment;

    public Appointment(Doctor doctor, Patient patient, Date dateOfAppointment) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateOfAppointment = dateOfAppointment;
    }
}
