package managerApp.managerExceptions;

public class VehicleDoesNotExistException extends Exception {
    
    private String plate;

    public VehicleDoesNotExistException(String plate) {
        this.plate = plate;
    }

    public String toString() {
        return "Placa " + plate + " nao encontrada no sistema.";
    }
}
