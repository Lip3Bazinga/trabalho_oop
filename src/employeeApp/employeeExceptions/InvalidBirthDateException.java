package employeeApp.employeeExceptions;

public class InvalidBirthDateException extends Exception{
    public InvalidBirthDateException(String birthDate) {
        super("Data de nascimento " + birthDate + " invalida.");
    }
}
