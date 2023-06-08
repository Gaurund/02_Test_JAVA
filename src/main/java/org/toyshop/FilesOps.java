package org.toyshop;

import java.io.*;

public class FilesOps {

    public static void CreateFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getName());
            } else {
                System.out.println("Файл уже существует. Создавать его не надо.");
            }
        } catch (IOException e) {
            System.out.println("Возникла ошибка. ");
            e.printStackTrace();
        }
    }

    public static void WriteToFile(String fileName, String text, Boolean flag) {
        try {
            FileWriter myWriter = new FileWriter(fileName, flag);
            myWriter.write(text);
            myWriter.close();
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Возникла ошибка. ");
            e.printStackTrace();
        }
    }




}
