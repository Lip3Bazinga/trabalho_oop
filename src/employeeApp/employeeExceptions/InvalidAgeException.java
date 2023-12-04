package employeeApp.employeeExceptions;

public class InvalidAgeException extends Exception{
    public InvalidAgeException(String birthDate) {
        super("O cliente nascido na data " + birthDate + " tem menos de 18 anos.");
    }
}
