import java.io.FileWriter;
import java.util.*;

// dont need a helper since each method is usinf
public class SeedProfitManager {
    public static void seedProfitCalculator(Scanner scanner) {
        System.out.println("Welcome to Seed Profit Calculator\nPlease select a tool below (1/2/3):\n");
        System.out.println("""
                1. Input seeds
                2. Calculate Profit
                3. Return
                """);
        int tool = scanner.nextInt();

        switch (tool){
            case 1:
                inputSeeds(scanner);
                break;
            case 2:
                // calculateProfit(scanner);
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Input.");
        }
    }

    public static boolean inputSeeds(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> seedOptions = Helpers.createSeedStock();
        scanner.nextLine();

        System.out.println("Seeds:\n");
        System.out.println(Helpers.createSeedStock());

        while (true) {

            System.out.println("Enter a seed followed by the quantity, or R to return.\n");
            String seedInput = scanner.nextLine().trim();

            if (seedInput.isEmpty()) {
                System.out.println("Input cannot be empty");
                continue;
            }

            if (seedInput.equalsIgnoreCase("R")) {
                return false;
            }

            Map.Entry<String, Integer> result = Helpers.parseItemAndQuantity(seedInput);
            if (result == null) continue;

            String seedName = result.getKey();
            int quantity = result.getValue();

            if (seedOptions.containsKey(seedName)) {
                BudgetItem.BudgetItemImpl selected = seedOptions.get(seedName);
                System.out.println(seedName + " x" + quantity + " added to your list.");

                // append to SeedList.txt
                Helpers.saveToSeedList(seedName, selected, quantity);
            } else {
                System.out.println("Invalid Input");
            }

        }
    }

   /*     public static boolean calculateProfit(Scanner scanner) {
            // read SeedList.txt
            // do maths (seed price - seed sell price = seed profit
            // output
        }*/
}
