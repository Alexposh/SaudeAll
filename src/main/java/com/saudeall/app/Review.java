public class Review {
    private Doctor doctor;
    private Patient patient;
    private int ratingGiven;

    public Review(Doctor doctor, Patient patient, int ratingGiven) {
        this.doctor = doctor;
        this.patient = patient;
        this.ratingGiven = ratingGiven;
    }

}
