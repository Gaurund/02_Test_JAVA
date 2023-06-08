package org.toyshop;

public class Toy {
    private final int id;
    private final int weight;
    private final String name;
    private int amount;
    private int[] tickets;

    public Toy(String[] inputArray) {
        int lastElement = inputArray.length;

        this.id = Integer.parseInt(inputArray[0]);
        this.weight = Integer.parseInt(inputArray[1]);
        this.amount = Integer.parseInt(inputArray[2]);

        if (lastElement > 4) {
            for (int i = 4; i < lastElement; i++) {
                inputArray[3] = inputArray[3] + " " + inputArray[i];
            }
        }
        this.name = inputArray[3];
    }

    @Override
    public String toString() {
        return "Артикул: " + id + ", вес брутто: " + weight + " кг., кол-во в наличии: " + amount + " шт., наименование: " + name;
    }

    public String toStoreString() {
        return id + " " + weight + " " + amount + " " + name + ";";
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
