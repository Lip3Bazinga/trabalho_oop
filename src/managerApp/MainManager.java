package managerApp;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import managerApp.managerController.vehicles.Vehicle;
import managerApp.managerExceptions.InvalidPlateFormattingException;
import managerApp.managerExceptions.InvalidPlateSizeException;
import managerApp.managerExceptions.InvalidYearException;
import managerApp.managerExceptions.NotPostiveNumberException;
import managerApp.managerExceptions.VehicleAlreadyExistsException;
import managerApp.managerExceptions.WithoutPermissionException;
import managerApp.managerModel.ModelVehicleRegister;
import managerApp.managerView.Screen;

public class MainManager {

    private static ArrayList<Vehicle> vehicleArray = new ArrayList<>();
    public static void main(String args[]) throws NotPostiveNumberException, WithoutPermissionException, VehicleAlreadyExistsException, InvalidYearException, InvalidPlateFormattingException, InvalidPlateSizeException {

        ModelVehicleRegister mvr = new ModelVehicleRegister();
        vehicleArray = mvr.initializeVehicles();

        SwingUtilities.invokeLater(Screen::new);
    }

    public static ArrayList<Vehicle> getVehicleArray() {
        return vehicleArray;
    }
}
