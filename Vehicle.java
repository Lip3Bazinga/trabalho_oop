public class Vehicle {

    private String plate;
    private String brand;
    private String model;
    private String color;
    private int year;
    private String group;
    private String status;
    private static int numberVehicles = 0;

    public Vehicle(String plate, String brand, String model, String color, int year, String group, String status) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.group = group;
        this.status = status;
        numberVehicles++;
    }

    public String getPlate() {
        return plate;
    }

    public String getbrand() {
        return brand;
    }

    public String getmodel() {
        return model;
    }

    public String getcolor() {
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

    protected void setStatus(String status) {
        this.status = status;
    }

    protected int getNumberVehicles() {
        return numberVehicles;
    }
}
