import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SeasonalBudgetManager {
    public static boolean farmBuildings(Scanner scanner) {
        boolean farmBuildingShop = true;

        Map<String, BudgetItem.BudgetItemImpl> buildingOptions = new LinkedHashMap<>();

        buildingOptions.put("Barn", new SeasonalBudgetFormat(6000, Map.of("Wood", 350, "Stone", 150)));
        buildingOptions.put("Big Barn", new SeasonalBudgetFormat(12000, Map.of("Wood", 450, "Stone", 200)));
        buildingOptions.put("Deluxe Barn", new SeasonalBudgetFormat(25000, Map.of("Wood", 550, "Stone", 300)));

        buildingOptions.put("Coop", new SeasonalBudgetFormat(4000, Map.of("Wood", 300, "Stone", 100)));
        buildingOptions.put("Big Coop", new SeasonalBudgetFormat(10000, Map.of("Wood", 400, "Stone", 150)));
        buildingOptions.put("Deluxe Coop", new SeasonalBudgetFormat(20000, Map.of("Wood", 500, "Stone", 200)));

        buildingOptions.put("Fish Pond", new SeasonalBudgetFormat(5000, Map.of("Stone", 200, "Seaweed", 5, "Green Algae", 5)));
        buildingOptions.put("Mill", new SeasonalBudgetFormat(2500, Map.of("Wood", 150, "Stone", 50, "Cloth", 4)));
        buildingOptions.put("Shed", new SeasonalBudgetFormat(15000, Map.of("Wood", 300)));

        buildingOptions.put("Big Shed", new SeasonalBudgetFormat(20000, Map.of("Wood", 550, "Stone", 300)));
        buildingOptions.put("Silo", new SeasonalBudgetFormat(100, Map.of("Stone", 100, "Clay", 10, "Copper Bar", 5)));
        buildingOptions.put("Slime Hutch", new SeasonalBudgetFormat(10000, Map.of("Stone", 500, "Refined Quartz", 10, "Iridium Bar", 1)));
        buildingOptions.put("Stable", new SeasonalBudgetFormat(10000, Map.of("Hardwood", 100, "Iron Bar", 5)));

        buildingOptions.put("Well", new SeasonalBudgetFormat(1000, Map.of("Stone", 75)));
        buildingOptions.put("Cabin", new GoldOnlyBudgetFormat(100));
        buildingOptions.put("Shipping Bin", new SeasonalBudgetFormat(250, Map.of("Wood", 150)));
        buildingOptions.put("Pet Bowl", new SeasonalBudgetFormat(5000, Map.of("Hardwood", 25)));

        System.out.println("Here are the available farm buildings:\n");
        for (Map.Entry<String, BudgetItem.BudgetItemImpl> entry : buildingOptions.entrySet()) {
            System.out.println(entry.getKey() + ":\n" + entry.getValue());
        }

        while (true) {

            System.out.println("\nEnter building name to add to your list, or R to return to the Carpenter's Shop:");
            String buildingInput = scanner.nextLine();

            if (buildingInput.equalsIgnoreCase("R")) {
                return false;
            } else if (buildingOptions.containsKey(buildingInput)) {
                BudgetItem.BudgetItemImpl selected = buildingOptions.get(buildingInput);
                // add selected to user's list
                System.out.println(buildingInput + " added to your list.");

                try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(buildingInput + ":\n");
                    fw.write(" Gold: " + selected.getGold() + "g\n");

                    if (!selected.getMaterials().isEmpty()) {
                        fw.write(" Materials:\n");
                        for (Map.Entry<String, Integer> entry : selected.getMaterials().entrySet()) {
                            fw.write("   - " + entry.getKey() + ": " + entry.getValue() + "\n");
                        }
                    }
                    fw.write("\n");
                    fw.close();

                } catch(IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static boolean houseUpgrades(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> houseOptions = new LinkedHashMap<>();

        houseOptions.put("Kitchen", new SeasonalBudgetFormat(10000, Map.of("Wood", 450)));
        houseOptions.put("Crib", new SeasonalBudgetFormat(65000, Map.of("Hardwood", 100)));
        houseOptions.put("Basement", new GoldOnlyBudgetFormat(100000));

        System.out.println("Here are the available house upgrades:\n");
        for (Map.Entry<String, BudgetItem.BudgetItemImpl> entry : houseOptions.entrySet()) {
            System.out.println(entry.getKey() + ":\n" + entry.getValue());
        }

        while (true) {

            System.out.println("\nEnter the upgrade name to add to your list, or R to return to the Carpenter's Shop:");
            String buildingInput = scanner.nextLine();

            if (buildingInput.equalsIgnoreCase("R")) {
                return false;
            } else if (houseOptions.containsKey(buildingInput)) {
                BudgetItem.BudgetItemImpl selected = houseOptions.get(buildingInput);
                // add selected to user's list
                System.out.println(buildingInput + " added to your list.");

                try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(buildingInput + ":\n");
                    fw.write(" Gold: " + selected.getGold() + "g\n");

                    if (!selected.getMaterials().isEmpty()) {
                        fw.write(" Materials:\n");
                        for (Map.Entry<String, Integer> entry : selected.getMaterials().entrySet()) {
                            fw.write("   - " + entry.getKey() + ": " + entry.getValue() + "\n");
                        }
                    }
                    fw.write("\n");
                    fw.close();

                } catch(IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static boolean houseRenovations(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> houseRenoOptions = new LinkedHashMap<>();

        houseRenoOptions.put("Open Bedroom", new GoldOnlyBudgetFormat(10000));
        houseRenoOptions.put("Add Southern Room", new GoldOnlyBudgetFormat(30000));
        houseRenoOptions.put("Add Corner Room", new GoldOnlyBudgetFormat(20000));

        houseRenoOptions.put("Add Dining Room", new GoldOnlyBudgetFormat(150000));
        houseRenoOptions.put("Add Cubby", new GoldOnlyBudgetFormat(10000));
        houseRenoOptions.put("Add Attic", new GoldOnlyBudgetFormat(60000));

        houseRenoOptions.put("Expand Corner Room", new GoldOnlyBudgetFormat(100000));
        houseRenoOptions.put("Open Dining Room", new GoldOnlyBudgetFormat(10000));

        System.out.println("Here are the available house renovations:\n");
        for (Map.Entry<String, BudgetItem.BudgetItemImpl> entry : houseRenoOptions.entrySet()) {
            System.out.println(entry.getKey() + ":\n" + entry.getValue());
        }

        while (true) {

            System.out.println("\nEnter the renovation name to add to your list, or R to return to the Carpenter's Shop:");
            String buildingInput = scanner.nextLine();

            if (buildingInput.equalsIgnoreCase("R")) {
                return false;
            } else if (houseRenoOptions.containsKey(buildingInput)) {
                BudgetItem.BudgetItemImpl selected = houseRenoOptions.get(buildingInput);
                // add selected to user's list
                System.out.println(buildingInput + " added to your list.");

                try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(buildingInput + ":\n");
                    fw.write(" Gold: " + selected.getGold() + "g\n");

                    if (!selected.getMaterials().isEmpty()) {
                        fw.write(" Materials:\n");
                        for (Map.Entry<String, Integer> entry : selected.getMaterials().entrySet()) {
                            fw.write("   - " + entry.getKey() + ": " + entry.getValue() + "\n");
                        }
                    }
                    fw.write("\n");
                    fw.close();

                } catch(IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid selection.");
            }

        }
    }

    public static boolean livestock(Scanner scanner) {
        Map<String, BudgetItem.BudgetItemImpl> livestockOptions = new LinkedHashMap<>();

        livestockOptions.put("Chicken", new GoldOnlyBudgetFormat(800));
        livestockOptions.put("Cow", new GoldOnlyBudgetFormat(1500));
        livestockOptions.put("Goat", new GoldOnlyBudgetFormat(4000));

        livestockOptions.put("Duck", new GoldOnlyBudgetFormat(1200));
        livestockOptions.put("Sheep", new GoldOnlyBudgetFormat(8000));
        livestockOptions.put("Rabbit", new GoldOnlyBudgetFormat(8000));
        livestockOptions.put("Pig", new GoldOnlyBudgetFormat(16000));

        System.out.println("Here are the available livestock:\n");
        for (Map.Entry<String, BudgetItem.BudgetItemImpl> entry : livestockOptions.entrySet()) {
            System.out.println(entry.getKey() + ":\n" + entry.getValue());
        }

        while (true) {

            System.out.println("\nEnter the livestock name to add to your list, or R to return:");
            String buildingInput = scanner.nextLine();

            if (buildingInput.equalsIgnoreCase("R")) {
                return false;
            } else if (livestockOptions.containsKey(buildingInput)) {
                BudgetItem.BudgetItemImpl selected = livestockOptions.get(buildingInput);
                // add selected to user's list
                System.out.println(buildingInput + " added to your list.");

                try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(buildingInput + ":\n");
                    fw.write(" Gold: " + selected.getGold() + "g\n");

                    if (!selected.getMaterials().isEmpty()) {
                        fw.write(" Materials:\n");
                        for (Map.Entry<String, Integer> entry : selected.getMaterials().entrySet()) {
                            fw.write("   - " + entry.getKey() + ": " + entry.getValue() + "\n");
                        }
                    }
                    fw.write("\n");
                    fw.close();

                } catch(IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static boolean petAdoption(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> petAdoptionOptions = new LinkedHashMap<>();

        petAdoptionOptions.put("Cat", new GoldOnlyBudgetFormat(40000));
        petAdoptionOptions.put("Dog", new GoldOnlyBudgetFormat(40000));
        petAdoptionOptions.put("Turtle", new GoldOnlyBudgetFormat(60000));
        petAdoptionOptions.put("Special Turtle", new GoldOnlyBudgetFormat(500000));

        System.out.println("Here are the available pets:\n");
        for (Map.Entry<String, BudgetItem.BudgetItemImpl> entry : petAdoptionOptions.entrySet()) {
            System.out.println(entry.getKey() + ":\n" + entry.getValue());
        }

        while (true) {

            System.out.println("\nEnter the pet name to add to your list, or R to return to Marnie's Ranch:");
            String buildingInput = scanner.nextLine();

            if (buildingInput.equalsIgnoreCase("R")) {
                return false;
            } else if (petAdoptionOptions.containsKey(buildingInput)) {
                BudgetItem.BudgetItemImpl selected = petAdoptionOptions.get(buildingInput);

                System.out.println(buildingInput + " added to your list.");

                try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(buildingInput + ":\n");
                    fw.write(" Gold: " + selected.getGold() + "g\n");

                    if (!selected.getMaterials().isEmpty()) {
                        fw.write(" Materials:\n");
                        for (Map.Entry<String, Integer> entry : selected.getMaterials().entrySet()) {
                            fw.write("   - " + entry.getKey() + ": " + entry.getValue() + "\n");
                        }
                    }
                    fw.write("\n");
                    fw.close();

                } catch(IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }
}
