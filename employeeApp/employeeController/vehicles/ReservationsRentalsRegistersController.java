package employeeApp.employeeController.vehicles;

public class ReservationsRentalsRegistersController {
    
    private long identifier;
    private int cpf;
    private String plate;
    private String pickupDate;
    private String returnDate;
    private double rentalValue;
    private String status;

    public ReservationsRentalsRegistersController(long identifier, int cpf, String plate, String pickupDate, String returnDate, double rentalValue, String status) {
      
        this.identifier = identifier;
        this.cpf = cpf;
        this.plate = plate;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.rentalValue = rentalValue;
        this.status = status;
    }

    public long getIdentifier() {
        return identifier;
    }

    public int getCpf() {
        return cpf;
    }

    public String getPlate() {
        return plate;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public double getRentalValue() {
        return rentalValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
