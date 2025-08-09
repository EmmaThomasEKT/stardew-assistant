import java.util.HashMap;
import java.util.Map;

public class SeedInfo {
    int price;
    int sellPrice;
    int profit;

    SeedInfo(int price, int sellPrice) {
        this.price = price;
        this.sellPrice = sellPrice;
        this.profit = sellPrice - price;
    }
}
