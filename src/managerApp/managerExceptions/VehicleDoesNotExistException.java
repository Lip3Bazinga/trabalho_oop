package managerApp.managerExceptions;

public class VehicleDoesNotExistException extends Exception {
    public VehicleDoesNotExistException(String plate) {
        super();
        System.out.println("O veiculo " + plate + " nao existe no sistema.");
    }
}
