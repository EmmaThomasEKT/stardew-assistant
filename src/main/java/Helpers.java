import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Helpers {

    public static void printOptions(Map<String, BudgetItem.BudgetItemImpl> options) {
        for (Map.Entry<String, BudgetItem.BudgetItemImpl> entry : options.entrySet()) {
            System.out.println(entry.getKey() + ":\n" + entry.getValue());
        }
    }

    public static void saveToShoppingList(String itemName, BudgetItem.BudgetItemImpl item, int quantity) {

        try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
            fw.write(itemName + " x" + quantity + "g\n");
            fw.write(" Gold: " + (item.getGold() * quantity) + "g\n");

            if (!item.getMaterials().isEmpty()) {
                fw.write(" Materials:\n");
                for (Map.Entry<String, Integer> entry : item.getMaterials().entrySet()) {
                    fw.write("   - " + entry.getKey() + ": " + entry.getValue() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToSeedList(String seedName, BudgetItem.BudgetItemImpl item, int quantity) {

        try (FileWriter fw = new FileWriter("SeedList.txt", true)) {
            fw.write(seedName + " x" + quantity + "g\n");
            fw.write(" Gold: " + (item.getGold() * quantity) + "g\n");

            if (!item.getMaterials().isEmpty()) {
                fw.write(" Materials:\n");
                for (Map.Entry<String, Integer> entry : item.getMaterials().entrySet()) {
                    fw.write("   - " + entry.getKey() + ": " + entry.getValue() + "\n");
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static Map.Entry<String, Integer> parseItemAndQuantity(String input) {
        String[] parts = input.trim().split("\\s+");
        if (parts.length < 2) {
            System.out.println("Please enter both item name and quantity (e.g. Cherry Sapling 20)");
            return null;
        }

        String quantityStr = parts[parts.length -1];
        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                System.out.println("Quantity must be a positive number.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity. Please enter a number at the end.");
            return null;
        }

        String itemName = String.join(" ", Arrays.copyOf(parts, parts.length - 1));
        return new AbstractMap.SimpleEntry<>(itemName, quantity);
    }

    public static Map<String, BudgetItem.BudgetItemImpl> createFarmBuildingOptions() {

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

        return buildingOptions;
    }

    public static Map<String, BudgetItem.BudgetItemImpl> createHouseUpgradeOptions() {
        Map<String, BudgetItem.BudgetItemImpl> houseOptions = new LinkedHashMap<>();

        houseOptions.put("Kitchen", new SeasonalBudgetFormat(10000, Map.of("Wood", 450)));
        houseOptions.put("Crib", new SeasonalBudgetFormat(65000, Map.of("Hardwood", 100)));
        houseOptions.put("Basement", new GoldOnlyBudgetFormat(100000));

        return houseOptions;
    }

    public static Map<String, BudgetItem.BudgetItemImpl> createHouseRenoOptions() {
        Map<String, BudgetItem.BudgetItemImpl> houseRenoOptions = new LinkedHashMap<>();

        houseRenoOptions.put("Open Bedroom", new GoldOnlyBudgetFormat(10000));
        houseRenoOptions.put("Add Southern Room", new GoldOnlyBudgetFormat(30000));
        houseRenoOptions.put("Add Corner Room", new GoldOnlyBudgetFormat(20000));

        houseRenoOptions.put("Add Dining Room", new GoldOnlyBudgetFormat(150000));
        houseRenoOptions.put("Add Cubby", new GoldOnlyBudgetFormat(10000));
        houseRenoOptions.put("Add Attic", new GoldOnlyBudgetFormat(60000));

        houseRenoOptions.put("Expand Corner Room", new GoldOnlyBudgetFormat(100000));
        houseRenoOptions.put("Open Dining Room", new GoldOnlyBudgetFormat(10000));

        return houseRenoOptions;
    }

    public static Map<String, BudgetItem.BudgetItemImpl> createLivestockOptions() {
        Map<String, BudgetItem.BudgetItemImpl> livestockOptions = new LinkedHashMap<>();

        livestockOptions.put("Chicken", new GoldOnlyBudgetFormat(800));
        livestockOptions.put("Cow", new GoldOnlyBudgetFormat(1500));
        livestockOptions.put("Goat", new GoldOnlyBudgetFormat(4000));

        livestockOptions.put("Duck", new GoldOnlyBudgetFormat(1200));
        livestockOptions.put("Sheep", new GoldOnlyBudgetFormat(8000));
        livestockOptions.put("Rabbit", new GoldOnlyBudgetFormat(8000));
        livestockOptions.put("Pig", new GoldOnlyBudgetFormat(16000));

        return livestockOptions;
    }

    public static Map<String, BudgetItem.BudgetItemImpl> createPetAdoptionOptions() {
        Map<String, BudgetItem.BudgetItemImpl> petAdoptionOptions = new LinkedHashMap<>();

        petAdoptionOptions.put("Cat", new GoldOnlyBudgetFormat(40000));
        petAdoptionOptions.put("Dog", new GoldOnlyBudgetFormat(40000));
        petAdoptionOptions.put("Turtle", new GoldOnlyBudgetFormat(60000));
        petAdoptionOptions.put("Special Turtle", new GoldOnlyBudgetFormat(500000));

        return petAdoptionOptions;
    }

    public static Map<String, BudgetItem.BudgetItemImpl> createYearRoundStockOptions() {
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

        return yearRoundOptions;
    }

    public static Map<String, BudgetItem.BudgetItemImpl> createSpringStock() {
        Map<String, BudgetItem.BudgetItemImpl> springOptions = new LinkedHashMap<>();

        springOptions.put("Parsnip Seeds", new GoldOnlyBudgetFormat(20));
        springOptions.put("Bean Starter", new GoldOnlyBudgetFormat(60));
        springOptions.put("Cauliflower Seeds", new GoldOnlyBudgetFormat(80));

        springOptions.put("Potato Seeds", new GoldOnlyBudgetFormat(50));
        springOptions.put("Tulip Bulb", new GoldOnlyBudgetFormat(20));
        springOptions.put("Kale Seeds", new GoldOnlyBudgetFormat(70));

        springOptions.put("Jazz Seeds", new GoldOnlyBudgetFormat(30));
        springOptions.put("Garlic Seeds", new GoldOnlyBudgetFormat(40));
        springOptions.put("Rice Shoot", new GoldOnlyBudgetFormat(40));

        return springOptions;
    }

    public static Map<String, BudgetItem.BudgetItemImpl> createSummerStock() {
        Map<String, BudgetItem.BudgetItemImpl> summerOptions = new LinkedHashMap<>();

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

        return summerOptions;
    }

    public static Map<String, BudgetItem.BudgetItemImpl> createFallStock() {
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

        return fallOptions;
    }

    public static Map<String, BudgetItem.BudgetItemImpl> createSeedStock() {
        Map<String, BudgetItem.BudgetItemImpl> seedOptions = new LinkedHashMap<>();

        seedOptions.put("Parsnip Seeds", new GoldOnlyBudgetFormat(20));
        seedOptions.put("Bean Starter", new GoldOnlyBudgetFormat(60));
        seedOptions.put("Cauliflower Seeds", new GoldOnlyBudgetFormat(80));

        seedOptions.put("Potato Seeds", new GoldOnlyBudgetFormat(50));
        seedOptions.put("Tulip Bulb", new GoldOnlyBudgetFormat(20));
        seedOptions.put("Kale Seeds", new GoldOnlyBudgetFormat(70));

        seedOptions.put("Jazz Seeds", new GoldOnlyBudgetFormat(30));
        seedOptions.put("Garlic Seeds", new GoldOnlyBudgetFormat(40));
        seedOptions.put("Rice Shoot", new GoldOnlyBudgetFormat(40));

        seedOptions.put("Melon Seeds", new GoldOnlyBudgetFormat(80));
        seedOptions.put("Tomato Seeds", new GoldOnlyBudgetFormat(50));
        seedOptions.put("Blueberry Seeds", new GoldOnlyBudgetFormat(80));

        seedOptions.put("Pepper Seeds", new GoldOnlyBudgetFormat(40));
        seedOptions.put("Wheat Seeds", new GoldOnlyBudgetFormat(10));
        seedOptions.put("Radish Seeds", new GoldOnlyBudgetFormat(40));

        seedOptions.put("Poppy Seeds", new GoldOnlyBudgetFormat(100));
        seedOptions.put("Spangle Seeds", new GoldOnlyBudgetFormat(50));
        seedOptions.put("Hops Starer", new GoldOnlyBudgetFormat(60));

        seedOptions.put("Corn Seeds", new GoldOnlyBudgetFormat(150));
        seedOptions.put("Sunflower Seeds", new GoldOnlyBudgetFormat(200));
        seedOptions.put("Red Cabbage Seeds", new GoldOnlyBudgetFormat(100));

        seedOptions.put("Eggplant Seeds", new GoldOnlyBudgetFormat(20));
        seedOptions.put("Corn", new GoldOnlyBudgetFormat(225));
        seedOptions.put("Pumpkin Seeds", new GoldOnlyBudgetFormat(100));

        seedOptions.put("Bokchoy Seeds", new GoldOnlyBudgetFormat(50));
        seedOptions.put("Yam Seeds", new GoldOnlyBudgetFormat(60));
        seedOptions.put("Cranberry Seeds", new GoldOnlyBudgetFormat(240));

        seedOptions.put("Sunflower Seeds", new GoldOnlyBudgetFormat(100));
        seedOptions.put("Fairy Seeds", new GoldOnlyBudgetFormat(50));
        seedOptions.put("Amaranth Starer", new GoldOnlyBudgetFormat(60));

        seedOptions.put("Grape Starter", new GoldOnlyBudgetFormat(150));
        seedOptions.put("Wheat Seeds", new GoldOnlyBudgetFormat(10));
        seedOptions.put("Artichoke Seeds", new GoldOnlyBudgetFormat(100));

        return seedOptions;
    }
}
