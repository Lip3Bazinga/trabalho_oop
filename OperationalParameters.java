public class OperationalParameters {

    private String group;
    private double dailyCost;
    private double tankCost;
    private double externalCleaningCost;
    private double internalCleaningCost;
    private double dailyInsuranceCost;

    public OperationalParameters(String group, double dailyCost, double tankCost, double externalCleaningCost, double internalCleaningCost, double dailyInsuranceCost) {
        this.group = group;
        this.dailyCost = dailyCost;
        this.tankCost = tankCost;
        this.externalCleaningCost = externalCleaningCost;
        this.internalCleaningCost = internalCleaningCost;
        this.dailyInsuranceCost = dailyInsuranceCost;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(double dailyCost) {
        this.dailyCost = dailyCost;
    }

    public double getTankCost() {
        return tankCost;
    }

    public void setTankCost(double tankCost) {
        this.tankCost = tankCost;
    }

    public double getExternalCleaningCost() {
        return externalCleaningCost;
    }

    public void setExternalCleaningCost(double externalCleaningCost) {
        this.externalCleaningCost = externalCleaningCost;
    }

    public double getInternalCleaningCost() {
        return internalCleaningCost;
    }

    public void setInternalCleaningCost(double internalCleaningCost) {
        this.internalCleaningCost = internalCleaningCost;
    }

    public double getDailyInsuranceCost() {
        return dailyInsuranceCost;
    }

    public void setDailyInsuranceCost(double dailyInsuranceCost) {
        this.dailyInsuranceCost = dailyInsuranceCost;
    }

    // PRECISA ADD COISA AINDA
    public double totalRentValue(int days, boolean tank, boolean externalCleaning, boolean internalcleaning, boolean insurance) {

        double totalValue = 0;
        totalValue = dailyCost * days;

        if (tank) {
            totalValue += tankCost;
        }

        if (externalCleaning) {
            totalValue += externalCleaningCost;
        }

        if (internalcleaning) {
            totalValue += internalCleaningCost;
        }

        if (insurance) {
            totalValue += dailyInsuranceCost * days;
        }

        return totalValue;
    }

}