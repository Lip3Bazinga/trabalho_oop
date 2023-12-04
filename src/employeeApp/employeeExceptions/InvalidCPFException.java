package employeeApp.employeeExceptions;

public class InvalidCPFException extends Exception{
    public InvalidCPFException(int cpf) {
        super();
        System.out.println("CPF " + cpf + " invalido.");
    }
}
