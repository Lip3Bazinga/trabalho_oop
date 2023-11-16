package managerApp.managerModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class ModelOperationalParameters {

    // String do caminho absoluto do arquivo de texto "operationalParameters.txt" a partir do diretorio do projeto (user.dir) e do diretorio database
    String pathOperationalParameters = Paths.get(System.getProperty("user.dir"), "database", "operationalParameters.txt").toString();
    
    /**
     * Método que define o novo valor da diária de um grupo de veículos específico
     * @param group Grupo a ter o valor da diária atualizado
     * @param dailyValue Novo valor da diária do grupo
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    public void setDailyValue(String group, float dailyValue) throws IOException {
        updateParameterValue(group, 1, dailyValue); // Invoca o método 'updateParameterValue' para atualizar o valor da diária do grupo de veículo ('group') com o novo valor ('dailyValue')
    }

    /**
     * Método que define o novo valor do tanque de veículos específico
     * @param group Grupo a ter o valor do tanque atualizado
     * @param tankValue Novo valor do tanque do grupo 
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    public void setTankValue(String group, float tankValue) throws IOException {
        updateParameterValue(group, 2, tankValue); // Invoca o método 'updateParameterValue' para atualizar o valor do tanque do grupo de veículo ('group') com o novo valor ('tankValue')
    }

    /**
     * Método que define o novo valor da lipeza externa de um grupo de veículos específico
     * @param group Grupo a ter o valor da limpeza externa atualizado
     * @param externalCleaningPrice Novo valor da limpeza externa do grupo
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    public void setExternalCleaningPrice(String group, float externalCleaningPrice) throws IOException {
        updateParameterValue(group, 3, externalCleaningPrice); // Invoca o método 'updateParameterValue' para atualizar o valor da limpeza externa do grupo de veículo ('group') com o novo valor ('externalCleaningPrice')
    }

    /**
     * Método que define o novo valor da lipeza interna de um grupo de veículos específico
     * @param group Grupo a ter o valor da limpeza interna atualizado
     * @param internalCleaningPrice Novo valor da limpeza interna do grupo
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    public void setInternalCleaningPrice(String group, float internalCleaningPrice) throws IOException {
        updateParameterValue(group, 4, internalCleaningPrice); // Invoca o método 'updateParameterValue' para atualizar o valor da limpeza interna do grupo de veículo ('group') com o novo valor ('internalCleaningPrice')
    }

    /**
     * Método que define o novo valor do seguro diário de um grupo de veículos específico
     * @param group Grupo a ter o valor do seguro diário atualizado
     * @param insuranceDailyValue Novo valor do seguro diário do grupo
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    public void setInsuranceDailyValue(String group, float insuranceDailyValue) throws IOException {
        updateParameterValue(group, 5, insuranceDailyValue); // Invoca o método 'updateParameterValue' para atualizar o valor do seguro diário do grupo de veículo ('group') com o novo valor ('insuranceDailyValue')
    }

    /**
     * Método que atualiza um parâmetro operacional específico de um grupo de veículos
     * @param group Grupo a ter o parâmetro operacional atualizado
     * @param parameterIndex Índice do parâmetro operacional a ser atualizado (1: 'dailyValue', 2: 'tankValue', 3: 'externalCleaningPrice', 4: 'internalCleaningPrice', 5: 'insuranceDailyValue')
     * @param newValue Novo valor do parâmetro operacional a ser atualizado
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    private void updateParameterValue(String group, int parameterIndex, float newValue) throws IOException {

        String line; 

        // Armazena em um buffer ('inputBuffer') e le o arquivo de texto "operationalParameters.txt" linha por linha
        StringBuilder inputBuffer = new StringBuilder(); // Inicializa um objeto 'StringBuilder' chamado 'inputBuffer' para armazenar o conteúdo atualizado quer será posto mo arquivo de texto "operationalParameters.txt" (StringBuilder: classe que permite a manipulação de strings de forma mais eficiente do que a classe String)

        BufferedReader file = new BufferedReader(new FileReader(pathOperationalParameters)); 
            // new FileReader(pathOperationalParameters): Inicializa um objeto 'FileReader' para ler o arquivo de texto "operationalParameters.txt" (FileReader: classe que permite a leitura de arquivos de texto)
            // new BufferedReader(new FileReader(pathOperationalParameters)): Inicializa um objeto 'BufferedReader' para ler o arquivo de texto "operationalParameters.txt" em linhas (BufferedReader: classe que permite a leitura de arquivos de texto)
       
        // Le o arquivo de texto "operationalParameters.txt" linha por linha até encontrar a linha do grupo de veículo que se deseja atualizar os parametros operacionais
        while ((line = file.readLine()) != null) { // Lê a próxima linha do arquivo e armazena em 'line' (método 'readLine' na string 'file' para ler a próxima linha do arquivo)
            String[] lineParts = line.split("\\t"); // Quebra a linha em partes separadas por \t (método 'split' na string 'line' para quebrar a linha em partes separadas por \t)

            // Verifica se a linha atual é do grupo de veiculo que se deseja atualizar os parametros operacionais e atualiza os valores dos parametros operacionais.
                // lineParts.length >= 6: Verifica se 'lineParts' possuir pelo menos 6 segmentos (grupo, valorDiaria, valorTanque, valorLimpezaExterna, valorLimpezaInterna, valorSeguroDiaria) 
                // lineParts[0].equals(group): Verifica se o primeiro segmento da linha é igual ao grupo de veiculo que se deseja atualizar os parametros operacionais
            if (lineParts.length >= 6 && lineParts[0].equals(group)) {
                // Atualiza o valor do parâmetro operacional do grupo de veículo (lineParts) com o novo valor (newValue)
                lineParts[parameterIndex] = Float.toString(newValue);
            }

            
            line = String.join("\t", lineParts); // Junta os segmentos da linha em uma string separados por \t (método 'join' na string 'lineParts' para juntar os segmentos da linha em uma string separados por \t)
            inputBuffer.append(lineParts).append('\n'); // Adiciona a linha atual ao buffer de entrada e acrescentra uma quebra de linha no final (\n)
        }

        file.close(); // Fecha o arquivo de texto

        // Escreve o conteúdo de inputBuffer no arquivo de texto
        FileWriter fileWriter = new FileWriter(pathOperationalParameters); // Inicializa um objeto 'FileWriter' chamado 'fileWriter' para escrever no arquivo de texto "operationalParameters.txt"
        fileWriter.write(inputBuffer.toString()); // Invoca o método 'write' da classe 'FileWriter' para escrever o conteúdo do 'inputBuffer' no arquivo de texto "operationalParameters.txt". (Transforma o conteúdo de StringBuilder inputBuffer em uma String e depois escreve no arquivo)
        fileWriter.close(); // Método close() é chamado no objeto 'fileWriter' para fechar o arquivo de texto
    }


    /**
     * Método que retorna o atual valor da diária de um grupo de veículos específico
     * @param group Grupo a ter o valor da diária retornado
     * @return Atual valor da diária do grupo de veículos especificado
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    public float getDailyValue(String group) throws IOException {
        return getParameterValue(group, 1);
    }

    /**
     * Método que retorna o atual valor do tanque de um grupo de veículos específico
     * @param group Grupo a ter o valor do tanque retornado
     * @return Atual valor do tanque do grupo de veículos especificado
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    public float getTankValue(String group) throws IOException {
        return getParameterValue(group, 2);
    }

    /**
     * Método que retorna o atual valor da limpeza externa de um grupo de veículos específico
     * @param group Grupo a ter o valor da limpeza externa retornado
     * @return Atual valor da limpeza externa do grupo de veículos especificado 
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    public float getExternalCleaningPrice(String group) throws IOException {
        return getParameterValue(group, 3);
    }

    /**
     * Método que retorna o atual valor da limpeza interna de um grupo de veículos específico
     * @param group Grupo a ter o valor da limpeza interna retornado
     * @return Atual valor da limpeza interna do grupo de veículos especificado 
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    public float getInternalCleaningPrice(String group) throws IOException {
        return getParameterValue(group, 4);
    }

    /**
     * Método que retorna o atual valor do seguro diário de um grupo de veículos específico
     * @param group Grupo a ter o valor do seguro diário retornado
     * @return Atual valor do seguro diário do grupo de veículos especificado 
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    public float getInsuranceDailyValue(String group) throws IOException {
        return getParameterValue(group, 5);
    }

    /**
     * Método que obtém o valor de um parâmetro operacional específico de um grupo de veículos e retorna esse valor
     * @param group Grupo a ter o valor do parâmetro operacional retornado
     * @param parameterIndex Índice do parâmetro operacional a ser retornado (1: 'dailyValue', 2: 'tankValue', 3: 'externalCleaningPrice', 4: 'internalCleaningPrice', 5: 'insuranceDailyValue')
     * @return Valor do parâmetro operacional do grupo de veículos especificado
     * @throws IOException Falha ao acessar o arquivo de texto
     */
    private float getParameterValue(String group, int parameterIndex) throws IOException {

        String line;

        // Le o arquivo de texto "operationalParameters.txt" linha por linha 
        BufferedReader file = new BufferedReader(new FileReader(pathOperationalParameters)); 
            // new FileReader(pathOperationalParameters): Inicializa um objeto 'FileReader' para ler o arquivo de texto "operationalParameters.txt" (FileReader: classe que permite a leitura de arquivos de texto)
            // new BufferedReader(new FileReader(pathOperationalParameters)): Inicializa um objeto 'BufferedReader' para ler o arquivo de texto "operationalParameters.txt" em linhas (BufferedReader: classe que permite a leitura de arquivos de texto)

            // Le o arquivo de texto "operationalParameters.txt" linha por linha até encontrar a linha do grupo de veículo que se deseja obter o valor do parâmetro operacional
            while((line = file.readLine()) != null) { // Lê a próxima linha do arquivo e armazena em 'line' (método 'readLine' na string 'file' para ler a próxima linha do arquivo)
            String[] lineParts = line.split("\\t"); // Quebra a linha em partes separadas por \t (método 'split' na string 'line' para quebrar a linha em partes separadas por \t)

            // Verifica se a linha atual é do grupo de veículo que deseja obter o valor do parâmetro operacional
                // lineParts.length >= 6: Verifica se 'lineParts' possuir pelo menos 6 segmentos (grupo, valorDiaria, valorTanque, valorLimpezaExterna, valorLimpezaInterna, valorSeguroDiaria) 
                // lineParts[0].equals(group): Verifica se o primeiro segmento da linha é igual ao grupo de veiculo que deseja obter o valor do parâmetro operacional
            if(lineParts.length >= 6 && lineParts[0].equals(group)) {
                return Float.parseFloat(lineParts[parameterIndex]); // Converte para float o valor do parâmetro operacional do grupo de veículo ('lineParts[parameterIndex]') (OBS.: PARA FACILITAR NA PARTE DE ESTATÍSTICA) e retorna esse valor (método 'parseFloat' na string 'lineParts[parameterIndex]' para converter para float o valor do parâmetro operacional do grupo de veículo)
            }
        }

        file.close(); // Fecha o arquivo de texto
        return (float)0.0; // Se nenhuma linha válida for encontrada para o grupo de veículo especificado (ou problema ao ler arquivo) retorna 0.0
    }

}
