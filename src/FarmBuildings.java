import java.util.Map;

public class FarmBuildings {
    int gold;
    Map<String, Integer> materials;

    public FarmBuildings(int gold, Map<String, Integer> materials) {
        this.gold = gold;
        this.materials = materials;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Gold: " + gold + "g\nMaterials:\n");
        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            sb.append("  - ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}

