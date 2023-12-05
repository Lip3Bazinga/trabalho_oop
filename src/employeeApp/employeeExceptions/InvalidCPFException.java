package employeeApp.employeeExceptions;

public class InvalidCPFException extends Exception{
    public InvalidCPFException(int cpf) {
        super("CPF " + cpf + " invalido.");
    }
}
