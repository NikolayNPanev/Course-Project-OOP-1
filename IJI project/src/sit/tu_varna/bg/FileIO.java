package sit.tu_varna.bg;

import java.io.*;

public class FileIO {

    public static Object readPerson(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void savePerson(String filepath, Person P){
        try (FileOutputStream fos = new FileOutputStream(filepath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(P);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
