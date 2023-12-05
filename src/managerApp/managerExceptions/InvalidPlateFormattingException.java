package managerApp.managerExceptions;

/**
Classe para exceção de formatação da placa invalida (mostrar formatação correta). Cadastrar novo veículo e excluir veículo existente 
*/
public class InvalidPlateFormattingException extends Exception {
    public InvalidPlateFormattingException(String plate) {
        super("Formatacao da placa " + plate + " invalida. Formatacao correta: LLLNLNN.");
    }  
}