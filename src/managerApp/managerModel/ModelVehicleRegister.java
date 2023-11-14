package managerApp.managerModel;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Paths;

import employeeApp.employeeController.vehicles.VehicleRegisterController;

public class ModelVehicleRegister {

    String pathVehicleRegister = Paths.get(System.getProperty("user.dir"), "database", "vehicleRegister.txt").toString();

    public boolean addVehicle() {
        
        //Manipular txt para add veiculo
        //Add no array o veiculo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathVehicleRegister))) {
            // Escrever no arquivo
            writer.write("Seu conteúdo aqui");
            System.out.println("Conteúdo foi escrito no arquivo com sucesso.");
            System.out.println(pathVehicleRegister);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean removeVehicle(String reason, int numberVehicle, ArrayList<VehicleRegisterController> arrayVehicles) {

        //Muda status do veiculo no txt
        //Muda status do veiculo no Array
        return true;
    }

    public String reportVehicles() {
        return "";
    }

    public int getPositionVehicleInArrayByPlate(String plate, ArrayList<VehicleRegisterController> arrayVehicles) {
        return -1;
    }

    public boolean getVehicle(String plate) {
        return true;
    }
}
