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
    public void addVehicle(String plate, String brand, String model, String color, int year, String group, ArrayList<Vehicle> vehicleArray) throws InvalidPlateSizeException, InvalidPlateFormattingException, InvalidYearException, VehicleAlreadyExistsException, WithoutPermissionException {
     
        if(verifyVehicleExistence(plate, vehicleArray)) {
            throw new VehicleAlreadyExistsException(plate);
        }
        
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
    public void validatePlateFormatting(String plate) throws InvalidPlateFormattingException {
        if(!plate.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}")) {
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
        if(year < 1886 || year > 2024) {
            throw new InvalidYearException(year);
        }
    }

    /**
     * Metodo que após validar o tamanho da placa, a formatacao da placa, o status do veiculo e a existencia do veiculo, altera o status do veiculo
     * @param reason Motivo da exclusao do veiculo
     * @param plate Placa do veiculo a ser excluido
     * @param vehicleArray Local onde estao sendo armazenados as instancias dos veiculos
     * @throws LeasedVehicleException Veiculo esta alugado
     * @throws VehicleDoesNotExistException Veiculo nao existe no sistema
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void removeVehicle(String reason, String plate, ArrayList<Vehicle> vehicleArray) throws LeasedVehicleException, VehicleDoesNotExistException, WithoutPermissionException {
        try {

            if(!verifyVehicleExistence(plate, vehicleArray)) {
                throw new VehicleDoesNotExistException(plate);
            }
            validateVehicleStatus(plate, vehicleArray);
            int positionInArray = getPositionVehicleInArrayByPlate(plate, vehicleArray);

            ModelVehicleRegister modelVehicleRegister = new ModelVehicleRegister();
            modelVehicleRegister.removeVehicle(reason, plate, vehicleArray, positionInArray);
        } catch(LeasedVehicleException lve) {
            throw lve;
        } catch(WithoutPermissionException wpe) {
            throw wpe;
        }
    }

/**
     * Valida se o veiculo esta alugado ou indisponivel
     * Metodo auxiliar para o metodo removeVehicle
     * @param plate Placa do veiculo
     * @param vehicleArray Local onde estao sendo armazenados as instancias dos veiculos
     * @throws LeasedVehicleException Veiculo esta alugado
     */
   private void validateVehicleStatus(String plate, ArrayList<Vehicle> vehicleArray) throws LeasedVehicleException {
        for(Vehicle vehicle : vehicleArray) {            
            if(vehicle.getPlate().equals(plate)) {
                // String status = vehicle.getStatus().toLowerCase();
                if(!vehicle.getStatus().equals("disponivel")) {
                    throw new LeasedVehicleException(vehicle.getPlate(), vehicle.getStatus());
                } else {
                    return;
                }
            }
        }
    }
    
    /**
     * Metodo que inicializa os veiculos no ArrayList
     * @return ArrayList com os veiculos cadastrados
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public ArrayList<Vehicle> initializeVehicles() throws WithoutPermissionException {
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
    public static int getPositionVehicleInArrayByPlate(String plate, ArrayList<Vehicle> vehiclesArray) throws VehicleDoesNotExistException {
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
    public static boolean verifyVehicleExistence(String plate, ArrayList<Vehicle> vehiclesArray) {
        
        for(int i = 0; i < vehiclesArray.size(); i++) {
            if(vehiclesArray.get(i).getPlate().equals(plate)) {
                return true;
            }
        }
        return false;
    }
}
