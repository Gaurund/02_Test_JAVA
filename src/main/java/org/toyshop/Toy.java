package org.toyshop;

public class Toy {
    private final int id;
    private final int weight;
    private final String name;
    private int amount;
    private int[] tickets;

    public Toy(int id, int weight, String name, int amount) {
        this.id = id;
        this.weight = weight;
        this.name = name;
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Артикул: " + id + ", наименование: " + name + ", вес брутто: " + weight + " кг., кол-во в наличии: " + amount + " шт.";
    }

    public void setTickets(int ticketLow, int ticketHigh) {
        this.tickets = new int[]{ticketLow, ticketHigh};
    }

    public int[] getTickets() {
        return tickets;
    }

    public int getID() {
        return this.id;
    }

    public int getWeight() {
        return weight;
    }

    public int getAmount() {
        return amount;
    }

    public void decreaseAmount() {
        this.amount -= 1;
    }
}
