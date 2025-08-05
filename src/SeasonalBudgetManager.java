import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SeasonalBudgetManager {
    public static boolean farmBuildings(Scanner scanner) { // boolean instead of void (automatically true)

        Map<String, BudgetItem.BudgetItemImpl> buildingOptions = SeasonalBudgetHelpers.createFarmBuildingOptions();

        System.out.println("Here are the available farm buildings:\n");
        SeasonalBudgetHelpers.printOptions(buildingOptions);

        while (true) {

            System.out.println("\nEnter building name to add to your list, or R to return to the Carpenter's Shop:");
            String buildingInput = scanner.nextLine();

            if (buildingInput.equalsIgnoreCase("R")) {
                return false;
            } else if (buildingOptions.containsKey(buildingInput)) {
                BudgetItem.BudgetItemImpl selected = buildingOptions.get(buildingInput);
                // add selected to user's list
                System.out.println(buildingInput + " added to your list.");
                SeasonalBudgetHelpers.saveToShoppingList(buildingInput, selected, 1);
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static boolean houseUpgrades(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> houseOptions = SeasonalBudgetHelpers.createHouseUpgradeOptions();

        System.out.println("Here are the available house upgrades:\n");
        SeasonalBudgetHelpers.printOptions(houseOptions);

        while (true) {

            System.out.println("\nEnter the upgrade name to add to your list, or R to return to the Carpenter's Shop:");
            String upgradeInput = scanner.nextLine();

            if (upgradeInput.equalsIgnoreCase("R")) {
                return false;
            } else if (houseOptions.containsKey(upgradeInput)) {
                BudgetItem.BudgetItemImpl selected = houseOptions.get(upgradeInput);
                // add selected to user's list
                System.out.println(upgradeInput + " added to your list.");
                SeasonalBudgetHelpers.saveToShoppingList(upgradeInput, selected, 1);
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static boolean houseRenovations(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> houseRenoOptions = SeasonalBudgetHelpers.createHouseRenoOptions();

        System.out.println("Here are the available house renovations:\n");
        SeasonalBudgetHelpers.printOptions(houseRenoOptions);

        while (true) {

            System.out.println("\nEnter the renovation name to add to your list, or R to return to the Carpenter's Shop:");
            String renoInput = scanner.nextLine();

            if (renoInput.equalsIgnoreCase("R")) {
                return false;
            } else if (houseRenoOptions.containsKey(renoInput)) {
                BudgetItem.BudgetItemImpl selected = houseRenoOptions.get(renoInput);
                // add selected to user's list
                System.out.println(renoInput + " added to your list.");
                SeasonalBudgetHelpers.saveToShoppingList(renoInput, selected, 1);
            } else {
                System.out.println("Invalid selection.");
            }

        }
    }

    public static boolean livestock(Scanner scanner) {
        Map<String, BudgetItem.BudgetItemImpl> livestockOptions = SeasonalBudgetHelpers.createLivestockOptions();

        System.out.println("Here are the available livestock:\n");
        SeasonalBudgetHelpers.printOptions(livestockOptions);

        while (true) {

            System.out.println("\nEnter the livestock name to add to your list, or R to return:");
            String livestockInput = scanner.nextLine();

            if (livestockInput.equalsIgnoreCase("R")) {
                return false;
            } else if (livestockOptions.containsKey(livestockInput)) {
                BudgetItem.BudgetItemImpl selected = livestockOptions.get(livestockInput);
                // add selected to user's list
                System.out.println(livestockInput + " added to your list.");
                SeasonalBudgetHelpers.saveToShoppingList(livestockInput, selected, 1);
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static boolean petAdoption(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> petAdoptionOptions = SeasonalBudgetHelpers.createPetAdoptionOptions();

        System.out.println("Here are the available pets:\n");
        SeasonalBudgetHelpers.printOptions(petAdoptionOptions);

        while (true) {

            System.out.println("\nEnter the pet name to add to your list, or R to return to Marnie's Ranch:");
            String petInput = scanner.nextLine();

            if (petInput.equalsIgnoreCase("R")) {
                return false;
            } else if (petAdoptionOptions.containsKey(petInput)) {
                BudgetItem.BudgetItemImpl selected = petAdoptionOptions.get(petInput);

                System.out.println(petInput + " added to your list.");
                SeasonalBudgetHelpers.saveToShoppingList(petInput, selected, 1);
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static boolean yearRoundStock(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> yearRoundOptions = SeasonalBudgetHelpers.createYearRoundStockOptions();

        System.out.println("Here are the available items:\n");
        SeasonalBudgetHelpers.printOptions(yearRoundOptions);

        while (true) {

            System.out.println("\nSelect a seed followed by the quantity, or R to return:\n> ");
            String yearInput = scanner.nextLine().trim();

            if (yearInput.isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }

            if (yearInput.equalsIgnoreCase("R")) {
                return false;
            }

            Map.Entry<String, Integer> result = SeasonalBudgetHelpers.parseItemAndQuantity(yearInput);
            if (result == null) continue; // error already printed

            String itemName = result.getKey();
            int quantity = result.getValue();

            if (yearRoundOptions.containsKey(itemName)) {
                BudgetItem.BudgetItemImpl selected = yearRoundOptions.get(itemName);

                System.out.println(itemName + " x" + quantity + " added to your list.");
                SeasonalBudgetHelpers.saveToShoppingList(itemName, selected, quantity);

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

            System.out.println("\nSelect a seed followed by the quantity, or R to return:\n> ");
            String springInput = scanner.nextLine().trim();

            if (springInput.isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }

            if (springInput.equalsIgnoreCase("R")) {
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

            if (summerInput.isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }

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

            if (fallInput.isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }

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
