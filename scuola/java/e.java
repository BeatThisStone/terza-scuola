import java.sql.Array;

public class e {
    public static int maxProfit(int[] prices) {
        int[] maxPricePast = new int[prices.length];
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++)
                if (prices[j] > maxPricePast[i])
                    maxPricePast[i] = prices[j];
            if (maxPricePast[i] - prices[i] > maxProfit)
                maxProfit = maxPricePast[i] - prices[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 5, 3 };
        System.out.println(maxProfit(a));
    }
}