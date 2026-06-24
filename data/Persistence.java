
package data;
import domain.VeterinaryClinic;
import java.io.*;

public class Persistence {

    private static final String FILE_NAME = "clinic.data";

    public static void saveClinicInfo(VeterinaryClinic clinic) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(FILE_NAME));
            out.writeObject(clinic);
            out.close();
            System.out.println("Datos guardados con éxito");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos " + e.getMessage());
        }
    } 
    public static VeterinaryClinic loadClinic() {
        try {
            ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(FILE_NAME));
            VeterinaryClinic clinic = (VeterinaryClinic) in.readObject();
            in.close();
            System.out.println("Datos Cargados con éxito");
            return clinic;
        } catch (Exception e) {
            System.out.println("No se encontraron datos guardados");
            return new VeterinaryClinic("Veterinary Clinic");
        }
    }
}