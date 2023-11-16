package employeeApp.employeeExceptions;

public class ClientAlreadyExistsException extends Excepion {

  private String plate;

  public ClientAlreadyExistsException(int cpf){
    this.cpf = cpf;
  }

  public String toString(){
    return "CPF "+ cpf + " ja existente no sistema.";
  }
  
}
