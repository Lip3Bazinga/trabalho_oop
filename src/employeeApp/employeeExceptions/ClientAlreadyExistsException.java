package employeeApp.employeeExceptions;

public class ClientAlreadyExistsException extends Exception {
  public ClientAlreadyExistsException(int cpf) {
    super("CPF " + cpf + " ja existente no sistema.");
  }
}

