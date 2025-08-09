import java.util.*;

public class SeasonalBudgetManager {

    public static boolean farmBuildings(Scanner scanner) { // boolean instead of void (automatically true)

        Map<String, BudgetItem.BudgetItemImpl> buildingOptions = Helpers.createFarmBuildingOptions();

        System.out.println("Here are the available farm buildings:\n");
        Helpers.printOptions(buildingOptions);

        while (true) {

            System.out.println("\nEnter building name to add to your list, or R to return to the Carpenter's Shop:");
            String buildingInput = scanner.nextLine().trim();

            if (buildingInput.equalsIgnoreCase("R")) {
                return false;
            } else if (buildingOptions.containsKey(buildingInput)) {
                BudgetItem.BudgetItemImpl selected = buildingOptions.get(buildingInput);
                // add selected to user's list
                System.out.println(buildingInput + " added to your list.");
                Helpers.saveToShoppingList(buildingInput, selected, 1);
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static boolean houseUpgrades(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> houseOptions = Helpers.createHouseUpgradeOptions();

        System.out.println("Here are the available house upgrades:\n");
        Helpers.printOptions(houseOptions);

        while (true) {

            System.out.println("\nEnter the upgrade name to add to your list, or R to return to the Carpenter's Shop:");
            String upgradeInput = scanner.nextLine().trim();

            if (upgradeInput.equalsIgnoreCase("R")) {
                return false;
            } else if (houseOptions.containsKey(upgradeInput)) {
                BudgetItem.BudgetItemImpl selected = houseOptions.get(upgradeInput);
                // add selected to user's list
                System.out.println(upgradeInput + " added to your list.");
                Helpers.saveToShoppingList(upgradeInput, selected, 1);
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static boolean houseRenovations(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> houseRenoOptions = Helpers.createHouseRenoOptions();

        System.out.println("Here are the available house renovations:\n");
        Helpers.printOptions(houseRenoOptions);

        while (true) {

            System.out.println("\nEnter the renovation name to add to your list, or R to return to the Carpenter's Shop:");
            String renoInput = scanner.nextLine().trim();

            if (renoInput.equalsIgnoreCase("R")) {
                return false;
            } else if (houseRenoOptions.containsKey(renoInput)) {
                BudgetItem.BudgetItemImpl selected = houseRenoOptions.get(renoInput);
                // add selected to user's list
                System.out.println(renoInput + " added to your list.");
                Helpers.saveToShoppingList(renoInput, selected, 1);
            } else {
                System.out.println("Invalid selection.");
            }

        }
    }

    public static boolean livestock(Scanner scanner) {
        Map<String, BudgetItem.BudgetItemImpl> livestockOptions = Helpers.createLivestockOptions();

        System.out.println("Here are the available livestock:\n");
        Helpers.printOptions(livestockOptions);

        while (true) {

            System.out.println("\nEnter the livestock name to add to your list, or R to return:");
            String livestockInput = scanner.nextLine().trim();

            if (livestockInput.equalsIgnoreCase("R")) {
                return false;
            } else if (livestockOptions.containsKey(livestockInput)) {
                BudgetItem.BudgetItemImpl selected = livestockOptions.get(livestockInput);
                // add selected to user's list
                System.out.println(livestockInput + " added to your list.");
                Helpers.saveToShoppingList(livestockInput, selected, 1);
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static boolean petAdoption(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> petAdoptionOptions = Helpers.createPetAdoptionOptions();

        System.out.println("Here are the available pets:\n");
        Helpers.printOptions(petAdoptionOptions);

        while (true) {

            System.out.println("\nEnter the pet name to add to your list, or R to return to Marnie's Ranch:");
            String petInput = scanner.nextLine().trim();

            if (petInput.equalsIgnoreCase("R")) {
                return false;
            } else if (petAdoptionOptions.containsKey(petInput)) {
                BudgetItem.BudgetItemImpl selected = petAdoptionOptions.get(petInput);

                System.out.println(petInput + " added to your list.");
                Helpers.saveToShoppingList(petInput, selected, 1);
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static boolean yearRoundStock(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> yearRoundOptions = Helpers.createYearRoundStockOptions();

        System.out.println("Here are the available items:\n");
        Helpers.printOptions(yearRoundOptions);

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

            Map.Entry<String, Integer> result = Helpers.parseItemAndQuantity(yearInput);
            if (result == null) continue; // error already printed

            String itemName = result.getKey();
            int quantity = result.getValue();

            if (yearRoundOptions.containsKey(itemName)) {
                BudgetItem.BudgetItemImpl selected = yearRoundOptions.get(itemName);

                System.out.println(itemName + " x" + quantity + " added to your list.");
                Helpers.saveToShoppingList(itemName, selected, quantity);

            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static boolean springStock(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> springOptions = Helpers.createSpringStock();

        System.out.println("Here are the available seeds:\n");
        Helpers.printOptions(springOptions);

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

            Map.Entry<String, Integer> result = Helpers.parseItemAndQuantity(springInput);
            if (result == null) continue;

            String itemName = result.getKey();
            int quantity = result.getValue();

            if (springOptions.containsKey(itemName)) {
                BudgetItem.BudgetItemImpl selected = springOptions.get(itemName);

                System.out.println(itemName + " x" + quantity + " added to your list.");
                Helpers.saveToShoppingList(itemName, selected, quantity);

            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static boolean summerStock(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> summerOptions = Helpers.createSummerStock();

        System.out.println("Here are the available seeds:\n");
        Helpers.printOptions(summerOptions);

        while (true) {

            System.out.println("Select a seed followed by the quantity, or R to return.");
            String summerInput = scanner.nextLine().trim();

            if (summerInput.isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }

            if(summerInput.equalsIgnoreCase("R")) {
                return false;
            }

            Map.Entry<String, Integer> result = Helpers.parseItemAndQuantity(summerInput);
            if (result == null) continue;

            String itemName = result.getKey();
            int quantity = result.getValue();

            if (summerOptions.containsKey(itemName)) {
                BudgetItem.BudgetItemImpl selected = summerOptions.get(itemName);

                System.out.println(itemName + " x" + quantity + " added to your list.");
                Helpers.saveToShoppingList(itemName, selected, quantity);

            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static boolean fallStock(Scanner scanner) {

        Map<String, BudgetItem.BudgetItemImpl> fallOptions = Helpers.createFallStock();

        System.out.println("Here are the available seeds:\n");
        Helpers.printOptions(fallOptions);

        while (true) {

            System.out.println("Select a seed followed by the quantity, or R to return.");
            String fallInput = scanner.nextLine().trim();

            if (fallInput.isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }

            if(fallInput.equalsIgnoreCase("R")) {
                return false;
            }

            Map.Entry<String, Integer> result = Helpers.parseItemAndQuantity(fallInput);
            if (result == null) continue;

            String itemName = result.getKey();
            int quantity = result.getValue();

            if (fallOptions.containsKey(itemName)) {
                BudgetItem.BudgetItemImpl selected = fallOptions.get(itemName);

                System.out.println(itemName + " x" + quantity + " added to your list.");
                Helpers.saveToShoppingList(itemName, selected, quantity);

            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}
