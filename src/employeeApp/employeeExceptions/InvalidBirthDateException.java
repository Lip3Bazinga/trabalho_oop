package employeeApp.employeeExceptions;

public class InvalidBirthDateException extends Exception{
    public InvalidBirthDateException(String birthDate) {
        super();
        System.out.println("Data de nascimento " + birthDate + " invalida.");
    }
}
