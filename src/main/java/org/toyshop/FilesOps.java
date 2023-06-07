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

    public static void WriteObj(Shop obj, String fileName) {
        try {
            FileOutputStream f = new FileOutputStream(new File(fileName));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(obj);
            o.close();
            f.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public static Shop ReadObj(Shop obj, String fileName) {
        try {
            FileInputStream fi = new FileInputStream(new File(fileName));
            ObjectInputStream oi = new ObjectInputStream(fi);

            obj = (Shop) oi.readObject();

            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
}
