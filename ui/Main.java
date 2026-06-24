package ui;
import domain.*;
import data.Persistence;

public class Main {

    public static void main(String[] args) {
        Console.writeLine("program started");
        VeterinaryClinic clinic = Persistence.loadClinic();
        String option;

        do {

            Console.writeLine("Clinica Veterinaria");
            Console.writeLine("1. Registrar dueño");
            Console.writeLine("2. Buscar dueño");
            Console.writeLine("3. Registar mascota");
            Console.writeLine("4. Buscar Mascota");
            Console.writeLine("5. Mostrar informacón de la clinica");
            Console.writeLine("6. Registrar Veterinario");
            Console.writeLine("7. Programar Cita");
            Console.writeLine("8. Registrar tratamiento");
            Console.writeLine("9. Buscar Veterinario");
            Console.writeLine("10. Mostar Mascotas");
            Console.writeLine("11. Mostrar dueños");
            Console.writeLine("12 Guardar datos");
            Console.writeLine("13 Cargar datos");
            Console.writeLine("14. Eliminar dueño");
            Console.writeLine("15. Eliminar mascota");
            Console.writeLine("16. Eliminar veterinario");
            Console.writeLine("17. Eliminar cita");
            Console.writeLine("0. Salir");

            option = Console.readLine("Opción: ");

            switch (option) {

                case "1":
                    registerOwner(clinic);
                    break;

                case "2":
                    searchOwner(clinic);
                    break;

                case "3":
                    registerPet(clinic);
                    break;

                case "4":
                    searchPet(clinic);
                    break;

                case "5":
                    Console.writeLine(clinic.toString());
                    break;

                case "6":
                    registerVeterinarian(clinic);
                    break;

                case "7":
                    scheduleAppointment(clinic);
                    break;

                case "8":
                    registerTreatment(clinic);
                    break;

                case "9":
                    searchVeterinarian(clinic);
                    break;

                case "10":
                    showPets(clinic);
                    break;

                case "11":
                    showOwners(clinic);
                    break;

                case "12":
                    Persistence.saveClinicInfo(clinic);
                    break;

                case "13":
                    clinic = Persistence.loadClinic();
                    break;
                case "14":
                    deleteOwner(clinic);
                    break;

                case "15":
                    deletePet(clinic);
                    break;
                case "16":
                    deleteVeterinarian(clinic);
                    break;

                case "17":
                    deleteAppointment(clinic);
                    break;

                case "0":

                    Console.writeLine("Hasta luego!");

                    break;

                default:

                    Console.writeLine("Opción inválida");

            }

        } while (!option.equals("0"));

    }

    private static void registerOwner(VeterinaryClinic clinic) {

        String name = Console.readLine("Nombre: ");

        String id = Console.readLine("ID: ");

        String phone = Console.readLine("Número: ");

        String address = Console.readLine("Dirección: ");

        Owner owner = new Owner(name, id, phone, address);

        clinic.registerOwner(owner);

        Console.writeLine("El dueño se registró con éxito");

    }

    private static void searchOwner(VeterinaryClinic clinic) {

        String id = Console.readLine("ID dueño: ");

        Owner owner = clinic.findOwnerById(id);

        if (owner != null) {

            Console.writeLine(owner.getInfo());

        } else {

            Console.writeLine("Dueño no encontrado");

        }

    }

    private static void registerPet(VeterinaryClinic clinic) {

        String ownerId = Console.readLine("ID dueño: ");

        Owner owner = clinic.findOwnerById(ownerId);

        if (owner == null) {

            Console.writeLine("Dueño no encontrado");

            return;

        }

        String name = Console.readLine("Nombre de la mascota: ");
        int age = Integer.parseInt(Console.readLine("Edad: "));
        String specie = Console.readLine("Especie: ");

        String weight = Console.readLine("Peso: ");

        String color = Console.readLine("Color: ");

        Pet pet = new Pet(name, age, specie, weight, color);
        owner.addPet(pet);

        clinic.registerPet(pet);

        Console.writeLine("Mascota registrada con éxito");

    }

    private static void searchPet(VeterinaryClinic clinic) {

        String name = Console.readLine("Nombre de la mascota: ");
        Pet pet = clinic.findPetByName(name);

        if (pet != null) {
            Console.writeLine(pet.getInfo());

        } else {
            Console.writeLine("Mascota no encontrada");

        }

    }

    private static void registerVeterinarian(VeterinaryClinic clinic) {

        String name = Console.readLine("Nombre; ");
        String specialty = Console.readLine("Especialidad: ");
        String phone = Console.readLine("Número: ");
        Veterinarian vet = new Veterinarian(name, specialty, phone);
        clinic.registerVeterinarian(vet);

        Console.writeLine("Veterinario Registrado");
    }

    private static void scheduleAppointment(VeterinaryClinic clinic) {

        String petName = Console.readLine("Nombre de la mascota: ");
        Pet pet = clinic.findPetByName(petName);

        if (pet == null) {
            Console.writeLine("Mascota no encontrada");
            return;
        }

        String vetName = Console.readLine("Nombre del veterinario: ");

        Veterinarian vet = clinic.findVeterinarianByName(vetName);

        if (vet == null) {
            Console.writeLine("Veterinario no encontrada");
            return;
        }

        String id = Console.readLine("Código de cita: ");
        String date = Console.readLine("Fecha: ");
        String hour = Console.readLine("Hora: ");
        String reason = Console.readLine("Razón: ");
        Appointment appointment = new Appointment(id, date, hour, pet, vet, reason);

        clinic.scheduleAppointment(appointment);

        Console.writeLine("Cita programada");
    }

    private static void registerTreatment(VeterinaryClinic clinic) {

        String petName = Console.readLine("Nombre de la mascota: ");

        Appointment appointment = clinic.findAppointmentByPet(petName);

        if (appointment == null) {
            Console.writeLine("Cita no encontrada");
            return;
        }

        String description = Console.readLine("DEscripción del tratamiento: ");

        String medication = Console.readLine("Medicamento: ");

        double dosage = Double.parseDouble(
                Console.readLine("Dosis: "));

        String date = Console.readLine("Fecha tratamiento:");

        Treatment treatment = new Treatment(description, medication, dosage, date);

        appointment.addTreatment(treatment);

        Console.writeLine("Tratamiento agregado");

    }

    private static void searchVeterinarian(VeterinaryClinic clinic) {

        String name = Console.readLine("Nombre del veterinario: ");

        Veterinarian vet = clinic.findVeterinarianByName(name);

        if (vet != null) {
            Console.writeLine(
                    vet.getInfo());

        } else {

            Console.writeLine(
                    "Veterinario no encontrado");
        }
    }

    private static void showPets(VeterinaryClinic clinic) {

        for (Pet pet : clinic.getPets()) {

            Console.writeLine(pet.getInfo());

        }
    }

    private static void showOwners(VeterinaryClinic clinic) {

        for (Owner owner : clinic.getOwners()) {

            Console.writeLine(owner.getInfo());

        }
    }

    private static void deleteOwner(VeterinaryClinic clinic) {

        String id = Console.readLine("ID del dueño: ");

        if (clinic.removeOwner(id)) {

            Console.writeLine("Dueño eliminado");

        } else {

            Console.writeLine("Dueño no encontrado");
        }
    }

    private static void deletePet(VeterinaryClinic clinic) {
        String name = Console.readLine("Nombre de la mascota:");
        if (clinic.removePet(name)) {
            Console.writeLine("Mascota eliminada");
        } else {
            Console.writeLine("Mascota no encontrada");
        }
    }
     private static void deleteVeterinarian(VeterinaryClinic clinic) {
        String name = Console.readLine("Nombre del veterinario:");
        if (clinic.removeVeterinarian(name)) {
            Console.writeLine("Veterinario eliminado");
        } else {
            Console.writeLine("Veterinario no encontrado");
        }
    }
    private static void deleteAppointment(VeterinaryClinic clinic){
        String petName= Console.readLine("Mascota que tenia la cita:");
        if(clinic.removeAppointment(petName)){
            Console.writeLine("Cita eliminada");
        } else{
            Console.writeLine("Cita no encontrada");
        }

    }
}