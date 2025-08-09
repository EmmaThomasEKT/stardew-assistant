import java.util.HashMap;
import java.util.Map;

public class SeedDatabase {
    public static Map<String, SeedInfo> seedData = new HashMap<>();

    static {
        // — Spring Crops —
        seedData.put("Parsnip",     new SeedInfo(20, 35));
        seedData.put("Potato",      new SeedInfo(50, 80));
        seedData.put("Cauliflower", new SeedInfo(80, 175));
        seedData.put("Green Bean",  new SeedInfo(60, 40));
        seedData.put("Garlic",      new SeedInfo(40, 60));
        seedData.put("Kale",        new SeedInfo(70, 110));
        seedData.put("Rhubarb",     new SeedInfo(100, 220));
        seedData.put("Strawberry",  new SeedInfo(100, 120));
        seedData.put("Tulip",       new SeedInfo(20, 30));

        // — Summer Crops —
        seedData.put("Blueberry",   new SeedInfo(80, 50));
        seedData.put("Corn",        new SeedInfo(150, 50));
        seedData.put("Hops",        new SeedInfo(60, 25));
        seedData.put("Hot Pepper",  new SeedInfo(40, 40));
        seedData.put("Melon",       new SeedInfo(80, 250));
        seedData.put("Poppy",       new SeedInfo(100, 140));
        seedData.put("Radish",      new SeedInfo(40, 90));
        seedData.put("Red Cabbage", new SeedInfo(100, 260));
        seedData.put("Starfruit",   new SeedInfo(400, 800));
        seedData.put("Summer Spangle", new SeedInfo(50, 90));
        seedData.put("Sunflower",   new SeedInfo(200, 80));
        seedData.put("Tomato",      new SeedInfo(50, 60));
        seedData.put("Wheat",       new SeedInfo(10, 25));

        // — Fall Crops —
        seedData.put("Amaranth",    new SeedInfo(70, 150));
        seedData.put("Artichoke",   new SeedInfo(30, 160));
        seedData.put("Beet",        new SeedInfo(20, 100));
        seedData.put("Bok Choy",    new SeedInfo(50, 80));
        seedData.put("Cranberry",   new SeedInfo(240, 130));
        seedData.put("Eggplant",    new SeedInfo(20, 60));
        seedData.put("Fairy Rose",  new SeedInfo(200, 290));
        seedData.put("Grape",       new SeedInfo(60, 80));
        seedData.put("Pumpkin",     new SeedInfo(100, 320));
        seedData.put("Sweet Gem Berry", new SeedInfo(1000, 3000));
        seedData.put("Sunflower",   new SeedInfo(200, 80)); // repeated if desired
        seedData.put("Yam",         new SeedInfo(60, 160));
    }
}
