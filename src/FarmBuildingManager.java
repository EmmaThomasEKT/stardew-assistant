import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FarmBuildingManager {
    public static void farmBuildings() {
        boolean buildingShop = true;

        Scanner scanner = new Scanner(System.in);

        Map<String, FarmBuildings> buildingOptions = new LinkedHashMap<>();

        buildingOptions.put("Barn", new FarmBuildings(6000, Map.of("Wood", 350, "Stone", 150)));
        buildingOptions.put("Big Barn", new FarmBuildings(12000, Map.of("Wood", 450, "Stone", 200)));
        buildingOptions.put("Deluxe Barn", new FarmBuildings(25000, Map.of("Wood", 550, "Stone", 300)));

        buildingOptions.put("Coop", new FarmBuildings(4000, Map.of("Wood", 300, "Stone", 100)));
        buildingOptions.put("Big Coop", new FarmBuildings(10000, Map.of("Wood", 400, "Stone", 150)));
        buildingOptions.put("Deluxe Coop", new FarmBuildings(20000, Map.of("Wood", 500, "Stone", 200)));

        buildingOptions.put("Fish Pond", new FarmBuildings(5000, Map.of("Stone", 200, "Seaweed", 5, "Green Algae", 5)));
        buildingOptions.put("Mill", new FarmBuildings(2500, Map.of("Wood", 150, "Stone", 50, "Cloth", 4)));

        buildingOptions.put("Shed", new FarmBuildings(15000, Map.of("Wood", 300)));
        buildingOptions.put("Big Shed", new FarmBuildings(20000, Map.of("Wood", 550, "Stone", 300)));

        buildingOptions.put("Silo", new FarmBuildings(100, Map.of("Stone", 100, "Clay", 10, "Copper Bar", 5)));
        buildingOptions.put("Slime Hutch", new FarmBuildings(10000, Map.of("Stone", 500, "Refined Quartz", 10, "Iridium Bar", 1)));

        buildingOptions.put("Stable", new FarmBuildings(10000, Map.of("Hardwood", 100, "Iron Bar", 5)));
        buildingOptions.put("Well", new FarmBuildings(1000, Map.of("Stone", 75)));

        buildingOptions.put("Cabin", new FarmBuildings(100, Map.of()));
        buildingOptions.put("Shipping Bin", new FarmBuildings(250, Map.of("Wood", 150)));
        buildingOptions.put("Pet Bowl", new FarmBuildings(5000, Map.of("Hardwood", 25)));

        System.out.println("Here are the available farm buildings:\n");
        for (Map.Entry<String, FarmBuildings> entry : buildingOptions.entrySet()) {
            System.out.println(entry.getKey() + ":\n" + entry.getValue());
        }

        while (buildingShop) {

            System.out.println("\nEnter building name to add to your list, or R to return:");
            String buildingInput = scanner.nextLine();

            if (buildingInput.equalsIgnoreCase("R")) {
                buildingShop = false;
            } else if (buildingOptions.containsKey(buildingInput)) {
                FarmBuildings selected = buildingOptions.get(buildingInput);
                // add selected to user's list
                System.out.println(buildingInput + " added to your list.");

                try (FileWriter fw = new FileWriter("ShoppingList.txt", true)) {
                    fw.write(buildingInput + ":\n");
                    for (Map.Entry<String, Integer> entry : selected.materials.entrySet()) {
                        fw.write(" " + entry.getKey() + ": " + entry.getValue() + "\n");
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

        scanner.close();
    }
}
