package org.toyshop;


public class Main {
    public static void main(String[] args) {
//        FileHandling.CreateFile("test.txt");

//        FileHandling.WriteToFile("0.txt", "\nТретья строка строка", false); // Flag определяет дописывается ли файл (true) или перезаписывается (false).
        UserInterface ui = new UserInterface();

        ui.run();
    }
}