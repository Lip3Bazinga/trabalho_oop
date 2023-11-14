package managerApp.managerModel;

import java.io.File;

/* 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
*/

public class ModelVehicleRegister {

    File vehicleRegister = new File("../../database/vehicleRegister.txt");

    public void addVehicle(String plate, String brand, String model, String color, int year, String group) {
        
    }

    public boolean removeVehicle(String reason, String plate) {
        return true;
    }

    public String reportVehicles() {
        return "";
    }

    public boolean getVehicle(String plate) {
        return true;
    }
}
