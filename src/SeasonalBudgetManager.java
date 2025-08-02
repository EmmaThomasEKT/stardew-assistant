import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SeasonalBudgetManager {
    public static boolean farmBuildings(Scanner scanner) { // boolean instead of void (automatically true)

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
            String upgradeInput = scanner.nextLine();

            if (upgradeInput.equalsIgnoreCase("R")) {
                return false;
            } else if (houseOptions.containsKey(upgradeInput)) {
                BudgetItem.BudgetItemImpl selected = houseOptions.get(upgradeInput);
                // add selected to user's list
                System.out.println(upgradeInput + " added to your list.");

                try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(upgradeInput + ":\n");
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
            String renoInput = scanner.nextLine();

            if (renoInput.equalsIgnoreCase("R")) {
                return false;
            } else if (houseRenoOptions.containsKey(renoInput)) {
                BudgetItem.BudgetItemImpl selected = houseRenoOptions.get(renoInput);
                // add selected to user's list
                System.out.println(renoInput + " added to your list.");

                try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(renoInput + ":\n");
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
            String livestockInput = scanner.nextLine();

            if (livestockInput.equalsIgnoreCase("R")) {
                return false;
            } else if (livestockOptions.containsKey(livestockInput)) {
                BudgetItem.BudgetItemImpl selected = livestockOptions.get(livestockInput);
                // add selected to user's list
                System.out.println(livestockInput + " added to your list.");

                try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(livestockInput + ":\n");
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
            String petInput = scanner.nextLine();

            if (petInput.equalsIgnoreCase("R")) {
                return false;
            } else if (petAdoptionOptions.containsKey(petInput)) {
                BudgetItem.BudgetItemImpl selected = petAdoptionOptions.get(petInput);

                System.out.println(petInput + " added to your list.");

                try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(petInput + ":\n");
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

    public static boolean yearRoundStock(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> yearRoundOptions = new LinkedHashMap<>();

        yearRoundOptions.put("Cherry Sapling", new GoldOnlyBudgetFormat(3400));
        yearRoundOptions.put("Apricot Sapling", new GoldOnlyBudgetFormat(2000));
        yearRoundOptions.put("Orange Sapling", new GoldOnlyBudgetFormat(4000));
        yearRoundOptions.put("Peach Sapling", new GoldOnlyBudgetFormat(6000));
        yearRoundOptions.put("Pomegranate Sapling", new GoldOnlyBudgetFormat(6000));
        yearRoundOptions.put("Apple Sapling", new GoldOnlyBudgetFormat(4000));

        yearRoundOptions.put("Catalogue", new GoldOnlyBudgetFormat(30000));
        yearRoundOptions.put("Dehydrator (Recipe)", new GoldOnlyBudgetFormat(10000));

        yearRoundOptions.put("Large Pack", new GoldOnlyBudgetFormat(2000));
        yearRoundOptions.put("Deluxe Pack", new GoldOnlyBudgetFormat(10000));

        System.out.println("Here are the available items:\n");
        for (Map.Entry<String, BudgetItem.BudgetItemImpl> entry : yearRoundOptions.entrySet()) {
            System.out.println(entry.getKey() +"\n" + entry.getValue());
        }

        while (true) {

            System.out.println("\nPlease enter the item name to add to your list, or R to return.");
            String itemInput = scanner.nextLine();

            if(itemInput.equalsIgnoreCase("R")) {
                return false;
            }

            String[] parts = itemInput.trim().split(" ");
            if (parts.length < 2) {
                System.out.println("Please enter both item name and quantity (e.g. Parsnip Seeds 20)");
                continue;
            }

            String quantityStr = parts[parts.length -1];
            int quantity;
            try {
                quantity = Integer.parseInt(quantityStr);
                if (quantity <= 0) {
                    System.out.println("Quantity must be a positive number.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a number at the end.");
                continue;
            }

            String itemName = String.join(" ", Arrays.copyOf(parts, parts.length - 1));

            if (yearRoundOptions.containsKey(itemName)) {
                BudgetItem.BudgetItemImpl selected = yearRoundOptions.get(itemName);

                System.out.println(itemName + " x" + quantity + " added to your list.");

                try (FileWriter fw  = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(yearRoundOptions + ":\n");
                    fw.write(" Gold: " + (selected.getGold() * quantity) + "g\n");

                    if (!selected.getMaterials().isEmpty()) {
                        fw.write(" Materials:\n");
                        for (Map.Entry<String, Integer> entry : selected.getMaterials().entrySet()) {
                            fw.write("   - " + entry.getKey() + ": " + (entry.getValue() * quantity) + "\n");
                        }
                    }
                    fw.write("\n");
                    fw.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static boolean springStock(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> springOptions = new LinkedHashMap<>();

        // add quantity mechanism too

        springOptions.put("Parsnip Seeds", new GoldOnlyBudgetFormat(20));
        springOptions.put("Bean Starter", new GoldOnlyBudgetFormat(60));
        springOptions.put("Cauliflower Seeds", new GoldOnlyBudgetFormat(80));

        springOptions.put("Potato Seeds", new GoldOnlyBudgetFormat(50));
        springOptions.put("Tulip Bulb", new GoldOnlyBudgetFormat(20));
        springOptions.put("Kale Seeds", new GoldOnlyBudgetFormat(70));

        springOptions.put("Jazz Seeds", new GoldOnlyBudgetFormat(30));
        springOptions.put("Garlic Seeds", new GoldOnlyBudgetFormat(40));
        springOptions.put("Rice Shoot", new GoldOnlyBudgetFormat(40));

        System.out.println("Here are the available seeds:\n");
        for (Map.Entry<String, BudgetItem.BudgetItemImpl> entry : springOptions.entrySet()) {
            System.out.println(entry.getKey() +"\n" + entry.getValue());
        }

        while (true) {

            System.out.println("Select a seed followed by the quantity, or R to return.");
            String springInput = scanner.nextLine();

            if(springInput.equalsIgnoreCase("R")) {
                return false;
            }

            String[] parts = springInput.trim().split(" ");
            if (parts.length < 2) {
                System.out.println("Please enter both item name and quantity (e.g. Parsnip Seeds 20)");
                continue;
            }

            String quantityStr = parts[parts.length -1];
            int quantity;
            try {
                quantity = Integer.parseInt(quantityStr);
                if (quantity <= 0) {
                    System.out.println("Quantity must be a positive number.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a number at the end.");
                continue;
            }

            String itemName = String.join(" ", Arrays.copyOf(parts, parts.length - 1));

            if (springOptions.containsKey(itemName)) {
                BudgetItem.BudgetItemImpl selected = springOptions.get(itemName);

                System.out.println(itemName + " x" + quantity + " added to your list.");

                try (FileWriter fw  = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(springInput + ":\n");
                    fw.write(" Gold: " + (selected.getGold() * quantity) + "g\n");

                    if (!selected.getMaterials().isEmpty()) {
                        fw.write(" Materials:\n");
                        for (Map.Entry<String, Integer> entry : selected.getMaterials().entrySet()) {
                            fw.write("   - " + entry.getKey() + ": " + (entry.getValue() * quantity) + "\n");
                        }
                    }
                    fw.write("\n");
                    fw.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static boolean summerStock(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> summerOptions = new LinkedHashMap<>();

        // add quantity mechanism too

        summerOptions.put("Melon Seeds", new GoldOnlyBudgetFormat(80));
        summerOptions.put("Tomato Seeds", new GoldOnlyBudgetFormat(50));
        summerOptions.put("Blueberry Seeds", new GoldOnlyBudgetFormat(80));

        summerOptions.put("Pepper Seeds", new GoldOnlyBudgetFormat(40));
        summerOptions.put("Wheat Seeds", new GoldOnlyBudgetFormat(10));
        summerOptions.put("Radish Seeds", new GoldOnlyBudgetFormat(40));

        summerOptions.put("Poppy Seeds", new GoldOnlyBudgetFormat(100));
        summerOptions.put("Spangle Seeds", new GoldOnlyBudgetFormat(50));
        summerOptions.put("Hops Starer", new GoldOnlyBudgetFormat(60));

        summerOptions.put("Corn Seeds", new GoldOnlyBudgetFormat(150));
        summerOptions.put("Sunflower Seeds", new GoldOnlyBudgetFormat(200));
        summerOptions.put("Red Cabbage Seeds", new GoldOnlyBudgetFormat(100));

        System.out.println("Here are the available seeds:\n");
        for (Map.Entry<String, BudgetItem.BudgetItemImpl> entry : summerOptions.entrySet()) {
            System.out.println(entry.getKey() +"\n" + entry.getValue());
        }

        while (true) {

            System.out.println("Select a seed followed by the quantity, or R to return.");
            String summerInput = scanner.nextLine();

            if(summerInput.equalsIgnoreCase("R")) {
                return false;
            }

            String[] parts = summerInput.trim().split(" ");
            if (parts.length < 2) {
                System.out.println("Please enter both item name and quantity (e.g. Melon Seeds 20)");
                continue;
            }

            String quantityStr = parts[parts.length -1];
            int quantity;
            try {
                quantity = Integer.parseInt(quantityStr);
                if (quantity <= 0) {
                    System.out.println("Quantity must be a positive number.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a number at the end.");
                continue;
            }

            String itemName = String.join(" ", Arrays.copyOf(parts, parts.length - 1));

            if (summerOptions.containsKey(itemName)) {
                BudgetItem.BudgetItemImpl selected = summerOptions.get(itemName);

                System.out.println(itemName + " x" + quantity + " added to your list.");

                try (FileWriter fw  = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(summerInput + ":\n");
                    fw.write(" Gold: " + (selected.getGold() * quantity) + "g\n");

                    if (!selected.getMaterials().isEmpty()) {
                        fw.write(" Materials:\n");
                        for (Map.Entry<String, Integer> entry : selected.getMaterials().entrySet()) {
                            fw.write("   - " + entry.getKey() + ": " + (entry.getValue() * quantity) + "\n");
                        }
                    }
                    fw.write("\n");
                    fw.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static boolean fallStock(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> fallOptions = new LinkedHashMap<>();

        // add quantity mechanism too

        fallOptions.put("Eggplant Seeds", new GoldOnlyBudgetFormat(20));
        fallOptions.put("Corn", new GoldOnlyBudgetFormat(225));
        fallOptions.put("Pumpkin Seeds", new GoldOnlyBudgetFormat(100));

        fallOptions.put("Bokchoy Seeds", new GoldOnlyBudgetFormat(50));
        fallOptions.put("Yam Seeds", new GoldOnlyBudgetFormat(60));
        fallOptions.put("Cranberry Seeds", new GoldOnlyBudgetFormat(240));

        fallOptions.put("Sunflower Seeds", new GoldOnlyBudgetFormat(100));
        fallOptions.put("Fairy Seeds", new GoldOnlyBudgetFormat(50));
        fallOptions.put("Amaranth Starer", new GoldOnlyBudgetFormat(60));

        fallOptions.put("Grape Starter", new GoldOnlyBudgetFormat(150));
        fallOptions.put("Wheat Seeds", new GoldOnlyBudgetFormat(10));
        fallOptions.put("Artichoke Seeds", new GoldOnlyBudgetFormat(100));

        System.out.println("Here are the available seeds:\n");
        for (Map.Entry<String, BudgetItem.BudgetItemImpl> entry : fallOptions.entrySet()) {
            System.out.println(entry.getKey() +"\n" + entry.getValue());
        }

        while (true) {

            System.out.println("Select a seed followed by the quantity, or R to return.");
            String fallInput = scanner.nextLine();

            if(fallInput.equalsIgnoreCase("R")) {
                return false;
            }

            String[] parts = fallInput.trim().split(" ");
            if (parts.length < 2) {
                System.out.println("Please enter both item name and quantity (e.g. Eggplant Seeds 20)");
                continue;
            }

            String quantityStr = parts[parts.length -1];
            int quantity;
            try {
                quantity = Integer.parseInt(quantityStr);
                if (quantity <= 0) {
                    System.out.println("Quantity must be a positive number.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a number at the end.");
                continue;
            }

            String itemName = String.join(" ", Arrays.copyOf(parts, parts.length - 1));

            if (fallOptions.containsKey(itemName)) {
                BudgetItem.BudgetItemImpl selected = fallOptions.get(itemName);

                System.out.println(itemName + " x" + quantity + " added to your list.");

                try (FileWriter fw  = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(fallInput + ":\n");
                    fw.write(" Gold: " + (selected.getGold() * quantity) + "g\n");

                    if (!selected.getMaterials().isEmpty()) {
                        fw.write(" Materials:\n");
                        for (Map.Entry<String, Integer> entry : selected.getMaterials().entrySet()) {
                            fw.write("   - " + entry.getKey() + ": " + (entry.getValue() * quantity) + "\n");
                        }
                    }
                    fw.write("\n");
                    fw.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}
