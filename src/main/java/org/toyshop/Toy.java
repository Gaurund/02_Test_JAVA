package org.toyshop;

public class Toy {
    private final int id;
    private final int weight;
    private final String name;
    private int amount;
    private int[] tickets;

    public Toy(String[] inputArray) {
        int lastElement = inputArray.length - 1;

        this.id = Integer.parseInt(inputArray[0]);
        this.weight = Integer.parseInt(inputArray[1]);
        this.amount = Integer.parseInt(inputArray[lastElement]);

        if (lastElement > 3) {
            for (int i = 3; i < lastElement; i++) {
                inputArray[2] = inputArray[2] + " " + inputArray[i];
            }
        }
        this.name = inputArray[2];
    }

    @Override
    public String toString() {
        return "Артикул: " + id + ", наименование: " + name + ", вес брутто: " + weight + " кг., кол-во в наличии: " + amount + " шт.";
    }

    public String toStoreString() {
        return id + " " + weight + " " + name + " " + amount + ";";
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

    public String getName() {
        return this.name;
    }
}
