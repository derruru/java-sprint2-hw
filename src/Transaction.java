public class Transaction {
    int month;
    String name;
    int quantity;
    int unitPrice;
    boolean isExpense;

    @Override
    public String toString() {
        return "Transaction{" +
                "month=" + month +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", isExpense=" + isExpense +
                '}';
    }
}

