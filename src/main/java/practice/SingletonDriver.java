package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import practice.singleton.SerializableSingleton;

public class SingletonDriver {
    public static void main(String[] args) {
        try {
            SerializableSingleton instance1 = SerializableSingleton.getInstance();
            ObjectOutput obj1 = null;

            //serialize object state to file
            obj1 = new ObjectOutputStream(new FileOutputStream("Sample.txt"));
            obj1.writeObject(instance1);
            obj1.close();

            //deserialize from file to object
            ObjectInput obj2 = new ObjectInputStream(new FileInputStream("sample.txt"));
            SerializableSingleton instance2 = (SerializableSingleton)obj2.readObject();
            obj2.close();

            System.out.println("Instance 1 hashCode : "+instance1.hashCode());
            System.out.println("Instance 2 hashCode : "+instance2.hashCode());

        } catch (IOException |ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
