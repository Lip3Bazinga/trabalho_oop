package employeeApp.employeeController.clients;

public class Client {

    private int cpf;
    private String name;
    private String birthDate;
    private String email;
    private String phoneNumber;

    public Client(int cpf, String name, String birthDate, String email, String phoneNumber) {
    
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
