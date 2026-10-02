public class Cart {

    private final double[] prices;
    private final String cartId;
    private int itemCount;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        prices = new double[maxItems];
        itemCount = 0;
    }

    public void addItem(double price) {
        if (price >= 0 && itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }
}