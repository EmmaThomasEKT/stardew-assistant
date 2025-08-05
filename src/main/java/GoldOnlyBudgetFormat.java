import java.util.Collections;
import java.util.Map;

public class GoldOnlyBudgetFormat implements BudgetItem.BudgetItemImpl {
    private int gold;

    public GoldOnlyBudgetFormat(int gold) {
        this.gold = gold;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public Map<String, Integer> getMaterials() {
        return Collections.emptyMap();
    }

    @Override
    public String toString() {
        return "Gold: " + gold + "g\n";
    }
}
