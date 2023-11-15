package managerApp.managerView;

import managerApp.managerModel.*;

import java.io.IOException;
import java.util.ArrayList;
import managerApp.managerController.vehicles.VehicleRegisterController;
import java.util.Scanner;
import managerApp.managerExceptions.*;
public class MainManager {
    public static void main(String args[]) {

        ModelVehicleRegister mvr = new ModelVehicleRegister();
        ArrayList<VehicleRegisterController> vehiclesArray = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try {
            mvr.addVehicle("ABC1234", "Fiat", "Argo", "Preto", 2013, "Basico", vehiclesArray);
            sc.nextLine();
            mvr.addVehicle("ANE3052", "Toyota", "Corolla", "Branco", 2019, "Premium", vehiclesArray);
            sc.nextLine();
            mvr.removeVehicle("furto", "ABC1234", vehiclesArray);
            sc.close();
        } catch(IOException e) {
            System.err.println("Erro");
        } catch(VehicleDoesNotExistException e) {
            System.err.println("Erro");
        } catch(VehicleAlreadyExistsException e) {
            System.err.println("Erro");
        }

    }
}
