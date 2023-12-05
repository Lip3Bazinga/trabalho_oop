package managerApp.managerExceptions;

public class VehicleDoesNotExistException extends Exception {
    public VehicleDoesNotExistException(String plate) {
        super("O veiculo " + plate + " nao existe no sistema.");
    }
}
