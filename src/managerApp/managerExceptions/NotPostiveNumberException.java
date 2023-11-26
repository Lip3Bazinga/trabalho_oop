package managerApp.managerExceptions;

/**
Classe para exceção de completou com valor negativo ou zero (informar que completou com valor negativo ou zero em tal parâmetro de tal grupo). Alterar parâmetros operacionais 
*/
public class NotPostiveNumberException extends Exception {
    public NotPostiveNumberException(String parameter, String group, double value) {
        super();
        System.out.println("O valor " + value + " para o parametro " + parameter + " do grupo " + group + " nao pode ser um valor negativo ou zero.");
    }
    
}