import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        YearService yearService = new YearService();
        MonthService monthService = new MonthService();
        Checker checker = new Checker();
        boolean isReadMonth = false;
        boolean isReadYear = false;

        System.out.println("Добро пожаловать!");
        while (true) {
            System.out.println("Выберите один из пунктов меню:");
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                monthService.readFiles();
                isReadMonth = true;
                System.out.println("Отчёты считаны!");
            } else if (command == 2) {
                yearService.readFile();
                isReadYear = true;
            } else if (command == 3) {
                if (isReadYear && isReadMonth) {
                    System.out.println(checker.check());
                } else {
                    System.out.println("Считаны не все отчёты!");
                }
            } else if (command == 4) {
                if (isReadYear && isReadMonth) {
                    monthService.printStatistic();
                } else {
                    System.out.println("Считаны не все отчёты!");
                }
            } else if (command == 5) {
                if (isReadYear && isReadMonth) {
                    yearService.printData();
                } else {
                    System.out.println("Считаны не все отчёты!");
                }
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Такой команды нет. Введите корректный номер команды.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о месячных отчетах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}

