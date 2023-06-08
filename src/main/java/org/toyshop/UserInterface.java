package org.toyshop;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final String FILE_NAME = "shop.txt";
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
        shop.restoreShop(FILE_NAME);
        greetings();

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
        shop.storeShop(FILE_NAME);
    }

    private void greetings(){
        System.out.println("\nЗдравствуйте!\nСегодня наш магазин проводит аттракцион неслыханной щедрости!\nМы разыгрываем игрушки и раздаём их безвозмездно.\n");
        if (!shop.isEmpty()) {
            System.out.println("Наш текущий ассортимент: ");
            showAll();
        }
    }
    private void showAll() {
        if (!shop.isEmpty()) shop.showAll();
        else System.out.println("\nКаталог пуст.\n");
    }

    private void givePrize() {
        if (shop.isEmpty()) {
            System.out.println("\nВсе игрушки кончились. Разыгрывать нечего.");
        } else {
            shop.givePrize();
        }
    }

    private void put() {
        System.out.println("\nВведите одной строкой артикул, вес, наименование и количество товара (разделитель -- пробел): ");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        if (inputArray.length < 4) System.out.println("\nЭтого явно недостаточно. Повторите ввод.");
        else if (checkID(inputArray[0])) {
            shop.put(inputArray);
        }
    }

    public boolean checkID(String idString) {
        int id = Integer.parseInt(idString);
        if (id <= 0) {
            System.out.println("\nАртикул таким быть не может. Повторите ввод. ");
            return false;
        }
        for (Toy toy : shop.toys) {
            if (toy.getID() == id) {
                System.out.println("\nДанный артикул уже занят. Повторите ввод. ");
                return false;
            }
        }
        return true;
    }

    private void help() {
        System.out.println("\nИспользуйте следующие команды:\n\t\"выход\" для выхода из программы;\n\t\"каталог\" для просмотра существующего каталога игрушек;\n\t\"добавить\" для ввода новой позиции в каталоге;\n\t\"розыгрыш\" для проведения безвозмездного розыгрыша.\n");
    }
}
