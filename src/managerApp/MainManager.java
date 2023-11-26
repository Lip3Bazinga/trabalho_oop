package managerApp;

import java.util.ArrayList;
import java.util.Scanner;

import managerApp.managerModel.ModelOperationalParameters;
import managerApp.managerModel.ModelVehicleRegister;
import managerApp.managerController.vehicles.VehicleRegisterController;
import managerApp.managerExceptions.VehicleAlreadyExistsException;
import managerApp.managerExceptions.WithoutPermissionException;

public class MainManager {
    public static void main(String args[]) {

        ModelOperationalParameters mop = new ModelOperationalParameters();
        Scanner sc = new Scanner(System.in);
        double d;

        try {
            System.out.println(mop.getExternalCleaningPrice("Basico"));
            sc.nextLine();
            System.out.println(mop.getDailyValue("Padrao"));
            sc.nextLine();
            d = sc.nextDouble();
            mop.setExternalCleaningPrice("Premium", d);
            System.out.println("PASSEI");
            System.out.println(mop.getExternalCleaningPrice("Premium"));
        } catch(WithoutPermissionException e) {
            System.err.println("ERRO");
        }

        ModelVehicleRegister mvr = new ModelVehicleRegister();
        ArrayList <VehicleRegisterController> vehiclesArray = new ArrayList<VehicleRegisterController>();

        try {
            try {
                mvr.addVehicle("AAAAAAA", "Fiat", "Argo", "Prata", 2020, "Basico", vehiclesArray);
            } catch (VehicleAlreadyExistsException e) {
                e.printStackTrace();
            }
        } catch(WithoutPermissionException e) {
            System.err.println("ERRO");
        } finally {
            sc.close();
        }

        
    }
}
