package employeeApp.employeeExceptions;

public class ClientAlreadyExistsException extends Excepion {

  private int cpf;

  public ClientAlreadyExistsException(int cpf){
    this.cpf = cpf;
  }

  public String toString(){
    return "CPF "+ cpf + " ja existente no sistema.";
  }
  
}
