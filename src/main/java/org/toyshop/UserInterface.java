package org.toyshop;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final String FILE_NAME = "obj.txt";
    public static Scanner scanner = new Scanner(System.in);
    private final List<String> helpInput = Arrays.asList("help", "h", "?", "помощь", "справка");
    private final List<String> quitInput = Arrays.asList("quit", "q", "й", "выход", "авада кедавра");
    private final List<String> addingInput = Arrays.asList("add", "a", "put", "p", "добавить", "ввод");
    private final List<String> rollingInput = Arrays.asList("roll", "r", "розыгрыш");
    private final List<String> showAllInput = Arrays.asList("show", "s", "print", "список", "каталог", "игрушки");
    private Shop shop;

    public UserInterface() {
        this.shop = new Shop();
    }

    public void run() {
        fillShop();

        boolean flag = true;
        while (flag) {
            System.out.println("\nВведите запрос, например \"справка\" или \"выход\": ");
            String input = scanner.nextLine().strip().toLowerCase();
            if (helpInput.contains(input)) {
                help();
            } else if (quitInput.contains(input)) {
                System.out.println("\"Лавка Чудачеств\" прощается с вами!");
                flag = false;
            } else if (addingInput.contains(input)) {
                put();
            } else if (rollingInput.contains(input)) {
                givePrize();
            } else if (showAllInput.contains(input)) {
                showAll();
            } else {
                System.out.println("\nВвод некорректен. Повторите. ");
            }
        }
        FilesOps.WriteObj(shop, FILE_NAME);
    }

    private void showAll() {
        if (!shop.isEmpty()) shop.showAll();
        else System.out.println("\nКаталог пуст.\n");
    }

    private boolean isNull() {
        return shop != null;
    }

    private void givePrize() {
        if (shop.isEmpty()) {
            System.out.println("\nВсе игрушки кончились. Разыгрывать нечего.");
        } else {
            shop.givePrize();
        }
    }

    private int inputID() {
        while (true) {
            System.out.println("\nВведите артикул: ");
            int id = scanner.nextInt();
            if (shop.checkID(id)) {
                return id;
            }
        }
    }

    private void put() {
        int id = inputID();
        System.out.println("\nВведите наименование товара: ");
        String name = scanner.next();
        System.out.println("\nВведите сколько весит товар вместе с упаковкой: ");
        int weight = scanner.nextInt();
        System.out.println("\nВведите количество единиц товара: ");
        int amount = scanner.nextInt();
        shop.put(id, weight, name, amount);
    }

    private void help() {
        System.out.println("\nИспользуйте следующие команды:\n\t\"выход\" для выхода из программы;\n\t\"каталог\" для просмотра существующего каталога игрушек;\n\t\"добавить\" для ввода новой позиции в каталоге;\n\t\"розыгрыш\" для проведения безвозмездного розыгрыша.\n");
    }

    private void fillShop() {
//        shop = FilesOps.ReadObj(shop, FILE_NAME);
        shop.put(1, 2, "Резиновый утёнок", 100);
        shop.put(2, 1, "Дурилка картонная", 100);
        shop.put(3, 6, "Конструктор \"Юный дровосек\"", 20);
        shop.put(4, 3, "Автомат АК-47 (пластик)", 85);
    }
}
