import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class SeasonalBudgetHelpers {

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

    public static void printBuildingOptions(Map<String, BudgetItem.BudgetItemImpl> options) {
        for (Map.Entry<String, BudgetItem.BudgetItemImpl> entry : options.entrySet()) {
            System.out.println(entry.getKey() + ":\n" + entry.getValue());
        }
    }

    public static void saveToShoppingList(String buildingName, BudgetItem.BudgetItemImpl item) {
        try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
            fw.write(buildingName + ":\n");
            fw.write(" Gold: " + item.getGold() + "g\n");

            if (!item.getMaterials().isEmpty()) {
                fw.write(" Materials:\n");
                for (Map.Entry<String, Integer> entry : item.getMaterials().entrySet()) {
                    fw.write("   - " + entry.getKey() + ": " + entry.getValue() + "\n");
                }
            }
            fw.write("\n");
            fw.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
