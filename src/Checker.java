public class Checker {
    MonthService monthService = new MonthService();
    YearService yearService = new YearService();

    String check() {
        boolean result = false;
        for (int i = 1; i <= 3; i++) {
            if (monthService.getSumExpense(i) == yearService.getSumExpense(i)) {
                result = true;
            }
        }
        if(result) {
            return "Отчёты совпали";
        }
        return "Отчёты не совпали";
    }
}
