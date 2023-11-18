package employeeApp.employeeModel;

<<<<<<< HEAD
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import employeeApp.employeeExceptions.ClientAlreadyExistsException;
import employeeApp.employeeController.clients.ClientRegisterController;

=======
>>>>>>> parent of dc242c8 (Correções Dúzia por falta de compilador)
public class ModelClientRegister {

    //Retorna obj do tipo cliente...

    String pathClientRegister = Paths.get(System.getProperty("user.dir"), "database", "clientRegister.txt").toString();

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
    
    public void addClient(int cpf, String name, String birthDate, String email, String phoneNumber, ArrayList<clientRegisterController> clientsArray) throws ClientAlreadyExistsException, IOException {

        if(verifyClientExistence(cpf, ) {
            throw new ClientAlreadyExistsException(cpf);   
        }

        // Linha que será adicionada ao clientRegister.txt em database
        String clientInTxt = cpf + "\t" + name + "\t + birthDate + "\t" + email + "\t + phoneNumber + "\n";

        // Escreve a nova linha de cliente no clientRegister.txt em database
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathClientRegister, true));
        writer.write(clientInTxt);
        clientsArray.add(new clientRegisterController(cpf, name, birthDate, email, phoneNumber));
        writer.close();
    }
    
    public boolean verifyClientExistence(int cpf, ArrayList<clientRegisterController> clientsArray){
        for(int i = 0; i < vehiclesArray.size(); i++){
            if(clientsArray.get(i).getCpf().equals(cpf))
                return true
        }
        return false
    }
    
}
