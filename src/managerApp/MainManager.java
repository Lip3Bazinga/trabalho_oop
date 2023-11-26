package managerApp;

import java.util.ArrayList;
import javax.swing.SwingUtilities;

import managerApp.managerController.vehicles.VehicleRegisterController;
import managerApp.managerExceptions.NotPostiveNumberException;
import managerApp.managerView.Screen;
// import managerApp.managerExceptions.WithoutPermissionException;

public class MainManager {
    public static void main(String args[]) throws NotPostiveNumberException {

        SwingUtilities.invokeLater(Screen::new);

        // ModelOperationalParameters mop = new ModelOperationalParameters();
        // Scanner sc = new Scanner(System.in);
        // double d;

        // try {
        //     System.out.println(mop.getExternalCleaningPrice("Basico"));
        //     sc.nextLine();
        //     System.out.println(mop.getDailyValue("Padrao"));
        //     sc.nextLine();
        //     d = sc.nextDouble();
        //     mop.setExternalCleaningPrice("Premium", d);
        //     System.out.println("PASSEI");
        //     System.out.println(mop.getExternalCleaningPrice("Premium"));
        // } catch(WithoutPermissionException e) {
        //     System.err.println("ERRO");
        // } finally {
        //     sc.close();
        // }
        
    }

    public static ArrayList<VehicleRegisterController> getVehiclesArray(){

        ArrayList<VehicleRegisterController> vehiclesArray = new ArrayList<>();

        vehiclesArray.add(new VehicleRegisterController("ABC11234", "Mustang", "Shelby GT500", "Black", 2023, "Premium", "Alugado"));
        vehiclesArray.add(new VehicleRegisterController("XYZ56789", "Ferrari", "488 GTB", "Red", 2023, "Luxury", "Disponível"));
        vehiclesArray.add(new VehicleRegisterController("DEF45678", "Chevrolet", "Camaro", "Yellow", 2023, "Sport", "Em Manutenção"));
    
        return vehiclesArray;

    }

}
