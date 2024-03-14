public class YearTransaction {
    int month;
    int amount;
    boolean isExpense;

    @Override
    public String toString() {
        return "YearTransaction{" +
                "month=" + month +
                ", amount=" + amount +
                ", isExpense=" + isExpense +
                '}';
    }
}
