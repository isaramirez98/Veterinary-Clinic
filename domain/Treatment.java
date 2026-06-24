package domain;
import java.io.Serializable;

public class Treatment implements Serializable {
    private String description;
    private String medication;
    private double dosage;
    private String date;

    public Treatment(String description, String medication, 
        double dosage, String date) {
        this.description = description;
        this.medication = medication;
        this.dosage = dosage;
        this.date=date;

    }

    public String getInfo() {
        return "\nTreatment:" + description +
                "\nMedication:" + medication +
                "\nDosage:" + dosage +
                "\nDate:"+ date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }
    public String getDate(){
        return date;
    }

}