package employeeApp.employeeController.clients;

public class Client {

    // Atributos
    private int cpf;
    private String name;
    private String birthDate;
    private String email;
    private String phoneNumber;

    // Construtor
    public Client(int cpf, String name, String birthDate, String email, String phoneNumber) {
    
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Metodo que obtem o cpf do cliente
     * @return CPF do cliente
     */
    public int getCpf() {
        return cpf;
    }

    /**
     * Metodo que obtem o nome do cliente
     * @return Nome do cliente
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que obtem a data de nascimento do cliente
     * @return Data de nascimento do cliente
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Metodo que obtem o email do cliente
     * @return Email do cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo que obtem o numero de telefone do cliente
     * @return Numero de telefone do cliente
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
