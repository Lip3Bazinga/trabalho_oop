package managerApp.managerExceptions;

/**
Classe para exceção de ano inválido (informa que ano inválido). Cadastrar novo veículo 
*/
public class InvalidYearException extends Exception {
    public InvalidYearException(int year) {
        super();
        System.out.println("Ano " + year + " invalido.");
    }
    
}