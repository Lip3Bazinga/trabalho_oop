package managerApp.managerExceptions;

/**
Classe para exceção de placa de veículo nao pode ser excluido (informa que veículo está locado e impede a ação de remoção). Excluir veículo existente 
*/
public class LeasedVehicleException extends Exception {
    public LeasedVehicleException(String plate, String status) {
        super("O veiculo " + plate + " esta " + status);
    }
}