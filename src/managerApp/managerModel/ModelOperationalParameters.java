package managerApp.managerModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import managerApp.managerExceptions.WithoutPermissionException;
import managerApp.managerExceptions.NotPostiveNumberException;

public class ModelOperationalParameters {

    String pathOperationalParameters = Paths.get(System.getProperty("user.dir"), "database", "operationalParameters.txt").toString();

    /**
     * Cria o arquivo de parametros operacionais caso ele nao exista com todos os parametros zerados
     * @throws WithoutPermissionException Nao ha permissao para criar o arquivo
     */
    public void setFirstData() throws WithoutPermissionException {

        File operationalParameters = new File(pathOperationalParameters);

        if (!operationalParameters.exists()) {
            try {
                operationalParameters.createNewFile();
                
            } catch (IOException e) {
                throw new WithoutPermissionException();
            }
        }

        try {
            String operationalParametersText = "Basico" + '\t' + 0.0 + '\t' + 0.0 + '\t' + 0.0 + '\t' + 0.0 + '\t' + 0.0 + '\n' +
                                               "Padrao" + '\t' + 0.0 + '\t' + 0.0 + '\t' + 0.0 + '\t' + 0.0 + '\t' + 0.0 + '\n' +
                                               "Premium" + '\t' + 0.0 + '\t' + 0.0 + '\t' + 0.0 + '\t' + 0.0 + '\t' + 0.0 + '\n';
                
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathOperationalParameters));
            writer.write(operationalParametersText);
            writer.close();
        } catch(IOException e) {
            throw new WithoutPermissionException();
        }
      
    }

    /**
     * Altera o valor da diaria do aluguel de um carro
     * @param group Grupo a ser alterado
     * @param dailyValue Novo valor da diaria
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void setDailyValue(String group, double dailyValue) throws NotPostiveNumberException, WithoutPermissionException {

        try {
            File operationalParameters = new File(pathOperationalParameters);
            String oldContent = "";
            BufferedReader reader = new BufferedReader(new FileReader(operationalParameters));
            String line = reader.readLine();

            if(line == null) {
                setFirstData();
                line = reader.readLine();
            }

            //Le todo o arquivo txt antigo
            while (line != null) {
                oldContent = oldContent + line + "\n";
                line = reader.readLine();
            }
            reader.close();

            //Linha do carro a ser excluido atualizada para o txt
            String newOperationalParameters = group + "\t" + dailyValue + "\t" + 
                                              getTankValue(group) + "\t" + getExternalCleaningPrice(group) + "\t" + 
                                              getInsuranceDailyValue(group) + "\t" + getInsuranceDailyValue(group) + "\n";

            String oldOperationalParameters = group + "\t" + getDailyValue(group) + "\t" + 
                                              getTankValue(group) + "\t" + getExternalCleaningPrice(group) + "\t" + 
                                              getInsuranceDailyValue(group) + "\t" + getInsuranceDailyValue(group) + "\n";

            
            //String que sera adicionada ao txt no lugar do texto antigo
            String newContent = oldContent.replaceAll(oldOperationalParameters, newOperationalParameters);

            BufferedWriter writer = new BufferedWriter(new FileWriter(pathOperationalParameters));
            writer.write(newContent);
            writer.close();

        } catch(IOException e) {          //O arquivo nao pode ser criado (nao ha permissao de acesso)
            throw new WithoutPermissionException();
        }
    }

    /**
     * Altera o valor do tanque para um determinado grupo
     * @param group Grupo a ter o valor alterado
     * @param tankValue Novo valor do tanque
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void setTankValue(String group, double tankValue) throws NotPostiveNumberException, WithoutPermissionException {

        try {
            File operationalParameters = new File(pathOperationalParameters);
            String oldContent = "";
            BufferedReader reader = new BufferedReader(new FileReader(operationalParameters));
            String line = reader.readLine();

            if(line == null) {
                setFirstData();
                line = reader.readLine();
            }

            //Le todo o arquivo txt antigo
            while (line != null) {
                oldContent = oldContent + line + "\n";
                line = reader.readLine();
            }
            reader.close();

            //Linha do carro a ser excluido atualizada para o txt
            String newOperationalParameters = group + "\t" + getDailyValue(group) + "\t" + 
                                              tankValue + "\t" + getExternalCleaningPrice(group) + "\t" + 
                                              getInternalCleaningPrice(group) + "\t" + getInsuranceDailyValue(group) + "\n";

            String oldOperationalParameters = group + "\t" + getDailyValue(group) + "\t" + 
                                              getTankValue(group) + "\t" + getExternalCleaningPrice(group) + "\t" + 
                                              getInternalCleaningPrice(group) + "\t" + getInsuranceDailyValue(group) + "\n";

            
            //String que sera adicionada ao txt no lugar do texto antigo
            String newContent = oldContent.replaceAll(oldOperationalParameters, newOperationalParameters);

            BufferedWriter writer = new BufferedWriter(new FileWriter(pathOperationalParameters));
            writer.write(newContent);
            writer.close();
        
        } catch(IOException e) {          //O arquivo nao pode ser criado (nao ha permissao de acesso)
            throw new WithoutPermissionException();
        }
    }

    /**
     * Altera o valor da limpeza externa para um determinado grupo de carros
     * @param group Grupo a ser alterado
     * @param externalCleaningPrice Novo valor da limpeza externa
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void setExternalCleaningPrice(String group, double externalCleaningPrice) throws NotPostiveNumberException, WithoutPermissionException {

        try {
            File operationalParameters = new File(pathOperationalParameters);
            String oldContent = "";
            BufferedReader reader = new BufferedReader(new FileReader(operationalParameters));
            String line = reader.readLine();

            if(line == null) {
                setFirstData();
                line = reader.readLine();
            }

            //Le todo o arquivo txt antigo
            while (line != null) {
                oldContent = oldContent + line + "\n";
                line = reader.readLine();
            }
            reader.close();

            //Linha do carro a ser excluido atualizada para o txt
            String newOperationalParameters = group + "\t" + getDailyValue(group) + "\t" + 
                                              getTankValue(group) + "\t" + externalCleaningPrice + "\t" + 
                                              getInternalCleaningPrice(group) + "\t" + getInsuranceDailyValue(group) + "\n";

            String oldOperationalParameters = group + "\t" + getDailyValue(group) + "\t" + 
                                              getTankValue(group) + "\t" + getExternalCleaningPrice(group) + "\t" + 
                                              getInternalCleaningPrice(group) + "\t" + getInsuranceDailyValue(group) + "\n";

            
            //String que sera adicionada ao txt no lugar do texto antigo
            String newContent = oldContent.replaceAll(oldOperationalParameters, newOperationalParameters);

            BufferedWriter writer = new BufferedWriter(new FileWriter(pathOperationalParameters));
            writer.write(newContent);
            writer.close();
        
        } catch(IOException e) {          //O arquivo nao pode ser criado (nao ha permissao de acesso)
            throw new WithoutPermissionException();
        }
    }

    /**
     * Altera o valor da limpeza interna de um grupo de carros
     * @param group Grupo a ser alterado
     * @param internalCleaningPrice Novo valor da limpeza interna
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void setInternalCleaningPrice(String group, double internalCleaningPrice) throws NotPostiveNumberException, WithoutPermissionException {

        try {
            File operationalParameters = new File(pathOperationalParameters);
            String oldContent = "";
            BufferedReader reader = new BufferedReader(new FileReader(operationalParameters));
            String line = reader.readLine();

            if(line == null) {
                setFirstData();
                line = reader.readLine();
            }

            //Le todo o arquivo txt antigo
            while (line != null) {
                oldContent = oldContent + line + "\n";
                line = reader.readLine();
            }
            reader.close();

            //Linha do carro a ser excluido atualizada para o txt
            String newOperationalParameters = group + "\t" + getDailyValue(group) + "\t" + 
                                              getTankValue(group) + "\t" + getExternalCleaningPrice(group) + "\t" + 
                                              internalCleaningPrice + "\t" + getInsuranceDailyValue(group) + "\n";

            String oldOperationalParameters = group + "\t" + getDailyValue(group) + "\t" + 
                                              getTankValue(group) + "\t" + getExternalCleaningPrice(group) + "\t" + 
                                              getInsuranceDailyValue(group) + "\t" + getInsuranceDailyValue(group) + "\n";
            
            //String que sera adicionada ao txt no lugar do texto antigo
            String newContent = oldContent.replaceAll(oldOperationalParameters, newOperationalParameters);

            BufferedWriter writer = new BufferedWriter(new FileWriter(pathOperationalParameters));
            writer.write(newContent);
            writer.close();
        
        } catch(IOException e) {          //O arquivo nao pode ser criado (nao ha permissao de acesso)
            throw new WithoutPermissionException();
        }
    }

    /**
     * Altera o valor da diaria do seguro de um determinado grupo
     * @param group Grupo a ser alterado
     * @param insuranceDailyValue Novo valor da diaria do seguro
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void setInsuranceDailyValue(String group, double insuranceDailyValue) throws NotPostiveNumberException, WithoutPermissionException {

        try {
            File operationalParameters = new File(pathOperationalParameters);
            String oldContent = "";
            BufferedReader reader = new BufferedReader(new FileReader(operationalParameters));
            String line = reader.readLine();

            if(line == null) {
                setFirstData();
                line = reader.readLine();
            }

            //Le todo o arquivo txt antigo
            while (line != null) {
                oldContent = oldContent + line + "\n";
                line = reader.readLine();
            }
            reader.close();

            //Linha do carro a ser excluido atualizada para o txt
            String newOperationalParameters = group + "\t" + getDailyValue(group) + "\t" + 
                                              getTankValue(group) + "\t" + getExternalCleaningPrice(group) + "\t" + 
                                              getInternalCleaningPrice(group) + "\t" + insuranceDailyValue + "\n";

            String oldOperationalParameters = group + "\t" + getDailyValue(group) + "\t" + 
                                              getTankValue(group) + "\t" + getExternalCleaningPrice(group) + "\t" + 
                                              getInternalCleaningPrice(group) + "\t" + getInsuranceDailyValue(group) + "\n";

            
            //String que sera adicionada ao txt no lugar do texto antigo
            String newContent = oldContent.replaceAll(oldOperationalParameters, newOperationalParameters);

            BufferedWriter writer = new BufferedWriter(new FileWriter(pathOperationalParameters));
            writer.write(newContent);
            writer.close();
        
        } catch(IOException e) {          //O arquivo nao pode ser criado (nao ha permissao de acesso)
            throw new WithoutPermissionException();
        }
    }

    /**
     * Metodo get para o valor da diaria de um grupo de carro
     * @param group Grupo a ter o valor da diaria retornado
     * @return Valor da diaria do grupo
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public double getDailyValue(String group) throws WithoutPermissionException {
        
        try {
            String groupLine[] = null;

            switch(group) {
                case "Basico":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(0).split("\t");
                    break;
                case "Padrao":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(1).split("\t");
                    break;
                case "Premium":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(2).split("\t");
                    break;
            }
            return Double.parseDouble(groupLine[1]);
        } catch(IOException e) {
            setFirstData();
            return 0.0;
        }
    }

    /**
     * Metodo get para o valor do tanque de um grupo de carro
     * @param group Grupo a ter o valor do tanque retornado
     * @return Valor do tanque do grupo
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public double getTankValue(String group) throws WithoutPermissionException {

        try {
            String groupLine[] = null;

            switch(group) {
                case "Basico":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(0).split("\t");
                    break;
                case "Padrao":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(1).split("\t");
                    break;
                case "Premium":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(2).split("\t");
                    break;
            }
            return Double.parseDouble(groupLine[2]);
        } catch(IOException e) {
            setFirstData();
            return 0.0;
        }
    }

    /**
     * Metodo get para o valor da limpeza externa de um grupo de carro
     * @param group Grupo a ter o valor da limpeza externa retornado
     * @return Valor da limpeza externa do grupo
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public double getExternalCleaningPrice(String group) throws WithoutPermissionException {

        try {
            String groupLine[] = null;

            switch(group) {
                case "Basico":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(0).split("\\t");
                    break;
                case "Padrao":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(1).split("\\t");
                    break;
                case "Premium":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(2).split("\\t");
                    break;
            }
            for (String parte : groupLine) {
                System.out.println("[-" + parte + "-]");
            }
            return Double.parseDouble(groupLine[3]);
        } catch(IOException e) {
            setFirstData();
            return 0.0;
        }
    }

    /**
     * Metodo get para o valor da limpeza interna de um grupo de carro
     * @param group Grupo a ter o valor da limpeza interna retornado
     * @return Valor da limpeza interna do grupo
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public double getInternalCleaningPrice(String group) throws WithoutPermissionException {

        try {
            String groupLine[] = null;

            switch(group) {
                case "Basico":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(0).split("\t");
                    break;
                case "Padrao":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(1).split("\t");
                    break;
                case "Premium":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(2).split("\t");
                    break;
            }
            return Double.parseDouble(groupLine[4]);
        } catch(IOException e) {
            setFirstData();
            return 0.0;
        }
    }

    /**
     * Metodo get para o valor da diaria do seguro de um grupo de carro
     * @param group Grupo a ter o valor da diaria do seguroretornado
     * @return Valor da diaria do seguro do grupo
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public double getInsuranceDailyValue(String group) throws WithoutPermissionException {

        try {
            String groupLine[] = null;

            switch(group) {
                case "Basico":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(0).split("\t");
                    break;
                case "Padrao":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(1).split("\t");
                    break;
                case "Premium":
                    groupLine = Files.readAllLines(Paths.get(pathOperationalParameters)).get(2).split("\t");
                    break;
            }
            return Double.parseDouble(groupLine[5]);
        } catch(IOException e) {
            setFirstData();
            return 0.0;
        }
    }
}
