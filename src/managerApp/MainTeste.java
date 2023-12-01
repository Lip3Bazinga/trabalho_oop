package managerApp;

import java.util.ArrayList;
import java.util.Scanner;

import managerApp.managerController.vehicles.Vehicle;
import managerApp.managerController.vehicles.VehicleRegisterController;
import managerApp.managerExceptions.InvalidPlateFormattingException;
import managerApp.managerExceptions.InvalidPlateSizeException;
import managerApp.managerExceptions.InvalidYearException;
import managerApp.managerExceptions.LeasedVehicleException;
import managerApp.managerExceptions.VehicleAlreadyExistsException;
import managerApp.managerExceptions.VehicleDoesNotExistException;
import managerApp.managerExceptions.WithoutPermissionException;
import managerApp.managerModel.ModelVehicleRegister;

/*
 * Classe para executar os testes
 */
public class MainTeste {
    
    public static void main(String args[]) {

        VehicleRegisterController vrc = new VehicleRegisterController();
        ArrayList <Vehicle> vehicleArray = new ArrayList<>();
        try {
            vehicleArray = vrc.initializeVehicles();
            System.out.println(vehicleArray.size());
            for(int i = 0; i < vehicleArray.size(); i++) {
                System.out.println(vehicleArray.get(i).toString());
            }
        } catch (WithoutPermissionException e) {
            System.err.println(e);
        }
        
        try {
            vrc.removeVehicle("roubo/furto", "ABD3D41", vehicleArray);
        } catch (LeasedVehicleException e) {
            System.err.println(e);
        } catch (VehicleDoesNotExistException e) {
            System.err.println(e);
        } catch (WithoutPermissionException e) {
            System.err.println(e);
        }
        
    }
}
