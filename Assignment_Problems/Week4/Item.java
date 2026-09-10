public class Item {
    private String itemName;
    private int stock;

    // Constructor resolving parameter/field clash via this
    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    // Method resolving parameter/field clash via this
    public void restock(int stock) {
        this.stock += stock;
    }

    public void printItemStatus() {
        System.out.println(itemName + " | Final Stock: " + stock);
    }

    public static void main(String[] args) {
        Item[] inventory = {
            new Item("Samosa", 15),
            new Item("Tea Powder", 40),
            new Item("Bread", 8),
            new Item("Biscuit Packs", 25)
        };

        // Batch restock using a for loop
        for (Item item : inventory) {
            item.restock(20);
            item.printItemStatus();
        }
    }
}