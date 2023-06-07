package org.toyshop;

import java.io.Serializable;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Shop {
    private static final Comparator<Toy> compareID = new Comparator<Toy>() {
        @Override
        public int compare(Toy o1, Toy o2) {
            return o1.getID() - o2.getID();
        }
    };
    private final PriorityQueue<Toy> toys;

    public Shop() {
        this.toys = new PriorityQueue<>(compareID);
    }

    public void givePrize() {
        Toy prizeToy = roll();
        System.out.println("Победителю достаётся игрушка: " + prizeToy.toString());
        prizeToy.decreaseAmount();
        if (prizeToy.getAmount() == 0) {
            System.out.println("И это была последняя игрушка данного артикула. Больше в розыгрыше она не участвует.");
            toys.remove(prizeToy);
        }
    }

    private Toy roll() {
        int limit = distributeTickets();
        Random random = new Random();
        int prize = random.nextInt(limit);
        for (Toy toy : toys) {
            if (checkPrize(prize, toy)) {
                return toy;
            }
        }
        return null;
    }

    private boolean checkPrize(int prize, Toy toy) {
        return toy.getTickets()[0] <= prize && toy.getTickets()[1] > prize;
    }

    private int distributeTickets() {
        int ticketLow = 0;
        int ticketHigh = 0;
        for (Toy toy : toys) {
            int tickets = toy.getAmount() * toy.getWeight();
            ticketHigh = ticketLow + tickets;
            toy.setTickets(ticketLow, ticketHigh);
            ticketLow = ticketHigh;
        }
        return ticketHigh;
    }

    public void put(int id, int weight, String name, int amount) {
        if (isNull() && checkID(id)) this.toys.add(new Toy(id, weight, name, amount));
    }

    public boolean checkID(int id) {
        if (id <= 0) {
            System.out.println("Артикул таким быть не может. Повторите ввод. ");
            return false;
        }
        for (Toy toy : toys) {
            if (toy.getID() == id) {
                System.out.println("Данный артикул уже занят. Повторите ввод. ");
                return false;
            }
        }
        return true;
    }

    public void showAll() {
        for (Toy toy : this.toys) {
            System.out.println(toy);
        }
    }

    public boolean isEmpty() {
        return toys.isEmpty();
    }

    public boolean isNull() {
        return toys != null;
    }
}
