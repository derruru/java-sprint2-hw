import java.util.ArrayList;
import java.util.HashSet;

public class YearService {

    FileReader reader = new FileReader();
    ArrayList<YearTransaction> transactions = new ArrayList<>();
    HashSet<Integer> monthNumbers = new HashSet<>();
    MonthService service = new MonthService();


    void readFile() {
        ArrayList<String> lines = reader.readFileContents("y.2021.csv");
        YearTransaction transaction;
        for (int i = 1; i < lines.size(); i++) {
            transaction = new YearTransaction();
            transaction.month = Integer.parseInt(lines.get(i).split(",")[0]);
            transaction.amount = Integer.parseInt(lines.get(i).split(",")[1]);
            transaction.isExpense = Boolean.parseBoolean(lines.get(i).split(",")[2]);
            transactions.add(transaction);
            monthNumbers.add(transaction.month);
        }
    }

    void printData() {
        System.out.println("Годовая статистика за 2021 год:");
        for (int i = 1; i <= monthNumbers.size(); i++) {
            System.out.println("Чистая прибыль за " + service.findMonth(i) + " месяц - " + getProfit(i));
        }
        System.out.println("Средний расход за год - " + getAverageExpense());
        System.out.println("Средний доход за год - " + getAverageProfit());
    }

    int getProfit(int month) {
        int profit = 0;
        for (YearTransaction transaction : transactions) {
            if (transaction.month == month) {
                if (transaction.isExpense) {
                    profit -= transaction.amount;
                } else {
                    profit += transaction.amount;
                }
            }
        }
        return profit;
    }

    int getAverageExpense() {
        int sum = 0;
        for (YearTransaction transaction : transactions) {
            if (transaction.isExpense) {
                sum += transaction.amount;
            }
        }
        return sum;
    }

    int getAverageProfit() {
        int sum = 0;
        for (YearTransaction transaction : transactions) {
            if (!transaction.isExpense) {
                sum += transaction.amount;
            }
        }
        return sum;
    }

    int getSumExpense(int month) {
        int sum = 0;
        for (YearTransaction transaction : transactions) {
            if (transaction.isExpense && transaction.month == month) {
                sum += transaction.amount;
            }
        }
        return sum;
    }

}
