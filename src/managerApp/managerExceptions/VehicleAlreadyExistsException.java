package managerApp.managerExceptions;

public class VehicleAlreadyExistsException extends Exception {
    public VehicleAlreadyExistsException(String plate) {
        super("O veiculo " + plate + " ja existe no sistema.");
    }
}
