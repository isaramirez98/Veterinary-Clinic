package domain;
import java.io.Serializable;
import java.util.ArrayList;

public class Owner implements Serializable {

    private String name;
    private String id;
    private String phoneNumber;
    private String address;
    private ArrayList<Pet> pets;

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public Owner(String name, String id, String phoneNumber,
            String address) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        if (!pets.contains(pet)) {
            pets.add(pet);
            pet.setOwner(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.isEmpty()) {
            this.phoneNumber = phone;
        }

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.isEmpty()) {
            this.address = address;
        }
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public String getInfo() { 
        return "Owner: " + name
                + "\nID: " + id
                + "\nPhone: " + phoneNumber
                + "\nAddress: " + address
                + "\nPets: " + pets.size();
    }
    
}
