package domain;
import java.io.Serializable;
import java.util.ArrayList;

public class VeterinaryClinic implements Serializable {
    private String clinicName;
    private ArrayList<Owner> owners;
    private ArrayList<Pet> pets;
    private ArrayList<Veterinarian> veterinarians;
    private ArrayList<Appointment> appointments;

    public VeterinaryClinic(String clinicName) {
        this.clinicName = clinicName;
        this.owners = new ArrayList<>();
        this.pets = new ArrayList<>();
        this.veterinarians = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public String getInfo() {
        return "Clinic: " + clinicName +
                "\nOwners: " + owners.size() +
                "\nPets: " + pets.size() +
                "\nVeterinarians: " + veterinarians.size() +
                "\nAppointments: " + appointments.size();
    }

    public String getClinicName() {
        return clinicName;
    }

    public void registerOwner(Owner owner) {
        owners.add(owner);
    }

    public void registerPet(Pet pet) {
        pets.add(pet);
    }

    public void registerVeterinarian(Veterinarian vet) {
        veterinarians.add(vet);
    }

    public void scheduleAppointment(Appointment apt) {
        appointments.add(apt);
    }

    
    public Owner findOwnerById(String id) {
        for (Owner o : owners) {
            if (o.getId().equals(id))
                return o;
        }
        return null;
    }

    public Pet findPetByName(String name) {
        for (Pet p : pets) {
            if (p.getName().equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public ArrayList<Veterinarian> getVeterinarians() {
        return veterinarians;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public Veterinarian findVeterinarianByName(String name) {

        for (Veterinarian v : veterinarians) {
            if (v.getName().equalsIgnoreCase(name)) {
                return v;

            }
        }
        return null;

    }
    public Appointment findAppointmentByPet(String petName) {

    for (Appointment a : appointments) {
        if (a.getPet().getName().equalsIgnoreCase(petName)) {
            return a;

        }

    }

    return null;

}
public boolean removeOwner(String id) {

    Owner owner = findOwnerById(id);

    if (owner != null) {

        owners.remove(owner);

        return true;

    }

    return false;

}

public boolean removePet(String name) {

    Pet pet = findPetByName(name);

    if (pet != null) {

        pets.remove(pet);

        return true;

    }

    return false;

}

public boolean removeVeterinarian(String name) {

    Veterinarian vet = findVeterinarianByName(name);

    if (vet != null) {

        veterinarians.remove(vet);

        return true;

    }

    return false;

}

public boolean removeAppointment(String petName) {

    Appointment appointment = findAppointmentByPet(petName);

    if (appointment != null) {

        appointments.remove(appointment);

        return true;

    }

    return false;

}

    @Override
    public String toString() {
        return getInfo();
    }
}
