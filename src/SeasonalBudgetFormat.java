import java.util.Map;

public class SeasonalBudgetFormat implements BudgetItem.BudgetItemImpl {
    private int gold;
    private Map<String, Integer> materials;

    public SeasonalBudgetFormat(int gold, Map<String, Integer> materials) {
        this.gold = gold;
        this.materials = materials;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public Map<String, Integer> getMaterials() {
        return materials;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Gold: " + gold + "g\n");
        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            sb.append("  - ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}

