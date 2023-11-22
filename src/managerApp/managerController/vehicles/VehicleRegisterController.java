package managerApp.managerController.vehicles;

import java.util.ArrayList;

import managerApp.managerExceptions.InvalidPlateFormattingException;
import managerApp.managerExceptions.InvalidPlateSizeException;
import managerApp.managerExceptions.InvalidYearException;
import managerApp.managerExceptions.LeasedVehicleException;
import managerApp.managerExceptions.VehicleAlreadyExistsException;
import managerApp.managerExceptions.VehicleDoesNotExistException;
import managerApp.managerExceptions.WithoutPermissionException;
import managerApp.managerModel.ModelVehicleRegister;

/**
Classe que registra veículos
*/
public class VehicleRegisterController {
   
    // Atributos
    private String plate;
    private String brand;
    private String model;
    private String color;
    private int year;
    private String group;
    private String status;

    // Construtor
    public VehicleRegisterController(String plate, String brand, String model, String color, int year, String group, String status) {

        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.group = group;
        this.status = status;
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getGroup() {
        return group;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addVehicle(String plate, String brand, String model, String color, int year, String group, ArrayList<VehicleRegisterController> vehicleArray) throws InvalidPlateSizeException, InvalidPlateFormattingException, InvalidYearException, VehicleAlreadyExistsException, WithoutPermissionException {
        try {
            validatePlateSize(plate);
            validatePlateFormatting(plate);
            validateYear(year);

            ModelVehicleRegister modelVehicleRegister = new ModelVehicleRegister();
            modelVehicleRegister.addVehicle(plate, brand, model, color, year, group, vehicleArray); 
        } catch(InvalidPlateSizeException ipse) {
            throw ipse;
        } catch(InvalidPlateFormattingException ipfe) {
            throw ipfe;
        } catch(InvalidYearException iye) {
            throw iye;
        } catch(VehicleAlreadyExistsException vaee) {
            throw vaee;
        } catch(WithoutPermissionException wpe) {
            throw wpe;
        }
    }

    private void validatePlateSize(String plate) throws InvalidPlateSizeException {
        if(plate.length() != 7) {
            throw new InvalidPlateSizeException(plate);
        }
    }

    private void validatePlateFormatting(String plate) throws InvalidPlateFormattingException {
        if(!plate.matches("[A-Za-z]{3}[0-9][A-Za-z][0-9]{2}")) {
            throw new InvalidPlateFormattingException(plate);
        // LLL N L NN
        // 123 4 5 67
        }
    }

    private void validateYear(int year) throws InvalidYearException {
        if(year < 1886 || year > 2023) {
            throw new InvalidYearException(year);
        }
    }

    public void removeVehicle(String reason, String plate, ArrayList<VehicleRegisterController> vehicleArray) throws LeasedVehicleException, InvalidPlateSizeException, InvalidPlateFormattingException, VehicleDoesNotExistException, WithoutPermissionException {
        try {

            //  
            validatePlateSize(plate);
            validatePlateFormatting(plate);
            validateVehicleStatus(plate, vehicleArray);

            ModelVehicleRegister modelVehicleRegister = new ModelVehicleRegister();
            modelVehicleRegister.removeVehicle(reason, plate, vehicleArray);
        } catch(InvalidPlateSizeException ipse) {
            throw ipse;
        } catch(InvalidPlateFormattingException ipfe) {
            throw ipfe; 
        } catch(LeasedVehicleException lve) {
            throw lve; 
        } catch(VehicleDoesNotExistException vndee) {
            throw vndee;
        } catch(WithoutPermissionException wpe) {
            throw wpe;
        }
    }


   private void validateVehicleStatus(String plate, ArrayList<VehicleRegisterController> vehicleArray) throws LeasedVehicleException {
        for(VehicleRegisterController vehicle : vehicleArray) {            
            if(vehicle.getPlate().equals(plate)) {
                // String status = vehicle.getStatus().toLowerCase();
                if(vehicle.getStatus().equals("alugado")) {
                    throw new LeasedVehicleException(vehicle.getPlate());
                }
            }
        }
    }
    

    public ArrayList<VehicleRegisterController> initializeVehicles() throws WithoutPermissionException {
        try {
            ModelVehicleRegister modelVehicleRegister = new ModelVehicleRegister();
            return modelVehicleRegister.initializeVehicles();
        } catch(WithoutPermissionException wpe) {
            throw wpe;
        }
    }
}
