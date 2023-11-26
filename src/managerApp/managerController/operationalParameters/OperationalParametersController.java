package managerApp.managerController.operationalParameters;

import managerApp.managerExceptions.NotPostiveNumberException;
import managerApp.managerExceptions.WithoutPermissionException;
import managerApp.managerModel.ModelOperationalParameters;


public class OperationalParametersController {
    // Atributos: instância da classe ModelOperationalParameters
    private ModelOperationalParameters modelOperationalParameters;

    // Construtor: inicializa o atributo modelOperationalParameters, criando uma instância da classe ModelOperationalParameters quando um objeto da classe OperationalParametersController é criado
    public OperationalParametersController() {
        this.modelOperationalParameters = new ModelOperationalParameters();
    }

    /**
     * Método que invoca o método getDailyValue da classe ModelOperationalParameters (obtem o valor da diária do grupo de veículos)
     * @param group Grupo do veículo a ter o valor da diária retornado
     * @return Valor da diária do grupo de veículos
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public double getDailyValue(String group) throws WithoutPermissionException {
        try {
            // Chama o método getDailyValue da classe ModelOperationalParameters para obter o valor da diária do grupo de veículos
            return this.modelOperationalParameters.getDailyValue(group);
        } catch (WithoutPermissionException wpe) {
            // Se o arquivo nao existe e nao ha permissao para cria-lo, lança a exceção WithoutPermissionException
            throw wpe;  
        }
    }

    /**
     * Método que invoca o método getTankValue da classe ModelOperationalParameters (obtem o valor do tanque do grupo de veículos)
     * @param group Grupo do veículo a ter o valor do tanque retornado
     * @return Valor do tanque do grupo de veículos
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public double getTankValue(String group) throws WithoutPermissionException {
        try {
            // Chama o método getTankValue da classe ModelOperationalParameters para obter o valor do tanque do grupo de veículos
            return this.modelOperationalParameters.getTankValue(group);
        } catch (WithoutPermissionException wpe) {
            // Se o arquivo nao existe e nao ha permissao para cria-lo, lança a exceção WithoutPermissionException
            throw wpe;  
        }
    }

    /**
     * Método que invoca o método getExternalCleaningPrice da classe ModelOperationalParameters (obtem o valor da limpeza externa do grupo de veículos)
     * @param group Grupo do veículo a ter o valor da limpeza externa retornado
     * @return Valor da limpeza externa do grupo de veículos 
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public double getExternalCleaningPrice(String group) throws WithoutPermissionException {
        try {
            // Chama o método getExternalCleaningPrice da classe ModelOperationalParameters para obter o valor da limpeza externa do grupo de veículos
            return this.modelOperationalParameters.getExternalCleaningPrice(group);
        } catch (WithoutPermissionException wpe) {
            // Se o arquivo nao existe e nao ha permissao para cria-lo, lança a exceção WithoutPermissionException
            throw wpe;  
        }
    }

    /**
     * Método que invoca o método getInternalCleaningPrice da classe ModelOperationalParameters (obtem o valor da limpeza interna do grupo de veículos)
     * @param group Grupo do veículo a ter o valor da limpeza interna retornado
     * @return Valor da limpeza interna do grupo de veículos 
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public double getInternalCleaningPrice(String group) throws WithoutPermissionException {
        try {
            // Chama o método getInternalCleaningPrice da classe ModelOperationalParameters para obter o valor da limpeza interna do grupo de veículos
            return this.modelOperationalParameters.getInternalCleaningPrice(group);
        } catch (WithoutPermissionException wpe) {
            // Se o arquivo nao existe e nao ha permissao para cria-lo, lança a exceção WithoutPermissionException
            throw wpe;  
        }
    }

    /**
     * Método que invoca o método getInsuranceDailyValue da classe ModelOperationalParameters (obtem o valor diário do seguro do grupo de veículos)
     * @param group Grupo do veículo a ter o valor diário do seguro retornado
     * @return Valor diário do seguro do grupo de veículos 
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public double getInsuranceDailyValue(String group) throws WithoutPermissionException {
        try {
            // Chama o método getInsuranceDailyValue da classe ModelOperationalParameters para obter o valor diário do seguro do grupo de veículos
            return this.modelOperationalParameters.getInsuranceDailyValue(group);
        } catch (WithoutPermissionException wpe) {
            // Se o arquivo nao existe e nao ha permissao para cria-lo, lança a exceção WithoutPermissionException
            throw wpe;  
        }
    }

    /**
     * Método que após validar o valor recebido, chama o método setDailyValue da classe ModelOperationalParameters (chama validateValue antes de definir o valor da diária)
     * @param group Grupo do veículo a ter o valor da diária alterado
     * @param dailyValue Valor da diária a ser alterado
     * @throws NotPostiveNumberException O valor da diária não é positivo
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void setDailyValue(String group, double dailyValue) throws NotPostiveNumberException, WithoutPermissionException {
        try {
            // Valida o valor da diária recebido antes de definir o valor da diária
            validateValue("valor da diaria", group, dailyValue);
            this.modelOperationalParameters.setDailyValue(group, dailyValue);
        } catch(NotPostiveNumberException npne) {
            // Se o valor recebido for menor ou igual a zero, lança a exceção NotPostiveNumberException
            throw npne;
        } catch (WithoutPermissionException wpe) {
            // Se o arquivo nao existe e nao ha permissao para cria-lo, lança a exceção WithoutPermissionException
            throw wpe;  
        }
    }

    /**
     * Método que após validar o valor recebido, chama o método setTankValue da classe ModelOperationalParameters (chama validateValue antes de definir o valor do tanque)
     * @param group Grupo do veículo a ter o valor do tanque alterado
     * @param tankValue Valor do tanque a ser alterado
     * @throws NotPostiveNumberException O valor do tanque não é positivo
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void setTankValue(String group, double tankValue) throws NotPostiveNumberException, WithoutPermissionException {
        try {
            // Valida o valor do tanque recebido antes de definir o valor do tanque
            validateValue("valor do tanque", group, tankValue);
            this.modelOperationalParameters.setTankValue(group, tankValue);
        } catch(NotPostiveNumberException npne) {
            // Se o valor recebido for menor ou igual a zero, lança a exceção NotPostiveNumberException
            throw npne;
        } catch (WithoutPermissionException wpe) {
            // Se o arquivo nao existe e nao ha permissao para cria-lo, lança a exceção WithoutPermissionException
            throw wpe;  
        }
    }

    /**
     * Método que após validar o valor recebido, chama o método setExternalCleaningPrice da classe ModelOperationalParameters (chama validateValue antes de definir o valor da limpeza externa)
     * @param group Grupo do veículo a ter o valor da limpeza externa alterado 
     * @param externalCleaningPrice Valor da limpeza externa a ser alterado
     * @throws NotPostiveNumberException O valor da limpeza externa não é positivo
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void setExternalCleaningPrice(String group, double externalCleaningPrice) throws NotPostiveNumberException, WithoutPermissionException {
        try {
            // Valida o valor da limpeza externa recebido antes de definir o valor da limpeza externa
            validateValue("valor da limpeza externa", group, externalCleaningPrice);
            this.modelOperationalParameters.setExternalCleaningPrice(group, externalCleaningPrice);
        } catch(NotPostiveNumberException npne) {
            // Se o valor recebido for menor ou igual a zero, lança a exceção NotPostiveNumberException
            throw npne;
        } catch (WithoutPermissionException wpe) {
            // Se o arquivo nao existe e nao ha permissao para cria-lo, lança a exceção WithoutPermissionException
            throw wpe;  
        }
    }

    /**
     * Método que após validar o valor recebido, chama o método setInternalCleaningPrice da classe ModelOperationalParameters (chama validateValue antes de definir o valor da limpeza interna)
     * @param group Grupo do veículo a ter o valor da limpeza interna alterado
     * @param internalCleaningPrice Valor da limpeza interna a ser alterado 
     * @throws NotPostiveNumberException O valor da limpeza interna não é positivo
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void setInternalCleaningPrice(String group, double internalCleaningPrice) throws NotPostiveNumberException, WithoutPermissionException {
        try {
            // Valida o valor da limpeza interna recebido antes de definir o valor da limpeza interna
            validateValue("valor da limpeza interna", group, internalCleaningPrice);
            this.modelOperationalParameters.setInternalCleaningPrice(group, internalCleaningPrice);
        } catch(NotPostiveNumberException npne) {
            // Se o valor recebido for menor ou igual a zero, lança a exceção NotPostiveNumberException
            throw npne;
        } catch (WithoutPermissionException wpe) {
            // Se o arquivo nao existe e nao ha permissao para cria-lo, lança a exceção WithoutPermissionException
            throw wpe;  
        }
    }

    /**
     * Método que após validar o valor recebido, chama o método setInsuranceDailyValue da classe ModelOperationalParameters (chama validateValue antes de definir o valor diário do seguro)
     * @param group Grupo do veículo a ter o valor diário do seguro alterado 
     * @param insuranceDailyValue Valor diário do seguro a ser alterado 
     * @throws NotPostiveNumberException O valor diário do seguro não é positivo
     * @throws WithoutPermissionException O arquivo nao existe e nao ha permissao para cria-lo
     */
    public void setInsuranceDailyValue(String group, double insuranceDailyValue) throws NotPostiveNumberException, WithoutPermissionException {
        try {
            // Valida o valor da diária do seguro recebido antes de definir o valor da diária do seguro
            validateValue("valor da diaria da seguro", group, insuranceDailyValue);
            this.modelOperationalParameters.setInsuranceDailyValue(group, insuranceDailyValue);
        } catch(NotPostiveNumberException npne) {
            // Se o valor recebido for menor ou igual a zero, lança a exceção NotPostiveNumberException
            throw npne;
        } catch (WithoutPermissionException wpe) {
            // Se o arquivo nao existe e nao ha permissao para cria-lo, lança a exceção WithoutPermissionException
            throw wpe;  
        }
    }

    /**
     * Valida se o valor recebido é positivo antes de definir o valor de um parâmetro operacional
     * Metodo auxiliar para os metodos setDailyValue, setTankValue, setExternalCleaningPrice, setInternalCleaningPrice e setInsuranceDailyValue
     * @param parameter Nome do parametro a ter seu valor validado
     * @param group Grupo do veiculo
     * @param value Valor a ser validado
     * @throws NotPostiveNumberException O valor nao e positivo
     */
    private void validateValue(String parameter, String group, double value) throws NotPostiveNumberException {
        if(value <= 0) {
            // Se o valor recebido for menor ou igual a zero, lança a exceção NotPostiveNumberException
            throw new NotPostiveNumberException(parameter, group, value);
        }
    }


}
