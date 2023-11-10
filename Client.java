public class Client {
    
    private int cpf;
    private String name;
    private String bornDate;
    private String email;
    private String phone;

    public Client(int cpf, String name, String bornDate, String email, String phone) {
        this.cpf = cpf;
        this.name = name;
        this.bornDate = bornDate;
        this.email = email;
        this.phone = phone;
    }

    public int getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getbornDate() {
        return bornDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
