package managerApp.managerExceptions;

public class VehicleAlreadyExistsException extends Exception {
    
    private String plate;

    public VehicleAlreadyExistsException(String plate) {
        this.plate = plate;
    }

    public String toString() {
        return "Placa " + plate + " ja encontrada no sistema.";
    }
}
