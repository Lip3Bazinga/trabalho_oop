package managerApp.managerModel;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import managerApp.managerExceptions.VehicleAlreadyExistsException;
import managerApp.managerExceptions.VehicleDoesNotExistException;
import managerApp.managerExceptions.WithoutPermissionException;
import managerApp.managerController.vehicles.Vehicle;

public class ModelVehicleRegister {

    //String do caminho absoluto do arquivo de texto "vehicleRegister.txt" a partir do diretorio do projeto (user.dir) e do diretorio database
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
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void addVehicle(String plate, String brand, String model, String color, int year, String group, ArrayList<Vehicle> vehiclesArray) throws VehicleAlreadyExistsException, WithoutPermissionException {

        //Linha que sera adicionada ao txt de database
        String vehicleInTxt = plate + "\t" + brand + "\t" + model + "\t" + color + "\t" + year + "\t" + group + "\t" + "disponivel" + "\n";
        
        //Escreve a nova linha do veiculo no txt de database, caso ele nao exista tambem cria o arquivo txt
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathVehicleRegister, true));
            writer.write(vehicleInTxt);
            vehiclesArray.add(new Vehicle(plate, brand, model, color, year, group, "disponivel"));
            writer.close();
        } catch(IOException e) {          //O arquivo nao pode ser criado (nao ha permissao de acesso)
            throw new WithoutPermissionException();
        }

    }

    /**
     * Metodo que exclui um veiculo, alterando seu status no txt e no objeto
     * @param reason Motivo da exclusao do veiculo
     * @param plate Placa do veiculo a ser excluido
     * @param vehiclesArray Local onde estao sendo armazenadas as instancias dos veiculos
     * @param positionInArray Posicao do veiculo no array
     * @throws VehicleDoesNotExistException Veiculo nao existe no sistema
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void removeVehicle(String reason, String plate, ArrayList<Vehicle> vehiclesArray, int positionInArray) throws VehicleDoesNotExistException, WithoutPermissionException {

        try {
            File vehicleRegister = new File(pathVehicleRegister);
            String oldContent = "";
            BufferedReader reader = new BufferedReader(new FileReader(vehicleRegister));
            String line = reader.readLine();

            //Le todo o arquivo txt antigo
            while (line != null) {
                oldContent = oldContent + line + "\n";
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
        } catch(IOException e) {          //O arquivo nao pode ser criado (nao ha permissao de acesso)
            throw new WithoutPermissionException();
        }
    }
    
    /**
     *  Metodo utilizado para inicializar o array de veiculos ao abrir o aplicativo com os dados do txt
     * @return Retorna o array de veiculos com os dados do txt
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public ArrayList<Vehicle> initializeVehicles() throws WithoutPermissionException {

        try {
            File vehicleRegister = new File(pathVehicleRegister);
            BufferedReader reader = new BufferedReader(new FileReader(vehicleRegister));
            String line = reader.readLine();
            String elements[];

            ArrayList<Vehicle> vehiclesArray = new ArrayList<>();;
            Vehicle vehicle;

            //Le todo o arquivo txt antigo
            while (line != null) {
                elements = line.split("\t");
                for(int i = 0; i < elements.length; i++) {
                    vehicle = new Vehicle(elements[0], elements[1], elements[2], elements[3], Integer.parseInt(elements[4]), elements[5], elements[6]);
                    vehiclesArray.add(vehicle);
                }

                line = reader.readLine();
            }
            reader.close();

            return vehiclesArray;
        } catch(IOException e) {          //O arquivo nao pode ser criado (nao ha permissao de acesso)
            throw new WithoutPermissionException();
        }
    }
}
