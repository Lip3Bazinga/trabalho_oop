package employeeApp.employeeController.clients;

import java.util.ArrayList;

import employeeApp.employeeExceptions.InvalidCPFException;
import employeeApp.employeeExceptions.ClientAlreadyExistsException;
import employeeApp.employeeExceptions.InvalidBirthDateException;
import employeeApp.employeeExceptions.InvalidAgeException;
import employeeApp.employeeExceptions.WithoutPermissionException;
import employeeApp.employeeModel.ModelClientRegister;


/**
 * Classe que registra clientes
 */
public class ClientRegisterController {
    
    /**
     * Metodo que, após a validacao do CPF e data de nascimento, adiciona o cliente ao sistema
     * @param cpf CPF do cliente
     * @param name Nome do cliente
     * @param birthDate Data de nascimento do cliente
     * @param email Email do cliente
     * @param phoneNumber Numero de telefone do cliente
     * @param clientArray Local onde estao sendo armazenadas as instancias dos clientes
     * @throws InvalidCPFException CPF invalido
     * @throws ClientAlreadyExistsException Cliente ja existe no sistema
     * @throws InvalidBirthDateException Data de nascimento invalida
     * @throws InvalidAgeException Cliente menor de idade
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo 
     */
    public void addClient(int cpf, String name, String birthDate, String email, String phoneNumber, ArrayList<Client> clientArray) throws InvalidCPFException, ClientAlreadyExistsException, InvalidBirthDateException, InvalidAgeException, WithoutPermissionException {
        
        try {
            validateCpf(cpf);

            if(verifyClientExistence(cpf, clientArray)) {
                throw new ClientAlreadyExistsException(cpf);
            }

            validateBirthDate(birthDate);
            validateAge(birthDate);

            ModelClientRegister modelClientRegister = new ModelClientRegister();
            modelClientRegister.addClient(cpf, name, birthDate, email, phoneNumber, clientArray);
        } catch(InvalidCPFException ice) {
            throw ice;
        } catch(ClientAlreadyExistsException caee) {
            throw caee;
        } catch(InvalidBirthDateException ibde) {
            throw ibde;
        } catch(InvalidAgeException iae) {
            throw iae;
        } catch(WithoutPermissionException wpe) {
            throw wpe;
        }
    }

    /**
     * Metodo que valida se o CPF esta correto
     * @param cpf CPF do cliente
     * @throws InvalidCPFException CPF invalido
     */
    private void validateCpf(int cpf) throws InvalidCPFException {

        // Comverter CPF para uma string
        String cpfString = Integer.toString(cpf);

        // Verificar o tamanho do CPF
        if (cpfString.length() != 11) {
            throw new InvalidCPFException(cpf);
        }
        
        // Converter cpf (int) para um array
        int cpfArray[] = new int[11];
        for(int i = 10; i >= 0; i++) {
            cpfArray[i] = cpf % 10; // Pega o ultimo digito do CPF
            cpf = cpf / 10; // Remove o ultimo digito do CPF
        }

        // Calcular digito verificador 1
        int sum1 = 0;
        for(int i = 0; i < 9; i++) {
            sum1 = sum1 + cpfArray[i] * (i + 1);
        }

        int remainder1 = sum1 % 11;
        int firstDigit;

        if(remainder1 != 10) {
            firstDigit = remainder1;
        } else {
            firstDigit = 0;
        }

        // Calcular digito verificador 2
        int sum2 = 0;
        for(int i = 0; i < 10; i++) {
            sum2 = sum2 + cpfArray[i] * i;
        }

        int remainder2 = sum2 % 11;
        int secondDigit;

        if(remainder2 != 10) {
            secondDigit = remainder2;
        } else {
            secondDigit = 0;
        }

        // Comparar os digitos verificadores com os digitos do CPF
        if(firstDigit != cpfArray[9] || secondDigit != cpfArray[10]) {
            throw new InvalidCPFException(cpf);
        }

/*
 *      0 1 2 3 4 5 6 7 8   9 10
 * CPF: 1 2 3 4 5 6 7 8 9 - 1 2
 * 
 * 1*1 + 2*2 + 3*3 + 4*4 + 5*5 + 6*6 + 7*7 + 8*8 + 9*9 = 285
 * 
 * 285 % 11 = 10 ==> primeiro digito verificador: 0
 * 
 * 1*0 + 2*1 + 3*2 + 4*3 + 5*4 + 6*5 + 7*6 + 8*7 + 9*8 + 0*9 = 240
 * 
 * 240 % 11 = 9 ==> segundo digito verificador: 9
*/

    }

    /**
     * Metodo que valida se o cliente ja esta cadastrado
     * @param cpf CPF do cliente
     * @param clientArray Array de clientes
     * @return True se o cliente ja esta cadastrado, false se nao
     * @throws ClientAlreadyExistsException Cliente ja existe no sistema
     */
    public static boolean verifyClientExistence(int cpf, ArrayList<Client> clientArray) throws ClientAlreadyExistsException {
        for(int i = 0; i < clientArray.size(); i++) {
            if(clientArray.get(i).getCpf() == cpf) { // .equals nao da para usar em int
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que valida se a data de nascimento esta correta
     * @param birthDate Data de nascimento do cliente
     * @throws InvalidBirthDateException Data de nascimento invalida
     */
    private void validateBirthDate(String birthDate) throws InvalidBirthDateException {
        // Verificar se a data tem o tamanho correto
        if(birthDate.length() != 10) { // 10 caracteres, sendo eles 8 numeros e 2 tracos
            throw new InvalidBirthDateException(birthDate);
        }

        // Separar a data em ano, mes e dia
        String year = birthDate.substring(0, 4);
        String month = birthDate.substring(5, 7);
        String day = birthDate.substring(8, 10);

        // 0123 4 56 7 89
        // YYYY - MM - DD

        // Transformar dia, mes e ano em int
        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);
        int dayInt = Integer.parseInt(day);

        // Verificar se o ano esta entre 1907 e 2023
        if(yearInt < 1907 || yearInt > 2023) {
            throw new InvalidBirthDateException(birthDate);
        }

        // Verifica se o mes esta entre 1 e 12
        if(monthInt < 1 || monthInt > 12) {
            throw new InvalidBirthDateException(birthDate);
        }

        // Verifica dias de cada mes 
            // ano bissexto se o ano nao terminar em 00 e for divisivel por 4
        if(monthInt == 1 || monthInt == 3 || monthInt == 5 || monthInt == 7 || monthInt == 8 || monthInt == 10 || monthInt == 12) {
            if(dayInt < 1 || dayInt > 31) {
                throw new InvalidBirthDateException(birthDate);
            }
        } else if(monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11) {
            if(dayInt < 1 || dayInt > 30) {
                throw new InvalidBirthDateException(birthDate);
            }
        } else if(monthInt == 2) {
            if(yearInt % 100 != 0 && yearInt % 4 == 0) { // ano bissexto
                if(dayInt < 1 || dayInt > 29) {
                    throw new InvalidBirthDateException(birthDate);
                }
            } else {
                if(dayInt < 1 || dayInt > 28) {
                    throw new InvalidBirthDateException(birthDate);
                }
            }
        }

    }

    /**
     * Metodo que valida se cliente maior de idade (considerando que a data de hoje é 2023-12-10
     */
    private void validateAge(String birthDate) throws InvalidAgeException {
        // Separar a data em ano, mes e dia
        String year = birthDate.substring(0, 4);
        String month = birthDate.substring(5, 7);
        String day = birthDate.substring(8, 10);

        // Transformar dia, mes e ano em int
        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);
        int dayInt = Integer.parseInt(day);

        if(yearInt > 2005 || yearInt == 2005 && monthInt == 12 && dayInt > 10) {
            throw new InvalidAgeException(birthDate);
        }
    }
     
    
}