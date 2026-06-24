package domain;
import java.io.Serializable;
import java.util.ArrayList;

public class Appointment implements Serializable {
    private String appointmentId;
    private String date;
    private String hour;
    private Pet pet;
    private Veterinarian veterinarian;
    private String reason;
    private ArrayList<Treatment> treatments;

    public Appointment(String appointmentId, String date,String hour, 
        Pet pet, Veterinarian veterinarian, String reason) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.hour=hour;
        this.pet = pet;
        this.veterinarian = veterinarian;
        this.reason = reason;
        this.treatments = new ArrayList<>();
    }

    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);

    }

    public String getInfo() {
        return "Appointment Id:" + appointmentId +
                "Date:" + date + "Hour"+ hour+
                "Pet:" + pet +
                "Veterinarian:" + veterinarian+
                "Reason:"+ reason;

    }
    public Pet getPet(){
        return pet;
    }
    public Veterinarian getVeterinarian(){
        return veterinarian;
    }
    public ArrayList<Treatment> getTreatment(){
        return treatments;
    }
    
}


