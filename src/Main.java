// Stardew Valley Assistant.
// Basic seasonal budgeting for major purchases (seeds, farm animals and buildings)
// Calculate your profit based on animals (high/low heart level), seeds,

// CURRENT ISSUES:
//      printing "invalid input" when printing stock options
//      no lowercase/catch options for inputs
//      inconsistencies when printing stock options

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Stardew Assistant!\nPlease select a tool (1/2/3/4):");
            System.out.println("""
                            1. Seasonal Budget Planner
                            2. Quit
                            """);
            System.out.println("Please select a tool (1/2): ");
            int tool = scanner.nextInt();

            if (tool == 1) {
                seasonalBudget(scanner);
            } else if (tool == 2) {
                System.out.println("Thanks for using Stardew Assistant!");
                running = false;
            } else {
                System.out.println("Invalid Choice.");
            }
        }
        scanner.close();
    }

    public static void seasonalBudget(Scanner scanner) {
        boolean budgeting = true;

        while (budgeting) {
            System.out.println("""
                        Welcome to seasonal budget.
                        Please select a shop or tool to begin your seasonal budget:
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
                    calculateTotal();
                    break;
                case 6:
                    budgeting = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void carpenterShop(Scanner scanner) {
        boolean carpenter = true;

        while (carpenter) {
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
    }

    public static void marnieRanch(Scanner scanner) {

    System.out.println("Welcome to Marnie's Ranch! Please select a category from below:\n");
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
                System.out.println("--- Shhopping List ---\n");
                do {
                    System.out.println(line);
                    line = br.readLine();
                } while (line != null);
            } else {
                System.out.println("Your shopping list is empty!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please select an option from below (1/2/3):\n" +
                            """
                                1. Clear List
                                2. Calculate Total
                                3. Return to Seasonal Budget Menu
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
                calculateTotal();
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

    public static void calculateTotal() {
        // create a hashmap with the string item and integer quanity
        // find a way to combine string items
    }
}