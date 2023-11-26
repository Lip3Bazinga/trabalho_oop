package managerApp.managerController.vehicles;

import java.util.ArrayList;

import managerApp.managerExceptions.InvalidPlateFormattingException;
import managerApp.managerExceptions.InvalidPlateSizeException;
import managerApp.managerExceptions.InvalidYearException;
import managerApp.managerExceptions.LeasedVehicleException;
import managerApp.managerExceptions.VehicleAlreadyExistsException;
import managerApp.managerExceptions.VehicleDoesNotExistException;
import managerApp.managerExceptions.WithoutPermissionException;
import managerApp.managerModel.ModelVehicleRegister;

/**
Classe que registra veículos
*/
public class VehicleRegisterController {
   
    // Atributos
    private String plate;
    private String brand;
    private String model;
    private String color;
    private int year;
    private String group;
    private String status;

    // Construtor
    public VehicleRegisterController(String plate, String brand, String model, String color, int year, String group, String status) {

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

    /**
     * Metodo que após validar o tamanho da placa, a formatacao da placa e o ano do veiculo, adiciona um veiculo ao sistema 
     * @param plate Placa do veiculo
     * @param brand Marca do veiculo
     * @param model Modelo do veiculo
     * @param color Cor do veiculo
     * @param year Ano do veiculo
     * @param group Grupo do veiculo
     * @param vehicleArray Local onde estao sendo armazenados as instancias dos veiculos
     * @throws InvalidPlateSizeException Tamanho da placa invalido
     * @throws InvalidPlateFormattingException Formatacao da placa invalido
     * @throws InvalidYearException Ano invalido
     * @throws VehicleAlreadyExistsException Veiculo ja existe no sistema
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void addVehicle(String plate, String brand, String model, String color, int year, String group, ArrayList<VehicleRegisterController> vehicleArray) throws InvalidPlateSizeException, InvalidPlateFormattingException, InvalidYearException, VehicleAlreadyExistsException, WithoutPermissionException {
        try {
            validatePlateSize(plate);
            validatePlateFormatting(plate);
            validateYear(year);

            ModelVehicleRegister modelVehicleRegister = new ModelVehicleRegister();
            modelVehicleRegister.addVehicle(plate, brand, model, color, year, group, vehicleArray); 
        } catch(InvalidPlateSizeException ipse) {
           throw ipse;
        } catch(InvalidPlateFormattingException ipfe) {
            throw ipfe;
        } catch(InvalidYearException iye) {
            throw iye;
        } catch(VehicleAlreadyExistsException vaee) {
            throw vaee;
        } catch(WithoutPermissionException wpe) {
            throw wpe;
        }
    }

    /**
     * Valida se o tamanho da placa esta correto
     * Metodo auxiliar para os metodos addVehicle e removeVehicle
     * @param plate Placa do veiculo
     * @throws InvalidPlateSizeException Tamanho da placa invalido
     */
    private void validatePlateSize(String plate) throws InvalidPlateSizeException {
        if(plate.length() != 7) {
            throw new InvalidPlateSizeException(plate);
        }
    }

    /**
     * Valida se a formatacao da placa esta correta
     * Metodo auxiliar para os metodos addVehicle e removeVehicle
     * @param plate Placa do veiculo
     * @throws InvalidPlateFormattingException Formatacao da placa invalido
     */
    private void validatePlateFormatting(String plate) throws InvalidPlateFormattingException {
        if(!plate.matches("[A-Za-z]{3}[0-9][A-Za-z][0-9]{2}")) {
            throw new InvalidPlateFormattingException(plate);
        // LLL N L NN
        // 123 4 5 67
        }
    }

    /**
     * Valida se o ano do veiculo esta correto
     * Metodo auxiliar para o metodo addVehicle
     * @param year Ano do veiculo
     * @throws InvalidYearException Ano invalido
     */
    private void validateYear(int year) throws InvalidYearException {
        if(year < 1886 || year > 2023) {
            throw new InvalidYearException(year);
        }
    }

    /**
     * Metodo que após validar o tamanho da placa, a formatacao da placa, o status do veiculo e a existencia do veiculo, altera o status do veiculo
     * @param reason Motivo da exclusao do veiculo
     * @param plate Placa do veiculo a ser excluido
     * @param vehicleArray Local onde estao sendo armazenados as instancias dos veiculos
     * @throws LeasedVehicleException Veiculo esta alugado
     * @throws InvalidPlateSizeException Tamanho da placa invalido
     * @throws InvalidPlateFormattingException Formatacao da placa invalido
     * @throws VehicleDoesNotExistException Veiculo nao existe no sistema
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void removeVehicle(String reason, String plate, ArrayList<VehicleRegisterController> vehicleArray) throws InvalidPlateSizeException, InvalidPlateFormattingException, LeasedVehicleException, VehicleDoesNotExistException, WithoutPermissionException {
        try {

            validatePlateSize(plate);
            validatePlateFormatting(plate);
            validateVehicleStatus(plate, vehicleArray);

            ModelVehicleRegister modelVehicleRegister = new ModelVehicleRegister();
            modelVehicleRegister.removeVehicle(reason, plate, vehicleArray);
        } catch(InvalidPlateSizeException ipse) {
            throw ipse;
        } catch(InvalidPlateFormattingException ipfe) {
            throw ipfe; 
        } catch(LeasedVehicleException lve) {
            throw lve; 
        } catch(VehicleDoesNotExistException vndee) {
            throw vndee;
        } catch(WithoutPermissionException wpe) {
            throw wpe;
        }
    }

/**
     * Valida se o veiculo esta alugado
     * Metodo auxiliar para o metodo removeVehicle
     * @param plate Placa do veiculo
     * @param vehicleArray Local onde estao sendo armazenados as instancias dos veiculos
     * @throws LeasedVehicleException Veiculo esta alugado
     */
   private void validateVehicleStatus(String plate, ArrayList<VehicleRegisterController> vehicleArray) throws LeasedVehicleException {
        for(VehicleRegisterController vehicle : vehicleArray) {            
            if(vehicle.getPlate().equals(plate)) {
                // String status = vehicle.getStatus().toLowerCase();
                if(vehicle.getStatus().equals("alugado")) {
                    throw new LeasedVehicleException(vehicle.getPlate());
                }
            }
        }
    }
    
    /**
     * Metodo que inicializa os veiculos no ArrayList
     * @return ArrayList com os veiculos cadastrados
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public ArrayList<VehicleRegisterController> initializeVehicles() throws WithoutPermissionException {
        try {
            ModelVehicleRegister modelVehicleRegister = new ModelVehicleRegister();
            return modelVehicleRegister.initializeVehicles();
        } catch(WithoutPermissionException wpe) {
            throw wpe;
        }
    }

    /**
     * Metodo que encontra a posicao do veiculo no ArrayList onde eles estao armazenados
     * @param plate Placa do veiculo a ser encontrado
     * @param vehiclesArray Local onde estao sendo armazenados os veiculos
     * @return Posicao do veiculo em "vehiclesArray"
     * @throws VehicleDoesNotExistException Veiculo nao existe em "vehiclesArray"
     */
    public int getPositionVehicleInArrayByPlate(String plate, ArrayList<VehicleRegisterController> vehiclesArray) throws VehicleDoesNotExistException {
        for(int i = 0; i < vehiclesArray.size(); i++) {
            if(vehiclesArray.get(i).getPlate().equals(plate)) {
                return i;
            }
        }
        throw new VehicleDoesNotExistException(plate);
    }

    /**
     * Verifica a existencia de um veiculo em um ArrayList
     * @param plate Placa do veiculo
     * @param vehiclesArray ArrayList onde o veiculo sera buscado
     * @return "true" se o veiculo existe no ArrayList, ou "false" caso contrario
     */
    public static boolean verifyVehicleExistence(String plate, ArrayList<VehicleRegisterController> vehiclesArray) {
        
        for(int i = 0; i < vehiclesArray.size(); i++) {
            if(vehiclesArray.get(i).getPlate().equals(plate)) {
                return true;
            }
        }
        return false;
    }
}
