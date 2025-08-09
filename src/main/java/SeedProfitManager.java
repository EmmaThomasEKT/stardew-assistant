import java.io.*;
import java.util.*;

// dont need a helper since each method is usinf
public class SeedProfitManager {
    public static void seedProfitCalculator(Scanner scanner) {
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
                calculateProfit(scanner);
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid Input.");
        }
    }

    public static void editSeedList(Scanner scanner) {
        // read the file
        try (BufferedReader br = new BufferedReader(new FileReader("SeedList.txt"))) {
            String line = br.readLine();

            if (line != null) {
                System.out.println("---Seed List---");
                do {
                    System.out.println(line);
                    line = br.readLine();
                } while (line != null);
            } else {
                System.out.println("Your seed list is empty!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Press C to clear or R to return.");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("C")) {
            try (PrintWriter writer = new PrintWriter("SeedList.txt")) {
                writer.print("");
                writer.close();
                System.out.println("Your seed list has been successfuly cleared.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (input.equalsIgnoreCase("R")) {
            return;
        } else {
            System.out.println("Invalid Input.");
        }
    }

    public static boolean inputSeeds(Scanner scanner) {

        Map<String, SeedInfo> seedData = SeedDatabase.seedData;

        System.out.println("Seeds:\n");
        System.out.println(SeedDatabase.seedData);

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

            if (seedData.containsKey(seedName)) {
                SeedInfo selected = seedData.get(seedName);
                System.out.println(seedName + " x" + quantity + " added to your list.");

                // append to SeedList.txt
                Helpers.saveToSeedList(seedName, quantity);
            } else {
                System.out.println("Invalid Input");
            }

        }
    }

    public static boolean calculateProfit(Scanner scanner) {
        int totalProfit = 0;


        try (BufferedReader br = new BufferedReader(new FileReader("SeedList.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Skip empty lines
                line = line.trim();
                if (line.isEmpty()) continue;

                // Split line into seedName and quantity
                String[] parts = line.split("\\s+");
                if (parts.length < 2) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }

                String seedName = String.join(" ", Arrays.copyOf(parts, parts.length - 1));

                int quantity;
                try {
                    quantity = Integer.parseInt(parts[parts.length -1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid quantity for seed: " + seedName);
                    continue;
                }

                // Look up seed info
                SeedInfo info = SeedDatabase.seedData.get(seedName);

                if (info != null) {
                    int profitForThisSeed = info.profit * quantity;
                    totalProfit += profitForThisSeed;
                    System.out.printf("%s x%d = %d profit%n", seedName, quantity, profitForThisSeed);
                } else {
                    System.out.println("Unknown seed: " + seedName);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Seasonal Profit Estimate: " + totalProfit);
        return true;
    }
}
