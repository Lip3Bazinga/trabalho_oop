package managerApp.managerExceptions;

/**
Classe para exceção de placa de veículo locado (informa que veículo está locado e impede a ação de remoção). Excluir veículo existente 
*/
public class LeasedVehicleException extends Exception {
    public LeasedVehicleException(String plate) {
        super();
        System.out.println("O veiculo " + plate + " esta locado.");
    }
    
}