package employeeApp.employeeModel;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Paths;

import employeeApp.employeeExceptions.WithoutPermissionException;
import employeeApp.employeeController.clients.Client;

public class ModelClientRegister {

    //Retorna obj do tipo cliente...

    String pathClientRegister = Paths.get(System.getProperty("user.dir"), "database", "clientRegister.txt").toString();

    /**
     * Método que adiciona um cliente no clientRegister.txt e instancia um novo objeto no array
     * @param cpf CPF do cliente
     * @param name  Nome do cliente
     * @param birthDate Data de nascimento do cliente
     * @param email Email do cliente
     * @param phoneNumber Numero de telefone do cliente
     * @param clientsArray Local onde estão sendo armazenadas as intâncias dos clientes
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para crialo
    */  
    public void addClient(int cpf, String name, String birthDate, String email, String phoneNumber, ArrayList<Client> clientArray) throws WithoutPermissionException {

        // Linha que será adicionada ao clientRegister.txt em database
        String clientInTxt = cpf + "\t" + name + "\t" + birthDate + "\t" + email + "\t" + phoneNumber + "\n";

        try {
            // Escreve a nova linha de cliente no clientRegister.txt em database
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathClientRegister, true));
            writer.write(clientInTxt);
            clientArray.add(new Client(cpf, name, birthDate, email, phoneNumber));
            writer.close();
        } catch(IOException e) {
            throw new WithoutPermissionException();
        }
    }
}
