package employeeApp.employeeModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import employeeApp.employeeController.clients.ClientRegisterController;
import employeeApp.employeeExceptions.ClientAlreadyExistsException;

public class ModelClientRegister {

    //Retorna obj do tipo cliente...

    String pathclientRegister = Paths.get(System.getProperty("user.dir"), "database", "clientRegister.txt").toString();

    /**
     * Método que adiciona um cliente no clientRegister.txt e instancia um novo objeto no array
     * @param cpf => CPF do cliente
     * @param name = > Nome do cliente
     * @param birthDate => Data de nascimento do cliente
     * @param email => Email do cliente
     * @param phoneNumber => Número de telefone do cliente
     * @param clientsArray => Local onde estão sendo armazenadas as intâncias dos clientes
     * @throws ClientAlreadyExistsException => Veículo já existente no sistema 
     * @throws IOException => Falha ao adicionar o cliente no txt adequado
    */
    
    public void addClient(int cpf, String name, String birthDate, String email, String phoneNumber, ArrayList<ClientRegisterController> clientsArray) throws ClientAlreadyExistsException, IOException {

        if(verifyClientExistence(cpf, clientsArray)) {
            throw new ClientAlreadyExistsException(cpf);   
        }

        // Linha que será adicionada ao clientRegister.txt em database
        String clientInTxt = cpf + "\t" + name + "\t" + birthDate + "\t" + email + "\t" + phoneNumber + "\n";

        // Escreve a nova linha de cliente no clientRegister.txt em database
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathclientRegister, true));
        writer.write(clientInTxt);
        clientsArray.add(new ClientRegisterController(cpf, name, birthDate, email, phoneNumber));
        writer.close();
    }
    
    public boolean verifyClientExistence(int cpf, ArrayList<ClientRegisterController> clientsArray){
        for(int i = 0; i < clientsArray.size(); i++){
            if(clientsArray.get(i).getCpf() == cpf)
                return true;
        }
        return false;
    }
    
}
