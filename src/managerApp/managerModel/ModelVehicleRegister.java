package managerApp.managerModel;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import managerApp.managerExceptions.VehicleAlreadyExistsException;
import managerApp.managerExceptions.VehicleDoesNotExistException;
import managerApp.managerController.vehicles.VehicleRegisterController;

public class ModelVehicleRegister {

    String pathVehicleRegister = Paths.get(System.getProperty("user.dir"), "database", "vehicleRegister.txt").toString();

    /**
     * Metodo que adiciona um veiculo no txt adequado e instancia um novo objeto no array
     * @param plate Placa do veiculo
     * @param brand Marca do veiculo
     * @param model Modelo do veiculo
     * @param color Cor do veiculo
     * @param year Ano do veiculo
     * @param group Grupo do veiculo
     * @param vehiclesArray Local onde estao sendo armazenadas as instancias dos veiculos
     * @throws VehicleAlreadyExistsException Veiculo ja existe no sistema
     * @throws IOException Falha ao adicionar o veiculo no txt adequado
     */
    public void addVehicle(String plate, String brand, String model, String color, int year, String group, ArrayList<VehicleRegisterController> vehiclesArray) throws VehicleAlreadyExistsException, IOException {
        
        //Verifica se o veiculo ja existe
        if(verifyVehicleExistence(plate, vehiclesArray)) {
            throw new VehicleAlreadyExistsException(plate);
        }

        //Linha que sera adicionada ao txt de database
        String vehicleInTxt = plate + "\t" + brand + "\t" + model + "\t" + color + "\t" + year + "\t" + group + "\t" + "disponivel" + "\n";
        
        //Escreve a nova linha do veiculo no txt de database
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathVehicleRegister, true));
        writer.write(vehicleInTxt);
        vehiclesArray.add(new VehicleRegisterController(plate, brand, model, color, year, group, "disponivel"));
        writer.close();
    }

    /**
     * Metodo que exclui um veiculo, alterando seu status no txt e no objeto
     * @param reason Motivo da exclusao do veiculo
     * @param plate Placa do veiculo a ser excluido
     * @param vehiclesArray Local onde estao sendo armazenadas as instancias dos veiculos
     * @throws VehicleDoesNotExistException Veiculo nao existe no sistema
     * @throws FileNotFoundException Falha ao encontrar o arquivo txt dos veiculos
     * @throws IOException Falha ao adicionar o veiculo no txt adequado
     */
    public void removeVehicle(String reason, String plate, ArrayList<VehicleRegisterController> vehiclesArray) throws VehicleDoesNotExistException, FileNotFoundException, IOException {

        //Posicao do veiculo a ser removido no array
        int positionInArray = getPositionVehicleInArrayByPlate(plate, vehiclesArray);

        File vehicleRegister = new File(pathVehicleRegister);
        String oldContent = "";
        BufferedReader reader = new BufferedReader(new FileReader(vehicleRegister));
        String line = reader.readLine();

        //Le todo o arquivo txt antigo
        while (line != null) {
            oldContent = oldContent + line + System.lineSeparator();
            line = reader.readLine();
        }
        reader.close();

        //Linha do carro a ser excluido atualizada para o txt
        String newCarRegister = vehiclesArray.get(positionInArray).getPlate() + "\t" + vehiclesArray.get(positionInArray).getBrand() + 
                                "\t" + vehiclesArray.get(positionInArray).getModel() + "\t" + vehiclesArray.get(positionInArray).getColor() + "\t" + 
                                vehiclesArray.get(positionInArray).getYear() + "\t" + vehiclesArray.get(positionInArray).getGroup() + "\t" + 
                                "indisponivel - " + reason + "\n";

        //String que sera adicionada ao txt no lugar do texto antigo
        String newContent = oldContent.replaceAll(vehiclesArray.get(positionInArray).toString() + "\n", newCarRegister);

        BufferedWriter writer = new BufferedWriter(new FileWriter(pathVehicleRegister));
        writer.write(newContent);
        writer.close();

        //Muda status do veiculo no array
        vehiclesArray.get(positionInArray).setStatus("indisponivel - " + reason);
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
    public boolean verifyVehicleExistence(String plate, ArrayList<VehicleRegisterController> vehiclesArray) {
        
        for(int i = 0; i < vehiclesArray.size(); i++) {
            if(vehiclesArray.get(i).getPlate().equals(plate)) {
                return true;
            }
        }
        return false;
    }
    
}
