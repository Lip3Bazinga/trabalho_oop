package managerApp.managerController.vehicles;

public class Vehicle {
  
    // Atributos
    private String plate;
    private String brand;
    private String model;
    private String color;
    private int year;
    private String group;
    private String status;

    // Construtor
    public Vehicle(String plate, String brand, String model, String color, int year, String group, String status) {

        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.group = group;
        this.status = status;
    }

    /**
     * Metodo que obtem a placa do veiculo
     * @return Placa do veiculo
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Metodo que obtem a marca do veiculo
     * @return Marca do veiculo
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Metodo que obtem o modelo do veiculo
     * @return Modelo do veiculo
     */
    public String getModel() {
        return model;
    }

    /**
     * Metodo que obtem a cor do veiculo
     * @return Cor do veiculo
     */
    public String getColor() {
        return color;
    }

    /**
     * Metodo que obtem o ano do veiculo
     * @return Ano do veiculo
     */
    public int getYear() {
        return year;
    }

    /**
     * Metodo que obtem o grupo do veiculo
     * @return Grupo do veiculo
     */
    public String getGroup() {
        return group;
    }

    /**
     * Metodo que obtem o status do veiculo
     * @return Status do veiculo
     */
    public String getStatus() {
        return status;
    }

    /**
     * Metodo que altera o status do veiculo
     * @param status Novo status do veiculo
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return plate + '\t' + brand + '\t' + model + '\t' + color + '\t' + year + '\t' + group + '\t' + status;
    }
}
