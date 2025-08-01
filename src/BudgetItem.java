import java.util.Map;

public class BudgetItem {
    public interface BudgetItemImpl {
        int getGold();
        Map<String, Integer> getMaterials();
    }
}
