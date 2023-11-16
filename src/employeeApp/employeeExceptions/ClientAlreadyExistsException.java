package employeeApp.employeeExceptions;

public class ClientAlreadyExistsException extends Excepion {

  private String plate;

  public ClientAlreadyExistsException(String cpf){
    this.cpf = cpf;
  }

  public String toString(){
    return "CPF " + " já existente no sistema.";
  }
  
}
