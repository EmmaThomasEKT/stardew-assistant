import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenuManager {

    public static boolean mainMenu(Scanner scanner) {
        while (true) {
            System.out.println("Welcome to Stardew Assistant!\n");
            System.out.println("""
                            1. Seasonal Budget Planner
                            2. Seed Profit Calculator
                            3. Quit
                            """);
            System.out.println("Please select a tool (1/2): ");
            int tool = scanner.nextInt();

            if (tool == 1) {
                seasonalBudgetTool(scanner);
            } else if (tool == 2) {
                SeedProfitManager.seedProfitCalculator(scanner);
            } else if (tool == 3) {
                System.out.println("Thanks for using Stardew Assistant!");
                System.exit(0);
            } else {
                System.out.println("Invalid Choice.");
            }
        }
    }

    public static boolean seasonalBudgetTool(Scanner scanner) {
        while (true) {
            System.out.println("""
                        Welcome to seasonal budget.
                        Please select a shop or tool to begin:
                        1. Carpenter's Shop
                        2. Marnie's Ranch
                        3. Pierre's Shop
                        4. View Shopping List
                        5. Calculate Total
                        6. Return
                        """);
            int shop = scanner.nextInt();

            switch (shop) {
                case 1:
                    carpenterShop(scanner);
                    break;
                case 2:
                    marnieRanch(scanner);
                    break;
                case 3:
                    pierresShop(scanner);
                    break;
                case 4:
                    shoppingList(scanner);
                    break;
                case 5:
                    calculateTotal(scanner);
                    break;
                case 6:
                    return false;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void carpenterShop(Scanner scanner) {
        System.out.println("Welcome to the Carpenter's shop! Please select a category below.\n");
        System.out.println("""
                    1. Farm Buildings
                    2. House Upgrades
                    3. House Renovations
                    4. Return
                    """);
        int category = scanner.nextInt();
        scanner.nextLine();

        switch (category) {
            case 1:
                SeasonalBudgetManager.farmBuildings(scanner);
                break;
            case 2:
                SeasonalBudgetManager.houseUpgrades(scanner);
                break;
            case 3:
                SeasonalBudgetManager.houseRenovations(scanner);
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void marnieRanch(Scanner scanner) {

        System.out.println("Welcome to Marnie's Ranch! Please select a category (1/2/3):\n");
        System.out.println("""
                1. Livestock
                2. Pet Adoption
                3. Return
                """);
        int category = scanner.nextInt();
        scanner.nextLine();

        switch (category) {
            case 1:
                SeasonalBudgetManager.livestock(scanner);
                break;
            case 2:
                SeasonalBudgetManager.petAdoption(scanner);
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Choice.");
        }
    }

    public static void shoppingList(Scanner scanner) {

        try (BufferedReader br = new BufferedReader(new FileReader("ShoppingList.txt"))) {
            String line = br.readLine();

            if (line != null) {
                System.out.println("--- Shopping List ---\n");
                do {
                    System.out.println(line);
                    line = br.readLine();
                } while (line != null);
            } else {
                System.out.println("Your shopping list is empty!");
            }

        } catch (IOException e) {
            e.printStackTrace(); // control what happens when exceptions occur: use a logging framework
        }

        System.out.println("Please select an option from below (1/2/3):\n" +
                """
                    1. Clear List
                    2. Calculate Total
                    3. Return
                    """);
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                try {
                    // print writer overwrites the file
                    PrintWriter writer = new PrintWriter("ShoppingList.txt");
                    // writing empty string to the file
                    writer.print("");
                    // close the writer to ensure all changes are written and resources are released
                    writer.close();
                    System.out.println("Your shopping list has been successfully cleared");
                } catch (FileNotFoundException e) {
                    System.err.println("Error: File not found");
                }
                break;
            case 2:
                calculateTotal(scanner);
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Choice.");
        }
    }

    public static void pierresShop(Scanner scanner) {

        System.out.println("Welcome to Pierre's Shop! Please select a category (1/2/3/4/5):\n");
        System.out.println("""
                1. Year-Round Stock
                2. Spring Stock
                3. Summer Stock
                4. Autumn Stock
                5. Return
                """);
        int category = scanner.nextInt();
        scanner.nextLine();

        switch (category) {
            case 1:
                SeasonalBudgetManager.yearRoundStock(scanner);
                break;
            case 2:
                SeasonalBudgetManager.springStock(scanner);
                break;
            case 3:
                SeasonalBudgetManager.summerStock(scanner);
                break;
            case 4:
                SeasonalBudgetManager.fallStock(scanner);
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid Choice.");
        }
    }

    public static boolean calculateTotal(Scanner scanner) {
        // read through ShoppingList.txt
        System.out.println("--- Calculate Total ---");

        int totalGold = 0;
        Map<String, Integer> materialTotals = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("ShoppingList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                //Gold line : "Gold: 100g"
                if (line.startsWith("Gold: ")) {
                    String goldStr = line.substring(6, line.length() - 1); // remove " Gold: " and "g"
                    int gold = Integer.parseInt(goldStr.trim());
                    totalGold += gold;


                    // Material line: "- Wood: 10"
                } else if (line.startsWith("-")) {
                    String[] parts = line.substring(2).split(":"); // remove "- ", then split
                    if (parts.length == 2) {
                        String material = parts[0].trim();
                        int amount = Integer.parseInt(parts[1].trim());

                        materialTotals.put(material, materialTotals.getOrDefault(material, 0) + amount);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // after parsing: printing totals:
        System.out.println("Total Gold: " + totalGold + "g");
        System.out.println("Total Materials:");
        for (Map.Entry<String, Integer> entry : materialTotals.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }

        scanner.nextLine();

        while (true) {
            System.out.println("\nThank you for using Stardew Assistant. Would you like to continue (y/n)?:\n");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("y")) {
                return false;
            } else if (input.equalsIgnoreCase("n")) {
                System.exit(0);
            } else {
                System.out.println("Invalid Choice.");
            }
        }
    }
}
