import java.io.*;
import java.util.*;

// dont need a helper since each method is usinf
public class SeedProfitManager {

    private final SeedRepo repository;
    private final Map<String, SeedInfo> seedData;

    public SeedProfitManager(SeedRepo repository, Map<String, SeedInfo> seedData) {
        this.repository = repository;
        this.seedData = seedData;
    }

    // UI
    public void runMenu(Scanner scanner) {
        System.out.println("Welcome to Seed Profit Calculator\nPlease select a tool below (1/2/3):\n");
        System.out.println("""
                1. View/Clear Seed List
                2. Input Seeds
                3. Calculate Profit
                4. Return
                """);
        int tool = scanner.nextInt();
        scanner.nextLine();

        switch (tool){
            case 1:
                editSeedList(scanner);
                break;
            case 2:
                inputSeeds(scanner);
                break;
            case 3:
                calculateProfitUI();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid Input.");
        }
    }

    // UI Helpers
    public void editSeedList(Scanner scanner) {
        List<String> seeds = repository.loadSeedList();
        if (seeds.isEmpty()) {
            System.out.println("Your seed list is empty!");
        } else {
            System.out.println("--- Seed List ---");
            seeds.forEach(System.out::println);
        }

        System.out.println("Press C to clear or R to return.");
        String input = scanner.nextLine().trim();
        if (input.equalsIgnoreCase("C")) {
            repository.clearSeedList();
            System.out.println("Your seed list has been successfully cleared.");
        }
    }

    public void inputSeeds(Scanner scanner) {
        Helpers.printOptions(Helpers.createSeedStock());

        while (true) {
            System.out.println("Enter a seed followed by the quantity, or R to return.\n");
            String seedInput = scanner.nextLine().trim();

            if (seedInput.equalsIgnoreCase("R")) break;
            if (seedInput.isEmpty()) {
                System.out.println("Input cannot be empty");
                continue;
            }

            Map.Entry<String, Integer> result = Helpers.parseItemAndQuantity(seedInput);
            if (result == null) continue;

            String seedName = result.getKey();
            int quantity = result.getValue();

            if (seedData.containsKey(seedName)) {
                repository.addSeed(seedName, quantity);
                System.out.println(seedName + " x" + quantity + " added to your list.");
            } else {
                System.out.println("Invalid Input");
            }

        }
    }

    public void calculateProfitUI() {
        Map<String, Integer> seeds = repository.getSeedQuantities();
        int profit = calculateProfit(seeds);
        System.out.println("Seasonal Profit Estimate: " + profit);
    }

    // core logic
    public int calculateProfit(Map<String, Integer> seedQuantities) {
        int totalProfit = 0;
        for (var entry : seedQuantities.entrySet()) {
            SeedInfo info = seedData.get(entry.getKey());
            if (info != null) {
                totalProfit += info.profit + entry.getValue();
            }
        }
        return totalProfit;
    }
}
