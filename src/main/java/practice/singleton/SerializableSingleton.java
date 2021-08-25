package practice.singleton;

import java.io.Serializable;

public class SerializableSingleton implements Serializable{
    private static volatile SerializableSingleton singleton = null;

    private SerializableSingleton(){
        System.out.println("Constructor is being called...");
    }

    public static SerializableSingleton getInstance(){
        if(singleton==null){
            synchronized(SerializableSingleton.class){
                if(singleton==null){
                    singleton = new SerializableSingleton();
                }
            }
        }
        return singleton;
    }

    Object readResolve(){
        return getInstance();
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new RuntimeException();
    }
}
