import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MonthService {

    FileReader reader = new FileReader();
    ArrayList<Transaction> transactions = new ArrayList<>();
    HashMap<String, Integer> mostProfit = new HashMap<>();
    HashMap<String,Integer> maxExpense = new HashMap<>();
    HashSet<Integer> monthNumbers = new HashSet<>();


    void readFiles() {
        for (int i = 1; i <= 3; i++) {
            ArrayList<String> lines = reader.readFileContents("m.20210" + i + ".csv");
            Transaction transaction;

            for (int j = 1; j < lines.size(); j++) {
                transaction = new Transaction();
                transaction.month = i;
                transaction.name = lines.get(j).split(",")[0];
                transaction.unitPrice = Integer.parseInt(lines.get(j).split(",")[3]);
                transaction.isExpense = Boolean.parseBoolean(lines.get(j).split(",")[1]);
                transaction.quantity = Integer.parseInt(lines.get(j).split(",")[2]);
                transactions.add(transaction);
                monthNumbers.add(transaction.month);
            }
        }
    }

    void printStatistic() {
        for (int i = 1; i <= monthNumbers.size(); i++) {
            System.out.println("Статистика за " + findMonth(i));
            System.out.println("Самый прибыльный товар - " + mostProfit(i) + ", сумма выручки - "
                    + mostProfit.get(mostProfit(i)));
            System.out.println("Самая большая трата - " + maxExpense.get(maxExpense(i)) + " за товар " + maxExpense(i));
        }
    }

    String findMonth(int monthNumber) {
        if (monthNumber == 1) {
            return "Январь";
        } else if (monthNumber == 2) {
            return "Февраль";
        } else if (monthNumber == 3) {
            return "Март";
        }
        return " ";
    }

    String mostProfit(int month) {
        String name = "";
        int amount = 0;
        for (Transaction transaction : transactions) {
            if (transaction.month == month) {
                if (!transaction.isExpense) {
                    if (transaction.quantity * transaction.unitPrice > amount) {
                        amount = transaction.quantity * transaction.unitPrice;
                        name = transaction.name;
                    }
                }
            }
        }
        mostProfit.put(name, amount);
        return name;
    }

    String maxExpense(int month) {
        String name = "";
        int amount = 0;
        for (Transaction transaction : transactions) {
            if (transaction.month == month) {
                if (transaction.isExpense) {
                    if (transaction.unitPrice * transaction.quantity > amount) {
                        amount = transaction.unitPrice * transaction.quantity;
                        name = transaction.name;
                    }
                }
            }
        }
        maxExpense.put(name, amount);
        return name;
    }

    int findCountExpense() {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.isExpense) {
                count += 1;
            }
        }
        return count;
    }

    int findCountProfit() {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (!transaction.isExpense) {
                count += 1;
            }
        }
        return count;
    }

    int getSumExpense(int month) {
        int sum = 0;
        for (Transaction transaction : transactions) {
            if (transaction.month == month) {
                if(transaction.isExpense) {
                    sum=+transaction.unitPrice* transaction.quantity;
                }
            }
        }
        return sum;
    }

}
