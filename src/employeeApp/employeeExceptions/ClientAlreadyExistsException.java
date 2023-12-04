package employeeApp.employeeExceptions;

public class ClientAlreadyExistsException extends Exception {
  public ClientAlreadyExistsException(int cpf) {
    super();
    System.out.println("CPF " + cpf + " ja existente no sistema.");
  }
}

