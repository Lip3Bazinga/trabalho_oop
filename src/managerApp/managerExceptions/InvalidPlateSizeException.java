package managerApp.managerExceptions;

/**
Classe para exceção de tamanho da placa invalida (mostrar formatação correta). Cadastrar novo veículo e excluir veículo existente 
*/
public class InvalidPlateSizeException extends Exception {
    public InvalidPlateSizeException(String plate) {
        super();
        System.out.println("Tamanho da placa " + plate + " invalida. Formatacao correta: LLLNLNN.");
    }
    
}