package managerApp.managerController.clients;

public class ClientRegisterController {
    
    private int cpf;
    private String name;
    private String birthDate;
    private String email;
    private String phoneNumber;

    public ClientRegisterController(int cpf, String name, String birthDate, String email, String phoneNumber) {
    
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

    public String toString() {
        return "";
    }
}
