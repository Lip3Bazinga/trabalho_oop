package employeeApp.employeeExceptions;

public class WithoutPermissionException extends Exception {
    public String toString() {
        return "Nao ha permissao para abrir ou criar o arquivo .txt necessario";
    }
}
