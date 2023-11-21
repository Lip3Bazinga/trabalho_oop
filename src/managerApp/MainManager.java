package managerApp;

import java.util.Scanner;

import managerApp.managerModel.ModelOperationalParameters;
import managerApp.managerExceptions.WithoutPermissionException;

public class MainManager {
    public static void main(String args[]) {

        ModelOperationalParameters mop = new ModelOperationalParameters();
        Scanner sc = new Scanner(System.in);
        double d;

        try {
            System.out.println(mop.getExternalCleaningPrice("Basico"));
            sc.nextLine();
            System.out.println(mop.getDailyValue("Padrao"));
            sc.nextLine();
            d = sc.nextDouble();
            mop.setExternalCleaningPrice("Premium", d);
            System.out.println("PASSEI");
            System.out.println(mop.getExternalCleaningPrice("Premium"));
        } catch(WithoutPermissionException e) {
            System.err.println("ERRO");
        } finally {
            sc.close();
        }
    }
}
