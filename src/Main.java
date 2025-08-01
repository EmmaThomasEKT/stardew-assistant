// Stardew Valley Assistant.
// Basic seasonal budgeting for major purchases (seeds, farm animals and buildings)
// Calculate your profit based on animals (high/low heart level), seeds,

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
                        return;
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
                        FarmBuildingManager.farmBuildings(scanner);
                        break;
                    case 2:
                        FarmBuildingManager.houseUpgrades(scanner);
                        break;
                    case 3:
                        houseRenovations(scanner);
                        break;
                    case 4:
                        return;
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

        public static void calculateTotal() {
            // create a hashmap with the string item and integer quanity
            // find a way to combine string items
        }

        public static void profitCalculator(Scanner scanner) {

        }

        public static void friendshipTracker(Scanner scanner) {

        }

    }