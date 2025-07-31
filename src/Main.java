// Stardew Valley Assistant.
// 3 Functions

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Stardew Assistant!\nHere are the available tools:");
            System.out.println("""
                            1. Seasonal Budget Planner
                            2. Profit Calculator
                            3. Friendship Point Tracker
                            4. Quit
                            """);
            System.out.println("Please select a tool (1/2/3/4): ");
            int tool = scanner.nextInt();

            switch (tool) {
                case 1:
                    seasonalBudget(scanner);
                    break;
                case 2:
                    profitCalculator(scanner);
                    break;
                case 3:
                    friendshipTracker(scanner);
                    break;
                case 4:
                    System.out.println("Thanks for using Stardew Assistant!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        }

        scanner.close();

        }

        public static void seasonalBudget(Scanner scanner) {
            boolean budgeting = true;

            while (budgeting) {
                System.out.println("""
                            Welcome to your seasonal budget.
                            Please select a shop to begin your shopping list:
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
                        pierreShop(scanner);
                        break;
                    case 4:
                        shoppingList();
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
                System.out.println("Welcome to the Carpenter's shop! Please select a category below.");
                System.out.println("""
                        1. Farm Buildings
                        2. House Upgrades
                        3. House Renovations
                        4. Return
                        """);
                int category = scanner.nextInt();

                switch (category) {
                    case 1:
                        farmBuildings(scanner);
                        break;
                    case 2:
                        houseUpgrades(scanner);
                        break;
                    case 3:
                        houseRenovations(scanner);
                        break;
                    case 4:
                        carpenter = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

        }

        public static void farmBuildings(Scanner scanner) {

            Map<String, Integer> barnMaterials = new HashMap<>();
            barnMaterials.put("Wood", 350);
            barnMaterials.put("Stone", 150);
            FarmBuildings barn = new FarmBuildings(6000, barnMaterials);


            System.out.println("Here are the available farm buildings: ");
            System.out.println("Barn:\n" + barn);

            System.out.println("Please select building/s to add to your shopping list: ");
            String building = scanner.nextLine();

            switch (building) {

            }

            try {
                FileWriter fw = new FileWriter("ShoppingList.txt", true); // true for append mode
                // ...
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public static void houseUpgrades(Scanner scanner) {

        }

        public static void houseRenovations(Scanner scanner) {

        }

        public static void marnieRanch(Scanner scanner) {

        }

        public static void pierreShop(Scanner scanner) {

        }

        public static void shoppingList() {

        }

        public static void calculateTotal() {

        }

        public static void profitCalculator(Scanner scanner) {

        }

        public static void friendshipTracker(Scanner scanner) {

        }

    }