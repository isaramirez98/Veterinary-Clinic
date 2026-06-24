package domain;
import java.io.Serializable;

public class Veterinarian implements Serializable {
    private String name;
    private String specialty;
    private String phoneNumber;

    public Veterinarian(String name, String specialty, String phoneNumber) {
        this.name = name;
        this.specialty = specialty;
        this.phoneNumber= phoneNumber;
    }

    public String getInfo() {
        return "Dr." + name +
                "Specialty:" + specialty+
                "Number:" + phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }
 @Override
    public String toString() {
        return getInfo();
    }
}

