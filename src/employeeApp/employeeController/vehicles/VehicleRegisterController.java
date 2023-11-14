package employeeApp.employeeController.vehicles;

public class VehicleRegisterController {
    
    private String plate;
    private String brand;
    private String model;
    private String color;
    private int year;
    private String group;
    private String status;

    public VehicleRegisterController(String plate, String brand, String model, String color, int year, String group, String status) {

        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.group = group;
        this.status = status;
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getGroup() {
        return group;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
