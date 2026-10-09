import java.util.HashMap;

public class MostPopularCanteenOrderDemo {

    static void mostPopular(String[] orders) {
        HashMap<String, Integer> count = new HashMap<>();

        for (String item : orders) {
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        String bestItem = orders[0];
        int bestCount = count.get(bestItem);

        for (String item : orders) {
            int currentCount = count.get(item);

            if (currentCount > bestCount) {
                bestItem = item;
                bestCount = currentCount;
            }
        }

        System.out.println("(\"" + bestItem + "\", " + bestCount + ")");
    }

    public static void main(String[] args) {
        String[] orders1 = {
            "dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"
        };

        String[] orders2 = {
            "tea", "coffee", "coffee", "tea"
        };

        mostPopular(orders1);
        mostPopular(orders2);
    }
}
