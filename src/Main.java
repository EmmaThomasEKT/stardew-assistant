// Stardew Valley Assistant.
// Basic seasonal budgeting for major purchases (seeds, farm animals and buildings)
// Calculate your profit based on animals (high/low heart level), seeds,

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Stardew Assistant!\nPlease select a tool (1/2/3/4):");
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
                    profitCalculator(scanner); // not started
                    break;
                case 3:
                    friendshipTracker(scanner); // not started
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
                        shoppingList(scanner);
                        break;
                    case 5:
                        calculateTotal();
                        break;
                    case 6:
                        budgeting = false;
                        // causes error. try to find way back to main without calling main() ?
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
                        FarmBuildingManager.farmBuildings();
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

        public static void houseUpgrades(Scanner scanner) {
            System.out.println("Under Construction!");
        }

        public static void houseRenovations(Scanner scanner) {
            System.out.println("Under Construction!");
        }

        public static void marnieRanch(Scanner scanner) {
            System.out.println("Under Construction!");
        }

        public static void pierreShop(Scanner scanner) {
            System.out.println("Under Construction!");
        }

        public static void shoppingList(Scanner scanner) {
            // add option to clear list
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
                    //clear the list
                    break;
                case 2:
                    calculateTotal();
                    break;
                case 3:
                    seasonalBudget(scanner);
                    break;
            }
        }

        public static void calculateTotal() {
            // create a hashmap with the string item and integer quanity
            // find a way to combine string items
        }

        public static void profitCalculator(Scanner scanner) {

        }

        public static void friendshipTracker(Scanner scanner) {

        }

    }